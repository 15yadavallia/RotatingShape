import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;


public class ShapePanel extends JComponent{

	private RotatingShape shape;
	private Color color;
	private int speed = 1;
	private int thickness = 5;
	
	public ShapePanel(RotatingShape line){
		shape = line;
	}
	
//	public ShapePanel(RegularPolygon polygon){
//		shape = polygon;
//	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(thickness));
		g2.setColor(color);
		if(shape instanceof Line){
			g2.drawLine(shape.getX1(this), shape.getY1(this), shape.getX2(this), shape.getY2(this));
		}
		else if(shape instanceof RegularPolygon){
			int[][] points = ((RegularPolygon)shape).getVertices(this);
			for(int i=0;i<((RegularPolygon)shape).getNumSides()-1;i++){
				g2.drawLine(points[i][0], points[i][1], points[i+1][0], points[i+1][1]);
			}
			g2.drawLine(points[0][0], points[0][1], points[points.length-1][0], points[points.length-1][1]);
		}
	}
	
	public void setColor(Color c) {
		color = c;
	}

	public void rotate(final boolean clockwise){
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
		RegularPolygon b = new RegularPolygon(5,103,25,true);
		ShapePanel c = new ShapePanel(b);
		Random r = new Random();
		Color color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		c.setColor(color);
		frame.add(c);
		frame.setVisible(true);
		c.rotate(true);
	}

}
