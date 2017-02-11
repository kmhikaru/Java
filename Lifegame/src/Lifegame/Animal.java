package Lifegame;

public class Animal implements Cell{
	int x,y;
	int aroundAnimal=-1; 
	boolean aroundPlant=true;//周りにPlantがあればtrue
	boolean born =true;//生まれたてならtrue
	int old=0;
	public Animal(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void computeNextState(){
		aroundPlant=false;
		born = false;
		aroundAnimal=-1;
			for(int k=-1;k<2;++k){
				for(int l=-1;l<2;++l){
					if(x+k>=0 && y+l>=0 && x+k<LifeGameGUI.tate && y+l<LifeGameGUI.yoko) {
						if(LifeGameGUI.cell[x+k][y+l] instanceof Animal) {
							aroundAnimal++;
						}
						else if(LifeGameGUI.cell[x+k][y+l] instanceof Plant) {
							aroundPlant = true;
						}
					}
				}
			}
		old++;
	}


	public void updateState(){	
		//周りにPlantがない、あるいはanimalLifeSpan(寿命)が20なら8割でAnimalは死ぬ そうでなければ周りのAnimal数により場合分け
		if((!aroundPlant || old==20)&&(int)(Math.random()*10)<7) {
			LifeGameGUI.cell[x][y] = new Ground(x,y);
		}
		else {
			if(aroundAnimal==0){
				//ランダムウォーク
				for(int k=1;!born&&k>-2 ;--k){
					for(int l=1;!born&&l>-2 ;--l){
						if(x+k>=0 && y+l>=0 && x+k<LifeGameGUI.tate && y+l<LifeGameGUI.yoko&&LifeGameGUI.cell[x+k][y+l] instanceof Plant)
							if((int)(Math.random()*9)<1){	
								LifeGameGUI.cell[x][y] = new Ground(x,y);
								LifeGameGUI.cell[x+k][y+l]=new Animal(x+k,y+l);
								born =true;							
							}
					}
				}
			}
			//周りにAnimalが1ついたら周りの各セルそれぞれ3割の確率で子孫を残す
			else if(aroundAnimal==1){
				for(int k=-1;!born&&k<2 ;++k){
					for(int l=-1;!born&&l<2 ;++l){
						if(x+k>=0 && y+l>=0 && x+k<LifeGameGUI.tate && y+l<LifeGameGUI.yoko&&!(LifeGameGUI.cell[x+k][y+l] instanceof Animal)) {
							if((int)(Math.random()*10)<3) {
								LifeGameGUI.cell[x+k][y+l]=new Animal(x+k,y+l);
								born = true;
							}
						}
					}
				}
			}
			//周りにAnimalが2つ以上なら5割の確率で死ぬ
			else if((int)(Math.random()*10)<5&&!born) LifeGameGUI.cell[x][y] = new Ground(x,y);
		}
		born=false;
	}
}
