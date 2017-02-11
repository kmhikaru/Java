package RLG;

public class Snake extends Monster{
	Snake(int x,int y,int hp,int str,int def,int ind){
		super(x,y,hp,str,def,ind);
		setText("S");
		setVerticalAlignment(this.CENTER);
		setHorizontalAlignment(this.CENTER);
		setSize(16,16);
	}

	//override
	public void takeAction(){
		//���̕����𗐐��Ō��߂�	
		if(hp<0) remove();
			else{
				int nextDir = (int)(Math.random()*4);
				switch(nextDir){
				case 0:	down();
				break;
				case 1: up();
				break;
				case 2: moveRight();
				break;
				case 3: moveLeft();
				break;
				}
				move();
			}
	}
}
