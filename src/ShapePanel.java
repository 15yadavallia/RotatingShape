import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;


public class ShapePanel extends JComponent{

	private RotatingShape shape;
	private Color color;
	private double speed;
	private int thickness;
	
	public ShapePanel(Line line){
		shape = line;
	}
	
//	public ShapePanel(RegularPolygon polygon){
//		shape = polygon;
//	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(10));
		g2.drawLine(shape.getX1(this), shape.getY1(this), shape.getX2(this), shape.getY2(this));
	}

	private void rotate(final boolean clockwise){
		class UpdateListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				shape.rotate(clockwise);
				repaint();
			}
		}
		final int DELAY = 100;
		ActionListener listener = new UpdateListener();
		Timer timer = new Timer(DELAY, listener);
		timer.start();
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Line b = new Line(0, true);
		ShapePanel c = new ShapePanel(b);
		frame.add(c);
		frame.setVisible(true);
		c.rotate(false);
	}

}
