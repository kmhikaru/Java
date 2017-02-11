package Calculator;

class Mult extends BinaryOperator{
	//�R���X�g���N�^
	public Mult(MathExpression e1,MathExpression e2){
		super(e1, e2);
	}
	protected double evaluate(double v1,double v2){
		return v1 * v2;
	}
}