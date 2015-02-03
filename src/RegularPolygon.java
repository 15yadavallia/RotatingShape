import javax.swing.JFrame;


public class RegularPolygon{
	private int numSides;
	private double length;
	
	public RegularPolygon(int t){
		numSides=t;
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
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	public double interiorAngle(){
		return Math.PI-2*Math.PI/numSides;
	}
	
//	public void draw(Display d){
//		
//	}
	
	public static void main(String[]args){
		JFrame f=new JFrame();
		f.setSize(300,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}






















