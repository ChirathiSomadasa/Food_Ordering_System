package serviceconsumer;

import serviceproducer.ICustomerService;
import serviceproducer.IFoodMenu;
import serviceproducer.IPaymentService;

public class OrderProcessor {
	
	private IFoodMenu menuService;
	private ICustomerService customerService;
	private IPaymentService paymentService;


	public OrderProcessor(IFoodMenu menuService) {
		this.menuService = menuService;
//		this.paymentService = paymentService;
//		this.customerService = customerService;
	}
	
	public void placeOrder(String item, int qty) {
		menuService.displayMenu();
		System.out.println("\nPlace order : " + item + " x " + qty );
		

	}
	public void processOrder(String item, int qty) {
		
		double itemPrice = menuService.getPrice(item);
		double totalAmount = itemPrice * qty;
		
		menuService.processOrder(item, qty, totalAmount);
	}
	
//	public void inputCustomerDetails(String name, String email, String address, String contact) {
//		customerService.displayCustomerDetails(name, email, address, contact);
//	}

}
