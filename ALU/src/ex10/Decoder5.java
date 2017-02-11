package ex10;
import ex07.*;
import ex08.*;
//5�r�b�g(a)����32�r�b�g(b)�ւ̃f�R�[�_
//��H��p�����ɍ쐬���Ă悢(if�����g�p��)
public class Decoder5 {
	Bus a,b;
	public Decoder5(Bus a,Bus b){
		this.a = a;
		this.b = b;
	}
	public void run(){
		//�o�Xb�̓��Aa�̒l�ɂ���đI�΂�� �z���̒l������1n�ɐݒ肷��(��̔z����0)
		int idx = a.getValue();
		for(int i = 0;i < 32;i++){ 
			if(i == idx) b.getPath(i).setSignal(new Signal(true));
			else b.getPath(i).setSignal(new Signal(false));
		}
	}
}
