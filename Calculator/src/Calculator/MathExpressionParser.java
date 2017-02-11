package Calculator;


import java.io.StreamTokenizer;

public class MathExpressionParser {
	private StreamTokenizer parser;

	MathExpressionParser (StreamTokenizer st) {
		parser = st;

		// �d����̕���'���L���Ƃ��Ĉ����D
		parser.ordinaryChar('/');
		parser.ordinaryChar('-');
		parser.ordinaryChar('a');
		parser.ordinaryChar('c');
		parser.ordinaryChar('e');
		parser.ordinaryChar('h');
		parser.ordinaryChar('l');
		parser.ordinaryChar('p');
		parser.ordinaryChar('r');
		parser.ordinaryChar('s');
		parser.ordinaryChar('t');
		parser.ordinaryChar('i');
		parser.ordinaryChar('f');

	}

	public MathExpression treeExpression() throws Exception{
		/*�ύX�O
		MathExpression e1 = treeTerm(); //��ꍀ��؂ɂ���
		int token = parser.nextToken();
		if(token == '+') return new Plus(e1,treeExpression());
		else if(token == '-') return new Minus(e1,treeExpression());
		parser.pushBack();
		return e1;
		 */
		MathExpression e = treeTerm();
		while(true){
			int token = parser.nextToken();
			if(token=='+'){
				e = new Plus(e,treeFactor());
			}
			else if(token=='-'){
				e = new Minus(e,treeFactor());
			}
			else{
				parser.pushBack();
				return e;
			}
		}
	}
	public MathExpression treeTerm() throws Exception{
		/*
		MathExpression e1 = treeFactor();
		int token = parser.nextToken();
		if(token == '*') return new Mult(e1,treeFactor());
		else if(token == '/') return new Div(e1,treeFactor());
		parser.pushBack();
		return e1;
		 */
		MathExpression e = treeFactor();
		while(true){
			int token = parser.nextToken();
			if(token=='*'){
				e = new Mult(e,treeFactor());
			}
			else if(token=='/'){
				e = new Div(e,treeFactor());
			}
			else{
				parser.pushBack();
				return e;
			}
		}
	}

	public MathExpression treeFactor() throws Exception{
		int token = parser.nextToken();

		if(token == '('){
			MathExpression e = treeExpression();
			if(parser.nextToken() == ')') return e;
			else throw new Exception("���ʂ̑Ή�������������܂���.");
		}
		//������
		else if(token == 'r'){
			MathExpression e  = treeExpression();
			if(parser.nextToken() == ')') return new Sqrt(e);
			else throw new Exception("���ʂ̑Ή�������������܂���.");
		}
		//sin
		else if(token == 's'){
			MathExpression e = treeExpression();
			if(parser.nextToken() == ')') return new Sin(e);
			else throw new Exception("���ʂ̑Ή�������������܂���.");

		}
		//cos
		else if(token == 'c'){
			MathExpression e = treeExpression();
			if(parser.nextToken() == ')') return new Cos(e);
			else throw new Exception("���ʂ̑Ή�������������܂���.");

		}
		//tan
		else if(token == 't'){
			MathExpression e = treeExpression();
			if(parser.nextToken() == ')') return new Tan(e);
			else throw new Exception("���ʂ̑Ή�������������܂���.");

		}
		//abs
		else if(token == 'a'){
			MathExpression e = treeExpression();
			if(parser.nextToken() == ')') return new Abs(e);
			else throw new Exception("���ʂ̑Ή�������������܂���.");
		}
		//log
		else if(token == 'l'){
			MathExpression e = treeExpression();
			if(parser.nextToken() == ')') return new Log(e);
			else throw new Exception("���ʂ̑Ή�������������܂���.");
		}
		//exp
		else if(token == 'e'){
			MathExpression e = treeExpression();
			if(parser.nextToken() == ')') return new Exp(e);
			else throw new Exception("���ʂ̑Ή�������������܂���.");
		}
		//floor
		else if(token == 'f'){
			MathExpression e = treeExpression();
			if(parser.nextToken() == ')') return new Floor(e);
			else throw new Exception("���ʂ̑Ή�������������܂���.");
		}
		//ceil
		else if(token == 'i'){
			MathExpression e = treeExpression();
			if(parser.nextToken() == ')') return new Ceil(e);
			else throw new Exception("���ʂ̑Ή�������������܂���.");
		}
		else if(token == StreamTokenizer.TT_NUMBER){
			return new DoubleConstant((int)parser.nval);
		}
		else if(token == '-'){
			return new Mult(new DoubleConstant(-1),treeTerm());
		}

		else{
			throw new Exception("�����������ł͂���܂���.");
		}
	}
} 