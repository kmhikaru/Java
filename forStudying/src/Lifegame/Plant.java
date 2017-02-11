package Lifegame;

public class Plant implements Cell{
	int x,y;
	int old=0;//寿命
	boolean nextState;
	public Plant(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void computeNextState(){
		old++;//年を重ねる
		if(old>50) nextState=true;
		}
	public void updateState(){
		//枯れる
		if(nextState&&(int)(Math.random()*10)<7) LifeGameGUI.cell[x][y] = new Ground(x,y);
	}
}
