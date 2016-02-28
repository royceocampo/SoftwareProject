package classes;

public class Product {
	private int productID;
	private String productName;
	private String category;
	private String subtype;
	private String brand;
	private String packaging;
	private float pricePerKilo;
	private int stocks;
	
	public Product(){}
	
	public Product(String productName, String category, String subtype, String brand, String packaging, float pricePerKilo, int stocks){
		this.productName = productName;
		this.category = category;
		this.subtype = subtype;
		this.brand = brand;
		this.packaging = packaging;
		this.pricePerKilo = pricePerKilo;
		this.stocks = stocks;
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

	public float getPricePerKilo() {
		return pricePerKilo;
	}

	public void setPricePerKilo(float pricePerKilo) {
		this.pricePerKilo = pricePerKilo;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	
}
