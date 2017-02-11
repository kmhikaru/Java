package Calculator;

class Log extends UnaryOperator{

	protected Log(MathExpression e) {
		super(e);
	}


	protected double evaluate(double v) {
		return Math.log(v);
	}

}
