package IG;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*;

public class Invader implements KeyListener{
	private JFrame frame;
	static JPanel pane;
	private Fighter player;
	private ArrayList<Missile> m_list = new ArrayList<Missile>();
	private ArrayList<EnemyMissile> eM_list = new ArrayList<EnemyMissile>();
	private ArrayList<Enemy> e_list = new ArrayList<Enemy>();
	static ImageIcon e_icon,f_icon,m_icon,hit_icon;//enemy,fighter,missile�̃A�C�R��
	//�E�B���h�E�̍����A��
	public static int wid_win=450;
	public static int hei_win=600;
	private int lastShootTime,currentTime;
	private final static int shootInterval = 7;//���@���~�T�C����łĂ�Ԋu
	int hitX,hitY;
	JLabel hit = new JLabel();
	Invader(int m,int n) {
		currentTime = 0;
		lastShootTime = -shootInterval;
		frame = new JFrame("Invader");
		pane = new JPanel();
		//���C�A�E�g�}�l�[�W�����g�킸�����Ŕz�u����
		pane.setLayout(null);
		//�w�i�����ɂ���
		pane.setBackground(Color.black);
		//�E�B���h�E��������Ƀv���O�������I������
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//�E�B���h�E�̃T�C�Y�𒲐�
		pane.setPreferredSize(new Dimension(wid_win,hei_win));
		frame.add(pane);
		frame.pack();
		frame.addKeyListener(this); 
		//�E�B���h�E��\��
		//enemy�̏�����Ԃ�ݒu	
		for(int i=0;i<m;++i){
			for(int j=0;j<n;++j){
				Enemy en= new Enemy(i,j,m,n,e_icon);
				pane.add(en.getLabel());
				en.move();
				e_list.add(en);
			}
		}
		player = new Fighter(f_icon);
		player.move();
		pane.add(player.getLabel());
		frame.setVisible(true);
	}

	public static Dimension getWinSize(){
		return pane.getSize();
	}


	public  void run(Invader inv) {
		while(true){
			synchronized(m_list){
				if(m_list.size()!=0)
					for(Iterator<Missile> l = m_list.iterator(); l.hasNext();){
						Missile mis = l.next();
						synchronized(e_list){
							mis.hitJudge(e_list,pane);
						}
						if(mis.hitFlag||mis.stageOutJudge()){
							hitX = mis.getX();
							hitY = mis.getY();
							hit.setSize(new Dimension(hit_icon.getIconWidth(),hit_icon.getIconHeight()));
							hit.setIcon(hit_icon);
							pane.add(hit).setLocation(hitX,hitY);
							l.remove();//�O�ɏo���������
						}
					}
			}
			synchronized(e_list){
				if(e_list.size()!=0)
					for(Iterator<Enemy> i = e_list.iterator(); i.hasNext();){
						Enemy en = i.next();
						en.move();
						int eM_x=en.getX(),eM_y=en.getY(),eM_wid=en.getLabel().getWidth(),eM_hei=en.getLabel().getHeight();
						synchronized(eM_list){
							if((Math.random()*1000)<1){
								EnemyMissile eM = new EnemyMissile(eM_x,eM_y,eM_wid,eM_hei,m_icon);	
								eM_list.add(eM);
							}
						}
					}
				else{
					System.out.println("Fighter defeated the invaders");
					System.exit(0);
				}
			}
			synchronized(eM_list){
				if(eM_list.size()!=0){
					for(Iterator<EnemyMissile> i = eM_list.iterator(); i.hasNext();){
						EnemyMissile eM = i.next();
						eM.move();
						pane.add(eM.getLabel());
						if(eM.stageOutJudge()){
							i.remove();
						}
					}
				}
			}

			synchronized(e_list){
				player.hitJudge(e_list,eM_list,pane);
			}
			if(player.hitFlag){
				hitX = player.getX();
				hitY = player.getY();
				hit.setSize(new Dimension(16,16));
				hit.setIcon(hit_icon);
				pane.add(hit).setLocation(hitX,hitY);
				System.out.println("invaded");
				System.exit(0);
			}

			++currentTime;

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

			pane.remove(hit);
		}
	}



	@Override
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {

		int pressedKey = e.getKeyCode();
		if(pressedKey == KeyEvent.VK_LEFT){
			player.moveLeft();
		}
		if(pressedKey == KeyEvent.VK_RIGHT){
			player.moveRight();
		}
		if(pressedKey == KeyEvent.VK_SPACE){
			if(currentTime - lastShootTime >= shootInterval){
				Missile l= new Missile(player.getX(),player.getY(),player.getLabel().getWidth(),player.getLabel().getHeight(),m_icon);
				synchronized(m_list){
					m_list.add(l);
				}
				pane.add(l.getLabel());
				lastShootTime = currentTime;
			}
		}
		player.move();
	}	  

	static public void main(String[] args) {
		e_icon = new ImageIcon("./src/images/invader.png"); 
		f_icon = new ImageIcon("./src/images/fighter.png"); 
		m_icon = new ImageIcon("./src/images/missile.png"); 
		hit_icon = new ImageIcon("./src/images/explosion.png"); 
		Invader inv = new Invader(5,5);
		inv.run(inv);
	}
}
