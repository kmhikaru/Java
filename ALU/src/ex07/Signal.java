package ex07;

public class Signal {
	boolean val ;
	public Signal(boolean val){
		this.val=val;
	}
	//�M���̒l��ǂݏo��
	public boolean getValue(){
		return val;
	}
	public String toString(){
		if(val)
			return "1";
		else
			return "0";
	}
}
