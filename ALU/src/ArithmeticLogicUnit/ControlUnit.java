package ArithmeticLogicUnit;
import ex07.*;
import ex08.*;

public class ControlUnit {
	NOTGate[] not = new NOTGate[6];
	ANDGateN[] andn = new ANDGateN[4];
	ORGate[] or = new ORGate[2];
	DUP[] dup = new DUP[6];
	 public ControlUnit(Bus opcode,
			 Path regDst, Path aluSrc, Path memToReg,
			 Path regWrite, Path memWrite, Path memRead,
			 Path branch, Path[] aluOp) { 
		 Path[] notOp = new Path[6];
		 for(int i = 0;i < 6;i++){
			 notOp [i] = new Path();
			 not[i] = new NOTGate(opcode.getPath(i),notOp[i]);
		 }
		 
		 Path[] paths0 = {notOp[0], notOp[1], notOp[2], notOp[3], notOp[4], notOp[5]};
		 Path[] paths1 = {opcode.getPath(0), opcode.getPath(1), notOp[2], notOp[3], notOp[4], opcode.getPath(5)};
		 Path[] paths2 = {opcode.getPath(0), opcode.getPath(1), notOp[2],opcode.getPath(3), notOp[4], opcode.getPath(5)};
		 Path[] paths3 = {notOp[0], notOp[1], opcode.getPath(2),notOp[3], notOp[4], notOp[5]};
		 Path op = new Path(), lw = new Path(), sw = new Path(), beq = new Path(),paths4 = new Path(), paths5 = new Path(), paths6 = new Path(), paths7 = new Path();
			
		 andn[0] = new ANDGateN(paths0, op);
		 andn[1] = new ANDGateN(paths1, lw);
		 andn[2] = new ANDGateN(paths2, sw);
		 andn[3] = new ANDGateN(paths3, beq);
			
		 dup[0] = new DUP(op, regDst, paths6);
		 dup[1] = new DUP(op, aluOp[1], new Path());
		 dup[2] = new DUP(lw, paths4, paths7);
		 dup[3] = new DUP(lw, memToReg, memRead);
		 dup[4] = new DUP(sw, paths5, memWrite);
		 dup[5] = new DUP(beq, branch, aluOp[0]);
			
		 or[0] = new ORGate(paths4, paths5, aluSrc);
		 or[1] = new ORGate(paths6, paths7, regWrite);
	 }
	 public void run(){
		 for(int i = 0; i < not.length; i++) not[i].run();
		 for(int i = 0; i < andn.length; i++) andn[i].run();
		 for(int i = 0; i < dup.length; i++) dup[i].run();
		 for(int i = 0; i < or.length; i++) or[i].run();
	 }
}
