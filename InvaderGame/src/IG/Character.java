package IG;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Character {
	protected JLabel label;
	protected int x,y;

	Character(){
		label = new JLabel();
	}

	//���W��Ԃ�
	public int getX(){ return x;}
	public int getY(){ return y;}

	//���x����Ԃ��B
	public JLabel getLabel () {
		return label;
	}

	public abstract void move();

	//icon�����x���ɓ\��
	public void setLabel(ImageIcon icon){
		int width = icon.getIconWidth();
		int height = icon.getIconHeight();
		//label�̃T�C�Y��icon�Ɠ�����
		label.setSize(new Dimension(width,height)); 
		label.setIcon(icon);
	}
}

