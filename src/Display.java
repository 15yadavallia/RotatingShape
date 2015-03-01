/*
 * Kenny Wang, Anindita Yadavalli, Erica Zhou
 * Mr. Marshall
 * Java AP / Period 4
 * 1 March 2015
 *
 * This class constructs the JFrame and 
 * displays it as a window. It also adds
 * the three panels (shape panel, button component panel, 
 * and slider component panel) to the pane of the JFrame
 */


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Display {
	private static final int FRAME_WIDTH = 825;
	private static final int FRAME_HEIGHT = 750;

	/*
	 * Adds slider, shape, and button panels to content pane of JFrame
	 * Positions the panels: buttons, shape, sliders (top to bottom)
	 */
	
	public static void addComponents(Container pane) {
		Line l = new Line(false, true, 0, Math.PI/650);
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

	/*
	 * Creates JFrame window 
	 * Sets size of window and adds content pane to window
	 */
	
	private static void createFrame(){
		JFrame f = new JFrame("Rotating Shape");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		f.setMinimumSize(new Dimension(825,500));
		addComponents(f.getContentPane());
		f.setVisible(true);
	}
	
	/*
	 * Creates and runs window
	 */

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createFrame();
			}
		});
	}
}
