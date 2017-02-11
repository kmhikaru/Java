package ex08;
import ex07.*;
public class PFA {
	ANDGate and;
	ORGate or;
	FA f;
	public PFA(Path a,Path b,Path carryIn,Path g,Path p,Path s){
		and = new ANDGate(a,b,g);
		or = new ORGate(a,b,p);
		f = new FA(a,b,carryIn,s,new Path());
	}
	public void run(){
		and.run();
		or.run();
		f.run();
	}
}
