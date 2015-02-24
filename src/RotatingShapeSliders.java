import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class RotatingShapeSliders {

	private ShapePanel panel;
	private JPanel controlPanel;
	
	public RotatingShapeSliders(ShapePanel p, JPanel control) {
		panel = p;
		controlPanel = control;
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		JLabel speedLabel = new JLabel("Speed", JLabel.CENTER);
		speedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		constraints.gridx = 0;
		constraints.gridy = 0;
		controlPanel.add(speedLabel, constraints);
		
		final JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		constraints.gridy = 1;
		controlPanel.add(speedSlider, constraints);
		
		speedSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if (!speedSlider.getValueIsAdjusting()) {
			        int newSpeed = speedSlider.getValue();
			        panel.getShape().setDelta(Math.PI/(5*(110-newSpeed)));
			        panel.repaint();
			    }
			}	
		});
		
		
		// Create thickness label 
		JLabel thicknessLabel = new JLabel("Thickness", JLabel.CENTER);
        thicknessLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Set label position
		constraints.gridx = 2;
		constraints.gridy = 0;
		// Add thickness label component
		controlPanel.add(thicknessLabel, constraints);

		// Create and add thickness slider component
		final JSlider thicknessSlider = new JSlider(JSlider.HORIZONTAL, 1, 21, 11);
		constraints.gridy = 1;
		controlPanel.add(thicknessSlider, constraints);
		
		thicknessSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if (!thicknessSlider.getValueIsAdjusting()) {
			        int newThickness = thicknessSlider.getValue();
			        panel.setThickness(newThickness);
			        panel.repaint();
			    }
			}	
		});
		
		// Create Side length label
		JLabel sideLengthLabel = new JLabel("Radius Length", JLabel.CENTER);
        sideLengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Set label position
		constraints.gridx = 4;
		constraints.gridy = 0;
		controlPanel.add(sideLengthLabel, constraints);
		
		// Create and add side length slider
		final JSlider sideLengthSlider = new JSlider(JSlider.HORIZONTAL, 100, 1000, 1000);
		// Set position
		constraints.gridy = 1;
		
		controlPanel.add(sideLengthSlider, constraints);

		sideLengthSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if(panel.getShape() instanceof Line)
					sideLengthSlider.setValue(1000);
				if (panel.getShape() instanceof RegularPolygon) {
					RegularPolygon a = (RegularPolygon)panel.getShape();
					if (!sideLengthSlider.getValueIsAdjusting()) {
						int newLength = sideLengthSlider.getValue();
						a.setRadius(newLength/3);
						panel.repaint();
					}
				}
			}	
		});
	}
	
	public ShapePanel getShapePanel() {
		return panel;
	}
}