
package TexGen;

public class Parameter extends LispElement {

	public char type;

	public Parameter(char type) {
		this.type = type;
	}

	public void set(float f) {
		this.value = f;
	}

	@Override
	public void accept(Visitor v) {
		v.visitParameter(this);
	}
}