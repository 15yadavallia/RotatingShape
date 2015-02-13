import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class RotatingShapeButtons{

	ShapePanel panel;

	public RotatingShapeButtons(Container pane, GridBagConstraints constraints) {
		JButton b = new JButton("Start/Stop Rotation");
		constraints.fill = GridBagConstraints.LAST_LINE_START;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(0,0,0,0);	//top, left, bottom, right
		pane.add(b, constraints);
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
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
		constraints.fill = GridBagConstraints.LAST_LINE_START;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(200,0,0,0);
		pane.add(b1, constraints);
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
		constraints.fill = GridBagConstraints.LAST_LINE_START;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(150,0,0,0);
		pane.add(b2, constraints);
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				panel.randomizeShapeColor();
				panel.repaint();
			}
		});  
		
		JButton b3 = new JButton("Less Sides");
		constraints.fill = GridBagConstraints.LAST_LINE_START;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(250,0,0,0);
		pane.add(b3, constraints);
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
						panel.setShape(new Line(panel.getShape().isRotating(), panel.getShape().getClockwise()));
						panel.repaint();
					}	
				}
			}
		});  
		
		JButton b4 = new JButton("More Sides");
		constraints.fill = GridBagConstraints.LAST_LINE_START;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(300,0,0,0);
		pane.add(b4, constraints);
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				if(panel.getShape() instanceof Line){
					panel.setShape(new RegularPolygon(3, 50, panel.getShape().isRotating(), panel.getShape().getClockwise()));
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

	public void setShapePanel(ShapePanel s) {
		this.panel = s;
	}
}
