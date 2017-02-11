package ex07;

public class XORDriver {
	public static void main(String[] args){
		System.out.println("0xor0="+XORTest(false,false));
		System.out.println("0xor1="+XORTest(false,true));
		System.out.println("1xor0="+XORTest(true,false));
		System.out.println("1xor1="+XORTest(true,true));
	}
	public static boolean XORTest(boolean a,boolean b){
		Path in1 = new Path(); //���͔z��1
		Path in2 = new Path(); //���͔z��2
		Path out1 = new Path(); //�o�͔z��
		XORCircuit xor1 = new XORCircuit(in1,in2,out1);
		in1.setSignal(new Signal(a));
		in2.setSignal(new Signal(b));
		
		xor1.run();
		return out1.readSignal().getValue();
 		
	}
}
