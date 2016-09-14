package MainDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadEntries {

	
	//methods to read specific data from the database so it can be used in other parts of the program
	public ArrayList<Order> RetrieveAllOrders()
	{
		ConnectionCenter connector = new ConnectionCenter();
		ArrayList<Order> allOrders = new ArrayList<Order>();
		System.out.println("Reading records from the table...");
		try 
		{
			System.out.println( "Creating statement...");
			String getAllOrdersStatement = "SELECT co.id, Customer_id, DateTime, CustomerOrderStatus_id,"
					+ " DeliveryDate, Employee_id, GDZ FROM customerorder co JOIN customer c ON"
					+ " c.id= co.Customer_id JOIN address a ON a.id = c.Address_id";
			connector.OpenConnectionToDatabase();
			connector.setStatement(connector.getConnection().createStatement());
			ResultSet resultFromQuery = connector.getStatement().executeQuery(getAllOrdersStatement);
			System.out.println(  "Read records from the table...");
			while (resultFromQuery.next()) 
			{
				Order order1 = new Order(resultFromQuery.getInt("id"),
						resultFromQuery.getInt("Customer_id"), 
						resultFromQuery.getString("DateTime"), 
						resultFromQuery.getInt("CustomerOrderStatus_id"), 
						resultFromQuery.getString("DeliveryDate"),
						resultFromQuery.getInt("Employee_id"),
						resultFromQuery.getInt("GDZ"));
				allOrders.add(order1);
			}
			resultFromQuery.close();	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println(  "Failed to read records from the table...");
		}

		connector.CloseConnectionToDatabase();
		return allOrders;
	}

	public ArrayList<Product> RetrieveAllProducts()
	{
		ConnectionCenter connector = new ConnectionCenter();
		ArrayList<Product> allProducts = new ArrayList<Product>();
		connector.OpenConnectionToDatabase();
		System.out.println("Reading records from the table...");
		try 
		{
			System.out.println( "Creating statement...");
			String getAllOrdersStatement = "SELECT id, ProductName, StockLevel, SellPrice, OrderPrice, LowLimit FROM products";
			connector.setStatement(connector.getConnection().createStatement());
			ResultSet resultFromQuery = connector.getStatement().executeQuery(getAllOrdersStatement);
			System.out.println(  "Read records from the table...");
			while (resultFromQuery.next()) 
			{
				Product order1 = new Product(resultFromQuery.getInt("id"),
						resultFromQuery.getString("productName"), 
						resultFromQuery.getInt("stockLevel"), 
						resultFromQuery.getDouble("sellPrice"), 
						resultFromQuery.getDouble("orderPrice"),
						resultFromQuery.getInt("lowLimit"));
				allProducts.add(order1);
			}
			resultFromQuery.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println(  "Failed to read records from the table...");
		}

		connector.CloseConnectionToDatabase();
		return allProducts;
	}

	public ArrayList<Product> AllProductsOnOrder(int id)
{
		ConnectionCenter connector = new ConnectionCenter();
		String query = "SELECT cop.CustomerOrder_id, cop.Products_id,"
				+ " p.ProductName FROM custorderproduct cop JOIN products p ON p.id = cop.Products_id"
				+ " WHERE cop.CustomerOrder_id = " + id;
		ArrayList<Product> productsOnOrder = new ArrayList<Product>();
		connector.OpenConnectionToDatabase();

		try 
		{
			System.out.println( "Creating statement...");
			String getAllOrdersStatement = query;
			connector.setStatement(connector.getConnection().createStatement());
			ResultSet resultFromQuery = connector.getStatement().executeQuery(getAllOrdersStatement);
			System.out.println(  "Read records from the table...");
			while (resultFromQuery.next()) 
			{
				Product product1 = new Product(resultFromQuery.getInt("cop.CustomerOrder_id"),
						resultFromQuery.getInt("cop.Products_id"), 
						resultFromQuery.getString("p.ProductName")); 
				productsOnOrder.add(product1);
			}
			resultFromQuery.close();	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println(  "Failed to read records from the table...");
		}

		connector.CloseConnectionToDatabase();
		return productsOnOrder;
	}

	public String ReadOrderStatus(int id)
	{
		ConnectionCenter connector = new ConnectionCenter();
		String statusOfOrder = null;
		try
		{
			System.out.println( "Creating statement...");
			String getOrderStatus = "SELECT Status FROM customerorder co"
					+ " JOIN customerorderstatus cos ON cos.id = co.CustomerOrderStatus_id"
					+ " WHERE co.id =" + id;
			connector.OpenConnectionToDatabase();
			connector.setStatement(connector.getConnection().createStatement());
			ResultSet resultFromQuery = connector.getStatement().executeQuery(getOrderStatus);
			while (resultFromQuery.next()) 
			{
				statusOfOrder = resultFromQuery.getString("Status");
				System.out.println(statusOfOrder);
			}
			resultFromQuery.close();
			System.out.println(  "Read status from the table...");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println(  "Failed to read records from the table...");
		}

		connector.CloseConnectionToDatabase();
		return statusOfOrder;
	}

	public int ReadStockLevel(int id)
{
		ConnectionCenter connector = new ConnectionCenter();
		int stockLevel = 0;
		try
		{
			System.out.println( "Creating statement...");
			String stockQuery = "SELECT StockLevel FROM products WHERE id =" + id;
			connector.OpenConnectionToDatabase();
			connector.setStatement(connector.getConnection().createStatement());
			ResultSet resultFromQuery = connector.getStatement().executeQuery(stockQuery);
			if(resultFromQuery.next()) 
			{
				stockLevel = resultFromQuery.getInt("StockLevel");
			}
			resultFromQuery.close();
			System.out.println(  "Read status from the table...");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println(  "Failed to read stock records from the table...");

		}

		connector.CloseConnectionToDatabase();	
		return stockLevel;	
	}

	public int ReadPurchaseOrderQuantity(int purchaseOrderId, int productId)
	{
		ConnectionCenter connector = new ConnectionCenter();
		int quantityDelievered = 0;
		try
		{
			System.out.println( "Creating statement...");
			String quantityQuery = "SELECT pop.Quantity, pop.Products_id FROM purchorderproduct pop"
					+ " WHERE pop.PurchaseOrder_id = " + purchaseOrderId +
					" AND pop.Products_id =" + productId;
			connector.OpenConnectionToDatabase();
			connector.setStatement(connector.getConnection().createStatement());
			ResultSet resultFromQuery = connector.getStatement().executeQuery(quantityQuery);
			if (resultFromQuery.next()) 
			{
				quantityDelievered = resultFromQuery.getInt("Quantity");
				System.out.println("Quantity is: " + quantityDelievered);
			}
			resultFromQuery.close();
			System.out.println(  "Read quantity from the table...");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println(  "Failed to read quantity from the table...");

		}

		connector.CloseConnectionToDatabase();	
		return 	quantityDelievered;
	}

	public boolean ReadEmployeeId(int EmployeeId)
	{
		ConnectionCenter connector = new ConnectionCenter();
		boolean isEmployee = false;
		try
		{
			System.out.println( "Creating statement...");
			String query = "SELECT concat(e.FName, \" \", e.SName) FROM employee e WHERE e.id =" + EmployeeId;
			connector.OpenConnectionToDatabase();
			connector.setStatement(connector.getConnection().createStatement());
			ResultSet resultFromQuery = connector.getStatement().executeQuery(query);
			if(resultFromQuery.next()) 
			{
				isEmployee = true;
			}
			resultFromQuery.close();
			System.out.println(  "Found Employee...");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println(  "Failed to read employee records from the table...");
		}
		connector.CloseConnectionToDatabase();
		return isEmployee;
	}

}
