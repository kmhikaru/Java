package Calculator;

class Sqrt extends UnaryOperator{

	protected Sqrt(MathExpression e) {
		super(e);
	}

	protected double evaluate(double v) {
		return Math.sqrt(v);
	}

}
