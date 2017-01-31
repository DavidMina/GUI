package UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import AllClasses.Date;
import AllClasses.Product;
import AllClasses.SaleInfo;
import AllClasses.SuperMarket;

public class AddProductMainPanel extends JPanel {

	public final static int PANEL_WIDTH = 350;

	public static enum ProductType {
		Shelf, FruitVeg, Fridge, Frozen;
	}

	private JLabel prodTypeLabel = new JLabel("Product Type: ");
	private JComboBox<String> types;
	private JLabel prodNameLabel = new JLabel("Product Name: ");
	private JTextField prodNameField = new JTextField(15);

	private JLabel barcodeLabel = new JLabel("Barcode: ");
	private JTextField barcodeField = new JTextField(15);

	private final static String[] PRODUCTS_OPTIONS = { "Shelf", "Fruit and Vegetable", "Fridge", "Frozen" };

	private BasePanelForAllProducts[] panelArr;
	private BasePanelForAllProducts tmpProductPanel = null;

	private JButton addButton;

	public AddProductMainPanel(SuperMarket s) {
		JPanel panel = new JPanel();
		SpringLayout theLayout = new SpringLayout();
		panel.setLayout(theLayout);

		JPanel prodPropertiesPanel = createprodPropertiesPanel();
		JPanel expPanel = createExpDateInfoPanel();
		JPanel saleInfoPanel = createSaleInfoPanel();
		JPanel pricePanel = createPricePanel();

		panelArr = new BasePanelForAllProducts[4];
		panelArr[0] = new ShelfPanel("Shelf");
		panelArr[1] = new FruitVegPanel("Fruit and Vegetable");
		panelArr[2] = new FridgePanel("Fridge");
		panelArr[3] = new FrozenPanel("Frozen");

		for (int i = 1; i < this.panelArr.length; i++) {
			this.panelArr[i].setVisible(false);
		}
		tmpProductPanel = panelArr[0];

		createAddButton();

		add(prodPropertiesPanel);
		add(expPanel);
		add(saleInfoPanel);
		add(pricePanel);
		add(tmpProductPanel);
		add(addButton);
		
		
		theLayout.putConstraint(SpringLayout.WEST, prodPropertiesPanel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, prodPropertiesPanel, 5, SpringLayout.NORTH, panel);

		theLayout.putConstraint(SpringLayout.WEST, expPanel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, expPanel, 5, SpringLayout.SOUTH, prodPropertiesPanel);

		theLayout.putConstraint(SpringLayout.WEST, saleInfoPanel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, saleInfoPanel, 5, SpringLayout.SOUTH, expPanel);

		theLayout.putConstraint(SpringLayout.WEST, pricePanel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, pricePanel, 5, SpringLayout.SOUTH, saleInfoPanel);


		
	}

	private JPanel createprodPropertiesPanel() {
		JPanel panel = new JPanel();
		SpringLayout theLayout = new SpringLayout();
		panel.setLayout(theLayout);

		types = new JComboBox(ProductType.values());
		types.setSelectedIndex(0);

		panel.add(prodTypeLabel);
		panel.add(types);
		panel.add(prodNameLabel);
		panel.add(prodNameField);
		panel.add(barcodeLabel);
		panel.add(barcodeField);

		theLayout.putConstraint(SpringLayout.NORTH, prodTypeLabel, 5, SpringLayout.NORTH, panel);
		theLayout.putConstraint(SpringLayout.WEST, prodTypeLabel, 10, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.EAST, types, 170, SpringLayout.WEST, prodTypeLabel);

		theLayout.putConstraint(SpringLayout.NORTH, prodNameLabel, 15, SpringLayout.SOUTH, prodTypeLabel);
		theLayout.putConstraint(SpringLayout.NORTH, prodNameField, 10, SpringLayout.SOUTH, types);
		theLayout.putConstraint(SpringLayout.WEST, prodNameLabel, 10, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.EAST, prodNameField, 260, SpringLayout.WEST, prodNameLabel);

		theLayout.putConstraint(SpringLayout.WEST, barcodeLabel, 10, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, barcodeLabel, 10, SpringLayout.SOUTH, prodNameLabel);
		theLayout.putConstraint(SpringLayout.EAST, barcodeField, 260, SpringLayout.WEST, barcodeLabel);
		theLayout.putConstraint(SpringLayout.NORTH, barcodeField, 5, SpringLayout.SOUTH, prodNameField);

		panel.setPreferredSize(new Dimension(350, 85));

		prodPropertiesActionListener();

		return panel;
	}

