package RLG;


public class Bat extends Monster{
	private int pastX,pastY;
	public int nextDir;
	Bat(int x,int y,int hp,int str,int def,int ind){
		super(x,y,hp,str,def,ind);
		pastX=0;
		pastY=0;
		setText("B");
		setVerticalAlignment(this.CENTER);
		setHorizontalAlignment(this.CENTER);
		setSize(16,16);

	}
	//�Ȃ�ׂ������^���ɂȂ�悤�Ɉړ��O�̍��W�ƌ��݂̍��W���玟�̓����𓱂�
	public int nextMove(int x,int y){
		int dx=x-pastX,dy=y-pastY;//�ǂ̂悤�Ɉړ����������v�Z
		pastX=x;//���̈ړ��������v�Z���邽�߂Ɍ��݂̍��W���i�[
		pastY=y;
		if(dx==0){
			if(dy>0) return 0;//�Ȃ�ׂ�down
			else return 1;//�Ȃ�ׂ�up
		}else if(dx>0) return 2;//�Ȃ�ׂ�moveRight
		else return 3;//�Ȃ�ׂ�moveLeft
	}
	public void takeAction(){
		if(hp<0) remove();//��
		else{
			int nextDir = nextMove(x,y);
			//�ړ�(���W�ύX�j�@�ȉ��͎��肪�ړ��\�ȏ󋵂ł��鎞��7/10+1/4=38/40�őO�Ɠ��������ɓ���
			if((int)(Math.random()*10)<7){
				switch(nextDir){
				case 0: down();
				break;
				case 1: up();
				break;
				case 2: moveRight();
				break;
				case 3: moveLeft();
				break;
				}
			}else {
				nextDir =(int)(Math.random()*4);
				switch(nextDir){
				case 0: up();
				break;
				case 1: down();
				break;
				case 2: moveLeft();break;
				case 3: moveRight();
				break;
				}	
			}
			move();
		}

	}
}
