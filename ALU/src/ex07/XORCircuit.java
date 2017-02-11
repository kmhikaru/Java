package ex07;

public class XORCircuit {
	NOTGate not1,not2;
	ANDGate and1,and2;
	ORGate or1;
	Path in1,in2,out1;
	public XORCircuit(Path in1,Path in2,Path out1){
		this.in1 = in1;
		this.in2 = in2;
		this.out1 = out1;
		Path inner1 = new Path(); //�����z��1
		Path inner2 = new Path(); //�����z��2
		Path inner3 = new Path(); //�����z��3
		Path inner4 = new Path(); //�����z��4
		//�����z�����g����NOTGate�̏o�͂�ANDGate�̓��͂ɁAANDGate�̏o�͂�ORGate�̓��͂�
		not1 = new NOTGate(in1,inner1);
		not2 = new NOTGate(in2,inner2);
		and1 = new ANDGate(inner1,in2,inner3);
		and2 = new ANDGate(in1,inner2,inner4);
		or1 = new ORGate(inner3,inner4,out1);
	}
	public void run(){
		not1.run();
		not2.run();
		and1.run();
		and2.run();
		or1.run();
	}
}
