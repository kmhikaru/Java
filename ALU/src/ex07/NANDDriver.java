package ex07;

public class NANDDriver {
	public static void main(String[] args){
		//���ʂ��o��
		System.out.println("0nand0="+NANDTest(false,false));
		System.out.println("0nand1="+NANDTest(false,true));
		System.out.println("1nand0="+NANDTest(true,false));
		System.out.println("1nand1="+NANDTest(true,true));
	}
	public static boolean NANDTest(boolean a,boolean b){
		Path in1 = new Path(); //���͔z��1
		Path in2 = new Path(); //���͔z��2
		Path out1 = new Path(); //�o�͔z��1
		NANDCircuit nand = new NANDCircuit(in1,in2,out1);
		in1.setSignal(new Signal(a));
		in2.setSignal(new Signal(b));
		nand.run();
		return out1.readSignal().getValue();
	}
}
