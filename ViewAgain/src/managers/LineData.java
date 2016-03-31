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
	
	private String clientName;
	private String deliveryDueDate;
	private String deliveryNotes;
	
	public LineData(int purchase_orderID, String clientName, String productName, String category, String subtype, String brand, String packaging, int pricePerKilo, int quantity, int weight, String deliveryDueDate, String deliveryNotes, int status){
		this.purchase_orderID = purchase_orderID;
		this.clientName = clientName;
		this.productName = productName;
		this.subtype = subtype;
		this.brand = brand;
		this.packaging = packaging;
		this.pricePerKilo = pricePerKilo;
		this.quantity = quantity;
		this.weight = weight;
		this.deliveryDueDate = deliveryDueDate;
		this.deliveryNotes = deliveryNotes;
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



	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDeliveryDueDate() {
		return deliveryDueDate;
	}

	public void setDeliveryDueDate(String deliverDueDate) {
		this.deliveryDueDate = deliverDueDate;
	}

	public String getDeliveryNotes() {
		return deliveryNotes;
	}

	public void setDeliveryNotes(String deliveryNotes) {
		this.deliveryNotes = deliveryNotes;
	}
	
	
	
}
