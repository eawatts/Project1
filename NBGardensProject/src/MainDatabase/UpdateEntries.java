package MainDatabase;

import java.sql.SQLException;

public class UpdateEntries 
{
	ConnectionCenter connector = new ConnectionCenter();
	
	
	//all methods update specific parts of the database depending on what has occurred in other parts of the program
	public void UpdateOrderStatus(int id, int orderStatusId)
	{
		String query = "UPDATE `customerorder` SET `CustomerOrderStatus_id` ="
		+ orderStatusId +" WHERE `id` =" + id;
				
	    connector.OpenConnectionToDatabase();
	    
	    try
	    {
	    	System.out.println("Creating statement...");
	    	String updateStatement = query;
	    	connector.setStatement(connector.getConnection().createStatement());
	    	connector.getStatement().executeUpdate(updateStatement);
	    	System.out.println(  "Updated records in database....");
	    }
	    catch (SQLException e)
	    {
	    	e.printStackTrace();
	    	System.out.println("Failed to update records...");
	    }
		
		connector.CloseConnectionToDatabase();
	}
	
	public void UpdateStockLevelPicking(int id)
	{
		ReadEntries readStockLevel = new ReadEntries();
		int currentStockLevel = readStockLevel.ReadStockLevel(id);
		int newStockLevel = currentStockLevel - 1;
		String query = "UPDATE `products` SET `StockLevel` =" + 
		newStockLevel + " WHERE `id` =" + id;
						
			    connector.OpenConnectionToDatabase();
			    
			    try
			    {
			    	System.out.println("Creating statement...");
			    	String updateStatement = query;
			    	connector.setStatement(connector.getConnection().createStatement());
			    	connector.getStatement().executeUpdate(updateStatement);
			    	System.out.println(  "Updated stock level in database....");
			    }
			    catch (SQLException e)
			    {
			    	e.printStackTrace();
			    	System.out.println("Failed to update stock level...");
			    }
				
				connector.CloseConnectionToDatabase();
	}
	
	public void UpdateStockLevelDelivery(int productId, int purchaseOrderId)
	{
		ReadEntries reader = new ReadEntries();
		int currentStockLevel = reader.ReadStockLevel(productId);
		int amountDelivered = reader.ReadPurchaseOrderQuantity(purchaseOrderId, productId);
		int newStockLevel = currentStockLevel + amountDelivered;
		String query = "UPDATE `products` SET `StockLevel` =" + newStockLevel + " WHERE `id` =" + productId;
								
					    connector.OpenConnectionToDatabase();
					    
					    try
					    {
					    	System.out.println("Creating statement...");
					    	String updateStatement = query;
					    	connector.setStatement(connector.getConnection().createStatement());
					    	connector.getStatement().executeUpdate(updateStatement);
					    	System.out.println(  "Updated stock level in database....");
					    }
					    catch (SQLException e)
					    {
					    	e.printStackTrace();
					    	System.out.println("Failed to update stock level...");
					    }
						
						connector.CloseConnectionToDatabase();
	}
	
	
}
