package ex07;

public class FADriver {
	public static void main (String[] args){
		int l,m,n;
		boolean a,b,c;
		boolean[] res = FATest(false,false,false);
		for(l=0;l<2;l++){
			for(m=0;m<2;m++){
				for(n=0;n<2;n++){
					if(l==0) a = false;
					else a = true;
					if(m==0) b = false;
					else b = true;
					if(n==0) c = false;
					else c = true;
					res = FATest(a,b,c);
					System.out.println("in1: "+l+" in2: "+m+" Cin: "+n+" sum: "+res[0]+" Cout: "+res[1]);
				}
			}
		}
	}
	
	//Answer �Ɓ@Carry out ��2�v�f�̔z��Ƃ��ĕԂ�
	public static boolean[] FATest(boolean a,boolean b,boolean cin){
		Path in1 = new Path(); //���͔z��1
		Path in2 = new Path(); //���͔z��2
		Path c1 = new Path(); 
		Path sum = new Path();
		Path c2 = new Path();
		FA fa = new FA(in1,in2,c1,sum,c2);
		in1.setSignal(new Signal(a));
		in2.setSignal(new Signal(b));
		c1.setSignal(new Signal(cin));
		fa.run();
		boolean[] res = new boolean[2];
		res[0] = sum.readSignal().getValue();
		res[1] = c2.readSignal().getValue();
		return res;
	}
}
