/*
 * 卡车要装载一批货物，货物有三种商品：电视、计算机和洗衣机。需要计算出大货车和小货车各自所装载的三种货物的总重量
 * 
 */
package 上机second;

/**
 *******************************************
 
 * @author Hejing
 * @date   2017年11月08日
 * @class   car.java
 ****************************************
**/
interface  ComputeWeight{           //定义接口
 public double computeWeight();     //接口中抽象方法的实现，必须指定为public
 }
 class Television implements  ComputeWeight{        //电视机类实现接口
   double  weight1;
	public Television(double d) {
		// TODO Auto-generated constructor stub
		this.weight1 =d;
	}
    public double computeWeight() {
	System.out.println("装载电视机有"+weight1+"kg");
	return weight1;
	}             
  } 
 class Computer implements  ComputeWeight{        //计算机类实现接口
       double  weight2;
		public Computer(double d) {
		//	 TODO Auto-generated constructor stub
			this.weight2 =d;
		}   
	    public double computeWeight() {
		System.out.println("装载计算机有"+weight2+"kg");
		return weight2;
		}             
	  } 
 class WashMachine implements  ComputeWeight{       //洗衣机类实现接口
	       double  weight3;
		    public WashMachine (double d) {
			// TODO Auto-generated constructor stub
			this.weight3 =d;
		} 
	    public double computeWeight() {
		System.out.println("装载洗衣机有"+weight3+"kg");
		return weight3;
		}             
	  } 
 public class car {
		ComputeWeight[] com;
		double Weights=0;
		car(ComputeWeight[]  com){
			this.com =com;
			
		}
		public static void main (String agrs[]) {
			ComputeWeight[] com=new ComputeWeight[3];//上转型对象
			com[0] =new Television(85.5);     //创建电视机对象并执行覆盖实现方法
			com[1] =new Computer(50.5);      //创建计算机对象并执行覆盖实现方法
			com[2] =new WashMachine(125.5); //创建洗衣机对象并执行覆盖实现方法 
			double Weights=0;
			Weights=com[0].computeWeight()+com[1].computeWeight()+com[2].computeWeight();
			System.out.print("那么装载的货物总重量为:"+Weights+"kg");  
			
		}
	}
