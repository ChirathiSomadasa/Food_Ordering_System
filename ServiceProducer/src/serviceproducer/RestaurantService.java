package serviceproducer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RestaurantService implements IFoodMenu {
	
	private Map<String, Double> menu = new LinkedHashMap<>();

	
	public RestaurantService() {
		menu.put("Cheese Burger", 250.00);
        menu.put("Chicken Burger", 300.00);
        menu.put("Veggie Burger", 220.00);
        menu.put("Margherita Pizza", 450.00);
        menu.put("Pepperoni Pizza", 500.00);
        menu.put("BBQ Chicken Pizza", 550.00);
        menu.put("Greek Salad", 280.00);
        menu.put("Caesar Salad", 300.00);
        menu.put("Garden Salad", 250.00);
        menu.put("Spaghetti Carbonara", 350.00);
        menu.put("Penne Arrabbiata", 320.00);
        menu.put("Lasagna", 400.00);
	}

	@Override
	public void displayMenu() {
		
		System.out.println("===================================");
        System.out.println("            FOOD MENU              ");
        System.out.println("===================================");
        System.out.printf("%-25s %s\n", "Item", "Price(RS)");
        System.out.println("-----------------------------------");
        
		for( Map.Entry<String, Double> entry : menu.entrySet()) {
 
			System.out.printf("%-25s %.2f\n", entry.getKey(), entry.getValue());
		}
		
        System.out.println("===================================\n");
 	}

	@Override
	public Double getPrice(String item) {
		return  menu.getOrDefault(item, 0.0);
	}

	@Override
	public void processOrder(String item, int qty) {
		
 
		System.out.println("\n============ORDER DETAILS============");
		System.out.println("Food Item    : " + item + " => RS " + getPrice(item));
		System.out.println("Quantity     : " + qty);

		System.out.println("=====================================\n");
 	}

}