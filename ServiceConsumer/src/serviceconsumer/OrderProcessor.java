package serviceconsumer;

import serviceproducer.IFoodMenu;
import serviceproducer.IPaymentService;


public class OrderProcessor {
	
	private IFoodMenu menuService;
	private IPaymentService paymentSystem;

	public OrderProcessor(IFoodMenu menuService, IPaymentService paymentSystem) {
		// TODO Auto-generated constructor stub
		this.menuService = menuService;
		this.paymentSystem = paymentSystem;
	}
	
	public void placeOrder(String item, int qty) {
		menuService.displayMenu();
		System.out.println("Order place : " + item + "x" + qty );
		
//		paymentSystem.processPayment(item, qty, paymentMethod, menuService);
	}

}
