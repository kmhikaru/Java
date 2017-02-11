package IG;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fighter extends Character{
	Dimension d = Invader.getWinSize();
	int widOfd = (int)d.getWidth(); //�L���X�g
	int heiOfd = (int)d.getHeight();
	int w,h;
	boolean hitFlag = false;

	Fighter(ImageIcon icon){
		super();
		setLabel(icon);	
		w = getLabel().getWidth();
		h = getLabel().getHeight();
		//�����ʒu
		x =widOfd/2;
		y =heiOfd-h;
	}

	//���x���������ʒu�ɃZ�b�g
	public void move() {
		label.setLocation(x, y); 
	}

	public void hitJudge(ArrayList<Enemy> enemy,ArrayList<EnemyMissile> enemyM,JPanel pane){
		Rectangle rect = getLabel().getBounds();
		synchronized(enemyM){
			for(Iterator<EnemyMissile> i = enemyM.iterator(); i.hasNext();){
				EnemyMissile enM = i.next();
				Rectangle cRect = enM.getLabel().getBounds();
				if(rect.intersects(cRect)){
					pane.remove(enM.getLabel());
					pane.remove(getLabel());
					pane.validate();
					i.remove();
					hitFlag=true;
				}
			}
			synchronized(enemy){	
				for(Iterator<Enemy> j = enemy.iterator(); j.hasNext();){
					Enemy en = j.next();
					Rectangle dRect = en.getLabel().getBounds();
					if(rect.intersects(dRect)){
						pane.remove(en.getLabel());
						pane.remove(getLabel());
						pane.validate();
						j.remove();
						hitFlag=true;
					}				
				}
			}
		}
	}

	public void moveRight(){
		//�E�B���h�E����o�Ȃ��悤��
		if(x+w<widOfd)
			x+=5;
	}
	public void moveLeft(){
		//�E�B���h�E����o�Ȃ��悤��
		if(0<x)
			x-=5;
	}
}