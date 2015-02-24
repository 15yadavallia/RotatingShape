import javax.swing.JFrame;


public class RegularPolygon extends RotatingShape {
	private int numSides;
	private double radiusL;
	
	public RegularPolygon(int sides, double length, boolean isRotating, boolean clockwise){
		super(isRotating, clockwise);
		numSides=sides;
		radiusL= length;
	}
	
	/**
	 * @return the numSides
	 */
	public int getNumSides() {
		return numSides;
	}
	
	public void setRadius(double r){
		radiusL=r;
	}

	/**
	 * @param numSides the numSides to set
	 */
	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}

	public int[][] getVertices(int panelWidth, int panelHeight){
		int centerX = panelWidth/2;
		int centerY = panelHeight/2;
		int[][] ret = new int[numSides][2];
		
		double thetaDiff = 2*Math.PI/numSides;
		for(int i=0;i<numSides;i++){
			double currTheta = getTheta()+i*thetaDiff;
			ret[i][0]=(int)Math.round(radiusL*Math.cos(currTheta)+centerX);
			ret[i][1]=(int)Math.round(radiusL*Math.sin(currTheta)+centerY);
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
