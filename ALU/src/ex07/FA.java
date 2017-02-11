package ex07;

public class FA {
	XORCircuit xor1,xor2;
	ANDGate and1,and2;
	ORGate or1;
	public FA(Path in1,Path in2,Path cin,Path sum,Path cout){
		Path inner1 = new Path();
		Path inner2 = new Path();
		Path inner3 = new Path();
		xor1 = new XORCircuit(in1,in2,inner1);
		and1 = new ANDGate(in1,in2,inner2);
		xor2 = new XORCircuit(cin,inner1,sum);
		and2 = new ANDGate(inner1,cin,inner3);
		or1 = new ORGate(inner2,inner3,cout);
	}
	public void run(){
		xor1.run();
		and1.run();
		xor2.run();
		and2.run();
		or1.run();
	}
}
