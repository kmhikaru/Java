package RLG;

import javax.swing.JLabel;

public class Item extends JLabel{
	public int x,y,pt,ind;
	Item(int x,int y,int pt,int ind){
		this.x=x;
		this.y=y;
		this.pt=pt;
		this.ind=ind;
		
	}
	
	public void remove(){
			JRogue.dun.remove(this);
			JRogue.dun.items[ind]=null;
			//JRogue.dun.validate();		
	}
	
	public void takeAction(){	
	}
	public void setItm(DungeonMap d){			
		if(DungeonMap.cells[x][y].possToPass()&&!(DungeonMap.cells[x][y].getJudge()))//�ʉ߉\����Ɓ@Creature�̑��ݔ���
			d.add(this);
	}
	
}
