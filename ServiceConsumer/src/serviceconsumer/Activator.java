package serviceconsumer;

import serviceconsumer.CustomerSystem;
import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import serviceproducer.ICustomerService;
import serviceproducer.IFoodMenu;
import serviceproducer.IPaymentService;
import serviceproducer.ILoginService;
import serviceproducer.IDeliveryService;

public class Activator implements BundleActivator {
	
	private ServiceReference loginServiceReference;
	private ServiceReference foodMenuServiceReference;
	private ServiceReference customerServiceReference;
	private ServiceReference deliveryServiceReference;
	private ServiceReference paymentServiceReference;


	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println(".....Consumer services strated.....\n");
		
		//Get references to the producer services
		loginServiceReference = context.getServiceReference(ILoginService.class.getName());
		foodMenuServiceReference = context.getServiceReference(IFoodMenu.class.getName());
		customerServiceReference = context.getServiceReference(ICustomerService.class.getName());
		paymentServiceReference = context.getServiceReference(IPaymentService.class.getName());
		deliveryServiceReference = context.getServiceReference(IDeliveryService.class.getName());
		
		ILoginService loginService = (ILoginService) context.getService(loginServiceReference);
		IFoodMenu foodMenuService = (IFoodMenu) context.getService(foodMenuServiceReference);
		ICustomerService customerService = (ICustomerService) context.getService(customerServiceReference);
		IPaymentService paymentService = (IPaymentService) context.getService(paymentServiceReference);
		IDeliveryService deliveryService = (IDeliveryService) context.getService(deliveryServiceReference);
		
		// Initialize consumer services
		LoginSystem loginSystem = new LoginSystem(loginService);
		RestaurantSystem restaurantSystem = new RestaurantSystem(deliveryService);
		PaymentSystem paymentSystem = new PaymentSystem(paymentService,foodMenuService,customerService);
		OrderProcessor orderProcessor = new OrderProcessor(foodMenuService);
		CustomerSystem customerSystem = new CustomerSystem(customerService);// Create an object of CustomerSystem using the retrieved customerService
		

		if(loginSystem.login("Amali","Amali@1234")) {
			//If login is successful, proceed with the following operations:
			//sample data
			orderProcessor.placeOrder("Margherita Pizza", 2);
			orderProcessor.processOrder("Margherita Pizza", 2);
			customerSystem.inputCustomerDetails("Amali", "amali@gmail.com", "Kurunegala", "0110000000");
			paymentSystem.processPayment("Margherita Pizza", 2, "Credit Card", foodMenuService, "Credit Card","Amali",10.0,50.0);//Process payment for order using Credit Card, with payment details
			restaurantSystem.notifyCustomer("12345","delivered");
			customerSystem.notifyCustomer("Order is comfirmed");// Provide notification
		}else {
			//If login fails, print a message and prevent further operations
			System.out.println("Login failed.cannot proceed with operations.");
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		System.out.println(".....Consumer services stopped.....");
		
		context.ungetService(loginServiceReference);
		context.ungetService(foodMenuServiceReference);
		context.ungetService(customerServiceReference);
		context.ungetService(paymentServiceReference);
		context.ungetService(deliveryServiceReference);
		
	}

}
