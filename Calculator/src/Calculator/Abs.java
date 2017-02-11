package Calculator;


class Abs extends UnaryOperator{

	protected Abs(MathExpression e) {
		super(e);
	}


	protected double evaluate(double v) {
		return Math.abs(v);
	}

}
