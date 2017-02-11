package Calculator;


abstract class BinaryOperator extends MathExpression{

	private MathExpression e1,e2;
	
	protected BinaryOperator( MathExpression e1, MathExpression e2){
		this.e1 = e1;
		this.e2 = e2;
	}
	
	protected abstract double evaluate(double v1,double v2);
	
	public double evaluate(){
		return evaluate(e1.evaluate(),e2.evaluate());
	}

	public String toString(){
		return Double.toString(evaluate());
	}

}
