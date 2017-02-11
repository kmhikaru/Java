package ArithmeticLogicUnit;
import ex07.*;

public class DUP {
	Path in1,out1,out2;
	public DUP(Path in1,Path out1,Path out2){
		this.in1 = in1;
		this.out1 = out1;
		this.out2 = out2;
	}
	public void run(){
		Signal sig = in1.readSignal();
		out1.setSignal(sig);
		out2.setSignal(sig);
	}

}
