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
				//?	panel.repaint();
					panel.getShape().setRotating(false);
				}
				else{
					panel.getShape().setRotating(true);
					panel.rotate();
				}
				System.out.println(panel.getShape().isRotating() + " " + panel.getShape().getClockwise());
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
				System.out.println(panel.getShape().getClockwise());
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
				System.out.println(panel.getColor());
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
