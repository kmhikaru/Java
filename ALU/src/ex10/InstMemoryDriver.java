package ex10;
import ex08.*;
public class InstMemoryDriver {
	public static void main(String[] args){
	Bus inst = new Bus(32);
	Bus addr = new Bus(32);
	InstMemory in1= new InstMemory(addr,inst);
		for(int i=0;i<1024;i++) in1.setInst(i*4+0x04000000,i);		
		addr.setValue(100*4+0x04000000);
		in1.run();
		System.out.println(inst.getValue());	
	}
}
