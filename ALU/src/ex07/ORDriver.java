package ex07;

public class ORDriver {
	public static void main(String[] args){
		//���ʂ��o��
		System.out.println("0or0="+ORTest(false,false));
		System.out.println("0or1="+ORTest(false,true));
		System.out.println("1or0="+ORTest(true,false));
		System.out.println("1or1="+ORTest(true,true));
		
		
		
	}
	public static boolean ORTest(boolean a,boolean b){
		Path in1 = new Path(); //���͔z��1
		Path in2 = new Path(); //���͔z��2
		Path out1 = new Path(); //�o�͔z��
		ORGate or1 = new ORGate(in1,in2,out1);
		
		in1.setSignal(new Signal(a)); //�M��(1)��ݒ�
		in2.setSignal(new Signal(b)); //�M��(2)��ݒ�
		
		or1.run(); //1 or 1
		
		return out1.readSignal().getValue();
	}
}
