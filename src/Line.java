import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class Line extends RotatingShape{

	public Line(double theta, boolean isRotating){
		super(theta, isRotating);
	}

	public Line(){
	}

	public int getX1(ShapePanel panel){
//		if(getTheta() <= Math.PI/4 || getTheta() >= 7*Math.PI/4)
//			return 0;
//		else if(getTheta() >= 3*Math.PI/4 && getTheta() <= 5*Math.PI/4)
//			return panel.getWidth();
//		else{
			double radius = Math.sqrt(panel.getWidth()/2 * panel.getWidth()/2 + panel.getHeight()/2 * panel.getHeight()/2);
			return (int)(-radius * Math.cos(getTheta()) + panel.getWidth()/2);
//		}
	}
	
	public int getX2(ShapePanel panel){
//		if(getTheta() <= Math.PI/4 || getTheta() >= 7*Math.PI/4)
//			return panel.getWidth();
//		else if(getTheta() >= 3*Math.PI/4 && getTheta() <= 5*Math.PI/4)
//			return 0;
//		else{
			double radius = Math.sqrt(panel.getWidth()/2 * panel.getWidth()/2 + panel.getHeight()/2 * panel.getHeight()/2);
			return (int)(radius * Math.cos(getTheta()) + panel.getWidth()/2);
//		}
	}
	
	public int getY1(ShapePanel panel){
//		if(getTheta() >= 5*Math.PI/4 && getTheta() <= 7*Math.PI/4)
//			return 0;
//		else if(getTheta() >= Math.PI/4 && getTheta() <= 3*Math.PI/4)
//			return panel.getHeight();
//		else{
			double radius = Math.sqrt(panel.getWidth()/2 * panel.getWidth()/2 + panel.getHeight()/2 * panel.getHeight()/2);
			return (int)(-radius * Math.sin(getTheta()) + panel.getHeight()/2);
//		}
	}
	
	public int getY2(ShapePanel panel){
//		if(getTheta() >= 5*Math.PI/4 && getTheta() <= 7*Math.PI/4)
//			return panel.getHeight();
//		else if(getTheta() >= Math.PI/4 && getTheta() <= 3*Math.PI/4)
//			return 0;
//		else{
			double radius = Math.sqrt(panel.getWidth()/2 * panel.getWidth()/2 + panel.getHeight()/2 * panel.getHeight()/2);
			return (int)(radius * Math.sin(getTheta()) + panel.getHeight()/2);
//		}
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
