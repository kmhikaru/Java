package ex08;

public class Complement1Driver {
	public static void main(String[] args){
		Bus in1 = new Bus(32); //32�r�b�g�̃p�X
		Bus out1 = new Bus(32);
		Complement1 c1 = new Complement1(in1,out1);
		
		in1.setValue(100); //�p�X�̒l�Ƃ���100��ݒ�
		c1.run(); //��H�����s
		System.out.println(out1.getValue()); //�p�X�̒l��ǂݏo��
	}
}
