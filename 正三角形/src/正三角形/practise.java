/*
 * ���������ǵĳ���*
 * 
 */
package ��������;

/**
 *******************************************

 * @author Hejing
 * @date   2017��11��12��
 * @class   practise.java
 ****************************************
 */
public class practise {
	public static void main(String  args[])
	{
		int i;
		int j;
		int input=10;
		System.out.println("ϵͳ����һ����������������ʾ��");
		for(i=1;i<=input;i++)
		{
			for(j=i;j<=input;j++)
			{
				System.out.print(" ");    //��ӡ
			}
//ϵͳ��ӡ����������
		   for(j=i;j>=1;j--)
		   {
			if(j>=10)
				System.out.print("*");   //����9��������9����
			else 
				System.out.print("*");   //��1~8Ҳ��*����
		    }
//��ӡ���ұߵ�������
		   for(j=2;j<=i;j++)
		   {
			if(j>=10)
				System.out.print("*");   //����9��������9����
			else 
				System.out.print("*");    //��1~8Ҳ��*����	
			}	
		
		System.out.println();            //��ӡ
	}
}
}
