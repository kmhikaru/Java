package ex10;
import ex07.*;
import ex08.*;
public class Register {
	int val; //���W�X�^�̒l
	Path wctl;
	Bus wdata,rdata;
	public Register(Path wctl, //�������
			Bus wdata, //����
			Bus rdata){ //�o��
		this.wctl = wctl;
		this.wdata = wdata;
		this.rdata = rdata;
	}
	public void setValue(int val){
		this.val = val;
	}
	public int getValue(){
		return val;
	}
	public void run(){
		// 1.���W�X�^�̒l��rdata�ɏo��
		rdata.setValue(val);
		// 2.wctl�̐M�����P�Ȃ�wdata�̒l����������
		if(wctl.readSignal().getValue())
			val = wdata.getValue();
	}
}
