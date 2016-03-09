package gui;

import java.util.ArrayList;

import classes.GetLine;
import classes.GetOrders;
import classes.GetProduct;
import managers.Order;

public class driver {
	
	public static void main(String[] args){
		GetOrders od = new GetOrders();
		GetProduct pd = new GetProduct();
		GetLine ld = new GetLine();
		
		ArrayList<Order> o = od.getOrder();
		//ArrayList<Product> p = pd.getProduct();
		//ArrayList<LineData> l = ld.getLineDelivery();
		//System.out.println(o.get(0).g);
		for(int i = 0; i < o.size(); i++){
			//System.out.println(o.get(i).getClientName() + o.get(i).getPrice() + o.get(i).getOrderReceiver() + o.get(i).getDeliveryDueDate() );
			//System.out.println(l.get(i).getProductName());
			System.out.println(o.get(i).getClientName());
		}
		
		viewOrder v = new viewOrder();
		
		v.createContents();
	}
}
