import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JFrameDisplay {
	private static int frameW = 750;
	private static int frameH = 750;

	public JFrameDisplay() {
	}
	public static void addComponents(Container pane) {
		Line l = new Line(false, true);
		RegularPolygon a = new RegularPolygon(60,8,true, false);
		ShapePanel shape = new ShapePanel(l);
		JPanel buttons = new JPanel();
		JPanel sliders = new JPanel();
		buttons.setSize(buttons.getWidth(), 25);
		sliders.setSize(buttons.getWidth(), 25);
		shape.setJFD(pane);
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
		JFrame f = new JFrame("F");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(frameW, frameH);
		addComponents(f.getContentPane());
		f.setVisible(true);
		f.setTitle("Rotating Shape");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createFrame();
			}
		});
	}
}
