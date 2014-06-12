package ee.ut.math.tvt.salessystem.ui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;

import ee.ut.math.tvt.salessystem.ui.panels.PurchaseItemPanel;
import ee.ut.math.tvt.salessystem.ui.tabs.PurchaseTab;



public class SaleUI extends JFrame {
	
	private JTextField payField;
	
//	public void actionPerformed(ActionEvent e) {
//		this.dispose();
//	}
	
	
	public SaleUI() {
	
	setSize(300, 300); // 
    setLocation(100, 100); // 

    Container sisu = getContentPane(); // konteineri loomine
    
    sisu.setLayout(new FlowLayout());
    JLabel silt1 = new JLabel(String.valueOf(PurchaseItemPanel.kSum));
    payField = new JTextField(5);
    final JLabel silt2 = new JLabel("0");
    
    
    
    payField.setText("0");
    
    JButton accep = new JButton("accept");
    accep.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		dispose();
    		PurchaseTab.model.getCurrentPurchaseTableModel().clear();
    		
    	}
    });
    
    JButton dec = new JButton("decline");
    dec.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		dispose();
    	}
    });
    sisu.add(silt1);
    sisu.add(payField);
    sisu.add(silt2);
    sisu.add(accep);
    sisu.add(dec);
    
  // Fill the dialog fields if the bar code text field loses focus
//  payField.addFocusListener(new FocusListener() {
//      public void focusGained(FocusEvent e) {
//      }
//
//      public void focusLost(FocusEvent e) {
//          silt2.setText(String.valueOf(Double.parseDouble(silt2.getText()) - PurchaseItemPanel.kSum));
//      }
//  });
//  payField.addVetoableChangeListener(new VetoableChangeListener() {
//      public void vetoableChange(PropertyChangeEvent e) {
//    	  silt2.setText(String.valueOf(Double.parseDouble(silt2.getText()) - PurchaseItemPanel.kSum));
//      }
//  });
    
    payField.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		silt2.setText(String.valueOf(Double.parseDouble(payField.getText()) - PurchaseItemPanel.kSum));
    	}
    });
    
    
    
	}

}
