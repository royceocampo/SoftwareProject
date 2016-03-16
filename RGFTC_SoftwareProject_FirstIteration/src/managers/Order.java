package managers;

import java.sql.Date;

public class Order {

	private int purchase_orderID;
	private String clientName;
	private float price;
	private String orderReceiver;
	private Date deliveryDueDate;
	private Boolean deliveryStatus;
	private String notes;

	public Order() {
	}

	public Order(String clientName, float price, String orderReceiver, Date deliveryDueDate, Boolean deliveryStatus, String notes) {
		this.clientName = clientName;
		this.price = price;
		this.orderReceiver = orderReceiver;
		this.deliveryDueDate = deliveryDueDate;
		this.deliveryStatus = deliveryStatus;
		this.notes = notes;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getOrderReceiver() {
		return orderReceiver;
	}

	public void setOrderReceiver(String orderReceiver) {
		this.orderReceiver = orderReceiver;
	}

	public Date getDeliveryDueDate() {
		return deliveryDueDate;
	}

	public void setDeliveryDueDate(Date deliveryDueDate) {
		this.deliveryDueDate = deliveryDueDate;
	}

	public Boolean getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
