import java.awt.Color;

import javax.swing.JPanel;


public abstract class RotatingShape{

	private double theta;
	private boolean isRotating;
	private final double DELTA_THETA = 0.13;
	
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
	
	public int getX1(ShapePanel panel){
		if(getTheta() <= Math.PI/4 || getTheta() >= 7*Math.PI/4)
			return 0;
		else if(getTheta() >= 3*Math.PI/4 && getTheta() <= 5*Math.PI/4)
			return panel.getWidth();
		else{
			double radius = Math.sqrt(panel.getWidth() * panel.getWidth() + panel.getHeight() * panel.getHeight());
			return (int)(-radius * Math.cos(getTheta()));
		}
	}
	
	public int getX2(ShapePanel panel){
		if(getTheta() <= Math.PI/4 || getTheta() >= 7*Math.PI/4)
			return panel.getWidth();
		else if(getTheta() >= 3*Math.PI/4 && getTheta() <= 5*Math.PI/4)
			return 0;
		else{
			double radius = Math.sqrt(panel.getWidth() * panel.getWidth() + panel.getHeight() * panel.getHeight());
			return (int)(radius * Math.cos(getTheta()));
		}
	}
	
	public int getY1(ShapePanel panel){
		if(getTheta() >= 5*Math.PI/4 && getTheta() <= 7*Math.PI/4)
			return 0;
		else if(getTheta() >= Math.PI/4 && getTheta() <= 3*Math.PI/4)
			return panel.getHeight();
		else{
			double radius = Math.sqrt(panel.getWidth() * panel.getWidth() + panel.getHeight() * panel.getHeight());
			return (int)(-radius * Math.sin(getTheta()));
		}
	}
	
	public int getY2(ShapePanel panel){
		if(getTheta() >= 5*Math.PI/4 && getTheta() <= 7*Math.PI/4)
			return panel.getHeight();
		else if(getTheta() >= Math.PI/4 && getTheta() <= 3*Math.PI/4)
			return 0;
		else{
			double radius = Math.sqrt(panel.getWidth() * panel.getWidth() + panel.getHeight() * panel.getHeight());
			return (int)(radius * Math.sin(getTheta()));
		}
	}
}
