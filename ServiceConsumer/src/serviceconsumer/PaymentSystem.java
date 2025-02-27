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
		
		//Calculate the total amount
		double itemPrice = menuService.getPrice(item);
		double totalAmount = itemPrice * quantity;
		String formattedItemPrice = String.format("%.2f", itemPrice);
		String formattedTotalAmount = String.format("%.2f", totalAmount);
		
		//Display the calculation of the total amount
		System.out.println("\n==============PAYMENT DETAILS==============");
		System.out.println("Calculating total  : "+ quantity + " x LKR " + formattedItemPrice + " = LKR " + formattedTotalAmount);
		
		//Verify the payment
		boolean verified = paymentService.verifyPayment(paymentMethod, totalAmount);
		
		//Display the result of the payment verification
		if(verified) {
			System.out.println("\n==============PAYMENT STATUS==============");
			System.out.println("Payment successful!");
			System.out.println("Order confirmed. Enjoy your meal!");
			System.out.println("==========================================\n");
		}else {
			System.out.println("\n==============PAYMENT STATUS==============");
			System.out.println("Payment failed. Please try again");
			System.out.println("==========================================\n");
		}
	}
}
