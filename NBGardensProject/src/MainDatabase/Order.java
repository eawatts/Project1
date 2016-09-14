package MainDatabase;

public class Order 
{

	private int id;
	private int customerId;
	private String dateTimeOrdered;
	private int customerOrderStatusId;
	private String deliveryDate;
	private int employeeId;
	private int gdz;
	
	
	//constructor for an order
	public Order(int id, int customerId, String dateTimeOrdered, int customerOrderStatusId, String deliveryDate, int employeeId, int gdz)
	{
		this.id=id;
		this.customerId=customerId;
		this.dateTimeOrdered=dateTimeOrdered;
		this.customerOrderStatusId=customerOrderStatusId;
		this.deliveryDate=deliveryDate;
		this.employeeId=employeeId;	
		this.gdz = gdz;
	}

	//all getters and setters for the variables in the order constructor
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDateTimeOrdered() {
		return dateTimeOrdered;
	}

	public void setDateTimeOrdered(String dateTimeOrdered) {
		this.dateTimeOrdered = dateTimeOrdered;
	}

	public int getCustomerOrderStatusId() {
		return customerOrderStatusId;
	}

	public void setCustomerOrderStatusId(int customerOrderStatusId) {
		this.customerOrderStatusId = customerOrderStatusId;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public int getGdz() {
		return gdz;
	}

	public void setGdz(int gdz) {
		this.gdz = gdz;
	}
}

