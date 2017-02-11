package ArithmeticLogicUnit;
import ex07.Signal;
import ex08.Bus;

public class Shifter2 {
	Bus a = new Bus(32), b = new Bus(32);
	public Shifter2(Bus a, Bus b) {
		this.a = a;
		this.b = b;
	}
	public void run() {
		for(int i = 0; i < 32; i++) {
			if(i < 2) b.getPath(i).setSignal(new Signal(false)); //b[0]��b[1]�͂O
			else b.getPath(i).setSignal(a.getPath(i-2).readSignal());
		}
	}
}
