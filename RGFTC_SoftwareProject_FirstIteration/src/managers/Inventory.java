package managers;

public class Inventory {

	private int inventoryID;
	private String person;
	private String product;
	private int quantity;
	private String date;
	private int productID;
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(int inventoryID, String person, String product,
			int quantity, String date, int productID) {
		super();
		this.inventoryID = inventoryID;
		this.person = person;
		this.product = product;
		this.quantity = quantity;
		this.date = date;
		this.productID = productID;
	}

	public int getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
}
