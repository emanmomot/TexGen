
package TexGen;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Stack;

public class Visitor {

	private ArrayList<Stack<LispElement>> stacks;
	private int x, y;
	private int width, height;
	private Boolean unevaluatedFilter = false;

	public Visitor(int width, int height) {
		this.width = width;
		this.height = height;
		stacks = new ArrayList<Stack<LispElement>>();
	}

	public void setParams(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void visitExpression(Expression e) {
		stack.push(e);
		
		Boolean filter = false;
		Iterator<LispElement> i = e.getIterator();
		for(;i.hasNext();) {
			unevaluatedFilter = false;
			i.next().accept(this);
			filter = filter || unevaluatedFilter;
		}

		unevaluatedFilter = filter;
		if(!unevaluatedFilter)
			e.evaluate();
		else
			stack.pop();
	}

	public void visitFilter(Filter f) {
		unevaluatedFilter = true;
		if(f.isComplete()) {
			f.evaluate(x, y);
		} else {
			f.child.accept(this);
			f.storeValue(x, y);

			if(x+1 == width && y+1 == height)
				f.complete();
		}
	}

	public void visitParameter(Parameter p) {
		if(p.type == 'x')
			p.set(x / (float)width - .5f);
		else
			p.set(y / (float)height -.5f);
	}
}
