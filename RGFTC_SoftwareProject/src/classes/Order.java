package classes;

import java.util.Date;

public class Order {

	private int purchase_orderID;
	private String clientName;
	private Product[] product;
	private float[] productPrice;
	private String receiver;
	private Date dueDate;
	private String[] notes;
	private Boolean deliveryStatus;
	
	public Order(){}
	
	public Order(String clientName, Product[] product, float[] productPrice, String receiver, Date dueDate, String[] notes, Boolean deliveryStatus){
		this.clientName = clientName;
		this.product = product;
		this.productPrice = productPrice;
		this.receiver = receiver;
		this.dueDate = dueDate;
		this.notes = notes;
		this.deliveryStatus = deliveryStatus;
	}

	public int getPurchase_orderID() {
		return purchase_orderID;
	}

	public void setPurchase_orderID(int purchase_orderID) {
		this.purchase_orderID = purchase_orderID;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Product[] getProduct() {
		return product;
	}

	public void setProduct(Product[] product) {
		this.product = product;
	}

	public float[] getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float[] productPrice) {
		this.productPrice = productPrice;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String[] getNotes() {
		return notes;
	}

	public void setNotes(String[] notes) {
		this.notes = notes;
	}

	public Boolean getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	
}
