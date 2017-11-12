/*
 * 生成正三角的程序*
 * 
 */
package 正三角形;

/**
 *******************************************

 * @author Hejing
 * @date   2017年11月12日
 * @class   practise.java
 ****************************************
 */
public class practise {
	public static void main(String  args[])
	{
		int i;
		int j;
		int input=10;
		System.out.println("系统生成一个正三角形如下所示：");
		for(i=1;i<=input;i++)
		{
			for(j=i;j<=input;j++)
			{
				System.out.print(" ");    //打印
			}
//系统打印左半边三角形
		   for(j=i;j>=1;j--)
		   {
			if(j>=10)
				System.out.print("*");   //大于9的数字用9代替
			else 
				System.out.print("*");   //把1~8也用*代替
		    }
//打印出右边的三角形
		   for(j=2;j<=i;j++)
		   {
			if(j>=10)
				System.out.print("*");   //大于9的数字用9代替
			else 
				System.out.print("*");    //把1~8也用*代替	
			}	
		
		System.out.println();            //打印
	}
}
}
