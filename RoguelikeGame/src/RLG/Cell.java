package RLG;

import java.awt.Image;

public abstract class Cell {
	private int x,y;
	private boolean judge;//true�Ȃ�N���[�`���[
	public Cell(int a,int b){
		x = a;
		y = b;
		judge=false;
	}
	public abstract Image getImg();
	//�ʉߔ���
	public abstract boolean possToPass();
	
	//creature�����݂��邩��Ԃ��@���݂���Ȃ�true�@���݂��Ȃ��Ȃ�false
	public boolean getJudge(){
		return judge;
	}
	//cell��creature�����邩�ǂ������X�V
	public void updateJdg(boolean jdg){
		judge=jdg;
	}
}
