import java.awt.Color;

import javax.swing.JPanel;


public abstract class RotatingShape{

//	private double theta;
	private Color color;
	private double speed;
	private double borderThickness;
	private boolean isRotating;
	
	public RotatingShape(Color color, double speed, double borderThickness, boolean isRotating){
		this.color = color;
		this.speed = speed;
		this.borderThickness = borderThickness;
		this.isRotating = isRotating;
	}
	
	public RotatingShape(){
		color = Color.BLACK;
		speed = 1;
		borderThickness = 1;
		isRotating = true;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getBorderThickness() {
		return borderThickness;
	}

	public void setBorderThickness(double borderThickness) {
		this.borderThickness = borderThickness;
	}

	public boolean isRotating() {
		return isRotating;
	}

	public void setRotating(boolean isRotating) {
		this.isRotating = isRotating;
	}
	
	public void rotate(boolean clockwise){
		
	}
	
	public void stopRotation(){
		isRotating = false;
	}
	
	public abstract void draw(JPanel panel);

}
