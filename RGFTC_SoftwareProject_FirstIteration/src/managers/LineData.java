package managers;

public class LineData {
	
	private int purchase_orderID;
	private String productName;
	private String category;
	private String subtype;
	private String brand;
	private String packaging;
	private int pricePerKilo;
	private int quantity;
	private int weight;
	private int status;
	
	public LineData(int purchase_orderID, String productName, String category, String subtype, String brand, String packaging, int pricePerKilo, int quantity, int weight, int status){
		this.purchase_orderID = purchase_orderID;
		this.productName = productName;
		this.category = category;
		this.subtype = subtype;
		this.brand = brand;
		this.packaging = packaging;
		this.pricePerKilo = pricePerKilo;
		this.quantity = quantity;
		this.weight = weight;
		this.status = status;
	}
	
	public int getPurchaseID() {
		return purchase_orderID;
	}

	public void setPurchaseID(int purchase_orderID) {
		this.purchase_orderID = purchase_orderID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public int getPricePerKilo() {
		return pricePerKilo;
	}

	public void setPricePerKilo(int pricePerKilo) {
		this.pricePerKilo = pricePerKilo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
