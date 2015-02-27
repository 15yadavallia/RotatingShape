/*
 * Kenny Wang, Anindita Yadavalli, Erica Zhou
 * Mr. Marshall
 * Java AP / Period 4
 * 1 March 2015
 */

/*
 * This class constructs a ShapePanel object and contains methods
 * to draw a RotatingShape on it and rotate this shape
 * 
 * Data includes:
 * 	RotatingShape shape = shape to be drawn on ShapePanel
 *	Color color = color of the shape
 *	int thickness = thickness of shape
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class ShapePanel extends JPanel {

	private RotatingShape shape;
	private Color color = Color.BLACK;
	private int thickness = 11;
	/**
	 * constructs a ShapePanel with the given parameters
	 * @param line sets the shape to the specified line
	 * @param color the color
	 * @param thickness thickness of line
	 */
	public ShapePanel(Line line, Color color, int thickness){
		shape = line;
		this.color = color;
		this.thickness = thickness;
	}
	/**
	 * constructs a ShapePanel containing the given line
	 * @param line the line
	 */
	public ShapePanel(Line line){
		shape = line;
		rotate();
	}
	/**
	 * constructs a Shape Panel with the given parameters
	 * @param polygon sets shape to the given regular polygon
	 * @param color the color
	 * @param thickness the thickness
	 */
	public ShapePanel(RegularPolygon polygon, Color color, int thickness){
		shape = polygon;
		this.color = color;
		this.thickness = thickness;
	}
	/**
	 * constructs a ShapePanel containing the given Polygon
	 * @param polygon the polygon
	 */
	public ShapePanel(RegularPolygon polygon){
		shape = polygon;
	}
	/**
	 * 
	 * @return the shape
	 */
	public RotatingShape getShape(){
		return shape;
	}
/**
 * 
 * @param shape the shape to set
 */
	public void setShape(RotatingShape shape){
		this.shape = shape;
	}
/**
 * 
 * @return the color
 */
	public Color getColor(){
		return color;
	}
/**
 * 
 * @param c the color to set
 */
	public void setColor(Color c){
		color = c;
	}
/**
 * 
 * @return the thickness
 */
	public int getThickness(){
		return thickness;
	}
/**
 * 
 * @param thickness the thickness to set
 */
	public void setThickness(int thickness){
		this.thickness = thickness;
	}
	/**
	 * randomizes the color of the shape
	 */
	public void randomizeShapeColor(){
		Random r = new Random();
		Color color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		setColor(color);
	}
/**
 * paints stuff
 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(thickness));
		g2.setColor(color);
		if(shape instanceof Line){
			g2.drawLine(((Line)shape).getX1(this.getWidth(), this.getHeight()), 
					((Line)shape).getY1(this.getWidth(), this.getHeight()), 
					((Line)shape).getX2(this.getWidth(), this.getHeight()), 
					((Line)shape).getY2(this.getWidth(), this.getHeight()));
		}
		else if(shape instanceof RegularPolygon){
			int[][] points = ((RegularPolygon)shape).getVertices(this.getWidth(), this.getHeight());
			for(int i=0;i<((RegularPolygon)shape).getNumSides()-1;i++){
				g2.drawLine(points[i][0], points[i][1], points[i+1][0], points[i+1][1]);
			}
			g2.drawLine(points[0][0], points[0][1], points[points.length-1][0], points[points.length-1][1]);
		}
	}
/**
 * rotates the shape using the shape's deltaTheta
 */
	public void rotate(){
		class UpdateListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				shape.rotate();
				repaint();
			}
		}
		ActionListener listener = new UpdateListener();
		Timer timer = new Timer(25, listener);
		timer.start();
	}

	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RegularPolygon b = new RegularPolygon(7, 130, true, true, 0, 0.01);
//		Line b = new Line(true, false);
		ShapePanel c = new ShapePanel(b);

		frame.add(c);
		frame.setVisible(true);
		c.rotate();
	}
}
