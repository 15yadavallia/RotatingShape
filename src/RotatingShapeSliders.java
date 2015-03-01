/*
 * Kenny Wang, Anindita Yadavalli, Erica Zhou
 * Mr. Marshall
 * Java AP / Period 4
 * 1 March 2015
 *
 *
 * This class constructs the JSliders and 
 * adds them to the component panel.
 * 
 * Data includes:
 * ShapePanel panel = panel of the rotating shape
 * JPanel control = panel for JSlider
 */


import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class RotatingShapeSliders {

	private ShapePanel panel;
	private JPanel sliderPanel;

	/*
	 * Constructs the sliders that control the shape panel
	 * p is the shape panel to which sliders correspond
	 * sliderPanel is the component panel to which the sliders are added
	 */

	public RotatingShapeSliders(ShapePanel p, JPanel control) {
		panel = p;
		sliderPanel = control;
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		JLabel speedLabel = new JLabel("Speed", JLabel.CENTER);
		speedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Positions slider label
		constraints.gridx = 0;
		constraints.gridy = 0;
		sliderPanel.add(speedLabel, constraints);
		final JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		//Positions slider
		constraints.gridy = 1;
		sliderPanel.add(speedSlider, constraints);
		//Associate an action with the slider change
		speedSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if (!speedSlider.getValueIsAdjusting()) {
					int newSpeed = speedSlider.getValue();
					panel.getShape().setDelta(Math.PI/(5*(130-newSpeed)));
					panel.repaint();
				}
			}	
		});

		JLabel thicknessLabel = new JLabel("Thickness", JLabel.CENTER);
		thicknessLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Positions slider label
		constraints.gridx = 2;
		constraints.gridy = 0;
		sliderPanel.add(thicknessLabel, constraints);
		final JSlider thicknessSlider = new JSlider(JSlider.HORIZONTAL, 1, 21, 11);
		constraints.gridy = 1;
		sliderPanel.add(thicknessSlider, constraints);
		//Associate an action with the slider change
		thicknessSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if (!thicknessSlider.getValueIsAdjusting()) {
					int newThickness = thicknessSlider.getValue();
					panel.setThickness(newThickness);
					panel.repaint();
				}
			}	
		});

		JLabel sideLengthLabel = new JLabel("Radius Length", JLabel.CENTER);
		sideLengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Positions slider label
		constraints.gridx = 4;
		constraints.gridy = 0;
		sliderPanel.add(sideLengthLabel, constraints);
		final JSlider sideLengthSlider = new JSlider(JSlider.HORIZONTAL, 100, 1000, 1000);
		//Positions slider
		constraints.gridy = 1;
		sliderPanel.add(sideLengthSlider, constraints);
		//Associate an action with the slider change
		sideLengthSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				if(panel.getShape() instanceof Line)
					sideLengthSlider.setValue(1000);
				if (panel.getShape() instanceof RegularPolygon) {
					RegularPolygon a = (RegularPolygon)panel.getShape();
					if (!sideLengthSlider.getValueIsAdjusting()) {
						int newLength = sideLengthSlider.getValue();
						a.setRadius(newLength/4);
						panel.repaint();
					}
				}
			}	
		});
	}

	//Gets and returns shape panel 
	public ShapePanel getShapePanel() {
		return panel;
	}
}