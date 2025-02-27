package serviceconsumer;

import serviceproducer.IFoodMenu;

public class OrderProcessorImpl {
	
	private IFoodMenu menuService;


	public OrderProcessorImpl(IFoodMenu menuService) {
		// TODO Auto-generated constructor stub
		this.menuService = menuService;

	}
	
	public void placeOrder(String item, int qty) {
		menuService.displayMenu();
		System.out.println("Order place : " + item + "x" + qty );
		

	}

}
