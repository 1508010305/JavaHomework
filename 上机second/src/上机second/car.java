/*
 * ����Ҫװ��һ�����������������Ʒ�����ӡ��������ϴ�»�����Ҫ������������С����������װ�ص����ֻ����������
 * 
 */
package �ϻ�second;

/**
 *******************************************
 
 * @author Hejing
 * @date   2017��11��08��
 * @class   car.java
 ****************************************
**/
interface  ComputeWeight{           //����ӿ�
 public double computeWeight();     //�ӿ��г��󷽷���ʵ�֣�����ָ��Ϊpublic
 }
 class Television implements  ComputeWeight{        //���ӻ���ʵ�ֽӿ�
   double  weight1;
	public Television(double d) {
		// TODO Auto-generated constructor stub
		this.weight1 =d;
	}
    public double computeWeight() {
	System.out.println("װ�ص��ӻ���"+weight1+"kg");
	return weight1;
	}             
  } 
 class Computer implements  ComputeWeight{        //�������ʵ�ֽӿ�
       double  weight2;
		public Computer(double d) {
		//	 TODO Auto-generated constructor stub
			this.weight2 =d;
		}   
	    public double computeWeight() {
		System.out.println("װ�ؼ������"+weight2+"kg");
		return weight2;
		}             
	  } 
 class WashMachine implements  ComputeWeight{       //ϴ�»���ʵ�ֽӿ�
	       double  weight3;
		    public WashMachine (double d) {
			// TODO Auto-generated constructor stub
			this.weight3 =d;
		} 
	    public double computeWeight() {
		System.out.println("װ��ϴ�»���"+weight3+"kg");
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
			ComputeWeight[] com=new ComputeWeight[3];//��ת�Ͷ���
			com[0] =new Television(85.5);     //�������ӻ�����ִ�и���ʵ�ַ���
			com[1] =new Computer(50.5);      //�������������ִ�и���ʵ�ַ���
			com[2] =new WashMachine(125.5); //����ϴ�»�����ִ�и���ʵ�ַ��� 
			double Weights=0;
			Weights=com[0].computeWeight()+com[1].computeWeight()+com[2].computeWeight();
			System.out.print("��ôװ�صĻ���������Ϊ:"+Weights+"kg");  
			
		}
	}
