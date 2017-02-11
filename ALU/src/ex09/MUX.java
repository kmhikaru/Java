package ex09;
import ex07.*;
public class MUX {
	ANDGate and1, and2;
	ORGate or1;
	NOTGate not1;
	public MUX(Path ctl, //�������
			Path in1,Path in2, //����
			Path out1){	//�o��
		Path[] inner = new Path[3];
		for(int i = 0;i < inner.length;i++) inner[i] = new Path();
		not1 = new NOTGate(ctl, inner[0]);
		and1 = new ANDGate(in1, inner[0], inner[1]);
		and2 = new ANDGate(in2, ctl, inner[2]);
		or1 = new ORGate(inner[1], inner[2], out1);
	}
	public void run(){
		not1.run();
		and1.run();
		and2.run();
		or1.run();
	}
}
