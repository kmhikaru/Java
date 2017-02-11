package ex08;
import ex07.*;
public class RCA {
	FA[] adder = new FA[32]; //1bit�S���Z��
	Path[] c= new Path[32];
	//a,b;���́@carryin;c0 s;�o�� carryout
	public RCA(Bus a,Bus b,Path carryIn,Bus s,Path carryOut){
		c[0] = carryIn;
		for(int i = 0;i<32;i++){
			//��H���쐬
			if(i==31)
				adder[i] = new FA(a.getPath(i),b.getPath(i),c[i],s.getPath(i),carryOut);
			else
			{
				c[i+1] = new Path();
				adder[i] = new FA(a.getPath(i),b.getPath(i),c[i],s.getPath(i),c[i+1]);	
			}
		}
	}
	public void run(){
		for(int i=0;i<32;i++){
			adder[i].run();
		}
	}
}
