import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class RotatingShapeSliders{

	ShapePanel panel;
	
	public RotatingShapeSliders(Container pane, GridBagConstraints constraints) {
		final JSlider speed = new JSlider(JSlider.HORIZONTAL, 0, 50, 20);
		constraints.insets = new Insets(0,50,0,50);
//        speed.setMinorTickSpacing(5);
//        speed.setMajorTickSpacing(10);
//        speed.setPaintTicks(true);
		speed.setPaintLabels(true);
		pane.add(speed, constraints);
		speed.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if (!speed.getValueIsAdjusting()) {
			        int newSpeed = speed.getValue();
			        panel.setSpeed(53 - newSpeed);
			        System.out.println(panel.getSpeed());
			    }
			}	
		});
		
		final JSlider thickness = new JSlider(JSlider.HORIZONTAL, 1, 20, 20);
		constraints.insets = new Insets(60,50,0,50);
//        thickness.setMinorTickSpacing(1);
//        thickness.setMajorTickSpacing(5);
//        thickness.setPaintTicks(true);
		thickness.setPaintLabels(true);
		pane.add(thickness, constraints);
		thickness.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if (!thickness.getValueIsAdjusting()) {
			        int newThickness = thickness.getValue();
			        panel.setThickness(newThickness);
			        System.out.println(panel.getThickness());
			    }
			}	
		});
		
		final JSlider sideLength = new JSlider(JSlider.HORIZONTAL, 1, 1000, 20);
		constraints.insets = new Insets(120,50,0,50);
//        speed.setMinorTickSpacing(10);
//        speed.setMajorTickSpacing(20);
//        speed.setPaintTicks(true);
		sideLength.setPaintLabels(true);
		pane.add(sideLength, constraints);
		sideLength.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if(panel.getShape() instanceof RegularPolygon){
					RegularPolygon a = (RegularPolygon)panel.getShape();
					if (!sideLength.getValueIsAdjusting()) {
						int newLength = sideLength.getValue();
						a.setLength(newLength/a.getNumSides());
						System.out.println(((RegularPolygon) (panel.getShape())).getLength());
					}
				}
			}	
		});
	}
	
	public ShapePanel getShapePanel() {
		return panel;
	}

	public void setShapePanel(ShapePanel s) {
		this.panel = s;
	}
}