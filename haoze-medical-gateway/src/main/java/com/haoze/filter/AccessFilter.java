package com.haoze.filter;

import com.haoze.common.dto.TUser;
import com.haoze.common.dto.UserEntity;
import com.haoze.common.response.ResultGenerator;
import com.haoze.common.utils.JSONUtils;
import com.haoze.common.utils.R;
import com.haoze.service.AdminService;
import com.haoze.service.JwtService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AccessFilter extends ZuulFilter {
    @Autowired
    JwtService jwtService;
    @Autowired
    AdminService adminService;

    private String loginPath = "/api-admin/system/user/login";
    private String infoPath = "/api-admin/system/user/info";

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10000;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }


    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // 预请求
        if ("OPTIONS".equals(request.getMethod())) {
            // 预请求不用进处理，直接返回成功即可
            setFailedRequest("", 200);
            return null;
        }
        // 登录请求 不用验证，直接发送到对应的服务
        if (loginPath.equals(request.getRequestURI())) {
            return null;
        } else {
            String token = request.getHeader("Authorization");
            if (StringUtils.isEmpty(token)) {
                //返回错误信息
                setFailedRequest(ResultGenerator.genUnauthorizedResult(), 401);
                return null;
            }
            String account = jwtService.getAccountByToken(token);
            if (account == null) { // 无token 或token无效 或token过期
                //返回错误信息
                setFailedRequest(ResultGenerator.genUnauthorizedResult(), 401);
                return null;
            }
            // 为后续转发的请求加上身份信息
            ctx.addZuulRequestHeader("zuul_account", account);

            /*  以上部分已经从token中获取到正确的account信息，表示已登录
                以下是获取登录人信息的请求
                注意 获取用户信息时，account参数需要从token中获取，而不是前台传入accout直接去info方法获取
                确保用户只能获取自己的用户信息
             */
            if (infoPath.equals(request.getRequestURI())) {
                TUser user = adminService.getInfo(account);
                Map m = new HashMap();
                m.put("code", 200);
                m.put("data", user);
                ctx.addZuulRequestHeader("zuul_userId", user.getTuId());
                ctx.addZuulRequestHeader("zuul_organizationId", user.getToId());
                setFailedRequest(m, 200);
                return null;
            }

        }
        return null;

//        final String requestUri = request.getRequestURI();
//        if (isStartWith(requestUri)) {
//            return null;
//        }
//        String accessToken = request.getHeader(CommonConstants.CONTEXT_TOKEN);
//        if(null == accessToken || accessToken == ""){
//            accessToken = request.getParameter(CommonConstants.TOKEN);
//        }
//        if (null == accessToken) {
//            setFailedRequest(R.error401(), 200);
//            return null;
//        }
//        try {
//            UserToken userToken = JwtUtils.getInfoFromToken(accessToken);
//        } catch (Exception e) {
//            setFailedRequest(R.error401(), 200);
//            return null;
//        }
//        FilterContextHandler.setToken(accessToken);
////        if(!havePermission(request)){
////            setFailedRequest(R.error403(), 200);
////            return null;
////        }
//        Set<String> headers = (Set<String>) ctx.get("ignoredHeaders");
//        //We need our JWT tokens relayed to resource servers
//        //添加自己header
////        ctx.addZuulRequestHeader(CommonConstants.CONTEXT_TOKEN, accessToken);
//        //移除忽略token
//        headers.remove("authorization");
//        return null;
////        RequestContext ctx = RequestContext.getCurrentContext();
////        Set<String> headers = (Set<String>) ctx.get("ignoredHeaders");
////        // We need our JWT tokens relayed to resource servers
////        headers.remove("authorization");
////        return null;
    }

    private void setFailedRequest(Object body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        HttpServletResponse response = ctx.getResponse();
        response.setCharacterEncoding("utf-8"); // 解决中文乱码
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(JSONUtils.beanToJson(body));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ctx.setSendZuulResponse(false);
    }

//    private boolean havePermission(HttpServletRequest request){
//        String currentURL = request.getRequestURI();
//        List<MenuDTO> menuDTOS = menuService.userMenus();
//        for(MenuDTO menuDTO:menuDTOS){
//            if(currentURL!=null&&null!=menuDTO.getUrl()&&currentURL.startsWith(menuDTO.getUrl())){
//                return true;
//            }
//        }
//        return false;
//    }

//    private boolean isStartWith(String requestUri) {
//        boolean flag = false;
//        for (String s : ignorePath.split(",")) {
//
//            if (requestUri.startsWith(s)) {
//                return true;
//            }
//        }
//        return flag;
//    }
}