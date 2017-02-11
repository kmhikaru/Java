package Calculator;

class Div extends BinaryOperator{

	//�R���X�g���N�^
	public Div(MathExpression e1,MathExpression e2){
		super(e1, e2);
	}
	protected double evaluate(double v1,double v2){
		//0���Z
		try{
			double c = v1/v2;
		}
		catch(ArithmeticException e){
			System.out.println("0���Z(Div)");
		}
		return v1 / v2;
	}
}