package ex08;
import ex07.*;
public class CLA4 {
	//Bus a,b,s:4�r�b�g
	PFA[] pfa1,pfa2;
	CLU clu;
	public Path[] inner_c;
	public CLA4(Bus a,Bus b,Path carryIn,Bus s,Path carryOut){
		//g,p���v�Z�����H
		Path[] g = new Path[4]; 
		Path[] p = new Path[4];
		pfa1 = new PFA[4];
		pfa2 = new PFA[4];

		for(int i=0;i<4;i++){
			g[i] = new Path();
			p[i] = new Path();
			if(i==0) pfa1[i] =new PFA(a.getPath(i),b.getPath(i),carryIn,g[i],p[i],s.getPath(i));
			pfa1[i] =new PFA(a.getPath(i),b.getPath(i),new Path(),g[i],p[i],s.getPath(i));
		}
		
		// c���v�Z�����H(Carry Lookahead Unit)
		inner_c = new Path[5];
		for(int i=0;i<5;i++){
			if(i==0) inner_c[i] = carryIn;
			else inner_c[i] = new Path();
		}
		clu = new CLU(g,p,inner_c);
		
		//s���v�Z�����H
		for(int i=0;i<4;i++){
			pfa2[i] =new PFA(a.getPath(i),b.getPath(i),inner_c[i],g[i],p[i],s.getPath(i));
		}
	}
	public void run(){
		//��H�����s
		for(int i=0;i<4;i++){
			pfa1[i].run();
		}
		clu.run();
		for(int i=0;i<4;i++){
			pfa2[i].run();
		}
	}
	
}
