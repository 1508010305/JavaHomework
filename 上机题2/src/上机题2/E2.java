/*
 *编程题:
先编写一个方法，它将格式为“yyyy/mm/dd"形式的日期字符串转化
为日期对象。若日期字符串不符合以上规定则抛出异常。再在main方法中对正常和异常
输入的日期字符串分别进行验证，并输出转换后的日期对象。
 * 
 */
package 上机题2;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *******************************************

 * @author Hejing
 * @date   2017年11月17日
 * @class   E2.java
 ****************************************
 */
public class E2 {
public static void main(String args[]) throws ParseException {
	System.out.println("请输入日期字符串:");
	Scanner s=new Scanner(System.in );
	String t=s.nextLine();
	
	try {System.out.println(getDate(t));
	
	}catch(ParseException e) {
		e.printStackTrace();
		throw e;
	}
}

public static Date getDate(String date) throws ParseException{
	DateFormat  format=new SimpleDateFormat("yyyy/MM/dd");
	try {System.out.println("转化为日期对象是：");
		return new Date(format.parse(date ).getTime());
	}catch(ParseException e) {
		e.printStackTrace();
		throw e;
	}

}}