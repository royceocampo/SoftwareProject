package managers;

public class LineItems {

	private int lineID;
	private int orderID;
	private int productID;
	private float pricePerKilo;
	private int quantity;
	
	public LineItems(){}
	
	public LineItems(int orderID, int productID, float pricePerKilo, int quantity){
		this.orderID = orderID;
		this.productID = productID;
		this.pricePerKilo = pricePerKilo;
		this.quantity = quantity;
	}

	public int getLineID() {
		return lineID;
	}

	public void setLineID(int lineID) {
		this.lineID = lineID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public float getPricePerKilo() {
		return pricePerKilo;
	}

	public void setPricePerKilo(float pricePerKilo) {
		this.pricePerKilo = pricePerKilo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}