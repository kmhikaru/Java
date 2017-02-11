package RLG;

import java.awt.Image;

import javax.swing.ImageIcon;

public class WallCell extends Cell{
	static private ImageIcon wallicon;
	public WallCell(int a,int b){
		super(a,b);
		if(wallicon==null){
			//�摜�̓ǂݍ���
			wallicon = new ImageIcon(("./src/images/wall.png"));
			//wallicon = new ImageIcon("/home/kawachi/edu/2013/cs1/wall.png");
		}
	}
	public Image getImg(){
		if(wallicon!=null){
			//�摜�̓ǂݍ���
			return wallicon.getImage();
		}
		return null;
	}
	public boolean possToPass(){
		return false;
	}
}
