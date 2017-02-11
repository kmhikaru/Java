package ex07;

public class ORGate {
	Path in1,in2,out1;
	public ORGate(Path in1,Path in2,Path out1){
		this.in1 = in1;
		this.in2 = in2;
		this.out1 = out1;
	}
	public void run(){
		Signal sig1 = in1.readSignal();//����1�̐M��
		Signal sig2 = in2.readSignal();//����2�̐M��
		//�_����
		boolean val = sig1.getValue()||sig2.getValue();
		out1.setSignal(new Signal(val));
	}
}
