import javax.swing.JFrame;


public class RegularPolygon extends RotatingShape{
	private int numSides;
	private double sideLength;
	
	public RegularPolygon(int sides, double length, boolean isRotating, boolean clockwise){
		super(isRotating, clockwise);
		numSides=sides;
		sideLength= length;
	}
	
	/**
	 * @return the numSides
	 */
	public int getNumSides() {
		return numSides;
	}

	/**
	 * @param numSides the numSides to set
	 */
	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return sideLength;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.sideLength = length;
	}

	public double interiorAngle(){
		return Math.PI-2*Math.PI/numSides;
	}
	
	public int[][] getVertices(ShapePanel panel){
		int centerX = panel.getWidth()/2;
		int centerY = panel.getHeight()/2;
		int[][] ret = new int[numSides][2];
		
		double radius = sideLength/(2*Math.sin(Math.PI/numSides));
		double thetaDiff = 2*Math.PI/numSides;
		for(int i=0;i<numSides;i++){
			double currTheta = getTheta()+i*thetaDiff;
			ret[i][0]=(int)Math.round(radius*Math.cos(currTheta)+centerX);
			ret[i][1]=(int)Math.round(radius*Math.sin(currTheta)+centerY);
		}
		
		return ret;
	}
	
	public static void main(String[]args){
		JFrame f=new JFrame();
		f.setSize(300,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
