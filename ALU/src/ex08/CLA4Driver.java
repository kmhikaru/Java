package ex08;
import ex07.*;
public class CLA4Driver {

	public static void main(String[] args){
	for(int i = 0;i<9;i++)
		for(int j =0;j<9;j++)
			System.out.println(i+"+"+j+"="+CLA4Test(i,j));
	}
	public static int CLA4Test(int a,int b){
		Bus a4 = new Bus(4);
		Bus b4 = new Bus(4);
		Path carryIn = new Path();
		Bus s4 = new Bus(4);
		Path carryOut = new Path();
		a4.setValue(a);
		b4.setValue(b);
		CLA4 cla = new CLA4(a4,b4,carryIn,s4,carryOut); 
		cla.run();
		return s4.getValue();
		
	}
}
