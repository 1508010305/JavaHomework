/*
 *�����:
�ȱ�дһ��������������ʽΪ��yyyy/mm/dd"��ʽ�������ַ���ת��
Ϊ���ڶ����������ַ������������Ϲ涨���׳��쳣������main�����ж��������쳣
����������ַ����ֱ������֤�������ת��������ڶ���
 * 
 */
package �ϻ���2;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *******************************************

 * @author Hejing
 * @date   2017��11��17��
 * @class   E2.java
 ****************************************
 */
public class E2 {
public static void main(String args[]) throws ParseException {
	System.out.println("�����������ַ���:");
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
	try {System.out.println("ת��Ϊ���ڶ����ǣ�");
		return new Date(format.parse(date ).getTime());
	}catch(ParseException e) {
		e.printStackTrace();
		throw e;
	}

}}