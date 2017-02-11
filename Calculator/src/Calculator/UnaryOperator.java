package Calculator;

abstract class UnaryOperator extends MathExpression{

	private MathExpression e;
	
	protected UnaryOperator(MathExpression e){
		this.e = e;
	}
	protected abstract double evaluate(double v);
	
	public double evaluate(){
		return evaluate(e.evaluate());
	}
	
	public String toString(){
		return Double.toString(evaluate());
	}
}