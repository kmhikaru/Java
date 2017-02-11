package ex07;

public class NOTDriver {
	public static void main(String[] args){
		//���ʂ��o��
		System.out.println("not 0="+NOTTest(false));
		System.out.println("not 1="+NOTTest(true));
	}
	
	public static boolean NOTTest(boolean a){
		Path in1 = new Path(); //���͐M��
		Path out1 = new Path();//�o�͐M��	
		NOTGate not = new NOTGate(in1,out1);
		in1.setSignal(new Signal(a));
		not.run();
		return out1.readSignal().getValue();
	}
}
