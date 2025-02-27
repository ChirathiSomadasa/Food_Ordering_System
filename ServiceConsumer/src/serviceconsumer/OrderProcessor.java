package serviceconsumer;

import serviceproducer.ICustomerService;
import serviceproducer.IFoodMenu;

public class OrderProcessor {
	
	private IFoodMenu menuService;
	private ICustomerService customerService;


	public OrderProcessor(IFoodMenu menuService) {
		this.menuService = menuService;
//		this.customerService = customerService;
	}
	
	public void placeOrder(String item, int qty) {
		menuService.displayMenu();
		System.out.println("Order place : " + item + "x" + qty );
		

	}
	public void processOrder(String item, int qty) {
		menuService.processOrder(item, qty);
	}
	
//	public void inputCustomerDetails(String name, String email, String address, String contact) {
//		customerService.displayCustomerDetails(name, email, address, contact);
//	}

}
