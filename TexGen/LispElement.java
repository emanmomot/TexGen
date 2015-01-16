
package TexGen;

public abstract class LispElement {

	protected float value;

	public abstract void accept(Visitor v);

	public float getValue() {
		return value;
	}
}