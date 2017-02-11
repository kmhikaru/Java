package Lifegame;

public class Ground implements Cell{
	int x,y;
	int time=0;
	boolean nextState=false;
	public Ground(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void computeNextState(){
		time++;
		if(time==10) nextState =true;
	}
	public void updateState(){
		if(nextState){
			LifeGameGUI.cell[x][y] = new Plant(x,y);
		}
	}
}
