package Calculator;

class Ceil extends UnaryOperator{

	protected Ceil(MathExpression e) {
		super(e);
	}


	protected double evaluate(double v) {
		return Math.ceil(v);
	}

}
