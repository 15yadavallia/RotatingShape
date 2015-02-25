
public class Line extends RotatingShape {

	public Line(boolean isRotating, boolean clockwise, double theta, double delta){
		super(isRotating, clockwise, theta, delta);
	}

	public double getRadius(int panelWidth, int panelHeight){
		return Math.sqrt(panelWidth/2 * panelWidth/2 + panelHeight/2 * panelHeight/2);
	}
	
	public int getX1(int panelWidth, int panelHeight){
		return (int)(-getRadius(panelWidth, panelHeight) * Math.cos(getTheta()) + panelWidth/2);
	}
	
	public int getX2(int panelWidth, int panelHeight){
		return (int)(getRadius(panelWidth, panelHeight) * Math.cos(getTheta()) + panelWidth/2);
	}
	
	public int getY1(int panelWidth, int panelHeight){
		return (int)(-getRadius(panelWidth, panelHeight) * Math.sin(getTheta()) + panelHeight/2);
	}
	
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
