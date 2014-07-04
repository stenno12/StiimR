package ee.ut.math.tvt.salessystem.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;




public class AddStockItemPanel extends JFrame {

	private JTextField idp;
	private JTextField namep;
	private JTextField descp;
	private JTextField pricep;
	private JTextField quantityp;
	private JButton accep;
	private SalesSystemModel model;
	
	public SalesSystemModel getSalesSystemModel() {
		return model;
	}



	public AddStockItemPanel(SalesSystemModel model) {
		
	this.model = model;
	setSize(300, 300); // 
    setLocation(100, 100); // 

    Container sisu = getContentPane(); // konteineri loomine
    
    sisu.setLayout(new BoxLayout(sisu,BoxLayout.Y_AXIS));
    idp = new JTextField();
    namep = new JTextField();
    descp = new JTextField();
    pricep = new JTextField();
    quantityp = new JTextField();
    
    
    
    
    
    accep = new JButton("Accept");
    accep.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		StockItem item = new StockItem(Long.parseLong(idp.getText()),namep.getText(),descp.getText(),Double.parseDouble(pricep.getText()),Integer.parseInt(quantityp.getText()));
//    		System.out.println(String.valueOf(item.getId()));
    		getSalesSystemModel().getWarehouseTableModel().addItem(item);
    		
    		dispose();
    	}
    });
    
    
    sisu.add(idp);
    sisu.add(namep);
    sisu.add(descp);
    sisu.add(pricep);
    sisu.add(quantityp);
    sisu.add(accep);
    
    
	}
	
}