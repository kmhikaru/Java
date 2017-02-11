package ex09;
import ex07.*;
import ex08.*;

public class MUX4 {
	ANDGateN[] andn;
	NOTGate[] not;
	ORGateN or1;

	public MUX4(Path[] ctls, //�������
			Path[] ins,	//����
			Path out1){ //�o��
		Path[] inner = new Path[6];
		not = new NOTGate[2];
		andn = new ANDGateN[4];
		for(int i = 0;i < inner.length;i++) inner[i] = new Path();
		for(int i = 0;i < not.length;i++) not[i] = new NOTGate(ctls[i],inner[i]);
		
		Path[] ps1 = {ins[0],inner[0],inner[1]};
		Path[] ps2 = {ins[1],ctls[0],inner[1]};
		Path[] ps3 = {ins[2],inner[0],ctls[1]};
		Path[] ps4 = {ins[3],ctls[0],ctls[1]};
		
		andn[0] = new ANDGateN(ps1, inner[2]);
		andn[1] = new ANDGateN(ps2, inner[3]);
		andn[2] = new ANDGateN(ps3, inner[4]);
		andn[3] = new ANDGateN(ps4, inner[5]);
		
		Path[] ps5 = {inner[2],inner[3],inner[4],inner[5]};
		
		or1 = new ORGateN(ps5,out1);
	}
	public void run(){
		for(int i = 0;i < not.length;i++) not[i].run();
		for(int i = 0;i < andn.length;i++) andn[i].run();
		or1.run();
	}	
}
