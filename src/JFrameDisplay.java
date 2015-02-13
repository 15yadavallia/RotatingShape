import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JFrameDisplay{
	private static int frameW = 500;
	private static int frameH = 500;
	private JPanel panel;
	//REMEMBER RESIZING
	private static final int MIN = 0;
	private static final int MAX = 30;
	private static final int INIT = 15;
	private boolean frozen = false; //getRotating()?
	//Timer timer;
	//int delay;

		public JFrameDisplay() {
		}
	public static void addComponents(Container pane) {
		pane.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		RotatingShapeButtons buttons = new RotatingShapeButtons(pane, constraints);
		RotatingShapeSliders sliders = new RotatingShapeSliders(pane, constraints);
//		Line l = new Line(true, false);
		RegularPolygon a = new RegularPolygon(6,3,true, false);
		ShapePanel p = new ShapePanel(a);
		buttons.setShapePanel(p);
		sliders.setShapePanel(p);
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
