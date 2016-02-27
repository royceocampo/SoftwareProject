package classes;

public class Product {
	private int productID;
	private String productName;
	private String category;
	private String subType;
	private String brand;
	private String packaging;
	private String size;
	private float pricePerKilo;
	
	public Product(){}
	
	public Product(String productName, String category, String subType, String brand, String packaging, String size, float pricePerKilo){
		this.productName = productName;
		this.category = category;
		this.subType = subType;
		this.brand = brand;
		this.packaging = packaging;
		this.size = size;
		this.pricePerKilo = pricePerKilo;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
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

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPricePerKilo() {
		return pricePerKilo;
	}

	public void setPricePerKilo(float pricePerKilo) {
		this.pricePerKilo = pricePerKilo;
	}
	
	
}
