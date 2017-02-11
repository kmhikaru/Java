package RLG;

public class Hero extends Creature{
	public static int gold=0,numPot=0;
	Hero(int x,int y,int hp,int str,int def){
		super(x,y,hp,str,def); 
		setText("@");
		setVerticalAlignment(this.CENTER);
		setHorizontalAlignment(this.CENTER);
		setSize(16,16);
	}

	//gold��ǉ�
	public void addG(int m){
		gold+=m;
	}
	//pt��potion�̎g�����
	public void addnumPot(int pt){
		numPot+=pt;
	}
	//�̗͉�
	public void recover(){
		if(numPot>0){
			if(hp+5>30)//hp�̍ő��30��
				hp=30;
			else hp+=5;
			numPot--;
			System.out.printf("recovered. hp:%d. %d times left.\n",this.hp,numPot);
		}else{
			System.out.println("cant recover.no potion.");
		}
	}
	public void takeAction(){
		if(hp<0)
			this.remove();
	}
	public void remove(){
		System.out.printf("end score(gold):%d\n",gold);
		System.out.println("press the 'e' key to close");
		JRogue.dun.remove(this);//�_���W�����������
		this.validate();
	}
	public void attack(int mx,int my){
		for(int i=0;i<JRogue.dun.numMon;i++){
			if(JRogue.dun.monsters[i]!=null){
				if(JRogue.dun.monsters[i].x==mx&&JRogue.dun.monsters[i].y==my){
					JRogue.dun.monsters[i].hp-=str-JRogue.dun.monsters[i].def;
					System.out.printf("%d damage to monster\n",str-JRogue.dun.monsters[i].def);
				}
			}
		}	
	}
}
