import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JFrameDisplay {
	private static int frameW = 1000;
	private static int frameH = 1000;

	public JFrameDisplay() {
		}
	public static void addComponents(Container pane) {
		Line l = new Line(false, true);
		RegularPolygon a = new RegularPolygon(60,8,true, false);
		ShapePanel shape = new ShapePanel(l);
		JPanel buttons = new JPanel();
		JPanel sliders = new JPanel();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(900, 0, 0, 0);
		RotatingShapeButtons b = new RotatingShapeButtons(shape, buttons);
		RotatingShapeSliders s = new RotatingShapeSliders(shape, sliders);
		pane.add(buttons, gbc);
		gbc.insets = new Insets(0, 0, 900, 0);
		pane.add(sliders, gbc);
		gbc.insets = new Insets(0, 0, 25, 0);
		pane.add(shape, gbc);
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
