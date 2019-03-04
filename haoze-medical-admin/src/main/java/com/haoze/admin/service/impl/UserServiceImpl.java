package com.haoze.admin.service.impl;

import com.haoze.admin.dto.system.UserDTO;
import com.haoze.admin.mapper.UserMapper;
import com.haoze.admin.model.UserEntity;
import com.haoze.admin.model.UserOrganizationEntity;
import com.haoze.admin.model.UserRoleEntity;
import com.haoze.admin.service.UserService;
import com.haoze.common.exception.ServiceException;
import com.haoze.common.service.AbstractService;
import com.haoze.common.utils.UUIDUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shenjun
 * @date 2019/02/27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends AbstractService<UserEntity> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        String s=new UserServiceImpl().passwordEncoder.encode("123123");
        System.out.print("-----------"+s);
    }

    /**
     * 重写save方法，密码加密后再存
     */
    @Override
    public void saveUserAndRoleAndOrganizagion(final UserDTO user) {
        UserEntity u = this.findBy("userName", user.getName());
        if (u != null) {
            throw new ServiceException("username already existed");
        } else {
            UserEntity tu = new UserEntity();
            tu.initAdd();
            tu.setTuId(user.getTuId());
            tu.setLoginName(user.getLoginName());
            tu.setUserName(user.getName());
            tu.setLockFlag(user.getLockFlag());
            tu.setUserTypes(user.getUserTypes());
            tu.setEndDate(user.getEndDate());
            tu.setOnLine(user.getUserLine());
            tu.setImage(user.getImage());
            tu.setUserPwd(this.passwordEncoder.encode("123123"));
            userMapper.insertSelective(tu);
            if(user.getRoleId()!=null){
                //用户角色关系
                UserRoleEntity tur = new UserRoleEntity();
                tur.initAdd();
                tur.setTurId(UUIDUtil.randomString());
                tur.setTuId(user.getTuId());
                tur.setTrId(user.getRoleId());
                userMapper.insertUserRoleRela(tur);
            }

            if(user.getOrganizationId()!=null){
                // 用户机构关系
                UserOrganizationEntity tuo = new UserOrganizationEntity();
                tuo.initAdd();
                tuo.setTuoId(UUIDUtil.randomString());
                tuo.setTuId(user.getTuId());
                tuo.setToId(user.getOrganizationId());
                userMapper.insertUserOrganizationRela(tuo);
            }

        }
    }

    /**
     * 重写save方法，密码加密后再存
     */
    @Override
    public void saveUserAndRoleAndOrganizagionCase(final UserDTO user) {
        UserEntity u = this.findBy("userName", user.getName());
        if (u != null) {
            if(user.getRoleId()!=null){
                //用户角色关系
                UserRoleEntity tur = new UserRoleEntity();
                tur.initAdd();
                tur.setTurId(UUIDUtil.randomString());
                tur.setTuId(user.getTuId());
                tur.setTrId(user.getRoleId());
                userMapper.insertUserRoleRela(tur);
            }

            if(user.getOrganizationId()!=null){
                // 用户机构关系
                UserOrganizationEntity tuo = new UserOrganizationEntity();
                tuo.initAdd();
                tuo.setTuoId(UUIDUtil.randomString());
                tuo.setTuId(user.getTuId());
                tuo.setToId(user.getOrganizationId());
                userMapper.insertUserOrganizationRela(tuo);
            }
        } else {
            UserEntity tu = new UserEntity();
            tu.initAdd();
            tu.setTuId(user.getTuId());
            tu.setLoginName(user.getLoginName());
            tu.setUserName(user.getName());
            tu.setLockFlag(user.getLockFlag());
            tu.setUserTypes(user.getUserTypes());
            tu.setEndDate(user.getEndDate());
            tu.setOnLine(user.getUserLine());
            tu.setImage(user.getImage());
            tu.setUserPwd(user.getPassword());
            userMapper.insertSelective(tu);
            if(user.getRoleId()!=null){
                //用户角色关系
                UserRoleEntity tur = new UserRoleEntity();
                tur.initAdd();
                tur.setTurId(UUIDUtil.randomString());
                tur.setTuId(user.getTuId());
                tur.setTrId(user.getRoleId());
                userMapper.insertUserRoleRela(tur);
            }

            if(user.getOrganizationId()!=null){
                // 用户机构关系
                UserOrganizationEntity tuo = new UserOrganizationEntity();
                tuo.initAdd();
                tuo.setTuoId(UUIDUtil.randomString());
                tuo.setTuId(user.getTuId());
                tuo.setToId(user.getOrganizationId());
                userMapper.insertUserOrganizationRela(tuo);
            }

        }
    }

    /**
     * 重写update方法
     */
    @Override
    public void updateUserAndRoleAndDept(final UserDTO user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setTuId(user.getTuId());
        userEntity.setLoginName(user.getLoginName());
        userEntity.setUserName(user.getName());
        userEntity.setLockFlag(user.getLockFlag());
        userEntity.setUserTypes(user.getUserTypes());
        userEntity.setEndDate(user.getEndDate());
        userEntity.setOnLine(user.getUserLine());
        userEntity.setImage(user.getImage());
        userMapper.updateByPrimaryKeySelective(userEntity);

        if(user.getRoleId()!=null){
            //用户角色关系
            userMapper.clearUserRoleRela(user.getTuId());
            UserRoleEntity tur = new UserRoleEntity();
            tur.initAdd();
            tur.setTurId(UUIDUtil.randomString());
            tur.setTuId(user.getTuId());
            tur.setTrId(user.getRoleId());
            userMapper.insertUserRoleRela(tur);
        }
        if(user.getOrganizationId()!=null){
            // 用户科室关系
            userMapper.clearUserOrganizationRela(user.getTuId());
            UserOrganizationEntity tuo = new UserOrganizationEntity();
            tuo.initAdd();
            tuo.setTuoId(UUIDUtil.randomString());
            tuo.setTuId(user.getTuId());
            tuo.setToId(user.getOrganizationId());
            userMapper.insertUserOrganizationRela(tuo);
        }
    }

    @Override
    public List<UserDTO> findAllUserWithRole(String queryString) {
        List<UserDTO> list = this.userMapper.findAllUserWithRole(queryString);
        for (UserDTO e : list) {
            List<String> idsList = new ArrayList<>();
            idsList.add(e.getOrganizationId());
            String ids = getParentDepartmentId(idsList);
            e.setOrganizationIds(ids);
        }
        return list;
    }

    public String getParentDepartmentId(List<String> list) {
        String id = list.get(0);
        String pid = userMapper.getParentOrganizationId(id);
        if (pid == null) {
            return "";
        } else if ("0".equals(pid)) { // 已是最上级
            return String.join(",", list);
        } else {
            list.add(0, pid);
            return getParentDepartmentId(list);
        }
    }

    @Override
    public UserDTO findDetailBy(final String column, final Object param) {
        final Map<String, Object> map = new HashMap<>(1);
        map.put(column, param);
        return this.userMapper.findDetailBy(map);
    }

    @Override
    public boolean verifyPassword(final String rawPassword, final String encodedPassword) {
        return this.passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public void deleteById(Object id) {
        //先删除子记录
        this.userMapper.clearUserRoleRela(String.valueOf(id));
        this.userMapper.clearUserOrganizationRela(String.valueOf(id));
        this.userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String encodePassword(String password) {
        return this.passwordEncoder.encode(password);
    }
}
