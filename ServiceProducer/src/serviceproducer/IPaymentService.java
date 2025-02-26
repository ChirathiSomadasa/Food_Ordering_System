package serviceproducer;

public interface IPaymentService {

	boolean verifyPayment(String paymentMethod,double amount);
}