	private void prodPropertiesActionListener() {
		types.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				showCorrectPanel(types.getSelectedIndex());
			}
		});
	}

	private JPanel createExpDateInfoPanel() {
		JPanel panel = new JPanel();
		SpringLayout theLayout = new SpringLayout();
		panel.setLayout(theLayout);

		panel.setBorder(BorderFactory.createTitledBorder("Exp Date Info"));

		JLabel isExpLabel = new JLabel("Exp Date? ");
		panel.add(isExpLabel);

		JCheckBox expCheck = new JCheckBox();
		panel.add(expCheck);

		JLabel expLabel = new JLabel("Exp Date: ");
		panel.add(expLabel);

		JLabel dayLabel = new JLabel("Day:");
		panel.add(dayLabel);

		JTextField dayF = new JTextField(2);
		dayF.setEnabled(false);
		panel.add(dayF);

		JLabel monthLabel = new JLabel("Month:");
		panel.add(monthLabel);

		JTextField monthF = new JTextField(2);
		monthF.setEnabled(false);
		panel.add(monthF);

		JLabel yearLabel = new JLabel("Year 15-22:");
		panel.add(yearLabel);

		JTextField yearF = new JTextField(2);
		yearF.setEnabled(false);
		panel.add(yearF);

		theLayout.putConstraint(SpringLayout.WEST, isExpLabel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.WEST, expCheck, 5, SpringLayout.EAST, isExpLabel);

		theLayout.putConstraint(SpringLayout.WEST, expLabel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, expLabel, 10, SpringLayout.SOUTH, isExpLabel);

		theLayout.putConstraint(SpringLayout.WEST, dayLabel, 5, SpringLayout.EAST, expLabel);
		theLayout.putConstraint(SpringLayout.NORTH, dayLabel, 10, SpringLayout.SOUTH, expCheck);

		theLayout.putConstraint(SpringLayout.WEST, dayF, 2, SpringLayout.EAST, dayLabel);
		theLayout.putConstraint(SpringLayout.NORTH, dayF, 10, SpringLayout.SOUTH, expCheck);

		theLayout.putConstraint(SpringLayout.WEST, monthLabel, 10, SpringLayout.EAST, dayF);
		theLayout.putConstraint(SpringLayout.NORTH, monthLabel, 10, SpringLayout.SOUTH, expCheck);

		theLayout.putConstraint(SpringLayout.WEST, monthF, 2, SpringLayout.EAST, monthLabel);
		theLayout.putConstraint(SpringLayout.NORTH, monthF, 10, SpringLayout.SOUTH, expCheck);

		theLayout.putConstraint(SpringLayout.WEST, yearLabel, 10, SpringLayout.EAST, monthF);
		theLayout.putConstraint(SpringLayout.NORTH, yearLabel, 10, SpringLayout.SOUTH, expCheck);

		theLayout.putConstraint(SpringLayout.WEST, yearF, 2, SpringLayout.EAST, yearLabel);
		theLayout.putConstraint(SpringLayout.NORTH, yearF, 10, SpringLayout.SOUTH, expCheck);

		panel.setPreferredSize(new Dimension(350, 80));

		return panel;
	}

	private JPanel createSaleInfoPanel() {
		JPanel panel = new JPanel();
		SpringLayout theLayout = new SpringLayout();
		panel.setLayout(theLayout);
		panel.setBorder(BorderFactory.createTitledBorder("Sale Info"));

		JLabel isOnSaleLabel = new JLabel("On Sale? ");
		panel.add(isOnSaleLabel);

		JCheckBox saleCheck = new JCheckBox();
		panel.add(saleCheck);

		JLabel startLabel = new JLabel("Start Date: ");
		panel.add(startLabel);

		JLabel startDayLabel = new JLabel("Day:");
		panel.add(startDayLabel);

		JTextField startDayF = new JTextField(2);
		startDayF.setEnabled(false);
		panel.add(startDayF);

		JLabel startMonthLabel = new JLabel("Month:");
		panel.add(startMonthLabel);

		JTextField startMonthF = new JTextField(2);
		startMonthF.setEnabled(false);
		panel.add(startMonthF);

		JLabel startYearLabel = new JLabel("Year 15-22:");
		panel.add(startYearLabel);

		JTextField startYearF = new JTextField(2);
		startYearF.setEnabled(false);
		panel.add(startYearF);

		JLabel endLabel = new JLabel("End Date: ");
		panel.add(endLabel);

		JLabel endDayLabel = new JLabel("Day:");
		panel.add(endDayLabel);

		JTextField endDayF = new JTextField(2);
		endDayF.setEnabled(false);
		panel.add(endDayF);

		JLabel endMonthLabel = new JLabel("Month:");
		panel.add(endMonthLabel);

		JTextField endMonthF = new JTextField(2);
		endMonthF.setEnabled(false);
		panel.add(endMonthF);

		JLabel endYearLabel = new JLabel("Year 15-22:");
		panel.add(endYearLabel);

		JTextField endYearF = new JTextField(2);
		endYearF.setEnabled(false);
		panel.add(endYearF);

		JLabel precentLabel = new JLabel("Precent:");
		panel.add(precentLabel);

		JTextField precentF = new JTextField(2);
		precentF.setEnabled(false);
		panel.add(precentF);

		theLayout.putConstraint(SpringLayout.WEST, isOnSaleLabel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.WEST, saleCheck, 5, SpringLayout.EAST, isOnSaleLabel);

		theLayout.putConstraint(SpringLayout.WEST, startLabel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, startLabel, 10, SpringLayout.SOUTH, isOnSaleLabel);

		theLayout.putConstraint(SpringLayout.WEST, startDayLabel, 5, SpringLayout.EAST, startLabel);
		theLayout.putConstraint(SpringLayout.NORTH, startDayLabel, 10, SpringLayout.SOUTH, isOnSaleLabel);

		theLayout.putConstraint(SpringLayout.WEST, startDayF, 2, SpringLayout.EAST, startDayLabel);
		theLayout.putConstraint(SpringLayout.NORTH, startDayF, 10, SpringLayout.SOUTH, isOnSaleLabel);

		theLayout.putConstraint(SpringLayout.WEST, startMonthLabel, 10, SpringLayout.EAST, startDayF);
		theLayout.putConstraint(SpringLayout.NORTH, startMonthLabel, 10, SpringLayout.SOUTH, isOnSaleLabel);

		theLayout.putConstraint(SpringLayout.WEST, startMonthF, 2, SpringLayout.EAST, startMonthLabel);
		theLayout.putConstraint(SpringLayout.NORTH, startMonthF, 10, SpringLayout.SOUTH, isOnSaleLabel);

		theLayout.putConstraint(SpringLayout.WEST, startYearLabel, 10, SpringLayout.EAST, startMonthF);
		theLayout.putConstraint(SpringLayout.NORTH, startYearLabel, 10, SpringLayout.SOUTH, isOnSaleLabel);

		theLayout.putConstraint(SpringLayout.WEST, startYearF, 2, SpringLayout.EAST, startYearLabel);
		theLayout.putConstraint(SpringLayout.NORTH, startYearF, 10, SpringLayout.SOUTH, isOnSaleLabel);

		theLayout.putConstraint(SpringLayout.WEST, endLabel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, endLabel, 5, SpringLayout.SOUTH, startLabel);

		theLayout.putConstraint(SpringLayout.WEST, endDayLabel, 12, SpringLayout.EAST, endLabel);
		theLayout.putConstraint(SpringLayout.NORTH, endDayLabel, 5, SpringLayout.SOUTH, startLabel);

		theLayout.putConstraint(SpringLayout.WEST, endDayF, 2, SpringLayout.EAST, endDayLabel);
		theLayout.putConstraint(SpringLayout.NORTH, endDayF, 5, SpringLayout.SOUTH, startLabel);

		theLayout.putConstraint(SpringLayout.WEST, endMonthLabel, 10, SpringLayout.EAST, endDayF);
		theLayout.putConstraint(SpringLayout.NORTH, endMonthLabel, 5, SpringLayout.SOUTH, startLabel);

		theLayout.putConstraint(SpringLayout.WEST, endMonthF, 2, SpringLayout.EAST, endMonthLabel);
		theLayout.putConstraint(SpringLayout.NORTH, endMonthF, 5, SpringLayout.SOUTH, startLabel);

		theLayout.putConstraint(SpringLayout.WEST, endYearLabel, 10, SpringLayout.EAST, endMonthF);
		theLayout.putConstraint(SpringLayout.NORTH, endYearLabel, 5, SpringLayout.SOUTH, startLabel);

		theLayout.putConstraint(SpringLayout.WEST, endYearF, 2, SpringLayout.EAST, endYearLabel);
		theLayout.putConstraint(SpringLayout.NORTH, endYearF, 5, SpringLayout.SOUTH, startLabel);

		theLayout.putConstraint(SpringLayout.WEST, precentLabel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, precentLabel, 5, SpringLayout.SOUTH, endLabel);

		theLayout.putConstraint(SpringLayout.WEST, precentF, 2, SpringLayout.EAST, precentLabel);
		theLayout.putConstraint(SpringLayout.NORTH, precentF, 5, SpringLayout.SOUTH, endLabel);

		panel.setPreferredSize(new Dimension(350, 115));

		return panel;
	}

	private JPanel createPricePanel() {
		JPanel panel = new JPanel();
		SpringLayout theLayout = new SpringLayout();
		panel.setLayout(theLayout);

		// 1
		JLabel priceToMarketLabel = new JLabel("Price to Market:");
		panel.add(priceToMarketLabel);
		JTextField priceToMarketF = new JTextField(10);
		panel.add(priceToMarketF);

		// 2
		JLabel priceToCustomerLabel = new JLabel("Price to Customer:");
		panel.add(priceToCustomerLabel);
		JTextField priceToCustomerF = new JTextField(10);
		panel.add(priceToCustomerF);
		// 3
		JLabel amountLabel = new JLabel("Amount:");
		JTextField amountF = new JTextField(10);
		panel.add(amountLabel);
		panel.add(amountF);

		theLayout.putConstraint(SpringLayout.WEST, priceToMarketLabel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, priceToMarketLabel, 10, SpringLayout.NORTH, panel);

		theLayout.putConstraint(SpringLayout.WEST, priceToMarketF, 21, SpringLayout.EAST, priceToMarketLabel);
		theLayout.putConstraint(SpringLayout.NORTH, priceToMarketF, 10, SpringLayout.NORTH, panel);

		theLayout.putConstraint(SpringLayout.WEST, priceToCustomerLabel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, priceToCustomerLabel, 10, SpringLayout.SOUTH, priceToMarketLabel);

		theLayout.putConstraint(SpringLayout.WEST, priceToCustomerF, 5, SpringLayout.EAST, priceToCustomerLabel);
		theLayout.putConstraint(SpringLayout.NORTH, priceToCustomerF, 10, SpringLayout.SOUTH, priceToMarketLabel);

		theLayout.putConstraint(SpringLayout.WEST, amountLabel, 5, SpringLayout.WEST, panel);
		theLayout.putConstraint(SpringLayout.NORTH, amountLabel, 10, SpringLayout.SOUTH, priceToCustomerLabel);

		theLayout.putConstraint(SpringLayout.WEST, amountF, 64, SpringLayout.EAST, amountLabel);
		theLayout.putConstraint(SpringLayout.NORTH, amountF, 10, SpringLayout.SOUTH, priceToCustomerLabel);

		panel.setPreferredSize(new Dimension(350, 85));

		return panel;
	}

	private void showCorrectPanel(int index) {
		if (tmpProductPanel != null) {
			tmpProductPanel.setVisible(false);
			remove(tmpProductPanel);
			remove(addButton);
		}

		tmpProductPanel = this.panelArr[index];
		
		add(tmpProductPanel);
		tmpProductPanel.setVisible(true);
		add(addButton);
	}



	private void createAddButton() {

		addButton = new JButton("Add");

	}
}
