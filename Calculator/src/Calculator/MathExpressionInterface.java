package Calculator;

public interface MathExpressionInterface {
	double evaluate();
}

abstract class MathExpression implements MathExpressionInterface{
	public abstract double evaluate();
}


