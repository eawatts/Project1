package MainDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionCenter {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/nb-gardens?useSSL=false";
	static final String USER = "root";
	static final String PASS = "broly1";

	private Connection connection = null;
	private Statement statement = null;
	private boolean isConnected = false;
	
	
	
//This method opens a connection to the database
	public boolean OpenConnectionToDatabase()
	{
		System.out.println( "Connecting to database...");
		try
		{
			Class.forName( "com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			isConnected = true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println(  "Failed to connect to database...");
		}	
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(  "Failed to connect to database...");
		}
		return isConnected;
	}

	//This method closes a connection to the database
	public boolean CloseConnectionToDatabase()

	{
		
		try 
		{
			if (connection != null)
			{
				connection.close();
				System.out.println("Connection closed...");
				isConnected = false;
			}
		} 
		catch (SQLException se) 
		{
			se.printStackTrace();
			System.out.println("Failed to disconnect. bad...");
		}

		System.out.println("Goodbye!...");
		return isConnected;
	}

	
	//these are getters and setters for the above statement and connection variables
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
	
	
	
}