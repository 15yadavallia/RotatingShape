
public abstract class RotatingShape {

	private boolean isRotating;
	private boolean clockwise;
	private double theta;
	private double deltaTheta;
	
	public RotatingShape(boolean isRotating, boolean clockwise, double theta, double delta){
		this.isRotating = isRotating;
		this.clockwise = clockwise;
		this.theta = theta;
		this.deltaTheta = delta;
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
	
	public double getTheta(){
		return theta;
	}
	
	public void setTheta(double theta){
		this.theta = theta;
	}
	
	public double getDelta(){
		return deltaTheta;
	}
	
	public void setDelta(double delta){
		deltaTheta = delta;
	}

	public void rotate(){
		if(isRotating){
			if(clockwise)
				theta = (theta + deltaTheta) % (2*Math.PI);
			else
				theta = (theta - deltaTheta) % (2*Math.PI);
		}
	}
}
