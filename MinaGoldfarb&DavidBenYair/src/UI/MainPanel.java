package UI;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import AllClasses.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

public class MainPanel extends JPanel {

	final static int ROWS = 1;
	final static int COLS = 2;
	final static int VER_GAP = 5;
	final static int HOR_GAP = 5;
	private SuperMarket superMarket;
	private JScrollPane scrollerProducts;
	private JTextArea txtArea;
	private DefaultTableModel tableModel;
	private JButton removeButton;
	private JTable tblProducts;
	private JButton nameSortButton;
	private JButton addButton;
	private JButton barcodeSortButton;
	private JButton expDateSortButton;
	private JButton checkExpDateButton;

	public MainPanel(SuperMarket superMarket) throws Exception {
		setSize(600, 300);
		this.superMarket = superMarket;

		SpringLayout theLayout = new SpringLayout();
		setLayout(theLayout);

		JPanel TablePanel = createTablePanel();
		JPanel ButtonPanel = createButtonPanel();

		add(TablePanel);
		add(ButtonPanel);

		theLayout.putConstraint("West", ButtonPanel, 5, "East", TablePanel);
		theLayout.putConstraint("North", ButtonPanel, 5, "North", this);

	}

	private JPanel createTablePanel() throws Exception {
		setSize(150, 150);

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(0, 1, 0, 5));

		tableModel = new DefaultTableModel();

		// tblProducts = new CustomTable(tableModel);
		tblProducts = new JTable(tableModel)
		{
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};

		tblProducts.setPreferredScrollableViewportSize(new Dimension(350, 120));
		tableModel.setColumnIdentifiers(new Object[] { "Barcode", "Name", "Exp Data" });

		scrollerProducts = new JScrollPane(tblProducts);
		scrollerProducts.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollerProducts);// makes the table appear on the screen

		txtArea = new JTextArea();
		txtArea.enable(false);
		txtArea.setLineWrap(true);// ?
		panel.add(txtArea);

		tblProducts.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblProducts.getSelectedRow();

				// Bring the text to the area
				String tmpBarcode = (String) tblProducts.getValueAt(row, 0);
				Product p = superMarket.getProductByBarcode(tmpBarcode);
				txtArea.setText(p.toString());

				// Remove button trigger
				removeButton.setEnabled(true);

			}
		});

		// tblProducts.getCellSelectionEnabled();

		for (int i = 0; i < this.superMarket.getProdCount(); i++) {
			Product tmpProduct = superMarket.getProductVector().elementAt(i);
			tableModel.addRow(
					new Object[] { tmpProduct.getBarcode(), tmpProduct.getName(), isNull(tmpProduct), tmpProduct });
		}

		return panel;
	}

	// checks if the expDate null or not
	private String isNull(Product tmpProduct) {
		if (tmpProduct.getExpDate() == null)
			return "None";
		return tmpProduct.getExpDate().toString();
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 200));
		panel.setLayout(new GridLayout(0, 1, 0, 5));

		addButton = new JButton("Add");
		panel.add(addButton);

		removeButton = new JButton("Remove");
		removeButton.setEnabled(false);
		panel.add(removeButton);

		nameSortButton = new JButton("Name Sort");
		panel.add(nameSortButton);

		barcodeSortButton = new JButton("Barcode Sort");
		panel.add(barcodeSortButton);

		expDateSortButton = new JButton("Date Sort");
		panel.add(expDateSortButton);

		checkExpDateButton = new JButton("Check Exp Date");
		panel.add(checkExpDateButton);

		buttonsActionListeners();

		return panel;

	}

	// Event listeners for all the buttons
	private void buttonsActionListeners() {

		// Add button
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddProductDialog(superMarket);//, MainPanel.this);
//				try {
//					new AddProductFrame(superMarket);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});

		// remove button
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int tmpRow = tblProducts.getSelectedRow();
				String tmpBarcode = (String) tblProducts.getValueAt(tmpRow, 0);
				superMarket.removeProduct(tmpBarcode);
				refreshProductList();
			}
		});

		// Name Sort
		nameSortButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				superMarket.sortProductsByName();
				refreshProductList();
			}
		});

		// Barcode sort
		barcodeSortButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				superMarket.sortProductsByBarcode();
				refreshProductList();
			}
		});

		// ExpDate sort
		expDateSortButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				superMarket.sortProductsByExpDate();
				refreshProductList();
			}
		});

		// Check exp Date

	}

	private void refreshProductList() {
		// remove from GUI
		if (tableModel.getRowCount() > 0) {
			for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
				tableModel.removeRow(i);
			}
		}

		// add table again to GUI
		Vector<Product> prodVec = superMarket.getProductVector();
		for (int i = 0; i < prodVec.size(); i++) {
			Product tmpProduct = (Product) prodVec.elementAt(i);
			tableModel.addRow(
					new Object[] { tmpProduct.getBarcode(), tmpProduct.getName(), isNull(tmpProduct), tmpProduct });
		}

		tblProducts.clearSelection();
		txtArea.setText(" ");
		if (removeButton != null) {
			removeButton.setEnabled(false);
		}

	}
}
