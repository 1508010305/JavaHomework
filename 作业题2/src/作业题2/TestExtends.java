/**
 * 
 */
package 作业题2;

/**
 * @author Hejing
 **/
/*设计一个学生类Student，其属性有：姓名(name)、年龄(age)、学历(education),由Student类
 * 派生出本科生类Undergraduate和研究生类Graduate，本科生类增加属性：专业(specialty),研
 * 究生类增加属性：研究方向(direction)。每个类都有构造方法和用于输出属性信息的show()方法，在测试
 * 类TestExtends中测试输出。
 */
import 作业题2.student; 
class student{
	 String name;//姓名
     int  age;//年龄
     String education;//学历
  student(String a,int b,String c ){
	   this.name =a;
	   this.age =b;
	   this.education =c;
	   
  }
public void show1(){
	   System.out.println("姓名："+name); 
	   System.out.println("年龄："+age); 
	   System.out.println("学历："+education);
  }
  }
class  undergraduate extends student{
	    String specialty;    //本科生增加的属性：专业
        undergraduate(String a,int b,String c ,String d){
		super(a,b,c);  //用super继承父类student中的姓名，年龄，学历等变量的值
		this.specialty =d;
	}
public void show2(){
	    super.show1();
	    System.out.println("专业："+specialty);
	  }
}
class graduate extends student{
	    String   direction;//研究生增加的属性：方向
	    graduate(String a,int b,String c ,String f){
		super(a,b,c);  //用super继承父类student中的姓名，年龄，学历
		this.direction =f;
	}
	public void show3(){
	    super.show1();//用super继承父类student中的姓名，年龄，学历
		System.out.println("研究方向："+direction);
	  }
}
public class TestExtends{    //测试类，测试是否成功
	public static void main (String args[]){
		student s=new student("张大",16,"中学");
		s.show1();
		System.out.println();
		undergraduate u=new undergraduate("张二",19,"本科","计算机科学与技术");
		u.show2();
		System.out.println(); 
		graduate g=new graduate("张三",23,"研究生","计算机应用");
		g.show3();
		System.out.println();
	}
}

