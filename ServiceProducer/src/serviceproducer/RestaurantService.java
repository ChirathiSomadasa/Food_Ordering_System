package serviceproducer;

import java.util.HashMap;
import java.util.Map;

public class RestaurantService implements IFoodMenu {
	
	private Map<String, Double> menu = new HashMap();

	
	public RestaurantService() {
		menu.put("Burger", 200.00);
		menu.put("Pizza", 400.00);
		menu.put("Salad", 200.00);
		menu.put("Pasta", 300.00);

	}

	@Override
	public void displayMenu() {
		System.out.println("=========Food Menu=========\n");
		
		for( Map.Entry<String, Double> entry : menu.entrySet()) {
			System.out.println(entry.getKey() + " : LKR " + entry.getValue());
		}
		
		System.out.println("===========================\n");

	}

	@Override
	public Double getPrice(String item) {
		return  menu.getOrDefault(item, 0.0);
	}

	@Override
	public void processOrder(String item, int qty) {
//		System.out.println("Processing order : " + item + " x " + qty );
		
		System.out.println("\n==========ORDER DETAILS==========");
		System.out.println("Food Item    :" + item);
		System.out.println("Quantity     :" + qty);
//		System.out.println("Total Amount :" + address);
//		System.out.println("Customer Contact :" + contact);
		System.out.println("=================================\n");
	}

}