/*
 *编程题:
     建盘输入一个十六进制数，再将其转比为的十六进制数，则抛出异常。
 * 
 */
package 上机题1;

/**
 *******************************************

 * @author Hejing
 * @date   2017年11月17日
 * @class   E1.java
 ****************************************
 */


import java.util.Scanner;

public class E1 {
	public static void main(String args[]) {
	System.out.println("请输入一个十六进制数：");	
	Scanner scanner = new Scanner(System.in);
	int s;
	String number= scanner.next();
	try {
		Integer.parseInt(number,16);	
	}catch(NumberFormatException e) {
		System.out.println("输入有误");
	}finally {
		s = Integer.valueOf(number,16);
	    System.out.println(s);
	}	
   }
}
