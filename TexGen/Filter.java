
package TexGen;

public abstract class Filter extends LispElement {

	public LispElement child;

	protected int width, height;
	protected float[] values;
	protected Parameter px, py;
	protected Boolean completed;

	public Filter(LispElement child, int width, int height) {
		this.child = child;
		this.width = width;
		this.height = height;
		this.px = px;
		this.py = py;
		values = new float[width*height];
	}

	@Override
	public void accept(Visitor v) {
		v.visitFilter(this);
	}

	public void storeValue(int x, int y) {
		values[x + y*width] = child.value;
	}

	public abstract void evaluate(int x, int y);

	public Boolean isComplete() { return completed; }
	public void complete() { completed = true; }
}