package UI;
import java.util.Vector;

import javax.swing.JFrame;

import AllClasses.*;

public class MainFrame extends JFrame {

	public MainFrame(SuperMarket superMarket) throws Exception{
		super("Manage Products in market " + superMarket.getName());
		MainPanel mainPanel = new MainPanel(superMarket);
		add(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		setSize(600,300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
	}
	
	public static void main(String[] args) throws Exception{
		// try {

				// UserData.GetMarketFromUser();

				Address ad1 = new Address("telAviv", "Alenbi", 34);
				// no need for product max after section B
				SuperMarket mega1 = new SuperMarket("Mina & David Eat as Much as YOU can ", ad1, 30); // ,100);

				// name,age isMale
				Customer[] custArr = new Customer[4];
				custArr[0] = new Customer("Momo", 23, false);
				custArr[1] = new Customer("momo", 55, true);
				// name, age, is Male, idCard,years,totalbuy
				custArr[2] = new MemberCustomer("Gogo", 44, true, "1234", 3, 0);
				custArr[3] = new MemberCustomer("Popo", 46, false, "3456", 5, 0);

				mega1.addCustomer(custArr[1]);
				mega1.addCustomer(custArr[3]);
				mega1.addCustomer(custArr[2]);
				mega1.addCustomer(custArr[0]);

				Date exp1 = new Date(1, 1, 2018);
				Date exp2 = new Date(1, 1, 2017);
				Date exp3 = new Date(31, 1, 2017);
				Date exp4 = new Date(1, 4, 2018);

				Date d1 = new Date(2, 3, 2015);
				Date d2 = new Date(12, 3, 2015);

				// start date, end date, percentage
				SaleInfo info = new SaleInfo(d1, d2, 15.0F);

				
				Location l1 = new Location(2, 3);
				Location l2 = new Location(1, 0);
				Location l3 = new Location(3, 1);
				
				Product p1 = new FrozenProduct("Shikolad", "93450", exp1, null, 8.8F, 12.4F, 34, -14);
				Product p2 = new FridgeProduct("Nutela", "67800", exp2, null, 3.8F, 5.4F, 100, 4);
				Product p3 = new FruitVegProduct("Kartoshka", "56610", null, info, 2.1F, 4.3F, 45, false);
				Product p4 = new FruitVegProduct("Baklazan", "19809", null, info, 8.1F, 11.3F, 12, true);
				Product p5 = new ShelfProduct("Peretz", "12345", exp3, null, 8.8F, 12.4F, 34, l1,
						ShelfProduct.packageType.Plastic);
				Product p6 = new ShelfProduct("Coffee harasho", "89898", exp4, info, 18.8F, 22.4F, 55, l2,
						ShelfProduct.packageType.Glass);
				Product p7 = new ShelfProduct("CiniBIGI", "34343", exp4, null, 10.8F, 16.4F, 55, l3,
						ShelfProduct.packageType.Cardboard);


				mega1.addProduct(p1);
				mega1.addProduct(p2);
				mega1.addProduct(p3);
				mega1.addProduct(p4);
				mega1.addProduct(p5);
				mega1.addProduct(p6);
				mega1.addProduct(p7);
				
				new MainFrame(mega1);

				/////////////////////////////////////////////

				// for (int i = 0 ; i < prdArr.length; i++)
				// mega1.addProduct(prdArr[i]);
				//
				// System.out.println(mega1);
				//
				// mega1.sortCustomers();
				// System.out.println("\n\n-----------Store after customer
				// sort----------\n");
				// System.out.println(mega1);
				//
				//
				// mega1.sortProductsByName();
				// System.out.println("\n\n-----------Store after product sort
				// by name----------\n");
				// System.out.println(mega1);
				//
				// mega1.sortProductsByBarcode();
				// System.out.println("\n\n-----------Store after product sort
				// by Barcode ----------\n");
				// System.out.println(mega1);
				//
				//
				// mega1.sortProductsByExpDate();
				// System.out.println("\n\n-----------Store after product sort
				// by ExpDate----------\n");
				// System.out.println(mega1);
				//
				// //create a vector of all customers and products to test
				// interface OnMonthable
				// Vector<Object> vecCustomer = new
				// Vector<Object>(Arrays.asList(mega1.getCustomerArr()));
				// Vector<Object> fullVec = new Vector<Object>();
				// fullVec.addAll(vecCustomer);
				// fullVec.addAll(mega1.getProductVector());
				// System.out.println("\n\n-----------Store Month Due
				// ----------\n");
				// mega1.monthDue(fullVec);
				//
				// System.out.println("\n\n-----------Store after month due
				// ----------\n");
				// System.out.println(mega1);
				//
				// //Checking LinkedHasMap and remove.
				// String barcode = "12345";
				// Product p = mega1.getProductByBarcode(barcode);
				// if (p!=null)
				// System.out.println("\nFound the product " + p);
				// else
				// System.out.println("Did not found barcode " + barcode);
				//
				// mega1.removeProduct(barcode);
				//
				// System.out.println("\n\n-----------Store after remove barcode
				// " + barcode + " ----------\n");
				//
				// p = mega1.getProductByBarcode(barcode);
				// if (p!=null)
				// System.out.println("\nFound the product " + p);
				// else
				// System.out.println("Did not found barcode " + barcode);
				// System.out.println(mega1);

				// } catch (Exception e) {
				// System.out.println(e.getMessage());
				// }
	}

}
