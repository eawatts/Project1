package MainDatabase;

public class Product {

	private int id, customerOrderid ;
	private String productName;
	private int stockLevel;
	private double sellPrice;
	private double orderPrice;
	private int lowLimit;
	
	//constructor so that we have all the details on a particular product
	public Product(int id, String productName, int stockLevel, double sellPrice, double orderPrice, int lowLimit)
	{
		this.id = id;
		this.productName = productName;
		this.stockLevel = stockLevel;
		this.sellPrice = sellPrice;
		this.orderPrice = orderPrice;
		this.lowLimit = lowLimit;			
	}
	
	//constructor that will allow us to create a list of products on an order
	public Product(int customerOrderid, int id, String productName){
		this.customerOrderid = customerOrderid;
		this.id = id;
		this.productName = productName;
	}
	
	//all getters and setters for two constructors above
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getLowLimit() {
		return lowLimit;
	}

	public void setLowLimit(int lowLimit) {
		this.lowLimit = lowLimit;
	}

	public int getCustomerOrderid() {
		return customerOrderid;
	}

	public void setCustomerOrderid(int customerOrderid) {
		this.customerOrderid = customerOrderid;
	}
	
	
}

