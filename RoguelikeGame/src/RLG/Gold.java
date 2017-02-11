package RLG;

public class Gold extends Item{
	//x,y�͍��W�@point�͗�
	Gold(int x,int y,int pt,int ind){
		super(x,y,pt,ind);
		setText("*");
		setVerticalAlignment(this.CENTER);
		setHorizontalAlignment(this.CENTER);
		setSize(16,16);
	}
	public void takeAction(){
		setLocation(x*16,y*16);	
		if(JRogue.hero.x==x&&JRogue.hero.y==y){
		JRogue.hero.addG(pt);
		System.out.printf("get %d gold | gold:%d\n",pt,Hero.gold);
		remove();
		}
	}
}
