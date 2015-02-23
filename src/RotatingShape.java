
public abstract class RotatingShape {

	private double theta;
	private boolean isRotating;
	private boolean clockwise;
	private final double DELTA_THETA = 0.005;
	private int thickness;
	
	public RotatingShape(boolean isRotating, boolean clockwise){
		this.isRotating = isRotating;
		this.clockwise = clockwise;
		this.thickness = 5;
	}
	
	public RotatingShape(){
		this.isRotating = false;
		this.clockwise = true;
		this.thickness = 5;
	}

	public double getTheta(){
		return theta;
	}
	
	public void setTheta(double theta){
		this.theta = theta;
	}

	public int getThickness(){
		return thickness;
	}

	public void setThickness(int thickness){
		this.thickness = thickness;
	}
	
	public boolean isRotating(){
		return isRotating;
	}

	public void setRotating(boolean isRotating){
		this.isRotating = isRotating;
	}
	
	public boolean getClockwise(){
		return clockwise;
	}
	
	public void setClockwise(boolean clockwise){
		this.clockwise = clockwise;
	}
	
	public void rotate(){
		if(isRotating){
			if(clockwise)
				theta += DELTA_THETA;
			else
				theta -= DELTA_THETA;
			if(theta > 2 * Math.PI)
				theta -= 2 * Math.PI;
			else if(theta < 0)
				theta += 2 * Math.PI;
		}
	}
}
