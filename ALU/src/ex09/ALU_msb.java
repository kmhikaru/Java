package ex09;
import ex07.*;
public class ALU_msb {
	Path[] inner1 = new Path[4];
	Path set;
	ANDGate and1;
	ORGate or1;
	NOTGate not1;
	XORCircuit xor1;
	FA adder1;
	MUX4 mux1;
	MUX mux2;
	public  ALU_msb(Path binvert,Path[] op,	//�������
			Path a,Path b,Path less, //����
			Path carryIn,
			Path s,Path carryOut,	//�o��
			Path set,Path overflow){
		Path[] inner2 = new Path[2];
		
		for(int i = 0; i < inner1.length; i++)
			inner1[i] = new Path();
		for(int i = 0; i < inner2.length; i++)
			inner2[i] = new Path();
		
		not1 = new NOTGate(b, inner2[0]);
		mux2 = new MUX(binvert, b, inner2[0], inner2[1]);
		and1 = new ANDGate(a, inner2[1], inner1[0]);
		or1 = new ORGate(a, inner2[1], inner1[1]);
		adder1 = new FA(a, inner2[1], carryIn, inner1[2], carryOut);
		inner1[3] = less;
		this.set = set;
		xor1 = new XORCircuit(carryIn, carryOut, overflow);
		mux1 = new MUX4(op, inner1, s);
	}
	public void run(){
		not1.run();
		mux2.run();
		and1.run();
		or1.run();
		adder1.run();
		xor1.run();
		mux1.run();
		set.setSignal(new Signal(inner1[2].readSignal().getValue()));
	}
}
