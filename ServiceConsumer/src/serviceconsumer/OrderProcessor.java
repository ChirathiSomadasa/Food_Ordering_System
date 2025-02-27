package serviceconsumer;

import serviceproducer.IFoodMenu;

public class OrderProcessor {
	
	private IFoodMenu menuService;


	public OrderProcessor(IFoodMenu menuService) {
		this.menuService = menuService;

	}
	
	public void placeOrder(String item, int qty) {
		menuService.displayMenu();
		System.out.println("Order place : " + item + "x" + qty );
		

	}

}
