package MainDatabase;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*; 
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProductListGUI extends JFrame{
	
	OrderSorter orderSorter = new OrderSorter();
	UpdateEntries updateStock = new UpdateEntries();
	
	private JPanel mainPanel;
	
	//GUI so that all products on an order can be seen and clicked on to remove them from the list as they are picked
	
	public ProductListGUI(int orderIdNumber)
	{
		super("Product List");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		orderSorter.SortedOrders();
		JList<String> productListOnOrder = new JList<String>(orderSorter.SendSpecificOrderToGUI(orderIdNumber));
		productListOnOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productListOnOrder.setBounds(11, 11, 400, 350);
		productListOnOrder.setLayoutOrientation(JList.VERTICAL);
		productListOnOrder.setVisibleRowCount(-1);
		mainPanel.add(productListOnOrder);
		productListOnOrder.addListSelectionListener(
					new ListSelectionListener()
					{
						public void valueChanged(ListSelectionEvent event)
						{
							int productListIndex =productListOnOrder.getSelectedIndex();
							if(productListIndex >=1)
							{
							String productString = productListOnOrder.getModel().getElementAt(productListIndex).toString();
							 String[] productIdString = productString.split("'");
							 int productId = Integer.parseInt(productIdString[1]);
							 JOptionPane.showMessageDialog(getContentPane(), productId);
							 updateStock.UpdateStockLevelPicking(productId);
							 
						
							}
							else
							{
								return;
							}
						}
					}
				); 
	}
}
