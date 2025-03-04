package serviceconsumer;

import serviceproducer.ICustomerService;//import ICustomerService interface from serviceproducer

/**
 * The CustomerSystem class acts as a consumer of the ICustomerService It is
 * responsible for handling customer related operations and forwarding them to
 * the provided service implementation
 */
public class CustomerSystem {
	private ICustomerService customerService;

	/**
	 * Constructor to initialize the CustomerSystem with a customer service
	 */
	public CustomerSystem(ICustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Accepts customer details and forwarding them to the customer service for
	 * processing
	 */

	public void inputCustomerDetails(String name, String email, String address, String contact) {
		customerService.displayCustomerDetails(name, email, address, contact);
	}

	/**
	 * Accepts message and forwarding them to the customer service
	 */
	public void notifyCustomer(String message) {
		customerService.notifyCustomer(message);
	}

	/**
	 * Accepts time and forwarding them to the customer service
	 */
	public void displayProcessStatus( ) {
		customerService.displayProcessStatus( );
	}

}
