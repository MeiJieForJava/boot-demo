package com.boot.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * <p>字符串处理工具类</p>
 * 
 * @author Li Wei
 * Create at:2012-8-14 上午11:35:10
 */ 
public class StringUtil {

	private static final Pattern LEGAL_MOBILE_NO_PATTEN = Pattern.compile("^(1)\\d{10}$");
	/***
	 * add by liuqun 20151221 判断手机号是否合法
	 * 第一位是1 其它10位均为数字
	 * @param mobile
	 * @return
	 */
	public static boolean isLegalMobileNo(String mobile){
		Matcher m = LEGAL_MOBILE_NO_PATTEN.matcher(mobile);
		return m.matches();  
	}

	private static final Pattern LEGAL_PHONE_NO_PATTEN = Pattern.compile("^(\\d{3,4}-)?\\d{7,8}$|((13[0-9]|14[5-9]|15[0-9]|166|17[0-8]|18[0-9]|19[8-9])[0-9]{8})$");
	//校验手机号
	public static boolean isLegalPhoneNo(String phone){
		Matcher m = LEGAL_PHONE_NO_PATTEN.matcher(phone);
		return m.matches();
	}
	private static final Pattern LEGALEMAIL_NO_PATTEN = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
	/***
	 * add by liuqun 20151221 判断邮箱是否合法
	 * @param eamil
	 * @return
	 */
	public static boolean isLegalEmailNo(String eamil){
		Matcher m = LEGALEMAIL_NO_PATTEN.matcher(eamil);
		return m.matches();  
	}
	
	/** 
	 * 空字符串判断, <span style="color:red;">去左右空格后</span>, 如果为空返回 true<br/> 
	 * <span style="color:green;">为保证安全, 要事先定义好密码首尾是否能有空格</span> 
	 *  
	 * @param param 待验证字符串
	 * @return boolean 
	 */  
	public static boolean isEmpty(CharSequence param) {
	    return (param == null || "".equals(param.toString().trim()));  
	} 

	private static final Pattern CHECK_REGEX_PATTEN = Pattern.compile("[^%$&><,'\"|]{1,}");
	
	/** 
	 * 空字符串判断是否包含非法字符, <span style="color:red;">非法字符%$&><,'"|</span>, 如果包含返回 false<br/> 
	 *  
	 * @param param 待验证字符串
	 * @return boolean 
	 */  
	public static boolean checkRegex(CharSequence param) {
		  return checkRegex(param, CHECK_REGEX_PATTEN);
	} 	
	
	/** 
	 * 空字符串判断是否包含非法字符, <span style="color:red;">自己定义正则表达式</span>, 如果包含返回 false<br/> 
	 *  
	 * @param param 待验证字符串
	 * @return boolean 
	 */  
	public static boolean checkRegex(CharSequence param, Pattern p) {
		  Matcher m=p.matcher(param);
		  return m.matches();
	} 
	/** 
	 * sql语句查询时，对特殊字符进行转义
	 *  
	 * @param s 待转义字符串
	 * @return boolean 
	 */  
	public static String escapseSqlLikeChar(String s) {
		s=s.replaceAll("\\\\", "\\\\\\\\");
		s=s.replaceAll("%", "\\\\%");
		s=s.replaceAll("_", "\\\\_");
		return s;
	}

	private static final Pattern INTEGER_PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");

	/*
      * 判断是否为整数
      * @param str 传入的字符串
      * @return 是整数返回true,否则返回false
    */
	public static boolean isInteger(String str) {
		if(str == null) {
			return false;
		}

		return INTEGER_PATTERN.matcher(str).matches();
	}
}
