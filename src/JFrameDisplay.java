import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JFrameDisplay {
	private static final int FRAME_WIDTH = 825;
	private static final int FRAME_HEIGHT = 750;

	public JFrameDisplay() {
	}
	public static void addComponents(Container pane) {
		Line l = new Line(false, true);
//		RegularPolygon a = new RegularPolygon(60,8,true, false);
		ShapePanel shape = new ShapePanel(l);
		JPanel buttons = new JPanel();
		JPanel sliders = new JPanel();
		buttons.setSize(buttons.getWidth(), 25);
		sliders.setSize(buttons.getWidth(), 25);
		shape.setSize(FRAME_WIDTH, FRAME_HEIGHT - 75);
//		pane.setLayout(new GridBagLayout());
//		GridBagConstraints gbc = new GridBagConstraints();
//		gbc.fill = GridBagConstraints.HORIZONTAL;
//		gbc.gridx = 0;
//		gbc.gridy = 0;
		RotatingShapeButtons b = new RotatingShapeButtons(shape, buttons);
		RotatingShapeSliders s = new RotatingShapeSliders(shape, sliders);
		pane.add(buttons, BorderLayout.NORTH);
//		gbc.gridy=1;
//		gbc.ipady=40;
		pane.add(shape, BorderLayout.CENTER);
//		gbc.gridy=2;
//		gbc.ipady=0;
		pane.add(sliders, BorderLayout.SOUTH);
	}

	private static void createFrame(){
		JFrame f = new JFrame("Rotating Shape");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		f.setMinimumSize(new Dimension(808,200));
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
