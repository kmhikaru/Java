package ex10;
import ex07.*;
import ex08.*;
public class RegisterFileDriver {
	public static void main(String[] args){
		Path regWrite =new Path();
		Bus read1 = new Bus(5),read2 = new Bus(5),write1 = new Bus(5),wdata = new Bus(32),rdata1 = new Bus(32),rdata2 = new Bus(32);
		RegisterFile regFile =new  RegisterFile(regWrite,read1,read2,write1,wdata,rdata1,rdata2);
		// 1�ԃ��W�X�^�ւ̏������݂Ɠǂݏo���𓯎��ɍs��
		regWrite.setSignal(new Signal(true));
		read1.setValue(1); //�ǂݏo�����W�X�^�ԍ�
		write1.setValue(1); //�������ރ��W�X�^�ԍ�
		wdata.setValue(100); //�������ޒl
		regFile.run();
		System.out.println(rdata1.getValue()); //�Â��l�i0�j
		//������x�����A�N�Z�X
		regFile.run();
		System.out.println(rdata1.getValue());
		//�V�����l�i100)
	}
}
