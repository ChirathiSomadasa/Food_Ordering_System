package serviceproducer;

/**
 * Interface for payment service operations
 * This interface defines the method for verifying payments.
 */

public interface IPaymentService {

	boolean verifyPayment(String paymentMethod,double amount);
}
