package com.haoze.dental.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
/**
 * @author shenjun
 * @date 2019/3/5
 */
public class Verify {
    private final static Logger log = LoggerFactory.getLogger(Verify.class);

    public static boolean isIDNumber(String IDNumber) {
        if (IDNumber == null || "".equals(IDNumber)) {
            return false;
        }
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        //假设18位身份证号码:41000119910101123X  410001 19910101 123X
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
        //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
        //$结尾

        //假设15位身份证号码:410001910101123  410001 910101 123
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //$结尾


        boolean matches = IDNumber.matches(regularExpression);

        //判断第18位校验值
        if (matches) {

            if (IDNumber.length() == 18) {
                try {
                    char[] charArray = IDNumber.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        log.error("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase() +
                                "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
                        return false;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("异常:" + IDNumber);
                    return false;
                }
            }

        }
        return matches;
    }

    /**
     * 通过身份证号码获取出生日期、性别、年龄
     * @param IDNumber
     * @return 返回的出生日期格式：1990-01-01   性别格式：F-女，M-男
     */
    public static Map<String, String> getBirAgeSex(String IDNumber) {
        String birthday = "";
        String age = "";
        String sexCode = "";

        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = IDNumber.toCharArray();
        boolean flag = true;
        if (number.length == 15) {
            for (int x = 0; x < number.length; x++) {
                if (!flag) return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }
        } else if (number.length == 18) {
            for (int x = 0; x < number.length - 1; x++) {
                if (!flag) return new HashMap<String, String>();
                flag = Character.isDigit(number[x]);
            }
        }
        if (flag && IDNumber.length() == 15) {
            birthday = "19" + IDNumber.substring(6, 8) + "-"
                    + IDNumber.substring(8, 10) + "-"
                    + IDNumber.substring(10, 12);
            sexCode = Integer.parseInt(IDNumber.substring(IDNumber.length() - 3, IDNumber.length())) % 2 == 0 ? "F" : "M";
            age = (year - Integer.parseInt("19" + IDNumber.substring(6, 8))) + "";
        } else if (flag && IDNumber.length() == 18) {
            birthday = IDNumber.substring(6, 10) + "-"
                    + IDNumber.substring(10, 12) + "-"
                    + IDNumber.substring(12, 14);
            sexCode = Integer.parseInt(IDNumber.substring(IDNumber.length() - 4, IDNumber.length() - 1)) % 2 == 0 ? "F" : "M";
            age = (year - Integer.parseInt(IDNumber.substring(6, 10))) + "";
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("birthday", birthday);
        map.put("age", age);
        map.put("sexCode", sexCode);
        return map;
    }

}
