package ex07;

public class NOTGate {
	Path in1,out1;
	public NOTGate(Path in1,Path out1){
		this.in1 = in1;
		this.out1 = out1;
	}
	public void run(){
		Signal sig1 = in1.readSignal();
		
		boolean val = !(sig1.getValue());
		out1.setSignal(new Signal(val));
	}
}
