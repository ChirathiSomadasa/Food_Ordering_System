package serviceproducer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * CustomerService class provides implementation for the ICustomerService
 * interface It is responsible for display customer details , display process
 * time and sending notifications
 */
public class CustomerService implements ICustomerService {

	private IPaymentService paymentService;
	private LocalDateTime creationTime;
	private LocalDateTime preparationTime;
	private LocalDateTime dispatchTime;
	private LocalDateTime arrivalTime;
	

	public CustomerService(IPaymentService paymentService) {
		this.paymentService = paymentService;
		this.creationTime = LocalDateTime.now();
		this.preparationTime = creationTime.plusMinutes(30);
		this.dispatchTime = preparationTime.plusMinutes(5);
		this.arrivalTime = dispatchTime.plusMinutes(35);
	}

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

	/**
	 * display order process status to the customer with the given time
	 */
	@Override
	public void displayProcessStatus() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		System.out.println("\n==========PROCESS STATUS============");
		System.out.println("Order Creation Time   : " + creationTime.format(formatter));// display given process time
		System.out.println("Food Preparation Time : " + preparationTime.format(formatter));
		System.out.println("Dispatch Time         : " + dispatchTime.format(formatter));
		System.out.println("Arrival Time          : " + arrivalTime.format(formatter));
 		System.out.println("====================================");

	}

}
