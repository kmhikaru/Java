package Calculator;


class Tan extends UnaryOperator{

	protected Tan(MathExpression e) {
		super(e);
	}

	protected double evaluate(double v) {
		return Math.tan(v);
	}

}
