package ex09;
import ex07.*;
import ex08.*;
public class ALU32 {
	ALU[] alu = new ALU[31];
	ALU_msb alu_msb;
	ORGateN or1;
	NOTGate not1;
	 public ALU32(Path[] ops, // �������
			 Bus a, Bus b,Path carryIn, //����
			 Bus s,Path carryOut,Path zero,Path overflow) { // �o��
			 
		 	Path binvert = ops[2];
			Path[] c = new Path[32];
			Path less = new Path();
			Path[] inner1 = new Path[32]; 
			Path inner2 = new Path();	
			
			for(int i = 0; i < 32; i++) {
					c[i] = new Path();
					if(i == 0)
						alu[i] = new ALU(binvert, ops, a.getPath(i), b.getPath(i),less,carryIn,s.getPath(i),c[i]);
					else if(i < 31)
						alu[i] = new ALU(binvert, ops, a.getPath(i), b.getPath(i),new Path(),c[i-1], s.getPath(i),c[i]);
					else
						alu_msb = new ALU_msb(binvert, ops, a.getPath(i), b.getPath(i),new Path(), c[i-1], s.getPath(i), carryOut, less, overflow);
					inner1[i] = s.getPath(i);
			}
				
			or1 = new ORGateN(inner1, inner2);
				
			not1 = new NOTGate(inner2, zero);
	}
	 
	
	 public void run(){
		//32bit ALU�����ԂɎ��s
		for(int i = 0;i < alu.length;i++) alu[i].run();
		alu_msb.run();
		or1.run();
		not1.run();
		alu[0].run();
	}
}
