/*
 * Kenny Wang, Anindita Yadavalli, Erica Zhou
 * Mr. Marshall
 * Java AP / Period 4
 * 1 March 2015
 */

/*
 * This abstract class constructs a RotatingShape object and is 
 * used as a superclass for the Line and RegularPolygon classes.
 * It stores a theta value for the shape and rotates it by adjusting
 * this value using polar coordinates.
 * 
 * Data includes:
 * 	boolean isRotating = whether or not the RotatingShape is rotating
 * 	boolean clockwise = whether RotatingShape rotates clockwise or counterclockwise
 *	double theta = current theta value 
 *	double deltaTheta = amount theta changes with each rotation
 */

public abstract class RotatingShape {

	private boolean isRotating;
	private boolean clockwise;
	private double theta;
	private double deltaTheta;
	
	/*
	 * Constructs a RotatingShape object based on whether or not it is rotating,
	 * whether it rotates clockwise or counterclockwise, its initial theta value,
	 * and the amount theta changes per rotation
	 * 
	 * Parameters:
	 *	boolean isRotating = whether or not the RotatingShape is rotating
	 * 	boolean clockwise = whether RotatingShape rotates clockwise or counterclockwise
	 *	double theta = current theta value 
	 *	double deltaTheta = amount theta changes with each rotation
	 */
	
	public RotatingShape(boolean isRotating, boolean clockwise, double theta, double delta){
		this.isRotating = isRotating;
		this.clockwise = clockwise;
		this.theta = theta;
		this.deltaTheta = delta;
	}
	
	/*
	 * Returns the isRotating value of the RotatingShape object
	 */
	
	public boolean isRotating(){
		return isRotating;
	}

	/*
	 * Sets the isRotating value of the RotatingShape object
	 * 
	 * Parameter:
	 * 	boolean isRotating = whether or not the RotatingShape is rotating
	 */
	
	public void setRotating(boolean isRotating){
		this.isRotating = isRotating;
	}
	
	/*
	 * Returns the clockwise value of the RotatingShape object
	 */
	
	public boolean getClockwise(){
		return clockwise;
	}
	
	/*
	 * Sets the clockwise value of the RotatingShape object
	 * 
	 * Parameter:
	 * 	boolean clockwise = whether RotatingShape rotates clockwise or counterclockwise
	 */
	
	public void setClockwise(boolean clockwise){
		this.clockwise = clockwise;
	}
	
	/*
	 * Returns the theta value of the RotatingShape object
	 */
	
	public double getTheta(){
		return theta;
	}
	
	/*
	 * Sets the theta value of the RotatingShape object
	 * 
	 * Parameter:
	 * 	double theta = current theta value
	 */
	
	public void setTheta(double theta){
		this.theta = theta;
	}
	
	/*
	 * Returns the deltaTheta value of the RotatingShape object
	 */
	
	public double getDelta(){
		return deltaTheta;
	}
	
	/*
	 * Sets the deltaTheta value of the RotatingShape object
	 * 
	 * Parameter:
	 * 	double deltaTheta = amount theta changes with each rotation
	 */
	
	public void setDelta(double delta){
		deltaTheta = delta;
	}

	/*
	 * Rotates the RotatingShape object by adding or subtracting
	 * deltaTheta depending on the value of clockwise
	 */
	
	public void rotate(){
		if(isRotating){
			if(clockwise)
				theta = (theta + deltaTheta) % (2*Math.PI);
			else
				theta = (theta - deltaTheta) % (2*Math.PI);
		}
	}
}
