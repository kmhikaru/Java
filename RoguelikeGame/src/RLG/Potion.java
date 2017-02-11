package RLG;

public class Potion extends Item{
	//x,y�͍��W�@pt�͉񕜂ł����
	Potion(int x,int y,int pt,int ind){
		super(x,y,pt,ind);
		setText("!");
		setVerticalAlignment(this.CENTER);
		setHorizontalAlignment(this.CENTER);
		setSize(16,16);
	}

	public void takeAction(){
		setLocation(x*16,y*16);	
		if(JRogue.hero.x==x&&JRogue.hero.y==y){
		JRogue.hero.addnumPot(pt);
		System.out.printf("got the potion. hp:%d. %d times left.\n",JRogue.hero.hp,Hero.numPot);
		remove();
		}
	}
}

