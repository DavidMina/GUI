package UI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import AllClasses.Date;
import AllClasses.Product;
import AllClasses.SaleInfo;
import AllClasses.ShelfProduct;

public class ShelfPanel extends BasePanelForAllProducts{

	private JRadioButton[] buttons;
	private ShelfProduct.packageType type;
	
	public ShelfPanel(String title) {
		super(title);
		SpringLayout theLayout = new SpringLayout();
		setLayout(theLayout);
		
		setBorder(BorderFactory.createTitledBorder("Shelf"));
		
		JLabel rowLabel = new JLabel("Row:");
		add(rowLabel);
		
		JTextField rowF = new JTextField(4);
		add(rowF);
		
		JLabel colLabel = new JLabel("Col:");
		add(colLabel);
		
		JTextField colF = new JTextField(4);
		add(colF);
		
		ShelfProduct.packageType[] types = ShelfProduct.packageType.values();
		buttons = new JRadioButton[types.length];
		
		  for (int i = 0; i < this.buttons.length; i++)
		    {
		      this.buttons[i] = new JRadioButton(types[i].name());
		      this.buttons[i].setActionCommand(types[i].name());
		     // this.buttons[i].addActionListener(this);
		    }
		    this.buttons[0].setSelected(true);
		    this.type = types[0];
		    
		ButtonGroup group = new ButtonGroup();
		 for (int i = 0; i < buttons.length; i++) {
		      group.add(buttons[i]);
		    }
		
		JRadioButton glassR = new JRadioButton("Glass");
		add(glassR);
		
		JRadioButton cardboardR = new JRadioButton("Cardboard");
		add(cardboardR);
		
		JRadioButton plasticR = new JRadioButton("Plastic");
		add(plasticR);
		
		
		theLayout.putConstraint(SpringLayout.WEST,rowLabel ,5 , SpringLayout.WEST, this);
		theLayout.putConstraint(SpringLayout.NORTH,rowLabel , 5, SpringLayout.NORTH,this);
		
		theLayout.putConstraint(SpringLayout.WEST,rowF , 5, SpringLayout.EAST,rowLabel);
		theLayout.putConstraint(SpringLayout.NORTH,rowF , 5, SpringLayout.NORTH,this);
		
		theLayout.putConstraint(SpringLayout.WEST,colLabel , 5, SpringLayout.EAST,rowF );
		theLayout.putConstraint(SpringLayout.NORTH,colLabel , 5, SpringLayout.NORTH,this);
		
		theLayout.putConstraint(SpringLayout.WEST, colF, 5, SpringLayout.EAST,colLabel );
		theLayout.putConstraint(SpringLayout.NORTH,colF , 5, SpringLayout.NORTH,this);
		
		theLayout.putConstraint(SpringLayout.WEST, glassR, 5, SpringLayout.WEST, this);
		theLayout.putConstraint(SpringLayout.NORTH, glassR,5 , SpringLayout.SOUTH,rowLabel);
		
		theLayout.putConstraint(SpringLayout.WEST, cardboardR, 5, SpringLayout.EAST,glassR );
		theLayout.putConstraint(SpringLayout.NORTH, cardboardR,5 , SpringLayout.SOUTH,rowLabel);
		
		theLayout.putConstraint(SpringLayout.WEST, plasticR, 5, SpringLayout.EAST,cardboardR );
		theLayout.putConstraint(SpringLayout.NORTH, plasticR,5 , SpringLayout.SOUTH,rowLabel);
		
		setPreferredSize(new Dimension(350, 75));
	}

	@Override
	public void clean() {
		
		
	}

	@Override
	public Product createProduct(String theName, String barcode, Date expD, SaleInfo saleData, int priceToStroe,
			int priceToCustomer, int amountI) throws Exception {
		
		return null;
	}

	
}
