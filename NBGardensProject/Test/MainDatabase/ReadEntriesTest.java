package MainDatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReadEntriesTest {

	@Test
	public void RetrieveAllOrdersTest() {
		ReadEntries tester = new ReadEntries();
		int size = tester.RetrieveAllOrders().size();
		assertEquals(size, 3);   //we know there are 3 entries in the database
	}

	
	@Test
	public void RetrieveAllProductsTest()
	{
		ReadEntries tester = new ReadEntries();
		int size = tester.RetrieveAllProducts().size();
		assertEquals(size, 13);
	}
	
	@Test
	public void AllProductsOnOrderTest()
	{
		ReadEntries tester = new ReadEntries();
		int size = tester.AllProductsOnOrder(1).size();
		assertEquals(size, 2);
	}

	@Test
	public void ReadOrderStatusTest(){
		ReadEntries tester = new ReadEntries();
		String orderStatusTest = tester.ReadOrderStatus(1);
		assertEquals(orderStatusTest, "Being Worked");
	}
	
	@Test
	public void ReadStockLevelTest(){
		ReadEntries tester = new ReadEntries();
		int stockLevelTest = tester.ReadStockLevel(1);
		assertEquals(stockLevelTest, 100);
	}
}
