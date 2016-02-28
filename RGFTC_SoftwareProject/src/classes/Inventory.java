package classes;

import java.util.Date;

public class Inventory {

	private int inventoryID;
	private String person;
	private String product;
	private int deposits;
	private int withdrawals;
	private Date date;
	
	public Inventory(){}
	
	public Inventory(String person, String product, int deposits, int withdrawals, Date date){
		this.person = person;
		this.product = product;
		this.deposits = deposits;
		this.withdrawals = withdrawals;
		this.date = date;
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

	public int getDeposits() {
		return deposits;
	}

	public void setDeposits(int deposits) {
		this.deposits = deposits;
	}

	public int getWithdrawals() {
		return withdrawals;
	}

	public void setWithdrawals(int withdrawals) {
		this.withdrawals = withdrawals;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
}
