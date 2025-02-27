package serviceproducer;

public class PaymentService implements IPaymentService{
	
	@Override
	
	public boolean verifyPayment(String paymentMethod,double amount) {
		return true;//Simulate payment verification
	}

}
