/*
 * Kenny Wang, Anindita Yadavalli, Erica Zhou
 * Mr. Marshall
 * Java AP / Period 4
 * 1 March 2015
 *
 * This class constructs the JButtons and 
 * adds them to the component panel.
 * 
 * Data includes:
 * ShapePanel panel = panel of the rotating shape
 * JPanel buttonPanel = panel of JButtons 
 */

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class RotatingShapeButtons {

	private ShapePanel panel;
	private JPanel buttonPanel;

	/*
	 * Constructs the buttons that control the shape panel
	 * p is the shape panel to which buttons correspond
	 * button is the component panel to which the buttons are added
	 */

	public RotatingShapeButtons(ShapePanel p, JPanel button) {
		buttonPanel = button;
		panel = p;
		GridBagConstraints constraints = new GridBagConstraints();
		//Button starts and stops rotation of shape
		final JButton b = new JButton("Start Rotation");
		//Positions button
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 45;
		constraints.insets = new Insets(670,0,0,0);	
		buttonPanel.add(b, constraints);

		b.addActionListener(new ActionListener() {
			//Associate an action with the button event
			public void actionPerformed(ActionEvent e) {
				if (panel.getShape().isRotating()){
					panel.getShape().setRotating(false);
					b.setText("Start Rotation");
				}
				else{
					panel.getShape().setRotating(true);
					panel.rotate();
					b.setText("Stop Rotation");

				}
			}
		});    

		//Button changes direction of rotation of shape
		JButton b1 = new JButton("Change Direction");
		//Positions button
		constraints.gridx = 1;
		constraints.gridy = 45;

		buttonPanel.add(b1, constraints);
		b1.addActionListener(new ActionListener() {
			//Associate an action with the button event
			public void actionPerformed(ActionEvent e)
			{
				if(panel.getShape().getClockwise())
					panel.getShape().setClockwise(false);
				else
					panel.getShape().setClockwise(true);
			}
		}); 

		//Button changes color rotating shape
		JButton b2 = new JButton("Change Color");
		constraints.gridx = 2;
		constraints.gridy = 45;

		buttonPanel.add(b2, constraints);
		b2.addActionListener(new ActionListener() {
			//Associate an action with the button event
			public void actionPerformed(ActionEvent e)
			{
				panel.randomizeShapeColor();
				panel.repaint();
			}
		});  

		//Button decreases number of sides of rotating shape
		JButton b3 = new JButton("Less Sides");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 3;
		constraints.gridy = 45;

		buttonPanel.add(b3, constraints);
		b3.addActionListener(new ActionListener() {
			//Associate an action with the button event
			public void actionPerformed(ActionEvent e)
			{
				if(panel.getShape() instanceof RegularPolygon){
					RegularPolygon a = (RegularPolygon)panel.getShape();
					if(a.getNumSides() > 3){
						a.setNumSides(a.getNumSides()-1);
						panel.repaint();
					}
					else if(a.getNumSides() == 3){
						panel.setShape(new Line(panel.getShape().isRotating(), panel.getShape().getClockwise(),
								panel.getShape().getTheta(), panel.getShape().getDelta()));
						panel.repaint();
					}	
				}
			}
		});  

		//Button increases number of sides of rotating shape
		JButton b4 = new JButton("More Sides");
		//Positions button
		constraints.fill = GridBagConstraints.LAST_LINE_START;
		constraints.gridx = 4;
		constraints.gridy = 45;

		buttonPanel.add(b4, constraints);
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				if(panel.getShape() instanceof Line){
					panel.setShape(new RegularPolygon(3, 250, panel.getShape().isRotating(), 
							panel.getShape().getClockwise(), panel.getShape().getTheta(), 
							panel.getShape().getDelta()));
					panel.repaint();
				}
				else if(panel.getShape() instanceof RegularPolygon){
					RegularPolygon a = (RegularPolygon)panel.getShape();
					a.setNumSides(a.getNumSides()+1);
					panel.repaint();
				}
			}
		});  
	}

	//Gets and returns shape panel 
	public ShapePanel getShapePanel() {
		return panel;
	}
}
