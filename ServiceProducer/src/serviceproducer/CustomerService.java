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
	public void displayProcessStatus(String name) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" HH:mm a");

		System.out.println("\n==========PROCESS STATUS===================");

		int hour = creationTime.getHour();

		if (hour >= 1 && hour < 12) {
			System.out.println("Good Morning, " + name + "!");
			System.out.println("Your order is being prepared with love and care !!");
		} else if (hour >= 12 && hour < 17) {
			System.out.println("Good Afternoon, " + name + "!");
			System.out.println("We are making sure your order reaches you fresh and delicious!!");

		} else {
			System.out.println("Good Evening, " + name + "!");
			System.out.println("A warm and tasty meal is coming your way!!");

		}

		System.out.println("-------------------------------------------");
		System.out.println("Order Creation Time   : " + creationTime.format(formatter));// display order creation time
		System.out.println("Food Preparation Time : " + preparationTime.format(formatter));// display food preparation
																							// time
		System.out.println("Dispatch Time         : " + dispatchTime.format(formatter));// display order dispatch time
		System.out.println("Arrival Time          : " + arrivalTime.format(formatter));// display order arrival time
		System.out.println("===========================================");

	}

}
