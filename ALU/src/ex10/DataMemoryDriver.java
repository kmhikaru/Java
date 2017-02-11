package ex10;
import ex07.*;
import ex08.*;
public class DataMemoryDriver {
	public static void main(String[] args) {
		Path memRead = new Path(), memWrite = new Path();
		Bus addr = new Bus(32),wdata = new Bus(32), rdata = new Bus(32);
		DataMemory dataMem = new DataMemory(memRead, memWrite, addr, wdata, rdata);
		
		//write
		addr.setValue(0x10000000);
		memRead.setSignal(new Signal(false));
		memWrite.setSignal(new Signal(true));
		wdata.setValue(100);
		dataMem.run();
		System.out.println(rdata.getValue());
		
		//read
		memRead.setSignal(new Signal(true));
		memWrite.setSignal(new Signal(false));
		dataMem.run();
		System.out.println(rdata.getValue());
	}
}
