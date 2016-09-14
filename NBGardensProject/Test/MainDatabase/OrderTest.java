package MainDatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	Order tester = new Order(1, 2, "2016-12-25 12:00:01", 3, "2016-12-30", 6, 9);
	
	@Test
	public void testGetId() {
		assertEquals(tester.getId(), 1);
	}

	@Test
	public void testSetId() {
		tester.setId(10);
		assertEquals(tester.getId(), 10);
	}

	@Test
	public void testGetCustomerId() {
		assertEquals(tester.getCustomerId(), 2);
	}

	@Test
	public void testSetCustomerId() {
		tester.setCustomerId(12);
		assertEquals(tester.getCustomerId(), 12);
	}

	@Test
	public void testGetDateTimeOrdered() {
		assertEquals(tester.getDateTimeOrdered(), "2016-12-25 12:00:01");
	}

	@Test
	public void testSetDateTimeOrdered() {
		tester.setDateTimeOrdered("2016-12-26 00:00:00");
		assertEquals(tester.getDateTimeOrdered(), "2016-12-26 00:00:00");
	}

	@Test
	public void testGetCustomerOrderStatusId() {
		assertEquals(tester.getCustomerOrderStatusId(), 3);
	}

	@Test
	public void testSetCustomerOrderStatusId() {
		tester.setCustomerOrderStatusId(16);
		assertEquals(tester.getCustomerOrderStatusId(), 16);
	}

	@Test
	public void testGetDeliveryDate() {
		assertEquals(tester.getDeliveryDate(), "2016-12-30");
	}

	@Test
	public void testSetDeliveryDate() {
		tester.setDeliveryDate("2017-01-01");
		assertEquals(tester.getDeliveryDate(), "2017-01-01");
	}

	@Test
	public void testGetEmployeeId() {
		assertEquals(tester.getEmployeeId(), 6);
	}

	@Test
	public void testSetEmployeeId() {
		tester.setEmployeeId(18);
		assertEquals(tester.getEmployeeId(), 18);
	}

	@Test
	public void testGetGdz() {
		assertEquals(tester.getGdz(), 9);
	}

	@Test
	public void testSetGdz() {
		tester.setGdz(20);
		assertEquals(tester.getGdz(), 20);
	}

}
