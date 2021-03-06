package managers;

public class Product {
	private int productID;
	private String productName;
	private String prodCategory;
	private String prodSubtype;
	private String prodBrand;
	private String prodPackaging;
	private float prodPrice;
	private int prodStocks;
	
	
//	public Product(String productName, String prodCategory, String prodSubtype,
//					String prodBrand, String prodPackaging, float prodPrice, int prodStocks){
//		this(0, productName, prodCategory, prodSubtype, prodBrand, prodPackaging, prodPrice, prodStocks);
//	}
	
	public Product(){}
	
	public Product(String productName, String prodCategory, String prodSubtype,
			String prodBrand, String prodPackaging, float prodPrice, int prodStocks){
		super();
//		this.productID = productID;
		this.productName = productName;
		this.prodCategory = prodCategory;
		this.prodSubtype= prodSubtype;
		this.prodBrand = prodBrand;
		this.prodPackaging = prodPackaging;
		this.prodPrice = prodPrice;
		this.prodStocks = prodStocks;
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


	public String getProdCategory() {
		return prodCategory;
	}


	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}


	public String getProdSubtype() {
		return prodSubtype;
	}


	public void setProdSubtype(String prodSubtype) {
		this.prodSubtype = prodSubtype;
	}


	public String getProdBrand() {
		return prodBrand;
	}


	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}


	public String getProdPackaging() {
		return prodPackaging;
	}


	public void setProdPackaging(String prodPackaging) {
		this.prodPackaging = prodPackaging;
	}


	public float getProdPrice() {
		return prodPrice;
	}


	public void setProdPrice(float prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdStocks() {
		return prodStocks;
	}

	public void setProdStocks(int prodStocks) {
		this.prodStocks = prodStocks;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", prodCategory=" + prodCategory
				+ ", prodSubtype=" + prodSubtype + ", prodBrand=" + prodBrand + ", prodPackaging=" + prodPackaging
				+ ", prodPrice=" + prodPrice + ", prodStocks=" + prodStocks + "]";
	}
}
