/*
 * 一个整数，大于0，不用循环和本地变量，按照n,2n,4n,8n,的顺序递增，当值大于5000时，输出*
 * 
 */
package 数字排序并输出;

/**
 *******************************************

 * @author Hejing
 * @date   2017年11月12日
 * @class   shuzi.java
 ****************************************
 */
import java.util.*;

public class shuzi{
	public static void main(String args[]) {
		System.out.println("请输入一个整数:");
		Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    shuchu f = new shuchu();
	    f.shuchu(n);
	}	
}
class shuchu{
	public int shuchu(int j) {
		if(j>= 5000) 
          {
			
			   System.out.println();
          }		
		else {
			  System.out.println(j*2);
			   shuchu(j*2);
		     }   		
		System.out.println(j);
		return j*2;
	}
}
	



