package Calculator;


class Cos extends UnaryOperator{

	protected Cos(MathExpression e) {
		super(e);
	}


	protected double evaluate(double v) {
		return Math.cos(v);
	}

}
