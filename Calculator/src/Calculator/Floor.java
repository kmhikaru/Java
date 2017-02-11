package Calculator;


class Floor extends UnaryOperator{

	protected Floor(MathExpression e) {
		super(e);
	}

	protected double evaluate(double v) {
		return Math.floor(v);
	}

}
