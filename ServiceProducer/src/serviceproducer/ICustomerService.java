package serviceproducer;

/**
 * The ICustomerService interface defines the contact for customer related
 * service Implementing classes should provides methods to display the customer
 * details and send notifications
 */
public interface ICustomerService {

	// display customer details such as name,email,address,contact
	void displayCustomerDetails(String name, String email, String address, String contact);

	// Sends notification message to the customer
	void notifyCustomer(String message);

	// display order process status
	void displayProcessStatus();

}
