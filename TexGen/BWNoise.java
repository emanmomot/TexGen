
package TexGen;

import java.util.Iterator;

public class BWNoise extends Expression {
	
	public BWNoise(LispElement... children) {
		super(children);
	}

	@Override
	public void evaluate() {
		value = (float)SimplexNoise.noise(children.get(0).value * children.get(2).value * 100.0f, 
			children.get(1).value * children.get(2).value * 100.0f) / 2.0f;
	}
}