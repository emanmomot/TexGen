
package TexGen;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Expression extends LispElement {

	protected ArrayList<LispElement> children;

	public Expression(LispElement... children) {
		this.children = new ArrayList<LispElement>();
		for(LispElement l : children) {
			this.children.add(l);
		}
	}

	@Override
	public void accept(Visitor v) {
		v.visitExpression(this);
	}

	public Iterator<LispElement> getIterator() {
		return children.iterator();
	}

	public abstract void evaluate();
}