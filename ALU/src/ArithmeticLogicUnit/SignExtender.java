package ArithmeticLogicUnit;
import ex08.Bus;

public class SignExtender {
	Bus a = new Bus(16), b = new Bus(32);
	public SignExtender(Bus a, Bus b) {
		this.a = a;
		this.b = b;
	}
	public void run() {
		for(int i = 0; i < 32; i++) {
			if(i < 15) b.getPath(i).setSignal(a.getPath(i).readSignal());// バスaの信号をバスb䛾0〜15本目に設定
			else b.getPath(i).setSignal(a.getPath(15).readSignal());// バスaの15本目の信号(get)をバスb䛾16〜31本目に設定(set)
		}
	}
}
