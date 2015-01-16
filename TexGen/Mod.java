
package TexGen;

import java.util.Iterator;

public class Mod extends Expression {
	
	public Mod(LispElement... children) {
		super(children);
	}

	@Override
	public void evaluate() {
		float d = (int)(255 * children.get(1).value + 1);
		if(d == 0)
			value = 0;
		else
			value = ((int)(255 * children.get(0).value) % d) / 255.0f;
	}
}