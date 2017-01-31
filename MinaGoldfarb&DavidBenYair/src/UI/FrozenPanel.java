package UI;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import AllClasses.Date;
import AllClasses.Product;
import AllClasses.SaleInfo;

public class FrozenPanel extends FridgePanel {

	public FrozenPanel(String title) {
		super(title);

	}


	@Override
	public Product createProduct(String theName, String barcode, Date expD, SaleInfo saleData, int priceToStroe,
			int priceToCustomer, int amountI) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
