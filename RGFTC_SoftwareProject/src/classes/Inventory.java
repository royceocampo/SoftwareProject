package classes;

public class Inventory {

	private int inventoryID;
	private Product product;
	private int stockAmount;
	private int boxAmount;
	private float weight;
	
	public Inventory(){}
	
	public Inventory(Product product, int stockAmount, int boxAmount, float weight){
		this.product = product;
		this.stockAmount = stockAmount;
		this.boxAmount = boxAmount;
		this.weight = weight;
	}

	public int getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public int getBoxAmount() {
		return boxAmount;
	}

	public void setBoxAmount(int boxAmount) {
		this.boxAmount = boxAmount;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
}
