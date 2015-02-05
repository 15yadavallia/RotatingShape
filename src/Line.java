
public class Line extends RotatingShape{

	public Line(double theta, boolean isRotating){
		super(theta, isRotating);
	}

	public Line(){
	}

	public int getX1(ShapePanel panel){
			double radius = Math.sqrt(panel.getWidth()/2 * panel.getWidth()/2 + panel.getHeight()/2 * panel.getHeight()/2);
			return (int)(-radius * Math.cos(getTheta()) + panel.getWidth()/2);
	}
	
	public int getX2(ShapePanel panel){
			double radius = Math.sqrt(panel.getWidth()/2 * panel.getWidth()/2 + panel.getHeight()/2 * panel.getHeight()/2);
			return (int)(radius * Math.cos(getTheta()) + panel.getWidth()/2);
	}
	
	public int getY1(ShapePanel panel){
			double radius = Math.sqrt(panel.getWidth()/2 * panel.getWidth()/2 + panel.getHeight()/2 * panel.getHeight()/2);
			return (int)(-radius * Math.sin(getTheta()) + panel.getHeight()/2);
	}
	
	public int getY2(ShapePanel panel){
			double radius = Math.sqrt(panel.getWidth()/2 * panel.getWidth()/2 + panel.getHeight()/2 * panel.getHeight()/2);
			return (int)(radius * Math.sin(getTheta()) + panel.getHeight()/2);
	}
	
	public static void main(String[] args){
		Line b = new Line(0,true);
		ShapePanel a = new ShapePanel(b);
		a.setSize(500, 500);
		System.out.println(b.getX1(a) + " " + b.getX2(a));
		b.setTheta(2);
		System.out.println(b.getX1(a) + " " + b.getX2(a));
	}
}
