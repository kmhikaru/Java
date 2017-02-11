package RLG;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class DungeonMap extends JPanel{
	public static Cell[][] cells;//�_���W�����̃Z��
	public static Monster[] monsters;//�����X�^�[���Ǘ�����z��
	public static Item[] items;//�A�C�e�����Ǘ�����z��
	public static Rect[] rects;//�����Ǘ�����z��
	public int dunX,dunY;//�_���W������x�����Ay�����T�C�Y
	public static int recW,recH;//��Ԃ̕��A����
	public static Room[][] room;//�������i�[����z��
	public static int  numMon,numItm;//�����X�^�[�A�A�C�e���̐�
	public static int next;//���̃_���W�����Ɉڂ邱�Ƃ��ł���K�i�����镔���̔ԍ�
	public int heroX,heroY;//hero�̏����ʒu
	public static int numRecX,numRecY;//���̐��@�����̐��Ɠ�����
	
	//�Z���̐�����_���W�����̑傫�������߂�
	public DungeonMap(int numCellX,int numCellY){
		dunX=numCellX;
		dunY=numCellY;
		cells = new Cell[numCellX][numCellY];
		//�܂��_���W��������Ŗ��߂�
		for(int i=0;i<numCellX;i++){
			for(int j=0;j<numCellY;j++){
				cells[i][j] = new RockCell(i,j);
			}
		}
		//��ԊO�g��wall��
		for(int i=0;i<dunX;i++){
			for(int j=0;j<dunY;j++){
				if(i==0||j==0||i==dunX-1||j==dunY-1){
					cells[i][j]=new WallCell(i,j);
				}
			}
		}
		//��ԖڂɊO�g��hall��
		for(int i=1;i<dunX-1;i++){
			for(int j=1;j<dunY-1;j++){
				if(i==1||j==1||i==dunX-2||j==dunY-2){
					cells[i][j]=new HallCell(i,j);
				}
			}
		}

		//��敪�� n,m�͋��̐��@�Œ�2�@�ō�3
		numRecX=(int)(Math.random()*2)+3;
		numRecY=(int)(Math.random()*2)+2;

		//�敪�����s���A���킹�ĕ��������
		makeRect(numRecX,numRecY);

		//��l������ԍ���̕����̍���ɐݒu
		heroX=(room[0][0].x)+1;
		heroY=(room[0][0].y)+1;
		JRogue.hero=new Hero(heroX,heroY,10,10,10);
		JRogue.hero.setCre(this);
		
		//�����X�^�[�̐��𗐐��Ō���
		numMon =(int)(Math.random()*25)+15;
		//�����X�^�[���쐬���AMonster�^�z��ɓ����B
		makeMon(numMon);
		//�����X�^�[��ݒu
		for(int i=0;i<monsters.length;i++){
			monsters[i].setCre(this);
		}

		//�A�C�e�����𗐐��Ō���
		numItm =(int)(Math.random()*25)+15;
		//�A�C�e�����쐬���AItem�^�z��ɓ����B
		makeItm(numItm);
		//�A�C�e����ݒu
		for(int i=0;i<items.length;i++){
			items[i].setItm(this);
		}

		//�L�������
		makeHall(room);
		//�T�C�Y���Z���̑傫���~�Z���̐��@�ɃZ�b�g
		setPreferredSize(new Dimension(16*numCellX,16*numCellY));
	}


	public class Rect{
		public int x,y,wid,hei;//x,y�͋��̍���̍��W�@wid,hei�͕��A����
		public boolean roomJud;//���������邩�ǂ���
		Rect(int x,int y,int wid,int hei){
			this.x=x;
			this.y=y;
			this.wid=wid;
			this.hei=hei;
		}
	}

	public class Room{
		public int x,y,wid,hei,recX,recY;//x,y�͕����̍���̍��W�@wid,hei�͕��A�����@recX,recY�͂ǂ��̋�悩

		Room(int x,int y,int wid,int hei,int recX,int recY){
			this.x=x;
			this.y=y;
			this.wid=wid;
			this.hei=hei;
			this.recX=recX;
			this.recY=recY;
		}

	}



	//��敪�� n,m�͋�搔
	public void makeRect(int n,int m){
		rects =new Rect[n*m];//���
		recW=dunX/n;//����x�����̕�
		recH=dunY/m;//����y�����̕�
		room = new Room[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				rects[i*j]=null;
				rects[i*j] =new Rect(i*recW,j*recH,recW,recH);
				int rx,ry,rw,rh;
				int spaceX =2+ (int)(Math.random()*(recW/3));
				int spaceY =2+ (int)(Math.random()*(recH/3));
				boolean maR=true;
				//rx,ry�͕����̍���̍��W�@rw,rh�͕�����
				while(maR){
					rx=rects[i*j].x+spaceX;
					ry=rects[i*j].y+spaceY;
					rw=rects[i*j].wid-(int)(Math.random()*recW)/3-spaceX-2;
					rh=rects[i*j].hei-(int)(Math.random()*recH)/3-spaceY-2;
					if(rw>2&&rh>2){
						makeRoom(rx,ry,rw,rh);
						room[i][j]=null;
						room[i][j] =new Room(rx,ry,rw,rh,i,j);
						maR=false;
					}
				}
			}
		}
	}

	//����̍��W�A���A�����������ɂ��ĕ��������
	public void makeRoom(int x,int y,int wid,int hei){	
		if(x+wid<=dunX&&y+hei<=dunY){
			for(int i=x;i<x+wid&&i<dunX;i++){
				for(int j=y;j<y+hei&&j<dunY;j++){
					if(i==x||j==y||i==x+wid-1||j==y+hei-1){
						cells[i][j] = new WallCell(i,j);
					}else cells[i][j] = new FloorCell(i,j);
				}
			}
		}
	}

	//�����X�^�[�����i�[�@�����̓����X�^�[�̐�
	public void makeMon(int num){
		monsters = new Monster[num];
		//�_���W�������ƂɃ����X�^�[����邽�߂܂����
		for(int i=0;i<monsters.length;i++){
			monsters[i] =null;
		}
		//�����X�^�[�������_���ȍ��W��new�@���̂Ƃ����̍��W�̃Z�����z�u�\�����Z���̎�ށA�N���[�`���[�̗L���ɂ���Ĕ���
		for(int i=0;i<num;i++){
			while(true){
				int x = (int) (Math.random()*dunX);
				int y = (int)(Math.random()*dunY);				
				if(cells[x][y].possToPass()&&!(cells[x][y].getJudge())){
					int hp = (int)((Math.random()*20));
					int str = (int)((Math.random()*10));
					int def = (int)((Math.random()*10));
					if(str<def){
						monsters[i]=new Bat(x,y,hp,str,def,i);
					}else{
						monsters[i] = new Snake(x,y,hp,str,def,i);
					}
					break;//�����X�^�[��K�؂�new�ł�����while���𔲂���
				}
			}
		}
	}

	public void makeItm(int num){
		items = new Item[num];
		//�_���W�������ƂɃA�C�e������邽�߂܂����
		for(int i=0;i<items.length;i++){
			items[i] =null;
		}
		for(int i=0;i<num;i++){
			while(true){
				int x = (int) (Math.random()*dunX);
				int y = (int)(Math.random()*dunY);				
				if(cells[x][y].possToPass()&&!(cells[x][y].getJudge())){
					int pt = (int)((Math.random()*10));
					if(pt<7){
						items[i]=new Potion(x,y,pt,i);
					}else{
						items[i] = new Gold(x,y,pt,i);
					}
					break;//�A�C�e����K�؂�new�ł�����while���𔲂���
				}
			}
		}

	}
	public void makeHall(Room[][] room){
		//�����ƊO��
		for(int i=1;i<numRecX;i++){
			for(int j=2;j<dunY-2;j++){
				cells[i*recW][j] = new HallCell(i*recW,j);
			}
		}
		for(int i=1;i<numRecY;i++){
			for(int j=2;j<dunX-2;j++){
				cells[j][i*recH] = new HallCell(j,i*recH);
			}
		}


		//�����ƒʘH
		for(int i=0;i<numRecX;i++){
			for(int j=0;j<numRecY;j++){
				int dir=(int)(Math.random()*4);
				int midX=room[i][j].x+room[i][j].wid/2;
				int midY=room[i][j].y+room[i][j].hei/2;
				switch(dir){
				//0:��@1:�E�@2:���@3:��
				case 0:
					for(int k=room[i][j].y;k!=1&&k!=j*recH;k--){
						cells[midX][k] = new HallCell(midX,k);
					}
					break;
				case 1:
					for(int k=room[i][j].x+room[i][j].wid-1;k!=dunX-2&&k!=(i+1)*recW;k++){
						cells[k][midY] = new HallCell(k,midY);
					}
					break;
				case 2:
					for(int k=room[i][j].y+room[i][j].hei-1;k!=dunY-2&&k!=(j+1)*recH;k++){
						cells[midX][k] = new HallCell(midX,k);
					}
					break;
				case 3:
					for(int k=room[i][j].x;k!=1&&k!=i*recW;k--){
						cells[k][midY] = new HallCell(k,midY);
					}
					break;
				}		
			}
		}
	}

	public void newDun(){
		cells = new Cell[dunX][dunY];
		
		//�܂��_���W��������Ŗ��߂�
		for(int i=0;i<dunX;i++){
			for(int j=0;j<dunY;j++){
				cells[i][j] =null;
				cells[i][j] =new RockCell(i,j);
			}
		}
		//��ԊO�g��wall��
		for(int i=0;i<dunX;i++){
			for(int j=0;j<dunY;j++){
				if(i==0||j==0||i==dunX-1||j==dunY-1){
					cells[i][j]=new WallCell(i,j);
				}
			}
		}

		//��ԖڂɊO�g��hall��
		for(int i=1;i<dunX-1;i++){
			for(int j=1;j<dunY-1;j++){
				if(i==1||j==1||i==dunX-2||j==dunY-2){
					cells[i][j]=new HallCell(i,j);
				}
			}
		}

		//��敪�� n,m�͋��̐��@�Œ�2�@�ō�3
		numRecX=(int)(Math.random()*2)+3;
		numRecY=(int)(Math.random()*2)+2;

		//�敪�����s���A���킹�ĕ��������
		makeRect(numRecX,numRecY);

		//��l������ԍ���̕����̍���ɐݒu
		heroX=(room[0][0].x)+1;
		heroY=(room[0][0].y)+1;
		JRogue.hero.x=heroX;
		JRogue.hero.y=heroY;
		JRogue.hero.setCre(this);
		
		//�����X�^�[�̐��𗐐��Ō���
		numMon =(int)(Math.random()*25)+15;
		//�����X�^�[���쐬���AMonster�^�z��ɓ����B
		makeMon(numMon);
		//�����X�^�[��ݒu
		for(int i=0;i<monsters.length;i++){
			monsters[i].setCre(this);
		}

		//�A�C�e�����𗐐��Ō���
		numItm =(int)(Math.random()*25)+15;
		//�A�C�e�����쐬���AItem�^�z��ɓ����B
		makeItm(numItm);
		//�A�C�e����ݒu
		for(int i=0;i<items.length;i++){
			items[i].setItm(this);
		}

		//�L�������
		makeHall(room);
	}
	//�_���W�����Ɋe�Z���̃A�C�R����image�ɂ��ĕ`��
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i=0;i<dunX;i++){
			for(int j=0;j<dunY;j++){
				Image img = cells[i][j].getImg();
				g.drawImage(img,i*16,j*16,this);
			}		
		}
	}

}
