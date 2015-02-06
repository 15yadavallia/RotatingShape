import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;


public class RotatingShapeButtons extends RotatingShape{

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
				if (isRotating()) {
					panel.repaint();
					setRotating(false);
				} else {
					setRotating(true);
					rotate(true);
				}
			}

		});    

		JButton b1 = new JButton("Change direction");
		constraints.fill = GridBagConstraints.LAST_LINE_START;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(200,0,0,0);
		pane.add(b1, constraints);
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				rotate(false);
			}
		});  

		JButton b2 = new JButton("Change color");
		constraints.fill = GridBagConstraints.LAST_LINE_START;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(150,0,0,0);
		pane.add(b2, constraints);
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				Random r = new Random();
				Color color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
				panel.setColor(color);
				panel.repaint();
			}
		});  



	}


	public void setShapePanel(ShapePanel s) {
		this.panel = s;
	}

	public ShapePanel getShapePanel() {
		return panel;
	}

}
