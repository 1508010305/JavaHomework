/*数字旋转方阵，N*N阶方阵
 * 
 */
package 数字旋转方阵;

/**
 *******************************************

 * @author Hejing
 * @date   2017年11月12日
 * @class   xuanzhuan.java
 ****************************************
 */

import java.util.Scanner;
public class xuanzhuan{	
public static void main(String[] args) {
Scanner input =new Scanner(System.in );
System.out.print("请输入矩阵的大小,范围在4~10之间的整数：");
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
	//从左上到左下
while(x<n&x>=0&&y<n&&y>=0) {
		if(f[x][y]!=0)
			break;
		f[x++][y]=++zhi;
	}
x--;
y++;

//从左下到右下
while(x<n&x>=0&&y<n&&y>=0) {
	if(f[x][y]!=0)
		break;
	f[x][y++]=++zhi;
}
y--;
x--;
//从右下到右上
while(x<n&x>=0&&y<n&&y>=0) {
if(f[x][y]!=0)
	break;
f[x--][y]=++zhi;
}
x++;
y--;
//从右上到左上
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
	System.out.println("您输入的矩阵大小有误！");}
}
}

