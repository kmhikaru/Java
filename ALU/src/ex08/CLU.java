package ex08;
import  ex07.*;
public class CLU {
	ANDGateN[] andn = new ANDGateN[10];
	ORGateN[] orn = new ORGateN[4];
	Path[] g,p,c,p_andn;
	public CLU(Path[] g,Path p[],Path c[]){
		//����:(g,p,c[0])�@�o��:c[1]�`c[4]
		this.p_andn = new Path[10];
		this.c=c;
		this.g=g;
		this.p=p;
		for(int i = 0;i<10;i++) p_andn[i] = new Path();
		Path[] p_and1 = {p[0],c[0]};
		Path[] p_and2 = {g[0],p[1]};
		Path[] p_and3 = {p[0],p[1],c[0]};
		Path[] p_and4 = {g[1],p[2]};
		Path[] p_and5 = {g[0],p[1],p[2]};
		Path[] p_and6 = {p[0],p[1],p[2],c[0]};
		Path[] p_and7 = {g[2],p[3]};
		Path[] p_and8 = {g[1],p[2],p[3]};
		Path[] p_and9 = {g[0],p[1],p[2],p[3]};
		Path[] p_and10 = {p[0],p[1],p[2],p[3],c[0]};
		
		andn[0] = new ANDGateN(p_and1,p_andn[0]);
		andn[1] = new ANDGateN(p_and2,p_andn[1]);
		andn[2] = new ANDGateN(p_and3,p_andn[2]);
		andn[3] = new ANDGateN(p_and4,p_andn[3]);
		andn[4] = new ANDGateN(p_and5,p_andn[4]);
		andn[5] = new ANDGateN(p_and6,p_andn[5]);
		andn[6] = new ANDGateN(p_and7,p_andn[6]);
		andn[7] = new ANDGateN(p_and8,p_andn[7]);
		andn[8] = new ANDGateN(p_and9,p_andn[8]);
		andn[9] = new ANDGateN(p_and10,p_andn[9]);
		
		Path[] p_or1 = {g[0],p_andn[0]};
		Path[] p_or2 = {g[1],p_andn[1],p_andn[2]};
		Path[] p_or3 = {g[2],p_andn[3],p_andn[4],p_andn[5]};
		Path[] p_or4 = {g[3],p_andn[6],p_andn[7],p_andn[8],p_andn[9]};
		
		orn[0] = new ORGateN(p_or1,c[1]);
		orn[1] = new ORGateN(p_or2,c[2]);
		orn[2] = new ORGateN(p_or3,c[3]);
		orn[3] = new ORGateN(p_or4,c[4]);
	}
	public void run(){
		
		for(int i = 0;i<10;i++){
			andn[i].run();
		}
		for(int i = 0;i<4;i++){
			orn[i].run();
		}
	}
}
