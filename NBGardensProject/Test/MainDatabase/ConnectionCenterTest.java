package MainDatabase;
import static org.junit.Assert.*;

import org.junit.Test;


public class ConnectionCenterTest {

	@Test
	public void testOpenConnectionToDatabase()
	{
		ConnectionCenter tester = new ConnectionCenter();
		assertTrue(tester.OpenConnectionToDatabase());
		tester.CloseConnectionToDatabase();
	}

	@Test
	public void testCreateDatabaseEntry()
	{
		
	}

	@Test
	public void testUpdateDatabaseEntry() 
	{
		
		
	}

	@Test
	public void testDeleteDatabaseEntry() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testCloseConnectionToDatabase() 
	{
		
		ConnectionCenter tester = new ConnectionCenter();
		tester.OpenConnectionToDatabase();
		assertFalse(tester.CloseConnectionToDatabase());
	}

}
