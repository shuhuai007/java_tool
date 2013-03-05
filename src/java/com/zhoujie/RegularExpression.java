
package com.zhoujie;

import java.util.regex.Pattern;

public class RegularExpression {
    
    /**
     * 验证数字
     * @param digit
     * @return
     */
    public static boolean validateDigit(String digit) {
        boolean flag = false;
        String reg = "^[0-9]+$";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(digit).matches();
        return flag;
    }

    /**
     * 验证n位数字
     * @param digits
     * @return
     */
    public static boolean validateNDigits(String digits, int n) {
        boolean flag = false;
        String reg = "^\\d{" + n + "}$";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(digits).matches();
        return flag;
    }

    /**
     * 验证至少n位数字
     * @param digits
     * @param n
     * @return
     */
    public static boolean validateMinNDigits(String digits, int n) {
        boolean flag = false;
        String reg = "^\\d{" + n + "," + "}$";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(digits).matches();
        return flag;
    }
    /**
     * 验证m到n位数字
     * @param digits
     * @param m
     * @param n
     * @return
     */
    public static boolean validateMNDigits(String digits, int m, int n) {
        boolean flag = false;
        String reg = "^\\d{" + m + "," + n + "}$";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(digits).matches();
        return flag;
    }

    /**
     * 验证正整数（不包括0）
     * @param digits
     * @return
     */
    public static boolean validatePositiveInteger(String digits) {
        boolean flag = false;
        String reg = "^\\+?[1-9][0-9]*$";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(digits).matches();
        return flag;
    }

    
    /**
     * 验证 手机号是否合法
     * 
     * @param phone:手机号
     * @return true:合法 false不合法
     */
    public static boolean validatePhone(String phone) {
        boolean flag = false;
        String reg = "^((13[0-9])|(15[0-9])|(14[0-9])|(18[0-9]))\\d{8}$";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(phone).matches();
        return flag;
    }

    /**
     * 验证邮箱是否合法
     * 
     * @param email 邮箱地址
     * @return true：合法，false不合法
     */
    public static boolean validateEmail(String email) {
        boolean flag = false;
        String reg = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(email).matches();
        return flag;
    }

    /**
     * 验证电话格式是否正确
     * 
     * @param telephone电话
     * @return true格式正确；false:格式不正确
     */
    public static boolean validateTelephone(String telephone) {
        boolean flag = false;
        String reg = "(^(\\+86\\-|86\\-)?[0-9]{3}[-]\\d{8})|(^(\\+86\\-|86\\-)?[0-9]{4}[-]\\d{7})";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(telephone).matches();
        return flag;
    }

    /**
     * 验证邮编是否符合要求
     * 
     * @param str 邮政编号
     * @return true:邮编正确 false:邮编错误
     */
    public static boolean validateZip(String str) {
        boolean flag = false;
        String reg = "^([0-9])\\d{5}";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(str).matches();
        return flag;
    }

    /**
     * 验证MSN账户
     * 
     * @param str:msn账户
     * @return true表明是msn ；false:表明非msn
     */
    public static boolean validateMsn(String str) {
        boolean flag = false;
        String reg = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@(live.com|hotmail.com|live.cn)";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(str).matches();
        return flag;
    }

    /**
     * 验证QQ号是否合法
     * 
     * @param str QQ号码
     * @return true是QQ号 false:不是QQ号
     */
    public static boolean validateQQ(String str) {
        boolean flag = false;
        String reg = "^[1-9][0-9]{4,9}$";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(str).matches();
        return flag;
    }

    /**
     * 验证身份证号格式是否符合要求
     * 
     * @param cardId 身份证号
     * @return true:身份证符合要求足；false:身份证不符合要求
     */
    public static boolean validateIdCard(String cardId) {
        boolean flag = false;
        String reg = "(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)";
        Pattern pattern = Pattern.compile(reg);
        flag = pattern.matcher(cardId).matches();
        return flag;
    }

    /**
     * 验证昵称是否符合要求（不能为纯数字，不能含有@字符,不能以数字开头）
     * 
     * @param str 昵称
     * @return true昵称合法 false昵称不合法
     */
    public static boolean validateNickName(String str) {
        boolean flag = false;
        String numReg = "([\u4E00-\u9FA5]+[^@]+$)|(^[^@0-9]+([\u4E00-\u9FA5]+[^@]+|[^@]+[A-Za-z_]+|[^@]+\\d+)[^@]+$)";
        Pattern pattern = Pattern.compile(numReg);
        flag = pattern.matcher(str).matches();
        return flag;
    }
    
    
    public static void print(Object str){
        System.out.print(str);
    }
    
    public static void println(Object str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        String fix = "---------functionName---------";
        println(fix.replace("functionName", "validateDigit"));
        println("1212: " + validateDigit("1212"));
        println("9955555d: " + validateDigit("9955555d"));
        println(" : " + validateDigit(" "));

        println(fix.replace("functionName", "validateNDigits"));
        println("1212: " + validateNDigits("1212", 4));
        println("1212: " + validateNDigits("1212", 3));
        println("9955555d: " + validateNDigits("995d", 4));
        println(" : " + validateNDigits(" ", 1));

        println(fix.replace("functionName", "validateMinNDigits"));
        println("1212: " + validateMinNDigits("1212", 5));
        println("1212: " + validateMinNDigits("1212", 4));
        println("1212: " + validateMinNDigits("1212", 3));
        println("9955555d: " + validateMinNDigits("995d", 4));
        println(" : " + validateMinNDigits(" ", 1));

        println(fix.replace("functionName", "validateMNDigits"));
        println("1212: " + validateMNDigits("1212", 1, 4));
        println("1212: " + validateMNDigits("1212", 1, 5));
        println("1212: " + validateMNDigits("1212", 1, 3));
        println("9955555d: " + validateMNDigits("995d", 1, 4));
        println(" : " + validateMNDigits(" ", 1, 4));

        println(fix.replace("functionName", "validatePositiveInteger"));
        println("1212: " + validatePositiveInteger("1212"));
        println("0: " + validatePositiveInteger("0"));
        println("+01111: " + validatePositiveInteger("+01111"));
        println("+1111: " + validatePositiveInteger("+1111"));
        println("9955555d: " + validatePositiveInteger("995d"));
        println(" : " + validatePositiveInteger(" "));
    }

}
