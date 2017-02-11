package RLG;

import java.awt.Image;

import javax.swing.ImageIcon;

public class HallCell extends Cell{
	static private ImageIcon hallicon;
	public HallCell(int a,int b){
		super(a,b);
		if(hallicon==null){
			//�摜�̓ǂݍ���
			//hallicon = new ImageIcon("/home/kawachi/edu/2013/cs1/hall.png");
			hallicon = new ImageIcon(("./src/images/hall.png"));
		}
	}
	
	public Image getImg(){
		if(hallicon!=null){
			//�摜�̓ǂݍ���
			return hallicon.getImage();
		}
		return null;
	}
	
	public boolean possToPass(){
		return true;
	}
	
}
