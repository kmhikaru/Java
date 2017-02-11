package RLG;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FloorCell extends Cell{
	static private ImageIcon flooricon;
	public FloorCell(int a,int b){
		super(a,b);
		if(flooricon==null){
			//�摜�̓ǂݍ���
			//flooricon = new ImageIcon("/home/kawachi/edu/2013/cs1/floor.png");
			flooricon = new ImageIcon(("./src/images/floor.png"));
		}
	}
	
	public Image getImg(){
		if(flooricon!=null){
			//�摜�̓ǂݍ���
			return flooricon.getImage();
		}
		return null;
	}
	
	public boolean possToPass(){
		return true;
	}
	
}
