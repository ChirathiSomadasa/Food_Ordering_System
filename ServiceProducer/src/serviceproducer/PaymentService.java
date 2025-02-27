package serviceproducer;

public class PaymentService implements IPaymentService{
	
	@Override
	
	public boolean verifyPayment(String paymentMethod,double amount) {
		System.out.println("Verifying payment of $" + amount + "via" + paymentMethod);
		return true;//Simulate payment verification
	}

}
