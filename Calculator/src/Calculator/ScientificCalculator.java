package Calculator;

import java.io.StreamTokenizer;
import java.io.StringReader;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ScientificCalculator extends JFrame {
	private static final long serialVersionUID = 1L;

	JPanel mainPanel = new JPanel();//���C���̃p�l��
	JTextField resultDisplay = new JTextField("0"); //�v�Z���ʂ�\������e�L�X�g�t�B�[���h
	JTextField operatorDisplay = new JTextField("");//���Z�q��\������t�B�[���h
	BorderLayout mainPanelLayout = new BorderLayout();//mainPanel�p
	boolean afterCalculate = false; //���Z�q�{�^�����������ォ�ǂ���
	String hyoujiValue = "0";
	String expression = "";//parse����p�̎�


	public ScientificCalculator() {
		mainPanel.setLayout(mainPanelLayout);
		this.setSize(new Dimension(330, 300));//�T�C�Y
		this.setTitle("関数電卓");//�t���[���̃^�C�g��
		this.setContentPane(mainPanel);

		mainPanel.add(resultDisplay, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(); //�{�^����z�u����p�l����p��
		buttonPanel.setLayout(new GridLayout(7, 4)); 
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		
		//(�t����@�\�t���{�^��,�ꏊ�j
		buttonPanel.add(new KeyButton("exp"), 0);
		buttonPanel.add(new KeyButton("log"), 1);
		buttonPanel.add(new KeyButton("ceil"), 2);
		buttonPanel.add(new KeyButton("floor"), 3);
		buttonPanel.add(new ClearButton(), 4);
		buttonPanel.add(new KeyButton("sin"), 5);
		buttonPanel.add(new KeyButton("cos"), 6);
		buttonPanel.add(new KeyButton("tan"), 7);
		buttonPanel.add(new NumButton("7"), 8); 
		buttonPanel.add(new NumButton("8"), 9);
		buttonPanel.add(new NumButton("9"), 10);
		buttonPanel.add(new BinaryOpButton("/"), 11);
		buttonPanel.add(new NumButton("4"), 12);
		buttonPanel.add(new NumButton("5"), 13);
		buttonPanel.add(new NumButton("6"), 14);
		buttonPanel.add(new BinaryOpButton("*"), 15);	
		buttonPanel.add(new NumButton("1"), 16);
		buttonPanel.add(new NumButton("2"), 17);
		buttonPanel.add(new NumButton("3"), 18);
		buttonPanel.add(new BinaryOpButton("-"), 19);
		buttonPanel.add(new NumButton("0"), 20);
		buttonPanel.add(new NumButton("."), 21);
		buttonPanel.add(new EqualButton("="),22);
		buttonPanel.add(new BinaryOpButton("+"),23);
		buttonPanel.add(new KeyButton("√"),24);
		buttonPanel.add(new NumButton("("),25);
		buttonPanel.add(new NumButton(")"),26);
		buttonPanel.add(new KeyButton("abs"),27);
		this.setVisible(true);
	}


	
	/* ��������͂���{�^���̒�` */
	public class NumButton extends JButton implements ActionListener {
		private static final long serialVersionUID = 1L;

		public NumButton(String keyTop) {
			super(keyTop); //JButton�N���X�̃R���X�g���N�^
			this.addActionListener(this); //�{�^���ɃA�N�V�����C�x���g��ݒ�
		}

		public void actionPerformed(ActionEvent evt) {
			//startDot=false;
			String putNumber = this.getText(); //�������{�^���̐������擾���i�[
			expression += putNumber;
			// �e�L�X�g�t�B�[���h�Ɉ����̕�������Ȃ��� 
			if(resultDisplay.getText().equals("0") && putNumber == ".") resultDisplay.setText("0.");
			else if(((resultDisplay.getText()).equals("0") || afterCalculate)) {//���Z�q�{�^��������������A�܂��͎ʂ��Ă��鐔����0
				resultDisplay.setText(putNumber); //�������{�^���̕����񂾂���ݒ肷��i��������N���A�������Ɍ�����j
				afterCalculate = false;
			}else
				resultDisplay.setText(resultDisplay.getText() + putNumber); //�������Ȃ���
		}
	}
	
	/*sin,abs�Ȃ�*/
	public class KeyButton extends JButton implements ActionListener {
		private static final long serialVersionUID = 1L;

		public KeyButton(String keyTop) {
			super(keyTop); //JButton�N���X�̃R���X�g���N�^
			this.addActionListener(this); //�{�^���ɃA�N�V�����C�x���g��ݒ�
		}

		public void actionPerformed(ActionEvent evt) {
			String key = this.getText(); //�������{�^���̐������擾���i�[
			if(key == "√") expression += "r";
			else if(key == "ceil") expression += "i";
			else expression +=key.substring(0,1);

			// �e�L�X�g�t�B�[���h�Ɉ����̕�������Ȃ��� 
			if((resultDisplay.getText()).equals("0") || afterCalculate) {//���Z�q�{�^��������������A�܂��͎ʂ��Ă��鐔����0
				resultDisplay.setText(key+"("); //�������{�^���̕����񂾂���ݒ肷��i��������N���A�������Ɍ�����j
				afterCalculate = false;
			}else
				resultDisplay.setText(resultDisplay.getText() + key+"("); //�������Ȃ���
		}
	}
	
	/*�񍀉��Z�q*/
	public class BinaryOpButton extends JButton implements ActionListener {
		private static final long serialVersionUID = 1L;

		public BinaryOpButton(String keyTop) {
			super(keyTop); //JButton�N���X�̃R���X�g���N�^
			this.addActionListener(this); //�{�^���ɃA�N�V�����C�x���g��ݒ�
		}

		public void actionPerformed(ActionEvent evt) {
			//startDot=false;
			String putOp = this.getText(); //�������{�^���̐������擾���i�[
			expression += putOp;
			// �e�L�X�g�t�B�[���h�Ɉ����̕�������Ȃ��� 
			if((resultDisplay.getText()).equals("0") || afterCalculate) {//���Z�q�{�^��������������A�܂��͎ʂ��Ă��鐔����0
				resultDisplay.setText(putOp); //�������{�^���̕����񂾂���ݒ肷��i��������N���A�������Ɍ�����j
				afterCalculate = false;
			}else
				resultDisplay.setText(resultDisplay.getText() + putOp); //�������Ȃ���
		}
	}
	
	/*�C�R�[���{�^��*/
	public class EqualButton extends JButton implements ActionListener {
		private static final long serialVersionUID = 1L;

		public EqualButton(String keyTop) {
			super(keyTop); //JButton�N���X�̃R���X�g���N�^
			this.addActionListener(this); //�{�^���ɃA�N�V�����C�x���g��ݒ�
		}

		public void actionPerformed(ActionEvent evt) {
			//startDot=false;
			//�؂����
			StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(expression));
			MathExpressionParser parser = new MathExpressionParser(tokenizer);
			
			// �e�L�X�g�t�B�[���h�Ɉ����̕�������Ȃ��� 
			if((resultDisplay.getText()).equals("0") || afterCalculate) {//���Z�q�{�^��������������A�܂��͎ʂ��Ă��鐔����0
				resultDisplay.setText("="); //�������{�^���̕����񂾂���ݒ肷��i��������N���A�������Ɍ�����j
				afterCalculate = false;
			} else
				try {
					resultDisplay.setText(resultDisplay.getText() + "="+parser.treeExpression());
				} catch (Exception e) {
					resultDisplay.setText("error"+expression);
					
				}
			expression = "";
			afterCalculate = true;
		}
	}
	

	/*�N���A�{�^��*/
	public class ClearButton extends JButton implements ActionListener {
		private static final long serialVersionUID = 1L;

		public ClearButton() {
			super("C");
			this.addActionListener(this);
		}

		public void actionPerformed(ActionEvent evt) {//�l�����Z�b�g�@�f�B�X�v���C������
			afterCalculate = false;
			expression = "";
			resultDisplay.setText("0");
			operatorDisplay.setText("");
		}
	}
}