/*
 * Kenny Wang, Anindita Yadavalli, Erica Zhou
 * Mr. Marshall
 * Java AP / Period 4
 * 1 March 2015
 */

/*
 * This class constructs a RegularPolygon object and contains methods 
 * to rotate it on a ShapePanel object
 *
 * This class extends the RotatingShape class
 * 
 * Data includes:
 * 	int sides = number of sides
 * 	int radiusL = length of radius of polygon
 */

import javax.swing.JFrame;


public class RegularPolygon extends RotatingShape {
	private int numSides;
	private double radiusL;
	/**
	 * creates a regular polygon with the given parameters
	 * @param sides number of sides
	 * @param length radius length
	 * @param isRotating whether the shape is rotating
	 * @param clockwise whether the shape is going clockwise
	 * @param theta starting angle
	 * @param delta starting delta of theta, the amount the polygon will rotate
	 */
	public RegularPolygon(int sides, double length, boolean isRotating, boolean clockwise, double theta, double delta){
		super(isRotating, clockwise, theta, delta);
		numSides=sides;
		radiusL= length;
	}
	
	/**
	 * @return the numSides
	 */
	public int getNumSides() {
		return numSides;
	}
	
	/**
	 * @param numSides the numSides to set
	 */
	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}
	/**
	 * 
	 * @return the radius length
	 */
	public double getRadius(){
		return radiusL;
	}
	/**
	 * 
	 * @param r the radius to set
	 */
	public void setRadius(double r){
		radiusL=r;
	}
	/**
	 * returns a 2D array containing the coordinates of the vertices of the regular polygon given a height and width of the panel on which to draw the regular polygon
	 * @param panelWidth width of panel
	 * @param panelHeight height of panel
	 * @return array of all coordinates
	 */
	public int[][] getVertices(int panelWidth, int panelHeight){
		int centerX = panelWidth/2;
		int centerY = panelHeight/2;
		int[][] ret = new int[numSides][2];
		
		double thetaDiff = 2*Math.PI/numSides;
		for(int i=0;i<numSides;i++){
			double currTheta = getTheta()+i*thetaDiff;
			ret[i][0]=(int)Math.round(radiusL*Math.cos(currTheta)+centerX);
			ret[i][1]=(int)Math.round(radiusL*Math.sin(currTheta)+centerY);
		}
		return ret;
	}
	
	public static void main(String[]args){
		JFrame f=new JFrame();
		f.setSize(300,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
