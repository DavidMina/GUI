package UI;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import AllClasses.Date;
import AllClasses.Product;
import AllClasses.SaleInfo;

public class FruitVegPanel extends BasePanelForAllProducts {

	public FruitVegPanel(String title) {
		super(title);
		SpringLayout theLayout = new SpringLayout();
		setLayout(theLayout);
		setBorder(BorderFactory.createTitledBorder("Fruit and Veg"));
		
		JLabel inPackageLabel = new JLabel("In Package?");
		add(inPackageLabel);
		
		JCheckBox chkbox=new JCheckBox();
		add(chkbox);
		
		theLayout.putConstraint(SpringLayout.WEST, inPackageLabel, 10, SpringLayout.WEST,this );
		theLayout.putConstraint(SpringLayout.NORTH, inPackageLabel,10 , SpringLayout.NORTH,this);
		
		theLayout.putConstraint(SpringLayout.WEST, chkbox, 10, SpringLayout.EAST,inPackageLabel );
		theLayout.putConstraint(SpringLayout.NORTH, chkbox,10 , SpringLayout.NORTH,this);
		
		setPreferredSize(new Dimension(350, 85));

	}

	@Override
	public void clean() {
		int i=0;
		
	}

	@Override
	public Product createProduct(String theName, String barcode, Date expD, SaleInfo saleData, int priceToStroe,
			int priceToCustomer, int amountI) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
