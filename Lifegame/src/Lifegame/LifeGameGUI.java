package Lifegame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.MediaTracker;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LifeGameGUI {
	// cellLabelはセル表示用　aliveIconとDeadIconはセルの生死アイコン
	
	private static JLabel cellLabel[][];
	private static ImageIcon animalIcon,plantIcon,groundIcon;
	private	static final int CELL_WIDTH = 16;
	private static final int CELL_HEIGHT = 16;
	public static int tate,yoko;//LifeGameのサイズ
	static Cell cell[][];

	// m×nのライフゲーム 
	public LifeGameGUI(int m,int n) {
		tate = m;
		yoko = n;
		//ウィンドウ作成　コンポーネントを格子状に配置
		JFrame frame = new JFrame("Life game");
		Container pane = frame.getContentPane();
		pane.setLayout(new	GridLayout(m,n));
		//アイコン画像読み込み
		animalIcon = new ImageIcon("./src/images/animal.png");
		if(animalIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
			System.err.println("Not found: animal.png");
			System.exit(1);
		}
		plantIcon = new ImageIcon("./src/images/plant.png");
		if(plantIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
			System.err.println("Not found: plant.png");
			System.exit(1);
		}
		groundIcon = new ImageIcon("./src/images/ground.png");
		if(groundIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
			System.err.println("Not found: ground.png");
			System.exit(1);
		}
		//セルラベル作成
		cellLabel = new	JLabel[m][n];
		cell = new Cell[m][n];
		//初期状態を乱数で決め、ラベルをパネルに貼る
		for(int	i=0; i<m; i++) {
			for(int	j=0; j<n; j++) {
				cellLabel[i][j] = new JLabel();
				cellLabel[i][j].setPreferredSize(new Dimension(CELL_WIDTH,CELL_HEIGHT));
				if(i==j) {
					cell[i][j] = new Animal(i,j);
					cellLabel[i][j].setIcon(animalIcon);
				}
				else{
					cell[i][j] = new Plant(i,j);
					cellLabel[i][j].setIcon(plantIcon);
				}
				pane.add(cellLabel[i][j]);
			}
		}
		//ウィンドウ処理
		//ウィンドウを閉じた時終了
		frame.addWindowListener(new	WindowAdapter() {
			public void	windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
		);
		//ウィンドウサイズ調整
		frame.pack();
		//ウィンドウ表示
		frame.setVisible(true);
	}

	public static void  updateCells(){
		while(true){
			//セルの次の状態計算
			for(int i=0;i<tate;i++){
				for(int j=0;j<yoko;j++){
					cell[i][j].computeNextState();
				}
			}
			//セルの状態をanimal以外から更新
			for(int i=0;i<tate;i++){
				for(int j=0;j<yoko;j++){
					if(!(cell[i][j] instanceof Animal))
						cell[i][j].updateState();
				}
			}
			for(int i=0;i<tate;i++){
				for(int j=0;j<yoko;j++){
					if(cell[i][j] instanceof Animal)
						cell[i][j].updateState();
				}
			}
			//セルの状態からラベルの張り替え
			for(int i=0;i<tate;i++){
				for(int j=0;j<yoko;j++){
					if(cell[i][j] instanceof Animal) 
						cellLabel[i][j].setIcon(animalIcon);
					else if(cell[i][j] instanceof Plant)
						cellLabel[i][j].setIcon(plantIcon);
					else cellLabel[i][j].setIcon(groundIcon);
				}
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
	}
}
