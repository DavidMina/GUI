package UI;
import AllClasses.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;


public abstract class BasePanelForAllProducts extends JPanel {
public final static int PANEL_HEIGHT=80;

	public BasePanelForAllProducts(String title) {
		super(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createTitledBorder(title));
		setPreferredSize(new Dimension(AddProductMainPanel.PANEL_WIDTH - 5, PANEL_HEIGHT));
	}

	public abstract void clean();

	public abstract Product createProduct(String theName, String barcode, Date expD, SaleInfo saleData,
			int priceToStroe, int priceToCustomer, int amountI) throws Exception;
	
}
