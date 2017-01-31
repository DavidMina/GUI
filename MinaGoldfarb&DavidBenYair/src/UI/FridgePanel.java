package UI;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import AllClasses.Date;
import AllClasses.Product;
import AllClasses.SaleInfo;

public class FridgePanel extends BasePanelForAllProducts{

	public FridgePanel(String title) {
		super(title);
		SpringLayout theLayout = new SpringLayout();
		setLayout(theLayout);
		
		setBorder(BorderFactory.createTitledBorder("Shelf"));
		
		JLabel tempLabel = new JLabel("Temperature:");
		add(tempLabel);
		
		JTextField tempF = new JTextField(5);
		add(tempF);
		
		theLayout.putConstraint(SpringLayout.WEST,tempLabel ,5 , SpringLayout.WEST, this);
		theLayout.putConstraint(SpringLayout.NORTH,tempLabel , 5, SpringLayout.NORTH,this);
		
		theLayout.putConstraint(SpringLayout.WEST,tempF ,5 , SpringLayout.EAST, tempLabel);
		theLayout.putConstraint(SpringLayout.NORTH,tempF , 5, SpringLayout.NORTH,this);

	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product createProduct(String theName, String barcode, Date expD, SaleInfo saleData, int priceToStroe,
			int priceToCustomer, int amountI) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
