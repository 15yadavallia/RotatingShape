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
	private Color color = new Color(153,255,204); //I set these here and used variables in the method add them to the ctor
	private int speed = 50;
	private int thickness = 5;
	
	public ShapePanel(Line line){
		shape = line;
	}
	
//	public ShapePanel(RegularPolygon polygon){
//		shape = polygon;
//	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(thickness));
		g2.setColor(color);
		g2.drawLine(shape.getX1(this), shape.getY1(this), shape.getX2(this), shape.getY2(this));
	}

	private void rotate(final boolean clockwise){
		class UpdateListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				shape.rotate(clockwise);
				repaint();
			}
		}
		ActionListener listener = new UpdateListener();
		Timer timer = new Timer(speed, listener);
		timer.start();
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setSize(500, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Line b = new Line(7, true);
		ShapePanel c = new ShapePanel(b);
		frame.add(c);
		frame.setVisible(true);
		c.rotate(true);
	}

}
