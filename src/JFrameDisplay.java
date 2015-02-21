import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		ShapePanel panel = new ShapePanel(l);
		GridBagConstraints constraints = new GridBagConstraints();
		RotatingShapeButtons buttons = new RotatingShapeButtons(panel, constraints);
		RotatingShapeSliders sliders = new RotatingShapeSliders(panel, constraints);
		pane.add(panel);
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
