	package IG;
	
	import java.awt.Rectangle;
	import java.util.ArrayList;
	import java.util.Iterator;
	import javax.swing.ImageIcon;
	import javax.swing.JPanel;
	
	import IG.Character;
	
	public class Missile extends Character {
		boolean hitFlag;
	
		Missile(int x_pla,int y_pla,int w_pla,int h_pla,ImageIcon icon){
			super();
			setLabel(icon);
			int w_mis = getLabel().getWidth();
			int h_mis = getLabel().getHeight();
			x = x_pla + (w_pla - w_mis)/2;
			y = y_pla - h_mis/2;
			hitFlag=false;
		}
		public void move(){
			label.setLocation(x,y);
		}
	
		public void hitJudge(ArrayList<Enemy> enemy,JPanel pane) {
			Rectangle rect = getLabel().getBounds();
			synchronized(enemy){
				for(Iterator<Enemy> i = enemy.iterator(); i.hasNext();){
					Enemy en = i.next();
					Rectangle cRect = en.getLabel().getBounds();
					if(rect.intersects(cRect)){
						pane.remove(en.getLabel());
						pane.remove(getLabel());
						pane.validate();
						i.remove();
						hitFlag=true;
					}
				}
			}
			if(!hitFlag){
				y-=5;
				label.setLocation(x, y); 
			}
		}
	
	
		public boolean stageOutJudge(){
			if(y+getLabel().getHeight()<=0) return true;
			return false;
		}
	}