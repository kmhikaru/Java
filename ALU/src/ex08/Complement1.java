package ex08;
import ex07.*;

//32bit��1�̕����\���𓾂��H
public class Complement1 {
	NOTGate[] not1= new NOTGate[32];
	public Complement1(Bus in1,Bus out1){
		//i�Ԗڂ̔z���̐M���𔽓]����
		for(int i = 0;i < 32; i++)
			not1[i] = new NOTGate(in1.getPath(i),out1.getPath(i));
	}
	public void run(){
		for (int i = 0;i<32;i++)
			not1[i].run();
	}
}
