import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class RotatingShapeButtons {

	private ShapePanel panel;
	private JPanel buttonPanel;

	public RotatingShapeButtons(ShapePanel p, JPanel button) {
		buttonPanel = button;
		panel = p;
		GridBagConstraints constraints = new GridBagConstraints();
		JButton b = new JButton("Start/Stop Rotation");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 45;
		constraints.insets = new Insets(670,0,0,0);	
		buttonPanel.add(b, constraints);
		
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (panel.getShape().isRotating()){
					panel.getShape().setRotating(false);
				}
				else{
					panel.getShape().setRotating(true);
					panel.rotate();
				}
			}
		});    

		JButton b1 = new JButton("Change Direction");
		constraints.gridx = 1;
		constraints.gridy = 45;

		buttonPanel.add(b1, constraints);
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				if(panel.getShape().getClockwise())
					panel.getShape().setClockwise(false);
				else
					panel.getShape().setClockwise(true);
			}
		});  

		JButton b2 = new JButton("Change Color");
		constraints.gridx = 2;
		constraints.gridy = 45;

		buttonPanel.add(b2, constraints);
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				panel.randomizeShapeColor();
				panel.repaint();
			}
		});  
		
		JButton b3 = new JButton("Less Sides");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 3;
		constraints.gridy = 45;

		buttonPanel.add(b3, constraints);
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				if(panel.getShape() instanceof RegularPolygon){
					RegularPolygon a = (RegularPolygon)panel.getShape();
					if(a.getNumSides() > 3){
						a.setNumSides(a.getNumSides()-1);
						panel.repaint();
					}
					else if(a.getNumSides() == 3){
						double theta = panel.getShape().getTheta();
						double delta = panel.getShape().getDelta();
						panel.setShape(new Line(panel.getShape().isRotating(), panel.getShape().getClockwise()));
						panel.getShape().setTheta(theta);
						panel.getShape().setDelta(delta);
						panel.repaint();
					}	
				}
			}
		});  
		
		JButton b4 = new JButton("More Sides");
		constraints.fill = GridBagConstraints.LAST_LINE_START;
		constraints.gridx = 4;
		constraints.gridy = 45;

		buttonPanel.add(b4, constraints);
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				if(panel.getShape() instanceof Line){
					double theta = panel.getShape().getTheta();
					double delta = panel.getShape().getDelta();
					panel.setShape(new RegularPolygon(3, 1000/4, panel.getShape().isRotating(), panel.getShape().getClockwise()));
					panel.getShape().setTheta(theta);
					panel.getShape().setDelta(delta);
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

	public ShapePanel getShapePanel() {
		return panel;
	}
}
