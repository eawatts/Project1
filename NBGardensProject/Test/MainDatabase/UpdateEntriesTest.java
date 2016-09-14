package MainDatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class UpdateEntriesTest
{
	UpdateEntries tester = new UpdateEntries();
	ReadEntries readTester = new ReadEntries();

	@Test
	public void testUpdateOrderStatus()
	{
		tester.UpdateOrderStatus(1, 2);
		String statusTester = readTester.ReadOrderStatus(1);
		assertEquals(statusTester, "Being Worked");	
	}

	@Test
	public void testUpdateStockLevelPicking()
	{
		int currentStockLevel = readTester.ReadStockLevel(1);
		tester.UpdateStockLevelPicking(1);
		int newStockLevel = readTester.ReadStockLevel(1);
		assertEquals(newStockLevel, currentStockLevel-1);
	}
	
	@Test
	public void testUpdateStockLevelDelivery(){
		int currentStockLevel = readTester.ReadStockLevel(1);
		int amountDelivered = readTester.ReadPurchaseOrderQuantity(1, 1);
		tester.UpdateStockLevelDelivery(1, 1);
		int updatedStockLevel = readTester.ReadStockLevel(1);
		assertEquals(updatedStockLevel, currentStockLevel + amountDelivered);
	}

}
