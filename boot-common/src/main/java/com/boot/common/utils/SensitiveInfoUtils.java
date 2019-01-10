package com.boot.common.utils;

/**
 * 用于敏感信息脱敏显示
 * Created by huquanbo on 2018/10/17.
 */
public class SensitiveInfoUtils {

    public static String getCellPhone(String cellPhone){
        if (cellPhone == null || cellPhone.trim().isEmpty()){
            return null;
        }
        try{
            cellPhone = cellPhone.trim();
            if (cellPhone.startsWith("1") && cellPhone.length() >= 11){
                return new StringBuilder(cellPhone.substring(0,2))
                        .append("****")
                        .append(cellPhone.substring(cellPhone.length() - 4,cellPhone.length()))
                        .toString();
            } else if (cellPhone.startsWith("9") && cellPhone.length() >= 8){
                return new StringBuilder(cellPhone.substring(0,1))
                        .append("****")
                        .append(cellPhone.substring(cellPhone.length() - 2,cellPhone.length()))
                        .toString();
            } else if (cellPhone.length() > 5){
                return new StringBuilder(cellPhone.substring(0,1))
                        .append("****")
                        .append(cellPhone.substring(cellPhone.length() - 2,cellPhone.length()))
                        .toString();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return cellPhone;
    }

    public static String getEmail(String email){
        if (email == null || email.trim().isEmpty()){
            return null;
        }
        try{
            email = email.trim();
            String[] args = email.split("@");
            if (args.length == 2){
                if (args[0].length() > 2){
                    return new StringBuilder(args[0].substring(0,2))
                            .append("***")
                            .append("@")
                            .append(args[1])
                            .toString();
                } else if (args[0].length() >= 1){
                    return new StringBuilder(args[0].substring(0,1))
                            .append("***")
                            .append("@")
                            .append(args[1])
                            .toString();
                } else {
                    return new StringBuilder()
                            .append("***")
                            .append("@")
                            .append(args[1])
                            .toString();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return email;
    }

    public static void main(String[] args){
        String phone = "13766347890";
        String phone2 = "93435000";
        String phone3 = "1569808293423894";
        String phone4 = " 923435234 ";
        String phone5 = "7234352";
        String phone6 = "  ";

        String email = "abc@123.com.cn";
        String email2 = "f@sina.cn";
        String email3 = "@gmail.com";
        String email4 = "jsaidfj_s234@163.com";
        String email5 = "we@jd.com";
        String email6 = null;


        System.out.println(SensitiveInfoUtils.getCellPhone(phone));
        System.out.println(SensitiveInfoUtils.getCellPhone(phone2));
        System.out.println(SensitiveInfoUtils.getCellPhone(phone3));
        System.out.println(SensitiveInfoUtils.getCellPhone(phone4));
        System.out.println(SensitiveInfoUtils.getCellPhone(phone5));
        System.out.println(SensitiveInfoUtils.getCellPhone(phone6));

        System.out.println(SensitiveInfoUtils.getEmail(email));
        System.out.println(SensitiveInfoUtils.getEmail(email2));
        System.out.println(SensitiveInfoUtils.getEmail(email3));
        System.out.println(SensitiveInfoUtils.getEmail(email4));
        System.out.println(SensitiveInfoUtils.getEmail(email5));
        System.out.println(SensitiveInfoUtils.getEmail(email6));
    }
}
