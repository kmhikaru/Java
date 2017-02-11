package ArithmeticLogicUnit;
import ex07.*;
import ex08.*;
import ex10.*;

public class PC {
	Register reg;
	public PC(Bus npc, Bus pc) {
		Path wctl1 = new Path();
		wctl1.setSignal(new Signal(true));
		reg = new Register(wctl1, npc, pc);
	}
	//�����A�h���X���Z�b�g
	public void setValue(int addr){
		reg.setValue(addr);
	}
	
	public void run(){
		reg.run();
	}
}