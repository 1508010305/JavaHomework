/*
 * ѧУ������ʦ��ͬѧ�����ˣ�����ְ�о���������ʦҲ��ѧ���� ��ѧ���Ĺ���Ͷ���ʦ�Ĺ������������϶������֡�
 * 
 */
package �ϻ�third;

/**
 *******************************************

 * @author Hejing
 * @date   2017��11��12��
 * @class   Graduate.java
 ****************************************
 */
interface StudentMangeInterface{
	public void setFee();                //����ѧ��ѧ��
	public int getFee();               //��ȡѧ��ѧ��
}
interface TeacherMangeInterface{
	public void setPay();              //���ý�ʦ����
	public int getPay();             //��ȡ��ʦ����
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
	System.out.println("������Ϣ��");
	System.out.println("������"+name);
	System.out.println("�Ա�"+sex);
	System.out.println("���䣺"+age);
}
public static void main(String ages[]) {
Graduate g=new Graduate("zhangsan","��",23);
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
	System.out.println("����Ҫ����");
}

}
}