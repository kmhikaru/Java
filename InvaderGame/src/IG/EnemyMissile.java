package IG;

import javax.swing.ImageIcon;

public class EnemyMissile extends Character {
	EnemyMissile(int x_ene,int y_ene,int w_ene,int h_ene,ImageIcon eM_icon){
		super(); 
		setLabel(eM_icon);
		x = x_ene;
		y = y_ene;
	}

	public void move() {
		y+=8;
		label.setLocation(x, y); 
	}

	public boolean stageOutJudge(){
		if(y+getLabel().getHeight()<=0) return true;
		return false;
	}
}