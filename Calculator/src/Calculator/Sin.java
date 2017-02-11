package Calculator;


class Sin extends UnaryOperator{

	protected Sin(MathExpression e) {
		super(e);
	}


	protected double evaluate(double v) {
		return Math.sin(v);
	}

}
