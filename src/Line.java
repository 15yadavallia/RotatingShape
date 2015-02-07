
public class Line extends RotatingShape{

	public Line(boolean isRotating, boolean clockwise){
		super(isRotating, clockwise);
	}

	public Line(){
	}

	public int getX1(int panelWidth, int panelHeight){
			double radius = Math.sqrt(panelWidth/2 * panelWidth/2 + panelHeight/2 * panelHeight/2);
			return (int)(-radius * Math.cos(getTheta()) + panelWidth/2);
	}
	
	public int getX2(int panelWidth, int panelHeight){
			double radius = Math.sqrt(panelWidth/2 * panelWidth/2 + panelHeight/2 * panelHeight/2);
			return (int)(radius * Math.cos(getTheta()) + panelWidth/2);
	}
	
	public int getY1(int panelWidth, int panelHeight){
			double radius = Math.sqrt(panelWidth/2 * panelWidth/2 + panelHeight/2 * panelHeight/2);
			return (int)(-radius * Math.sin(getTheta()) + panelHeight/2);
	}
	
	public int getY2(int panelWidth, int panelHeight){
			double radius = Math.sqrt(panelWidth/2 * panelWidth/2 + panelHeight/2 * panelHeight/2);
			return (int)(radius * Math.sin(getTheta()) + panelHeight/2);
	}
	
	public static void main(String[] args){
		Line b = new Line(true, true);
		ShapePanel a = new ShapePanel(b);
		a.setSize(510, 500);
		System.out.println(b.getX1(a.getWidth(), a.getHeight()) + " " + b.getX2(a.getWidth(), a.getHeight()));
		b.setTheta(2);
		System.out.println(b.getX1(a.getWidth(), a.getHeight()) + " " + b.getX2(a.getWidth(), a.getHeight()));
	}
}
