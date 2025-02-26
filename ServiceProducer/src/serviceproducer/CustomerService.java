package serviceproducer;

/**
 * CustomerService class provides implementation for the ICustomerService
 * interface It is responsible for display customer details and sending
 * notifications
 */
public class CustomerService implements ICustomerService {
	@Override
	public void displayCustomerDetails(String name, String email, String address, String contact) {
		System.out.println("\n==========CUSTOMER DETAILS==========");
		System.out.println("Customer Name    :" + name);// Display customer name
		System.out.println("Customer Email   :" + email);// Display customer email
		System.out.println("Customer Address :" + address);// Display customer address
		System.out.println("Customer Contact :" + contact);// Display customer contact
		System.out.println("====================================\n");

	}

	/**
	 * Send a notifications to the customer with the given message
	 */
	@Override
	public void notifyCustomer(String message) {
		System.out.println("" + message);// Display given message
	}

}
