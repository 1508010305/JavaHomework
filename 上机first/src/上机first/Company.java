/*
*编写一个java应用程序，要求有一个abstract类，类名为Employee，Employee的子类有YearWorker、MonthWorker、WeekWorker。
* 
*/
package 上机first;

/**
*******************************************

* @author Hejing
* @date   2017年11月08日
* @class   Company.java
****************************************
*/

 abstract class Employee{
	 abstract public double earnings(); 
 }
class YearWorker extends Employee{
       int year;
       double salary;
       YearWorker(int n,double m){
	   year=n;
	   salary=m;
	   }
       public void setyear(int n) {year=n;}
       public double earnings() {
		// TODO Auto-generated method stub
		     return salary*year;
	}

}
class MonthWorker extends Employee{
		private int month;
		private double salary;
		MonthWorker(int n,double m){
			month=n;
			salary=m;
		}
		public void setmonth(int n) {month=n;}
		public double earnings() {
				// TODO Auto-generated method stub
				return salary*month;
			}

		}
	class WeekWorker extends Employee{
			private int week;
			private double salary;
			WeekWorker(int n,double m){
				week=n;
				salary=m;
			}	
			public void setweek(int n) {week=n;}
			public double earnings() {
				   // TODO Auto-generated method stub
					return salary*week;
				}

			}

	class Company {
		Employee[]  em;
		Company (Employee[] em){
			this.em=em;
		}
	public static  void main(String agrs[]) {
		    Employee[]  em=new Employee[3];
			em[0]=new YearWorker(1,12000);
			em[1]=new MonthWorker(10,8000);
			em[2]=new WeekWorker(40,1000);
	      Company c=new Company(em);  
		    double sum;
		    sum=em[0].earnings()+em[1].earnings()+em[2].earnings();
		    System.out.println("一年应支付 的总金额为"+sum+"元");
	}
	}


