package serviceconsumer;

import serviceproducer.IFoodMenu;
import serviceproducer.IPaymentService;

public class PaymentSystem {

private IPaymentService paymentService;
	
	public PaymentSystem(IPaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processPayment (String item,int quantity,String method,IFoodMenu menuService) {
		double itemPrice = menuService.getPrice(item);
		double totalAmount = itemPrice * quantity;
		System.out.println("Calculating total: "+ quantity+ " x $" + itemPrice + " = $" + totalAmount);
		
		boolean verified = paymentService.verifyPayment(method, totalAmount);
		
		if(verified) {
			System.out.println("Payment successful! Order confirmed.");
		}else {
			System.out.println("Payment failed");
		}
	}
}
