package ee.ut.math.tvt.stenno;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class IntroUI extends JFrame {
	
	static Logger logger = Logger.getLogger(IntroUI.class.getName());
	
	public void kuvaintro() throws Exception {
		
		
		java.io.File fail = new java.io.File("version.properties"); 
		java.util.Scanner sc = new java.util.Scanner(fail);  
		String[] vn = new String[5];
		int jark = 0;
		while (sc.hasNextLine()) {
		    String rida = sc.nextLine();
		    vn[jark] = rida;
		    ++jark;
		    
		}
		
		String[] vn2 = new String[4];
		vn2[0] = vn[0];
		for (int i = 1; i < 4; i++) {
			String a = ((vn[i].split("="))[1]);
			vn2[i] = a;
			
		}
		

		
		
		sc.close();
		
		java.io.File fail2 = new java.io.File("application.properties"); 
		java.io.PrintWriter pw = new java.io.PrintWriter(fail); 
		java.io.FileWriter fw = new java.io.FileWriter(fail2); 
		
		pw.println(vn2[0]);
		pw.println("build.major.number="+vn2[1]);
		pw.println("build.minor.number="+vn2[2]);
		pw.println("build.revision.number="+vn2[3]);
		pw.println(vn2[1]+"."+vn2[2]+"."+vn2[3]);
		
		pw.close();
		fw.close();
		
		
		
	    setSize(300, 300); // 
	    setLocation(100, 100); // 

	    Container sisu = getContentPane(); // konteineri loomine
	    
	    sisu.setLayout(new BoxLayout(sisu,BoxLayout.Y_AXIS));

	    JLabel silt1 = new JLabel("Stiim");
	    JLabel silt2 = new JLabel("Stenno Sirdla");
	    JLabel silt3 = new JLabel("stenno.sirdla@gmail.com");
	    JLabel silt4 = new JLabel("null");
	    JLabel silt5 = new JLabel(vn2[1]+"."+vn2[2]+"."+vn2[3]);
	    
	    ImageIcon image = new ImageIcon("steam.jpg");
	    JLabel imageLabel = new JLabel(image);
	    
	    
	    sisu.add(silt1); // loodud elementide lisamine aknale
	    sisu.add(silt2);
	    sisu.add(silt3);
	    sisu.add(silt4);
	    sisu.add(silt5);
	    sisu.add(imageLabel);
	    
	    addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	          System.exit(0);
	        }
	    });
	    setVisible(true);
	    
	    logger.info("Intro window opened");
	    
	}

}
