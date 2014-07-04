package ee.ut.math.tvt.salessystem.domain.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ee.ut.math.tvt.salessystem.ui.SpecificationPanel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

public class SoldPack implements Cloneable, DisplayableItem {
	
	private String date;
	
	private String time;
	
	private double totalPrice;
	
	private String specification;
	
	public SoldPack(double totalPrice, String specification) {
		
		this.specification = specification;
		
		Date date = new Date();
		DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat timeF = new SimpleDateFormat("HH:mm:ss");
		
		this.totalPrice = totalPrice;
		this.date = dateF.format(date);
		this.time = timeF.format(date);
		
		
	}
	
	public void popInf() {
		SpecificationPanel inf = new SpecificationPanel(specification);
		inf.setVisible(true);
	}
	

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	
	public String getSpecification() {
		return specification;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
