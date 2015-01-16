
package TexGen;

import javax.swing.*;
import java.awt.*; 
import java.applet.Applet; 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Image;

public class TextureGenerator extends Applet { 

	private BufferedImage image;
	private LispElement e;

	int HEIGHT = 400;
	int WIDTH = 400;

	public TextureGenerator() {

		initExpression();

		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

		Visitor v = new Visitor(WIDTH, HEIGHT);
		for (int i = 0; i < HEIGHT * WIDTH; i++) {
			v.setParams(i%WIDTH, i/WIDTH);
			e.accept(v);
			int col = (int)((e.getValue()+.5f)*255);
			Color c = new Color(col,col,col);
			pixels[i] = c.getRGB() & 0x00ffffff;
		}

		JFrame f = new JFrame("Hello World example of awt application");

        f.add(new JLabel(new ImageIcon(image)));
        f.pack();

        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
	}
 
	public void initExpression() {
		Parameter px = new Parameter('x');
		Parameter py = new Parameter('y');
		Const scale = new Const(.1f);
		e = new BWNoise(px,py,scale);
	}

	public static void main(String[] args) {
		new TextureGenerator();
	}
} 

