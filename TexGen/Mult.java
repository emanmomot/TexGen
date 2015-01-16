
package TexGen;

import java.util.Iterator;

public class Mult extends Expression {
	
	public Mult(LispElement... children) {
		super(children);
	}

	@Override
	public void evaluate() {
		Iterator<LispElement> i = getIterator();
		value = i.next().value;
		for(;i.hasNext();) {
			value *= i.next().value;
		}
	}
}