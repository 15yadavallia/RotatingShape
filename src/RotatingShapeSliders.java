import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;


public class RotatingShapeSliders extends RotatingShape{

	public RotatingShapeSliders(Container pane, GridBagConstraints constraints) {
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 20);
		constraints.insets = new Insets(10,50,0,50);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		pane.add(slider, constraints);
		
		}

	
//	  public void start() {
//	        timer.start();
//	        frozen = false;
//	        
//	        }
//	
//	  public void stop() {
//		  timer.stop();
//		  frozen = true;
//	  }
//	  
//	public void change(ChangeEvent event) {
//	    JSlider slide = (JSlider)event.getSource();
//	    if (!slide.getValueIsAdjusting()) {
//	        int frames = (int)slide.getValue();
//	        if (frames == 0) {
//	            if (!frozen) stop();
//	        } else {
//	            delay = 1000 / frames;
//	            timer.setDelay(delay);
//	            timer.setInitialDelay(delay * 10);
//	            if (frozen) start();
//	        }
//	    }
//	}
//	
}
