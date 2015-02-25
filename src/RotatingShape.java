
public abstract class RotatingShape {

	private double theta;
	private boolean isRotating;
	private boolean clockwise;
	private double deltaTheta = Math.PI/650;
	
	public RotatingShape(boolean isRotating, boolean clockwise){
		this.isRotating = isRotating;
		this.clockwise = clockwise;
	}
	
	public double getDelta(){
		return deltaTheta;
	}
	
	public void setDelta(double delta){
		deltaTheta = delta;
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
				theta = (theta + deltaTheta) % (2*Math.PI);
			else
				theta = (theta - deltaTheta) % (2*Math.PI);
		}
	}
}
