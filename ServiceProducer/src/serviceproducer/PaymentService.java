package serviceproducer;

public class PaymentService implements IPaymentService{
	
	@Override
	
	public boolean verifyPayment(String paymentMethod,double amount) {
		
		//Format the amount to 2 decimal points
		String formattedAmount = String.format("%.2f", amount);
		
		//Display the total payment amount
		System.out.println("Total Amount Payable        : Rs " + formattedAmount);

		//Display the payment method
		System.out.println("Payment Method              : " + paymentMethod);
		
		System.out.println("===========================================================\n");
		
		return true;//Simulate payment verification
	}

}
