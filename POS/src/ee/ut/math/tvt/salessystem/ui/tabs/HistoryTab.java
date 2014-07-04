package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ee.ut.math.tvt.salessystem.domain.data.SoldPack;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {
    


	  private SalesSystemModel model;
	  JTable table;
	  
	  public JTable getTable() {
		  return table;
	  }

	  public HistoryTab(SalesSystemModel model) {
	    this.model = model;
	  }

	  // warehouse stock tab - consists of a menu and a table
	  public Component draw() {
	    JPanel panel = new JPanel();
	    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    GridBagLayout gb = new GridBagLayout();
	    GridBagConstraints gc = new GridBagConstraints();
	    panel.setLayout(gb);

	    gc.fill = GridBagConstraints.HORIZONTAL;
	    gc.anchor = GridBagConstraints.NORTH;
	    gc.gridwidth = GridBagConstraints.REMAINDER;
	    gc.weightx = 1.0d;
	    gc.weighty = 0d;

	    panel.add(drawStockMenuPane(), gc);

	    gc.weighty = 1.0;
	    gc.fill = GridBagConstraints.BOTH;
	    panel.add(drawStockMainPane(), gc);
	    return panel;
	  }

	  // warehouse menu
	  private Component drawStockMenuPane() {
	    JPanel panel = new JPanel();

	    GridBagConstraints gc = new GridBagConstraints();
	    GridBagLayout gb = new GridBagLayout();

	    panel.setLayout(gb);

	    gc.anchor = GridBagConstraints.NORTHWEST;
	    gc.weightx = 0;

	    gc.gridwidth = GridBagConstraints.RELATIVE;
	    gc.weightx = 1.0;

	    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    return panel;
	  }


	  public void updateTable() {
		  table = new JTable(model.getCurrentSoldPackTable());
	  }
	  // table of the wareshouse stock
	  private Component drawStockMainPane() {
	    JPanel panel = new JPanel();

	    table = new JTable(model.getCurrentSoldPackTable());
	    
	    table.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		model.getCurrentSoldPackTable().rows.get(table.getSelectedRow()).popInf();
	    	}
	    });
	    
//	    table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//	        public void valueChanged(ListSelectionEvent event) {
//	            // do some actions here, for example
//	            // print first column value from selected row
//	            System.out.println(table.getValueAt(table.getSelectedRow(), 1).toString());
//	            
//	        }
//	    });

	    JTableHeader header = table.getTableHeader();
	    header.setReorderingAllowed(false);

	    JScrollPane scrollPane = new JScrollPane(table);

	    GridBagConstraints gc = new GridBagConstraints();
	    GridBagLayout gb = new GridBagLayout();
	    gc.fill = GridBagConstraints.BOTH;
	    gc.weightx = 1.0;
	    gc.weighty = 1.0;

	    panel.setLayout(gb);
	    panel.add(scrollPane, gc);

	    panel.setBorder(BorderFactory.createTitledBorder("Sale history"));
	    return panel;
	  }
}