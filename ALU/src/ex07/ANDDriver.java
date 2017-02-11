package ex07;

public class ANDDriver {
	public static void main(String[] args){
		//true���o�͂����
		System.out.println("0and0="+ANDTest(false,false));
		System.out.println("0and1="+ANDTest(false,true));
		System.out.println("1and0="+ANDTest(true,false));
		System.out.println("1and1="+ANDTest(true,true));
	}
	public static boolean ANDTest(boolean a,boolean b){
		Path in1 = new Path(); //���͔z��1
		Path in2 = new Path(); //���͔z��2
		Path out1 = new Path(); //�o�͔z��
		ANDGate and1 = new ANDGate(in1,in2,out1);
		
		in1.setSignal(new Signal(a));
		in2.setSignal(new Signal(b));
		
		and1.run(); // 1 and 1
		
		return out1.readSignal().getValue(); //1��return�����
	}
}
