package ex07;

public class Path {
	Signal sig = new Signal(false);
	
	//�����M����ύX
	public void setSignal(Signal sig){
		this.sig = sig;
	}
	//����Ă���M����ǂݏo��
	public Signal readSignal(){
		return sig;
	}
}
