import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Display {
	private static final int FRAME_WIDTH = 825;
	private static final int FRAME_HEIGHT = 750;

	public Display() {
	}
	
	public static void addComponents(Container pane) {
		Line l = new Line(false, true);
		ShapePanel shape = new ShapePanel(l);
		JPanel buttons = new JPanel();
		JPanel sliders = new JPanel();
		buttons.setSize(buttons.getWidth(), 25);
		sliders.setSize(buttons.getWidth(), 25);
		shape.setSize(FRAME_WIDTH, FRAME_HEIGHT - 75);
		RotatingShapeButtons b = new RotatingShapeButtons(shape, buttons);
		RotatingShapeSliders s = new RotatingShapeSliders(shape, sliders);
		pane.add(buttons, BorderLayout.NORTH);
		pane.add(shape, BorderLayout.CENTER);
		pane.add(sliders, BorderLayout.SOUTH);
	}

	private static void createFrame(){
		JFrame f = new JFrame("Rotating Shape");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		f.setMinimumSize(new Dimension(825,500));
		addComponents(f.getContentPane());
		f.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createFrame();
			}
		});
	}
}
