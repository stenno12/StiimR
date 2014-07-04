package ee.ut.math.tvt.salessystem.ui.model;


import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldPack;

public class SoldPackTable extends SalesSystemTableModel<SoldPack> {

	private static final long serialVersionUID = 1L;

	public SoldPackTable() {
		
		super(new String[] { "Date", "Time", "Price"});

		
	}
	

	@Override
	protected Object getColumnValue(SoldPack item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getDate();
		case 1:
			return item.getTime();
		case 2:
			return item.getTotalPrice();
		}
		throw new IllegalArgumentException("Column index out of range");
	}
	
	
	public void addItem(final SoldPack item) {
        /**
         * XXX In case such stockItem already exists increase the quantity of the
         * existing stock.
         */
        
        rows.add(item);
        fireTableDataChanged();
    }
	
	
	

}
