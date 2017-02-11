package ex10;
import ex07.*;
import ex08.*;
//�f�R�[�_�A���W�X�^�A32�r�b�gMUX��ڑ�����
public class RegisterFile {
	Register[] regs = new Register[32];
	Decoder5 dec;
	MUX32_bus mux1,mux2;	
	ANDGate[] and1 = new ANDGate[31];
	public RegisterFile(Path regWrite, //�������
			Bus read1,Bus read2, Bus write1, //���� 5bit
			Bus wdata, //32bit
			Bus rdata1, Bus rdata2){ //�o��32bit
	
		Bus inner1 = new Bus(32);
		Bus[] inner2 = new Bus[32];
		Path[] inner3 = new Path[31];
		
		dec = new Decoder5(write1,inner1);
		for(int i = 0;i < 32;i++){
			inner2[i] = new Bus(32);
			if(i==0) regs[i] = new Register(new Path(),wdata,inner2[i]);
			else{
				inner3[i-1] = new Path();
				and1[i-1] = new ANDGate(regWrite,inner1.getPath(i),inner3[i-1]);
				regs[i] = new Register(inner3[i-1],wdata,inner2[i]);
			}
		}
		mux1 = new MUX32_bus(read1,inner2,rdata1);
		mux2 = new MUX32_bus(read2,inner2,rdata2);
	}
	public void setValue(int regNum,int val){
		regs[regNum].setValue(val);
	}
	public int getValue(int regNum){
		return regs[regNum].getValue();
	}
	public void run(){
		dec.run();
		for(int i = 0;i < 32;i++) {
			if(i>=1) and1[i-1].run();
			regs[i].run();
		}
		mux1.run();
		mux2.run();
	}
}
