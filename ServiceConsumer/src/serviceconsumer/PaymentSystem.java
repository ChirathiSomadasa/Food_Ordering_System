package serviceconsumer;

import serviceproducer.IPaymentService;
import serviceproducer.IFoodMenu;
import serviceproducer.ICustomerService;

public class PaymentSystem {

private IPaymentService paymentService;
private IFoodMenu menuService;
private  ICustomerService customerService;
	
	public PaymentSystem(IPaymentService paymentService,IFoodMenu menuService,ICustomerService customerService) {
		
		this.paymentService = paymentService;
		this.menuService = menuService;
		this.customerService = customerService;
	}

	public void processPayment (String item,int quantity,String method,IFoodMenu menuService,String paymentMethod,String customerName,double discountPercentage,double deliveryCost) {
		
		//Calculate the final amount
		double itemPrice = menuService.getPrice(item);
		double totalAmount = itemPrice * quantity;
		double discountAmount = totalAmount * (discountPercentage/100);
		double amountAfterDiscount = totalAmount - discountAmount;
		double finalAmount = amountAfterDiscount - deliveryCost;
		
		//Format the calculated amounts to 2 decimal places for consistent and clear display
		String formattedItemPrice = String.format("%.2f", itemPrice);
		String formattedTotalAmount = String.format("%.2f", totalAmount);
		String formattedDiscountAmount = String.format("%.2f", discountAmount);
		String formattedAmountAfterDiscount = String.format("%.2f", amountAfterDiscount);
		String formattedDeliveryCost = String.format("%.2f", deliveryCost);
		String formattedFinalAmount = String.format("%.2f", finalAmount);
		
		//Display the calculation of the total amount
		System.out.println("\n======================PAYMENT DETAILS======================");
		System.out.println("Calculating Item Price      : "+ quantity + " x Rs " + formattedItemPrice + "     = Rs " + formattedTotalAmount);
		System.out.println("Discount Applied            : Rs "+ formattedTotalAmount + " x " + discountPercentage + "% = Rs " + formattedDiscountAmount);
		System.out.println("Amount After Discount       : Rs "+ formattedAmountAfterDiscount);
		System.out.println("Delivery Cost               : Rs "+ formattedDeliveryCost);
		//Verify the payment
		boolean verified = paymentService.verifyPayment(paymentMethod, finalAmount);
		
		//Display the result of the payment verification
		if(verified) {
			System.out.println("\n===================PAYMENT STATUS===================");
			//Notify customer about the successful payment
			customerService.notifyCustomer("Dear " + customerName + ", your payment of Rs " + formattedFinalAmount + " was sucessful.");
			System.out.println("Payment successful!");
			System.out.println("Order confirmed. Enjoy your meal!");
			System.out.println("====================================================\n");
		}else {
			System.out.println("\n===================PAYMENT STATUS===================");
			System.out.println("Payment failed. Please try again");
			System.out.println("====================================================\n");
		}
	}
}
