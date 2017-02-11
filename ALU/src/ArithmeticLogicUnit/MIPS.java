package ArithmeticLogicUnit;
import ex07.*;
import ex08.*;
import ex09.*;
import ex10.*;

public class MIPS {
	// PC, RegisterFile, InstMemory, ALU32,
	PC pc;
	RegisterFile regFile;
	InstMemory iMem;
	ALU32 alu,adder1;
	// ControlUnit, ALUControlUnit���K�v
	ControlUnit conUni;
	ALUControlUnit aluConUni;
	Path[] op1 = new Path[3];
	Path inner;

	public MIPS() {	
		// ---��H�쐬---
		Bus npc1 = new Bus(32),pc1 = new Bus(32),instr = new Bus(32),wdata = new Bus(32),rdata1 = new Bus(32),rdata2 = new Bus(32);
		Path regWrite = new Path();inner = new Path();
		Path[] aluOp = new Path[2]; for(int i = 0;i < 2;i++) aluOp[i] = new Path();
		Path[] op = new Path[3]; for(int i = 0;i < 3;i++) op[i] = new Path();

		pc = new PC(npc1, pc1);
		iMem = new InstMemory(pc1, instr);
		conUni = new ControlUnit(instr.getSubset(26, 6), new Path(), new Path(), new Path(), regWrite, new Path(), new Path(), new Path(), aluOp);
		aluConUni = new ALUControlUnit(instr.getSubset(0, 6), aluOp, op);
		regFile = new RegisterFile(regWrite,instr.getSubset(21, 5), instr.getSubset(16, 5),instr.getSubset(11, 5), wdata,rdata1, rdata2);
		alu = new ALU32(op, rdata1, rdata2, op[2], wdata, new Path(), new Path(), new Path());
		Bus four = new Bus(32);

		for(int i = 0; i < 3; i++)
			op1[i] = new Path();

		op1[1].setSignal(new Signal(true));//�����Z
		four.setValue(4);
		adder1 = new ALU32(op1,pc1,four,new Path(),npc1,new Path(),new Path(),new Path());
		// -------------
		pc.setValue(0x04000000);
		// PC	�Ɏ��s�J�n�A�h���X��ݒ�
		iMem.setInst(0x04000000, 0x012a4020); //add $t0, $t1, $t2
		iMem.setInst(0x04000004, 0x012a4022); //sub $t0, $t1, $t2
		iMem.setInst(0x04000008, 0x012a4024); //and $t0, $t1, $t2
		iMem.setInst(0x0400000c, 0x012a4025); //or $t0, $t1, $t2
		//�������ɖ��߂��i�[
		//��	)add $t0, $t1, $t2 => 0x012a4020
		regFile.setValue(9,	0x100);// $t1�i9�ԃ��W�X�^�j�ɑ�� (�����ł�256)
		regFile.setValue(10, 0x300);// $t2�i10�ԃ��W�X�^�j�ɑ���@(�����ł�768)
	} 

	public void run() {
		long start = System.currentTimeMillis();
		//400000��v�Z����
		for(int j = 0; j < 100000; j++){
			for(int i=0;i<4;i++){
				pc.run();
				iMem.run();
				conUni.run();
				aluConUni.run();
				regFile.run();
				alu.run();
				regFile.run();
				// ALU	 �̌v�Z���ʂ��������ނ��߂ɂ�����x
				// $t0 �i 8�ԃ��W�X�^�j�̓��e��\������ꍇ
				System.out.println(regFile.getValue(8));
				adder1.run();
				pc.run();
			}
			pc.setValue(0x04000000);
		}
		long stop = System.currentTimeMillis();
		System.out.printf("time is %d [ms]\n",(stop-start));
	}

	public static void main(String[] args) {
		new MIPS().run();
		// ���s���J�n
	} 
}
