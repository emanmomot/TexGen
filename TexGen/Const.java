
package TexGen;

public class Const extends LispElement {

	public Const(float val) {
		this.value = val;
	}

	@Override
	public void accept(Visitor v) { }
}