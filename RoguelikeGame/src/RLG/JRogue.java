package RLG;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class JRogue extends JFrame implements KeyListener{	
	public static DungeonMap dun;
	public static Creature hero;
	public static JRogue jr;
	Container pane = getContentPane();// �����ɂ��΃N���A�����Ƃ��V�����_���W�����ɂ����@�_���W�����}�b�v�̃��X�g�ŊǗ�����ΊK�i�ŏオ�����艺��������ł��邩��
	public JRogue(){
		//name window JRogue
		super("JRogue");
		dun= new DungeonMap(85,40);
		pane.setLayout(new FlowLayout());
		pane.add(dun);
		//JTextArea area1=new JTextArea();
		//area1.setRows(3);
		//area1.setColumns(5);
		//pane.add(area1);
		
		addKeyListener(this);		
		this.pack();
		pane.validate();
		setVisible(true);	
		//�E�B���h�E���Ƃ����Ƃ��v���O�����I��
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public static void main(String[] args){
		jr = new JRogue();
		System.out.println("push space key to start");
		System.out.println("if you want to end this game,press the key 'e'");
	}



	public void keyTyped(KeyEvent e) {
		char key=e.getKeyChar();
		if(key=='p'){
			hero.recover();
		}
		if(key=='e'){
			System.exit(0);
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		int pressedKey = e.getKeyCode();
		if(pressedKey == KeyEvent.VK_LEFT){
			hero.moveLeft();
		}
		if(pressedKey == KeyEvent.VK_RIGHT){
			hero.moveRight();
		}
		if(pressedKey == KeyEvent.VK_UP){
			hero.up();
		}
		if(pressedKey == KeyEvent.VK_DOWN){
			hero.down();
		}

		hero.move();
		hero.takeAction();
		for(int i=0;i<dun.numMon;i++){
			if(dun.monsters[i]!=null){
				dun.monsters[i].takeAction();
			}
		}	
		for(int i=0;i<dun.numItm;i++){
			if(dun.items[i]!=null)
				dun.items[i].takeAction();
		}
		
		
		int j=0;
		for(int i=0;i<dun.numMon&&j==0;i++){		
			if(dun.monsters[i]!=null){
				j++;
			}
		}
		if(j==0) {
			for(int i=0;i<dun.numItm;i++){
				if(dun.items[i]!=null)
					dun.items[i].remove();
			}
			dun.newDun();
		}
	}
}	  

