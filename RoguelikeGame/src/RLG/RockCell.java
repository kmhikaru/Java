package RLG;

import java.awt.Image;

import javax.swing.ImageIcon;

public class RockCell extends Cell{
	static private ImageIcon rockicon;
	public RockCell(int a,int b){
		super(a,b);
		if(rockicon==null){
			//�摜�̓ǂݍ���
			//rockicon = new ImageIcon("/home/kawachi/edu/2013/cs1/rock.png");
			rockicon =new ImageIcon(("./src/images/rock.png"));
		}
	}
	
	public Image getImg(){
		if(rockicon!=null){
			//�摜�̓ǂݍ���
			return rockicon.getImage();
		}
		return null;
	}
	
	public boolean possToPass(){
		return false;
	}
}
