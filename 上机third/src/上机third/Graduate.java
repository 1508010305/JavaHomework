/*
 * 学校中有老师和同学两类人，而在职研究生既是老师也是学生， 对学生的管理和对老师的管理在他们身上都有体现。
 * 
 */
package 上机third;

/**
 *******************************************

 * @author Hejing
 * @date   2017年11月12日
 * @class   Graduate.java
 ****************************************
 */
interface StudentMangeInterface{
	public void setFee();                //设置学生学费
	public int getFee();               //获取学生学费
}
interface TeacherMangeInterface{
	public void setPay();              //设置教师工资
	public int getPay();             //获取教师工资
}
 class Graduate implements StudentMangeInterface ,TeacherMangeInterface {
 static String name;
String sex;
 int age,fee,pay;

 Graduate(String n,String s,int a) {
	this.name=n;
	this.sex =s;
	this.age =a;
}
 public void setFee() {}
 public void setFee(int i) {
		// TODO Auto-generated method stub
		fee=i;
	}
public int  getFee() {
	return fee;
}
public void setPay(){}
public void setPay(int i) {
	// TODO Auto-generated method stub
	pay=i;
}
public int getPay() {

		return  pay;
	}
public  void  people() {
	System.out.println("个人信息：");
	System.out.println("姓名："+name);
	System.out.println("性别："+sex);
	System.out.println("年龄："+age);
}
public static void main(String ages[]) {
Graduate g=new Graduate("zhangsan","男",23);
g.setFee(10000);
g.setPay(1000);
int tfee = g.getFee()+g.getFee();
int  tpay = g.getPay()*12;
int  gap=tpay-tfee;
if(gap<=2000)
{
	
	System.out.println("provide a loan");
	g.people();
	}
else {
	System.out.println("不需要贷款");
}

}
}