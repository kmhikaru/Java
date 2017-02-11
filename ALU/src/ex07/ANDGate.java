package ex07;

public class ANDGate {
	Path in1,in2,out1;
	public ANDGate(Path in1,Path in2,Path out1){
		this.in1 = in1; //����1��ڑ�
		this.in2 = in2; //����2��ڑ�
		this.out1 = out1; //�o��1��ڑ�
	}
	public void run(){
		Signal sig1 = in1.readSignal(); //����1�̐M��
		Signal sig2 = in2.readSignal(); //����2�̐M��
		//�@�_����
		boolean val = sig1.getValue() && sig2.getValue();
		out1.setSignal(new Signal(val)); //�o��1�ɐM����ݒ�
	}
}
