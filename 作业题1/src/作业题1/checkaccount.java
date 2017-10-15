/**
 * 
 */
package 作业题1;

/**
 * @author Hejing
 *
 */
/*模拟银行定期存款功能。创建银行定期存款账户类DepositAccount，其中包括：账号、
 * 储户姓名、存款余额、年利率等属性，和开户、存款、查询、计算利息等方法。要求用静态变量
 * 存储年利率，用私有实例变量存储其它属性。提供计算年利息的方法和计算月利息(年利息/12)
 * 的方法。另外编写一个测试程序测试该类，建立Account的对象saver(账号：1234567890，
 * 姓名：ZhangSan，定存5000元)，设置年利率是2.3%，存款2000元，查询余额，计算并显示年利息。
 */
import 作业题1.DepositAccount;

class DepositAccount {
	private  String name;     //姓名
	private  String account;    //账号
	private double balance;   //余额
	static double profit;      //年利率
	DepositAccount(String a,String b,double c){   //构造
		 this.name=a;   //姓名
		 this.account=b;//账号
	     this.balance=c ;//余额
	      }
	
	
	
	public String getname(){ //查询储户姓名
		return name;
	}
	
	public String getaccount(){ //查询储户账号
		return account;
	}
	public void save(float m){ //存款 
		System.out.println("在当前账户存款" + m+"元");  
		balance += m;  
		System.out.println("存款成功！您当前余额为：" + balance+"元");
	}
	public double getbalance(){ //查询余额
		return balance;
	}
    public static void  setprofit(double d){  //年利率
    	profit=d;
	
}	
	public double yearprofit() {  //年利息=金额*年利率  
		return balance * profit;  
		}
	
	public double monthprofit() {  //月利息=金额* 年利率、12（月）
		return balance* profit/12;  
		}
	
}
public  class checkaccount{   //测试类
	
	public static void main(String args[]) { 
		
		DepositAccount saver = new DepositAccount("ZhangSan","1234567890",5000); 
		DepositAccount.setprofit(0.023);  //年利率设置为2.3%
		System.out.println("储户姓名:"+saver.getname());//查询储户姓名
		System.out.println("储户账号:"+saver.getaccount()); // 查询储户账号
		System.out.println("定存:"+saver.getbalance()+"元"); //定存5000元
		System.out.println("年利率是2.3%");
		saver.save(2000); //存款2000元
		saver. yearprofit();
		System.out.println("通过计算可知年利息为:"+ saver. yearprofit()+"元"); //年利息 
		
		
		
	}

}


