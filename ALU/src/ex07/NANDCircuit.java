package ex07;

public class NANDCircuit {
	ANDGate and1;
	NOTGate not1;
	public NANDCircuit(Path in1,Path in2,Path out1){
		Path inner = new Path();//�����z��
		//�����z����������ANDGate�̏o�͂�NOTGate�̓��͂�ڑ�
		and1 = new ANDGate(in1,in2,inner);
		not1 = new NOTGate(inner,out1);	
		
	}
	public void run(){
		//�e�Q�[�g�����s
		and1.run();
		not1.run();
	}
}
