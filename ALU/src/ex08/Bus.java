package ex08;
import ex07.*;

public class Bus {
	Path[] paths;
	//n�r�b�g�̃p�X���쐬
	public Bus(int n){
		paths = new Path[n];
		for(int i = 0; i<n; i++)
			paths[i] = new Path();
	}
	//val�̒l��\���悤�ɔz���ɐM����ݒ�,n���i���ŕ\���悤�Ɋe����̐M����ݒ�
	public void setValue(int val){
		for(int i = 0;i<paths.length;i++){
			if((val & 0x1) != 0)//�r�b�g�������Ă�����
				paths[i].setSignal(new Signal(true));
			else
				paths[i].setSignal(new Signal(false));
			val >>= 1; //1bit�E�V�t�g
		}
	}
	//�z���̐M���ɂ���ĕ\����鐮���l��Ԃ�
	public int getValue(){
		int val = 0;
		for (int i = paths.length-1; i >= 0;i--){
			val <<= 1; //1bit���V�t�g
			if(paths[i].readSignal().getValue())
				val += 1;
		}
		return val;
	}
	//i�Ԗڂ̔z�������o��
	public Path getPath(int i){
		return paths[i];
	}
	 // index�Ԗڂ���num�{�̔z�������o�����o�X�̃T�u�Z�b�g��Ԃ�
	 public Bus getSubset(int index, int num) {
		 Bus subBus = new Bus(num);
		 for (int i = 0; i < num; i++)
		 subBus.paths[i] = this.paths[index + i];
		 return subBus;
		 } 
}
