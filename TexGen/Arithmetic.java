
package TexGen;

import java.util.Iterator;

public class Arithmetic extends Expression {
	public char op;
	
	public Arithmetic(char op, LispElement... children) {
		super(children);
		this.op = op;
	}

	@Override
	public void evaluate() {
		Iterator<LispElement> i = getIterator();
		switch(op) {
			case '+':
				value = 0;
				for(;i.hasNext();)
					value += i.next().value;
				break;
			case '-':
				value = 0;
				for(;i.hasNext();)
					value -= i.next().value;
				break;
			case '*':
				value = i.next().value;
				for(;i.hasNext();)
					value *= i.next().value;
				break;
			case '/':
				value = i.next().value;
				for(;i.hasNext();) {
					float d = i.next().value;
					if(d == 0) {
						value = 0;
						break;
					} else {
						value /= d;
					}
				}
				break;
		}
		
	}
}