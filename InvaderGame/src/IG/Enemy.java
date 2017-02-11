package IG;

import java.awt.Dimension;
import javax.swing.ImageIcon;

public class Enemy extends Character{
	Dimension d;
	int widOfd,heiOfd,widOfLabel,heiOfLabel;
	int movejudge=0;//�������������߂�
	int period=0;
	Enemy(int i,int j,int amountX,int amountY,ImageIcon icon){
		super();		
		setLabel(icon);
		d = Invader.getWinSize();//Invader�̃E�B���h�E�T�C�Y
		widOfd = (int)d.getWidth();
		heiOfd = (int)d.getHeight();
		widOfLabel = getLabel().getWidth();
		heiOfLabel = getLabel().getHeight();
		//�����ʒu
		x = (widOfd/amountX)*i;
		y = 2*heiOfLabel*(j+1);
	}

	public void move() {
		if(period%50==1){
			switch(movejudge%4){
			//�E�ɓ���
			case 0:
				x=x+2*widOfLabel;
				//���ɓ���
			case 2:
				x=x-widOfLabel;
				//���ɓ���
			default:
				y=y+heiOfLabel;
			}
			movejudge++;
		}
		label.setLocation(x,y);
		period++;
		if(y==widOfd){
			System.out.println("defeated");
			System.exit(0);
		}
	}
}