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
	private ServiceReference customerServiceReference;

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println(".....Consumer services strated.....");

		// Get references to the producer services
		foodMenuReServiceReference = context.getServiceReference(IFoodMenu.class.getName());
		paymentServiceReference = context.getServiceReference(IPaymentService.class.getName());
		customerServiceReference = context.getServiceReference(ICustomerService.class.getName());

		
		// Obtain the actual service object
		IFoodMenu foodMenuService = (IFoodMenu) context.getService(foodMenuReServiceReference);
		IPaymentService paymentService = (IPaymentService) context.getService(paymentServiceReference);
		ICustomerService customerService = (ICustomerService) context.getService(customerServiceReference);

		
		// Initialize consumer services
		OrderProcessor orderProcessor = new OrderProcessor(foodMenuService);
		PaymentSystem paymentSystem = new PaymentSystem(paymentService, foodMenuService);
		CustomerSystem customerSystem = new CustomerSystem(customerService);
		// Create an object of CustomerSystem using the retrieved customerService
		

		

		// Sample data
		orderProcessor.placeOrder("Pizza", 2);
		orderProcessor.processOrder("Pizza", 2);
		paymentSystem.processPayment("Pizza", 2, "Credit Card", foodMenuService, "Credit Card");
		customerSystem.inputCustomerDetails("Amali", "amali@gmail.com", "Kurunegala", "0110000000");
		// Provide notification

		customerSystem.notifyCustomer("Order is comfirmed");

	}

	@Override
	public void stop(BundleContext context) throws Exception {

		System.out.println(".....Consumer services stopped.....");
		context.ungetService(customerServiceReference);
		context.ungetService(foodMenuReServiceReference);
		context.ungetService(paymentServiceReference);

	}

}
