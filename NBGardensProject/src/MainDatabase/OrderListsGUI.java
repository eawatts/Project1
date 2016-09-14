package MainDatabase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class OrderListsGUI extends JFrame {
	
	OrderSorter orderSorter = new OrderSorter();
	
	

	private JPanel contentPane;
	private JButton submitButton;
	private JTextField orderIdBox;
	private JLabel headerLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		LoginGUI login = new LoginGUI();
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(300,200);
		login.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public OrderListsGUI() {
		super("Order lists");
		
		headerLabel = new JLabel("Enter order ID from left list to work on",JLabel.CENTER);
		headerLabel.setText("Enter order ID from left list to work on");
		orderIdBox = new JTextField(20);
		submitButton = new JButton("Submit");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		orderSorter.SortedOrders();
		JList toBeWorkedList = new JList(orderSorter.SendToBeWorkedOrderListGUI());
		
		toBeWorkedList.setBounds(10, 11, 300, 350);
		toBeWorkedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		toBeWorkedList.setLayoutOrientation(JList.VERTICAL);
		toBeWorkedList.setVisibleRowCount(-1);
		contentPane.add(toBeWorkedList);
		

		JList workingList = new JList(orderSorter.SendBeingWorkedListGUI());
		workingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		workingList.setBounds(330, 11, 300, 350);
		workingList.setLayoutOrientation(JList.VERTICAL);
		workingList.setVisibleRowCount(-1);
		contentPane.add(workingList);
		
		orderIdBox.setBounds(200, 400, 100, 30);
		submitButton.setBounds(330, 400, 100, 30 );
		headerLabel.setBounds(200, 330, 280, 100);
		contentPane.add(orderIdBox);
		contentPane.add(headerLabel);
		contentPane.add(submitButton);
		
		HandlerClass handler = new HandlerClass();
		submitButton.addActionListener(handler);
		
	}
	
	//inner class that handles all events on the GUI at this stage
	private class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();
			switch(command)
			{
			case "Submit":
				String orderID = orderIdBox.getText();
				int idNumber = 0;
				try{
				idNumber = Integer.parseInt(orderID);
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(getContentPane(), "Enter a number");
					return;
				}
				ReadEntries reader = new ReadEntries();
				 ArrayList<Product> productList = reader.AllProductsOnOrder(idNumber);
				 if(productList.size() > 0)
				 {
					//TODO build GUI for list of products on order 
					 ProductListGUI frame = new ProductListGUI(idNumber);
						frame.setVisible(true); 
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(getContentPane(), "Enter a valid order ID");
						return; 
				 }
			}
		}
	}
}
