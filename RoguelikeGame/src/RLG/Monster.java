package RLG;

public abstract class Monster extends Creature{
	Monster(int x, int y, int hp,int str,int def,int ind) {
		super(x, y, hp,str,def,ind);
	}
	public void attack(int hx,int hy){
		if(JRogue.hero.x==hx&&JRogue.hero.y==hy){
			JRogue.hero.hp-=str-JRogue.hero.def;
		System.out.printf("%d damage hp:%d \n",str,JRogue.hero.hp);
		}
	}
	public void takeAction(){
	}
	public void remove(){
		JRogue.dun.remove(this);//�_���W�����������
		DungeonMap.cells[x][y].updateJdg(false);
		DungeonMap.monsters[ind]=null;
		System.out.println("defeated the monster");
		this.validate();
	}
}
