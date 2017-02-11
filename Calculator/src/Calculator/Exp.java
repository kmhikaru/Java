package Calculator;

class Exp extends UnaryOperator{

	protected Exp(MathExpression e) {
		super(e);
	}


	protected double evaluate(double v) {
		return Math.exp(v);
	}

}
