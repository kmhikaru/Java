package ex10;
import ex08.*;
public class MUX32_bus {
	Bus ctls,out1;
	Bus[] ins;
	public MUX32_bus(Bus ctls, //5bit
			Bus[] ins, //32�{
			Bus out1){
		this.ctls = ctls;
		this.ins = ins;
		this.out1 = out1;
	}
	public void run(){
		//ctls�̒l�ɂ���đI���������̓o�X�̒l���o�̓o�X�ɐݒ肷��
		int idx = ctls.getValue();
		out1.setValue(ins[idx].getValue());
	}
}
