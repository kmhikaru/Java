package  ex08;
import ex07.*;

public class ANDGateN {
	Path[] ins;
	Path out1;
	public ANDGateN(Path[] ins,Path out1){
		this.ins = ins;
		this.out1 = out1;
	}
	public void run(){
		boolean val = true;
		for(int i = 0;i < ins.length;i++)
			if(!ins[i].readSignal().getValue()){
				val = false;
				break;
			}
		out1.setSignal(new Signal(val));	
	}
}
