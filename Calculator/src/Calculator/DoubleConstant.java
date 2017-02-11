package Calculator;

public class DoubleConstant extends MathExpression {
	private double n;
	public DoubleConstant(double n) {
		this.n = n;
	}
	public double evaluate(){
		return n;
	}
	public String toString() {
		return Double.toString(n);
	}
}