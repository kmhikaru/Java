package ex09;
import ex07.*;
import ex08.*;
public class ALU32Driver {
	public static void main(String[] args) {
		final int MaxInt = 2147483647,MinInt = -2147483648;
		int in1 = 1000,in2 = 2000;
		int ops;
		ops=0;
		System.out.printf("ALU32Test(%d,%d,%d),op:&& => "+ALU32Test(ops,in1,in2)+"\n",ops,in1,in2);
		ops=1;
		System.out.printf("ALU32Test(%d,%d,%d),op:|| => "+ALU32Test(ops,in1,in2)+"\n",ops,in1,in2);
		ops=2;
		System.out.printf("ALU32Test(%d,%d,%d),op:+ => "+ALU32Test(ops,in1,in2)+"\n",ops,in1,in2);
		ops=6;
		System.out.printf("ALU32Test(%d,%d,%d),op:- => "+ALU32Test(ops,in1,in2)+"\n",ops,in1,in2);
		System.out.printf("SltTest(%d,%d) =>"+SltTest(in1,in2)+"\n",in1,in2);
		System.out.printf("SltTest(%d,%d) =>"+SltTest(in2,in1)+"\n",in2,in1);
		System.out.printf("EqTest(%d,%d)=>"+EqTest(in1,in2)+"\n",in1,in2);
		System.out.printf("EqTest(%d,%d)=>"+EqTest(in1,in1)+"\n",in1,in1);
		ops=2;
		System.out.printf("OverflowTest(%d,%d,%d),op:+ =>"+OverflowTest(ops,MaxInt,MinInt)+"\n",ops,MaxInt,MinInt);
		System.out.printf("OverflowTest(%d,%d,%d),op:+ =>"+OverflowTest(ops,MinInt,MaxInt)+"\n",ops,MinInt,MaxInt);
		System.out.printf("OverflowTest(%d,%d,%d),op:+ =>"+OverflowTest(ops,MaxInt,1)+"\n",ops,MaxInt,1);
		System.out.printf("OverflowTest(%d,%d,%d),op:+ =>"+OverflowTest(ops,MaxInt,0)+"\n",ops,MaxInt,0);
		System.out.printf("OverflowTest(%d,%d,%d),op:+ =>"+OverflowTest(ops,MaxInt,-1)+"\n",ops,MaxInt,-1);
		
		ops=6;
		System.out.printf("OverflowTest(%d,%d,%d),op:- =>"+OverflowTest(ops,MaxInt,MinInt)+"\n",ops,MaxInt,MinInt);
		System.out.printf("OverflowTest(%d,%d,%d),op:- =>"+OverflowTest(ops,MinInt,MaxInt)+"\n",ops,MinInt,MaxInt);
		System.out.printf("OverflowTest(%d,%d,%d),op:- =>"+OverflowTest(ops,1,MinInt)+"\n",ops,1,MinInt);
		System.out.printf("OverflowTest(%d,%d,%d),op:- =>"+OverflowTest(ops,0,MinInt)+"\n",ops,0,MinInt);
		System.out.printf("OverflowTest(%d,%d,%d),op:- =>"+OverflowTest(ops,-1,MinInt)+"\n",ops,-1,MinInt);
	}
	public static int ALU32Test(int ops,int a,int b){
		Bus in1 = new Bus(32); // ���͔z��1
		Bus in2 = new Bus(32); // ���͔z��2
		Bus b_ops = new Bus(3);
		b_ops.setValue(ops);
		Path[] opp = new Path[3];
		opp[0] = new Path(); 
		opp[1] = new Path();
		opp[2] = new Path();
		Bus out1 = new Bus(32); // �o�͔z��1
		Path co = new Path();
		ALU32 alu1 = new ALU32(opp, in1, in2, opp[2], out1, co, new Path(), new Path());

		in1.setValue(a); // �M��(1)��ݒ�
		in2.setValue(b); // �M��(2)��ݒ�
		opp[0].setSignal(b_ops.getPath(0).readSignal());
		opp[1].setSignal(b_ops.getPath(1).readSignal());
		opp[2].setSignal(b_ops.getPath(2).readSignal());

		alu1.run();

		return out1.getValue();
	} 
		
	public static boolean SltTest(int a,int b){
		Bus in1 = new Bus(32); // ���͔z��1
		Bus in2 = new Bus(32); // ���͔z��2
		Path[] opp = new Path[3];
		opp[0] = new Path(); 
		opp[1] = new Path();
		opp[2] = new Path();
		Bus out1 = new Bus(32); // �o�͔z��1
		Path co = new Path();
		ALU32 alu1 = new ALU32(opp, in1, in2, opp[2], out1, co, new Path(), new Path());

		in1.setValue(a); // �M��(1)��ݒ�
		in2.setValue(b); // �M��(2)��ݒ�
		opp[0].setSignal(new Signal(true));
		opp[1].setSignal(new Signal(true));
		opp[2].setSignal(new Signal(true));

		alu1.run();
		if(out1.getValue()==1) return true;
		else return false;
	}
	public static boolean EqTest(int a,int b){
		Bus in1 = new Bus(32); // ���͔z��1
		Bus in2 = new Bus(32); // ���͔z��2
		Path[] ops = new Path[3];
		ops[0] = new Path(); ops[1] = new Path(); ops[2] = new Path();
		Path zero = new Path();
		ALU32 alu1 = new ALU32(ops, in1, in2, ops[2], new Bus(32), new Path(), zero, new Path());

		in1.setValue(a); // �M��(1)��ݒ�
		in2.setValue(b); // �M��(2)��ݒ�
		ops[0].setSignal(new Signal(false));
		ops[1].setSignal(new Signal(true));
		ops[2].setSignal(new Signal(true));

		alu1.run();
		return zero.readSignal().getValue();
	}

	public static boolean OverflowTest(int ops,int a,int b){
		Bus in1 = new Bus(32); // ���͔z��1
		Bus in2 = new Bus(32); // ���͔z��2
		Bus b_ops = new Bus(3);
		b_ops.setValue(ops);
		Path[] opp = new Path[3];
		opp[0] = new Path(); 
		opp[1] = new Path(); 
		opp[2] = new Path();
		Bus out1 = new Bus(32); // �o�͔z��1
		Path overflow = new Path();
		ALU32 alu1 = new ALU32(opp, in1, in2, opp[2], out1, new Path(), new Path(), overflow);

		in1.setValue(a); // �M��(1)��ݒ�
		in2.setValue(b); // �M��(2)��ݒ�
		opp[0].setSignal(b_ops.getPath(0).readSignal());
		opp[1].setSignal(b_ops.getPath(1).readSignal());
		opp[2].setSignal(b_ops.getPath(2).readSignal());

		alu1.run();
		return overflow.readSignal().getValue();
	}
}