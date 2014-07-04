package ee.ut.math.tvt.salessystem.ui;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class SpecificationPanel extends JFrame {

	private JLabel silt2;

//	public void actionPerformed(ActionEvent e) {
//		this.dispose();
//	}


	public SpecificationPanel(String tekst) {
		
	this.silt2 = new JLabel(tekst);
				
	setSize(300, 300); // 
    setLocation(100, 100); // 

    Container sisu = getContentPane(); // konteineri loomine
    
    sisu.setLayout(new BoxLayout(sisu,BoxLayout.Y_AXIS));
    
    sisu.add(silt2);
    
	}
	
}
