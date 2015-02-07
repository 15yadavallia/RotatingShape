
public abstract class RotatingShape{

	private double theta;
	private boolean isRotating;
	private final double DELTA_THETA = 0.06;
	
	public RotatingShape(double theta, boolean isRotating){
		this.theta = theta;
		this.isRotating = isRotating;
	}
	
	public RotatingShape(){
		theta = 0;
		isRotating = true;
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
	
	public void rotate(boolean clockwise){
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
