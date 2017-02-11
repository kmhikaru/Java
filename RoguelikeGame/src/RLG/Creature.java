package RLG;

import javax.swing.JLabel;

public abstract class Creature extends JLabel{
	public int x,y,hp,str,def,ind;
	//�����X�^�[�p
	Creature(int x,int y,int hp,int str,int def,int ind){
		this.x=x;
		this.y=y;
		this.hp=hp;
		this.str=str;
		this.def=def;
		this.ind=ind;
	}

	//hero�p
	Creature(int x,int y,int hp,int str,int def){
		this.x=x;
		this.y=y;
		this.hp=hp;
		this.str=str;
		this.def=def;
	}

	public void setCre(DungeonMap d){			
		if(DungeonMap.cells[x][y].possToPass()&&!(DungeonMap.cells[x][y].getJudge()))//�ʉ߉\����Ɓ@Creature�̑��ݔ���
			d.add(this);
		DungeonMap.cells[x][y].updateJdg(true);
	}

	public void moveRight(){
		//�ʉ߉\����Ɓ@�N���[�`���[�̑��ݔ���
		if(DungeonMap.cells[x+1][y].possToPass()){
			if(!(DungeonMap.cells[x+1][y].getJudge())){
				DungeonMap.cells[x][y].updateJdg(false);//Creature���ړ�����(����)
				x=x+1;
				DungeonMap.cells[x][y].updateJdg(true);
			}else{//�U�����L�q
				attack(x+1,y);
			}
		}
	}
	
	public void moveLeft(){
		//�ʉ߉\����Ɓ@�N���[�`���[�̑��ݔ���
		if(DungeonMap.cells[x-1][y].possToPass()){
			if(!(DungeonMap.cells[x-1][y].getJudge())){
				DungeonMap.cells[x][y].updateJdg(false);//Creature���ړ�����(����)
				x--;
				DungeonMap.cells[x][y].updateJdg(true);
			}else{
				attack(x-1,y);
			}
		}
	}
	
	public void up(){
		if(DungeonMap.cells[x][y-1].possToPass()){	//�ʉ߉\����
			if(!(DungeonMap.cells[x][y-1].getJudge())){//�N���[�`���[�̑��ݔ���
				DungeonMap.cells[x][y].updateJdg(false);//Creature���ړ�����(����)
				y--;
				DungeonMap.cells[x][y].updateJdg(true);
			}else{
				attack(x,y-1);
			}
		}
	}
	
	public void down(){
		if(DungeonMap.cells[x][y+1].possToPass()){//�ʉ߉\����
			if(!(DungeonMap.cells[x][y+1].getJudge())){//�N���[�`���[�����邩	
				DungeonMap.cells[x][y].updateJdg(false);//Creature���ړ�����(����)
				y++;
				DungeonMap.cells[x][y].updateJdg(true);
			}else{
				attack(x,y+1);
			}
		}
	}
	
	public void move(){
		this.setLocation(x*16,y*16);
	}
	public void remove(){
	}
	public void recover() {
	}

	public void addnumPot(int pt) {
	}

	public void attack(int x,int y){
	}

	public void addG(int pt) {
	}

	public void takeAction() {
	}
}


