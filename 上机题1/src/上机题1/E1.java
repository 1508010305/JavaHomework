/*
 *�����:
     ��������һ��ʮ�����������ٽ���ת��Ϊ��ʮ�������������׳��쳣��
 * 
 */
package �ϻ���1;

/**
 *******************************************

 * @author Hejing
 * @date   2017��11��17��
 * @class   E1.java
 ****************************************
 */


import java.util.Scanner;

public class E1 {
	public static void main(String args[]) {
	System.out.println("������һ��ʮ����������");	
	Scanner scanner = new Scanner(System.in);
	int s;
	String number= scanner.next();
	try {
		Integer.parseInt(number,16);	
	}catch(NumberFormatException e) {
		System.out.println("��������");
	}finally {
		s = Integer.valueOf(number,16);
	    System.out.println(s);
	}	
   }
}
