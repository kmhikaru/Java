package ArithmeticLogicUnit;
import ex07.*;
import ex08.*;


public class ALUControlUnit {
	NOTGate not1,not2;
	ANDGate and1,and2;
	ORGate or1,or2,or3;
	public ALUControlUnit(Bus funct,Path[] aluOp,Path[] op){
		Path[] paths = new Path[4];
		for(int i = 0;i < 4;i++) paths[i] = new Path();
		or1 = new ORGate(funct.getPath(3), funct.getPath(0), paths[0]);
		and1 = new ANDGate(funct.getPath(1), aluOp[1], paths[1]);
		and2 = new ANDGate(aluOp[1], paths[0], op[0]);
		not1 = new NOTGate(aluOp[1], paths[2]);
		not2 = new NOTGate(funct.getPath(2), paths[3]);
		or2 = new ORGate(aluOp[0], paths[1], op[2]);
		or3 = new ORGate(paths[2], paths[3], op[1]);
	}
	public void run(){
		or1.run();
		and1.run();
		and2.run();
		not1.run();
		not2.run();
		or2.run();
		or3.run();
	}
}
