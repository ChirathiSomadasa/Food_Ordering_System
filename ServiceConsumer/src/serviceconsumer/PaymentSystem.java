package serviceconsumer;

import serviceproducer.IPaymentService;
import serviceproducer.IFoodMenu;

public class PaymentSystem {

private IPaymentService paymentService;
private IFoodMenu menuService;
	
	public PaymentSystem(IPaymentService paymentService,IFoodMenu menuService) {
		this.paymentService = paymentService;
		this.menuService = menuService;
	}

	public void processPayment (String item,int quantity,String method,IFoodMenu menuService,String paymentMethod) {
		double itemPrice = menuService.getPrice(item);
		double totalAmount = itemPrice * quantity;
		System.out.println("\n==============PAYMENT DETAILS==============");
		System.out.println("Calculating total : "+ quantity+ " x LKR" + itemPrice + " = LKR" + totalAmount);
		 
		boolean verified = paymentService.verifyPayment(paymentMethod, totalAmount);
		
		System.out.println("\n==============PAYMENT STATUS==============");

		if(verified) {
			System.out.println("Payment successful!");
			System.out.println("Order confirmed.Enjoy your meal!");

		}else {
			System.out.println("Payment failed");
		}
		System.out.println("===========================================\n");

	}
}
