/*������ת����N*N�׷���
 * 
 */
package ������ת����;

/**
 *******************************************

 * @author Hejing
 * @date   2017��11��12��
 * @class   xuanzhuan.java
 ****************************************
 */

import java.util.Scanner;
public class xuanzhuan{	
public static void main(String[] args) {
Scanner input =new Scanner(System.in );
System.out.print("���������Ĵ�С,��Χ��4~10֮���������");
int n=input.nextInt();
if(n>=4&&n<10){
int f[][]=new int[n][n];
int m =n%2==0?n/2:n/2+1;
int x=0;
int y=0;
int zhi=1;
f[x][y]=zhi;
for(int i =1;i<=m;i++) {
	x++;
	//�����ϵ�����
while(x<n&x>=0&&y<n&&y>=0) {
		if(f[x][y]!=0)
			break;
		f[x++][y]=++zhi;
	}
x--;
y++;

//�����µ�����
while(x<n&x>=0&&y<n&&y>=0) {
	if(f[x][y]!=0)
		break;
	f[x][y++]=++zhi;
}
y--;
x--;
//�����µ�����
while(x<n&x>=0&&y<n&&y>=0) {
if(f[x][y]!=0)
	break;
f[x--][y]=++zhi;
}
x++;
y--;
//�����ϵ�����
while(x<n&x>=0&&y<n&&y>=0) {
	if(f[x][y]!=0)
		break;
	f[x][y--]=++zhi;
}
y++;
}
for(int i=0;i<f.length;i++) {
	for(int j=0;j<f[i].length;j++)
		System.out.printf("%5d",f[i][j]);
	System.out.println();
}
}
else{
	System.out.println("������ľ����С����");}
}
}

