package ex10;
import ex08.*;
public class InstMemory {
	int[] mem = new	int[1024];
	Bus addr,inst;
	// 1024	���[�h�@�@mem[i]: 1���[�h(32bit)=>1���ߕ��̏����i�[
	public	InstMemory(Bus	addr,Bus inst) {
		this.addr = addr;
		this.inst = inst;
	}
	public void run() {
	//inst�o�X�Ƀf�[�^�𑗂�
	//���߃A�h���X��0x04000000����n�܂�̂ŁA 0x04000000��mem[0]�ɑΉ�������ƌ������悢
	//mem�̓��[�h�P�ʂȂ̂�4�Ŋ���
	int val= addr.getValue();
	int offset = (int)(val- 0x04000000) / 4;
	//mem[offset]�̒l��inst�ɐݒ�
	inst.setValue(mem[offset]);
	}
	public void setInst(int addr,int inst)
	{
	//���߂��������ɏ������ޏ���������
		int idx = (int)(addr - 0x4000000) /4;
		mem[idx] = inst;
	} 
}
