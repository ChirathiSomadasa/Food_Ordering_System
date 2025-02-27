package serviceconsumer;

import serviceproducer.IFoodMenu;

public class OrderProcessorImpl {
	
	private IFoodMenu menuService;
//	private PaymentSystem paymentSystem;

	public OrderProcessorImpl(IFoodMenu menuService) {
		// TODO Auto-generated constructor stub
		this.menuService = menuService;
//		this.paymentSystem = paymentSystem;
	}
	
	public void placeOrder(String item, int qty) {
		menuService.displayMenu();
		System.out.println("Order place : " + item + "x" + qty );
		
//		paymentSystem.processPayment(item, qty, paymentMethod, menuService);
	}

}
