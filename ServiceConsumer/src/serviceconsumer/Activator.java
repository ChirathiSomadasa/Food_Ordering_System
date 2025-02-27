package serviceconsumer;

import serviceconsumer.CustomerSystem;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import serviceproducer.ICustomerService;
import serviceproducer.IFoodMenu;
import serviceproducer.IPaymentService;


public class Activator implements BundleActivator {
	
	private ServiceReference foodMenuReServiceReference;
	private ServiceReference paymentServiceReference;

	// Reference to the customer service
	private ServiceReference customerServiceReference;

	@Override
	public void start(BundleContext context) throws Exception {

		// Get the service reference for ICustomerService
		customerServiceReference = context.getServiceReference(ICustomerService.class.getName());
		// Obtain the actual service object
		ICustomerService customerService = (ICustomerService) context.getService(customerServiceReference);

		// Create an object of CustomerSystem using the retrieved customerService
		CustomerSystem customerSystem = new CustomerSystem(customerService);

		// Provide sample customer details
		customerSystem.inputCustomerDetails("Amali", "amali@gmail.com", "Kurunegala", "0110000000");
		// Provide notification

		customerSystem.notifyCustomer("Order is comfirmed");
 
		System.out.println("Consumer services strated....");
		
		//Get references to the producer services
		foodMenuReServiceReference = context.getServiceReference(IFoodMenu.class.getName());
		paymentServiceReference = context.getServiceReference(IPaymentService.class.getName());
		
		IFoodMenu foodMenuService = (IFoodMenu) context.getService(foodMenuReServiceReference);
		IPaymentService paymentService = (IPaymentService) context.getService(paymentServiceReference);
	
		//Initialize consumer services
		
		PaymentSystem paymentSystem = new PaymentSystem(paymentService,foodMenuService);
		
		//Sample data
		paymentSystem.processPayment("Pizza", 2, "Credit Card", foodMenuService, "Credit Card");
	
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		System.out.println(".....Consumer service stopped.....");
		context.ungetService(customerServiceReference);		
		context.ungetService(foodMenuReServiceReference);
		context.ungetService(paymentServiceReference);
		
	}

}
