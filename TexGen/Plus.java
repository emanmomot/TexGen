
package TexGen;

import java.util.Iterator;

public class Plus extends Expression {
	
	public Plus(LispElement... children) {
		super(children);
	}

	@Override
	public void evaluate() {
		value = 0;
		Iterator<LispElement> i = getIterator();
		for(;i.hasNext();) {
			value += i.next().value;
		}
	}
}