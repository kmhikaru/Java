package Lifegame;

public class LifeGame {
	static LifeGameGUI lifeGame;
	public static void main(String[] args){
		LifeGameGUI lifeGame = new LifeGameGUI(50,50);		
		LifeGameGUI.updateCells();
	}
}
