package MainDatabase;

import java.util.ArrayList;

public class OrderSorter {

	private ArrayList<Order> toBeWorked = new ArrayList<Order>();
	private ArrayList<Order> beingWorked = new ArrayList<Order>();

	//generates two lists of orders depending on their current status
	public void SortedOrders()
	{
		ReadEntries  allOrders = new ReadEntries();
		for(Order order : allOrders.RetrieveAllOrders())
		{
			if(order.getCustomerOrderStatusId() == 1)
			{
				toBeWorked.add(order);
				allOrders.RetrieveAllOrders().remove(order);
			}
			else if(order.getCustomerOrderStatusId() == 2)
			{
				beingWorked.add(order);
				allOrders.RetrieveAllOrders().remove(order);
			}
			else
			{
				allOrders.RetrieveAllOrders().remove(order);
				continue;	
			}
		}
	}

	//sends one of the lists to the gui class so that it can be shown
	public String[] SendToBeWorkedOrderListGUI()
	{
		//TODO Send both lists to respective GUIs 
		String[] stringArray = new String[toBeWorked.size()+1];
		stringArray[0]= "Order ID:        Date Ordered:          Order Status ID:     ";
		int n = 1;
		for(Order order: toBeWorked)
		{
//			System.out.print("id:   " + order.getId());
//			System.out.print("    Date & Time Ordered:" + order.getDateTimeOrdered());
//			System.out.print("    Status:" + order.getCustomerOrderStatusId());
//			System.out.println(); 
			String orderString = new String(order.getId() +"                   " + order.getDateTimeOrdered() + "                " + order.getCustomerOrderStatusId());
			stringArray[n] = orderString;
			n++;
		}
		
		return stringArray;
	}
	
	//sends one of the lists to the gui class so that it can be shown
	public String[] SendBeingWorkedListGUI()
	{
		String[] stringArray = new String[beingWorked.size()+1];
		stringArray[0]= "Order ID:        Date Ordered:          Order Status ID:     ";
		
		int n = 1;
		for(Order order: beingWorked)
		{
			System.out.print("id:   " + order.getId());
			System.out.print("    Date & Time Ordered:" + order.getDateTimeOrdered());
			System.out.print("    Status:" + order.getCustomerOrderStatusId());
			System.out.println();
			String orderString = new String(order.getId() +"                   " + order.getDateTimeOrdered() + "                " + order.getCustomerOrderStatusId());
			stringArray[n] = orderString;  
			n++;
		}
		return stringArray;
	}
	
	//sends all the products of one order to a gui so they can all be seen and then picked
	public String[] SendSpecificOrderToGUI(int orderId)
	{
		ReadEntries reader = new ReadEntries();
		ArrayList<Product> allProducts = reader.AllProductsOnOrder(orderId);
		String[] productsArray = new String[allProducts.size()+1];
		productsArray[0]= "Cust Order ID:        Product ID:          Product Name:     ";
		int n = 1;
		for(Product product : allProducts)
		{
//			System.out.print("Cust Order ID: " + product.getCustomerOrderid());
//			System.out.print(" Product ID: " + product.getId());
//			System.out.print(" Product Name: " + product.getProductName());
//			System.out.println();
			String orderString = new String(product.getCustomerOrderid()+"                              '" +
			product.getId() + "'                                  " + 
					product.getProductName());
			productsArray[n] = orderString;
			n++;
		}
		return productsArray;
	}

	//two getters so list can be retrieved by other methods
	public ArrayList<Order> getToBeWorked() {
		return toBeWorked;
	}



	public ArrayList<Order> getBeingWorked() {
		return beingWorked;
	}



}

