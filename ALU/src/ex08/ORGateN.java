package ex08;
import ex07.*;

public class ORGateN {
	Path[] ins;
	Path out1;
	public ORGateN(Path[] ins,Path out1){
		this.ins = ins;
		this.out1 = out1;
	}
	public void run(){
		boolean val = false;
		for(int i = 0;i < ins.length;i++)
			if(ins[i].readSignal().getValue()){
				val = true;
				break;
			}
		out1.setSignal(new Signal(val));
	}
}
