package ex08;
import ex07.*;
public class RCADriver {
	public static void main(String[] args){
	System.out.println(RCATest(1000,2000));
	}
	public static int RCATest(int na,int nb){
		Bus a = new Bus(32);//32�r�b�g�̃p�X
		Bus b = new Bus(32);
		Path carryIn = new Path();
		Bus s = new Bus(32);
		Path carryOut = new Path();	
		RCA adder = new RCA(a,b,carryIn,s,carryOut);
		
		a.setValue(na); //Ex.1000
		b.setValue(nb); //Ex.2000
		adder.run();
		return s.getValue(); //Should be 3000
	}	
}
