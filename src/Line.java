/*
 * Kenny Wang, Anindita Yadavalli, Erica Zhou
 * Mr. Marshmallow
 * Java AP / Period 4
 * 1 March 2015
 */

/*
 * This class constructs a Line object and contains methods 
 * to rotate it on a ShapePanel object
 *
 * This class extends the RotatingShape class
 */

public class Line extends RotatingShape {

	/*
	 * Constructs a Line object based on whether or not it is rotating,
	 * whether it rotates clockwise or counterclockwise, its initial theta value,
	 * and the amount theta changes per rotation
	 * 
	 * Parameters:
	 *	boolean isRotating = whether or not the RotatingShape is rotating
	 * 	boolean clockwise = whether RotatingShape rotates clockwise or counterclockwise
	 *	double theta = current theta value 
	 *	double deltaTheta = amount theta changes with each rotation
	 */
	
	public Line(boolean isRotating, boolean clockwise, double theta, double delta){
		super(isRotating, clockwise, theta, delta);
	}

	/*
	 * Calculates the maximum radius (diagonal) of the line based on the
	 * width and height of the panel on which it is drawn.
	 * This allows the line to rotate via polar coordinates
	 * 
	 * Parameters:
	 * 	int panelWidth = width of panel
	 * 	int panelHeight = height of panel
	 * 
	 * Returns the maximum radius based on the panel
	 */
	
	public double getRadius(int panelWidth, int panelHeight){
		return Math.sqrt(panelWidth/2 * panelWidth/2 + panelHeight/2 * panelHeight/2);
	}
	
	/*
	 * Calculates the x-value of a point on one side of the line based
	 * on the width and height of the panel on which it is drawn
	 * 
	 * Parameters:
	 * 	int panelWidth = width of panel
	 * 	int panelHeight = height of panel
	 * 
	 * Returns this x-coordinate
	 */
	
	public int getX1(int panelWidth, int panelHeight){
		return (int)(-getRadius(panelWidth, panelHeight) * Math.cos(getTheta()) + panelWidth/2);
	}
	
	/*
	 * Calculates the x-value of a point on the other side of the line based
	 * on the width and height of the panel on which it is drawn
	 * 
	 * Parameters:
	 * 	int panelWidth = width of panel
	 * 	int panelHeight = height of panel
	 * 
	 * Returns this x-coordinate
	 */
	
	public int getX2(int panelWidth, int panelHeight){
		return (int)(getRadius(panelWidth, panelHeight) * Math.cos(getTheta()) + panelWidth/2);
	}
	
	/*
	 * Calculates the y-value of a point on one side of the line based
	 * on the width and height of the panel on which it is drawn
	 * 
	 * Parameters:
	 * 	int panelWidth = width of panel
	 * 	int panelHeight = height of panel
	 * 
	 * Returns this y-coordinate
	 */
	
	public int getY1(int panelWidth, int panelHeight){
		return (int)(-getRadius(panelWidth, panelHeight) * Math.sin(getTheta()) + panelHeight/2);
	}
	
	/*
	 * Calculates the y-value of a point on the other side of the line based
	 * on the width and height of the panel on which it is drawn
	 * 
	 * Parameters:
	 * 	int panelWidth = width of panel
	 * 	int panelHeight = height of panel
	 * 
	 * Returns this y-coordinate
	 */
	
	public int getY2(int panelWidth, int panelHeight){
		return (int)(getRadius(panelWidth, panelHeight) * Math.sin(getTheta()) + panelHeight/2);
	}
	
	public static void main(String[] args){
		Line b = new Line(true, true, 0, 0.01);
		ShapePanel a = new ShapePanel(b);
		a.setSize(500, 500);
		System.out.println(b.getX1(a.getWidth(), a.getHeight()) + " " + b.getX2(a.getWidth(), a.getHeight()));
		b.setTheta(2);
		System.out.println(b.getX1(a.getWidth(), a.getHeight()) + " " + b.getX2(a.getWidth(), a.getHeight()));
	}
}
