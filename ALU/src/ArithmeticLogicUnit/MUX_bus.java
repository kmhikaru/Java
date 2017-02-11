package ArithmeticLogicUnit;
import ex07.Path;
import ex08.Bus;

public class MUX_bus {
	Path ctl;
	Bus a, b, c;
	public MUX_bus(Path ctl,Bus a, Bus b, Bus c) {
		this.ctl = ctl;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public void run() {
		//ctl�̒l��0�܂�false�Ȃ�a��value���A1�܂�true�Ȃ�b��value��c�ɐݒ�
		if(ctl.readSignal().getValue()) c.setValue(b.getValue());
		else c.setValue(a.getValue());
	}
}
