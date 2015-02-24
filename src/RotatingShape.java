
public abstract class RotatingShape {

	private double theta;
	private boolean isRotating;
	private boolean clockwise;
	private double DELTA_THETA = 0.01;
	
	public RotatingShape(boolean isRotating, boolean clockwise){
		this.isRotating = isRotating;
		this.clockwise = clockwise;
	}
	public void setDelta(double delta){
		DELTA_THETA = delta;
	}
	public RotatingShape(){
		this.isRotating = false;
		this.clockwise = true;
	}

	public double getTheta(){
		return theta;
	}
	
	public void setTheta(double theta){
		this.theta = theta;
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
				theta = (theta + DELTA_THETA) % (2*Math.PI);
			else
				theta = (theta - DELTA_THETA) % (2*Math.PI);
		}
	}
}
