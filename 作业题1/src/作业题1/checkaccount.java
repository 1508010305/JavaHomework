/**
 * 
 */
package ��ҵ��1;

/**
 * @author Hejing
 *
 */
/*ģ�����ж��ڴ��ܡ��������ж��ڴ���˻���DepositAccount�����а������˺š�
 * ��������������������ʵ����ԣ��Ϳ���������ѯ��������Ϣ�ȷ�����Ҫ���þ�̬����
 * �洢�����ʣ���˽��ʵ�������洢�������ԡ��ṩ��������Ϣ�ķ����ͼ�������Ϣ(����Ϣ/12)
 * �ķ����������дһ�����Գ�����Ը��࣬����Account�Ķ���saver(�˺ţ�1234567890��
 * ������ZhangSan������5000Ԫ)��������������2.3%�����2000Ԫ����ѯ�����㲢��ʾ����Ϣ��
 */
import ��ҵ��1.DepositAccount;

class DepositAccount {
	private  String name;     //����
	private  String account;    //�˺�
	private double balance;   //���
	static double profit;      //������
	DepositAccount(String a,String b,double c){   //����
		 this.name=a;   //����
		 this.account=b;//�˺�
	     this.balance=c ;//���
	      }
	
	
	
	public String getname(){ //��ѯ��������
		return name;
	}
	
	public String getaccount(){ //��ѯ�����˺�
		return account;
	}
	public void save(float m){ //��� 
		System.out.println("�ڵ�ǰ�˻����" + m+"Ԫ");  
		balance += m;  
		System.out.println("���ɹ�������ǰ���Ϊ��" + balance+"Ԫ");
	}
	public double getbalance(){ //��ѯ���
		return balance;
	}
    public static void  setprofit(double d){  //������
    	profit=d;
	
}	
	public double yearprofit() {  //����Ϣ=���*������  
		return balance * profit;  
		}
	
	public double monthprofit() {  //����Ϣ=���* �����ʡ�12���£�
		return balance* profit/12;  
		}
	
}
public  class checkaccount{   //������
	
	public static void main(String args[]) { 
		
		DepositAccount saver = new DepositAccount("ZhangSan","1234567890",5000); 
		DepositAccount.setprofit(0.023);  //����������Ϊ2.3%
		System.out.println("��������:"+saver.getname());//��ѯ��������
		System.out.println("�����˺�:"+saver.getaccount()); // ��ѯ�����˺�
		System.out.println("����:"+saver.getbalance()+"Ԫ"); //����5000Ԫ
		System.out.println("��������2.3%");
		saver.save(2000); //���2000Ԫ
		saver. yearprofit();
		System.out.println("ͨ�������֪����ϢΪ:"+ saver. yearprofit()+"Ԫ"); //����Ϣ 
		
		
		
	}

}


