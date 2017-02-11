package ex10;
import ex07.*;
import ex08.*;

public class DataMemory {
	int[] mem = new	int[1024]; // 1024���[�h
	Path memRead,memWrite;
	Bus addr,wdata,rdata;
	public DataMemory(Path memRead,Path memWrite, //�������
			Bus	addr,Bus wdata,	//����
			Bus	rdata) { //	�o��
		this.memRead = memRead;
		this.memWrite = memWrite;
		this.addr = addr;
		this.wdata = wdata;
		this.rdata = rdata;
	}
	
	public void run() {
		//�{���Ȃ�memRead��memWrite��1���ǂ�����ANDGate��
		//�g���Ĕ��肷�邪�A�����ł͉�H��p���Ȃ��̂�if	�����g���Ă悢
		int val = addr.getValue();
		if(memRead.readSignal().getValue()) {
			//�ǂݏo�������i�������̒l��rdata�ɐݒ�j
			rdata.setValue(mem[(int)(val - 0x10000000)/4]);
		}
		else if(memWrite.readSignal().getValue()) {
			//memRead,memWrite��������1�ɂȂ邱�Ƃ͂Ȃ��B=> else if
			//�������ݏ����iwdata�̒l���������ɐݒ�j	
			mem[(int)(val - 0x10000000)/4] = wdata.getValue();
		}
	} 
}
