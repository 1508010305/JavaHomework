/**
 * 
 */
package ��ҵ��2;

/**
 * @author Hejing
 **/
/*���һ��ѧ����Student���������У�����(name)������(age)��ѧ��(education),��Student��
 * ��������������Undergraduate���о�����Graduate�����������������ԣ�רҵ(specialty),��
 * �������������ԣ��о�����(direction)��ÿ���඼�й��췽�����������������Ϣ��show()�������ڲ���
 * ��TestExtends�в��������
 */
import ��ҵ��2.student; 
class student{
	 String name;//����
     int  age;//����
     String education;//ѧ��
  student(String a,int b,String c ){
	   this.name =a;
	   this.age =b;
	   this.education =c;
	   
  }
public void show1(){
	   System.out.println("������"+name); 
	   System.out.println("���䣺"+age); 
	   System.out.println("ѧ����"+education);
  }
  }
class  undergraduate extends student{
	    String specialty;    //���������ӵ����ԣ�רҵ
        undergraduate(String a,int b,String c ,String d){
		super(a,b,c);  //��super�̳и���student�е����������䣬ѧ���ȱ�����ֵ
		this.specialty =d;
	}
public void show2(){
	    super.show1();
	    System.out.println("רҵ��"+specialty);
	  }
}
class graduate extends student{
	    String   direction;//�о������ӵ����ԣ�����
	    graduate(String a,int b,String c ,String f){
		super(a,b,c);  //��super�̳и���student�е����������䣬ѧ��
		this.direction =f;
	}
	public void show3(){
	    super.show1();//��super�̳и���student�е����������䣬ѧ��
		System.out.println("�о�����"+direction);
	  }
}
public class TestExtends{    //�����࣬�����Ƿ�ɹ�
	public static void main (String args[]){
		student s=new student("�Ŵ�",16,"��ѧ");
		s.show1();
		System.out.println();
		undergraduate u=new undergraduate("�Ŷ�",19,"����","�������ѧ�뼼��");
		u.show2();
		System.out.println(); 
		graduate g=new graduate("����",23,"�о���","�����Ӧ��");
		g.show3();
		System.out.println();
	}
}

