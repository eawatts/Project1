package MainDatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderSorterTest {

	@Test
	public void testSortedOrders() 
	{
		OrderSorter tester = new OrderSorter();
		tester.SortedOrders();
		int beingWorkedSize = tester.getBeingWorked().size();
		int toBeWorkedSize = tester.getToBeWorked().size();
		assertEquals(toBeWorkedSize, 2);
		assertEquals(beingWorkedSize, 1);

	}

	
//	@Test
//	public void testSendToGUI()
//	{
//
//		fail("failure");
//	}

	@Test
	public void testGetToBeWorked()
	{
		OrderSorter tester = new OrderSorter();
		assertNotNull(tester.getToBeWorked());
	}
	
	@Test
	public void testGetBeingWorked()
	{
		OrderSorter tester = new OrderSorter();
		assertNotNull(tester.getBeingWorked());
	}
}


