/*
 * һ������������0������ѭ���ͱ��ر���������n,2n,4n,8n,��˳���������ֵ����5000ʱ�����*
 * 
 */
package �����������;

/**
 *******************************************

 * @author Hejing
 * @date   2017��11��12��
 * @class   shuzi.java
 ****************************************
 */
import java.util.*;

public class shuzi{
	public static void main(String args[]) {
		System.out.println("������һ������:");
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
	



