package UI;

import javax.swing.JDialog;
import javax.swing.JFrame;

import AllClasses.SuperMarket;

@SuppressWarnings("serial")
public class AddProductDialog extends JDialog {
	
	 private AddProductMainPanel mainPanel;
	 
	public AddProductDialog(SuperMarket superMarket){//, MainPanel panel){
		super((JFrame)null,true);

	    setTitle("Add a Product Dialog");
	    mainPanel = new AddProductMainPanel(superMarket);
	    add(mainPanel);
	    mainPanel.setBorder(null);
	    setResizable(false);
	    setLocationRelativeTo(null);
	    setAlwaysOnTop(true);
	    setSize(360, 535);
	    setVisible(true);
	}
}
