package serviceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import serviceproducer.ICustomerService;

public class Activator implements BundleActivator {

	// Reference to the customer service
	private ServiceReference customerServiceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println(".....Consumer service started.....");

		// Get the service reference for ICustomerService
		customerServiceReference = context.getServiceReference(ICustomerService.class.getName());
		// Obtain the actual service object
		ICustomerService customerService = (ICustomerService) context.getService(customerServiceReference);

		// Create an object of CustomerSystem using the retrieved customerService
		CustomerSystem customerSystem = new CustomerSystem(customerService);

		// Provide sample customer details
		customerSystem.inputCustomerDetails("Amali", "amali@gmail.com", "Kurunegala", "0110000000");
		// Provide notification
		customerService.notifyCustomer("Your order has been delivered!");


	}

	@Override
	public void stop(BundleContext context) throws Exception {

		System.out.println(".....Consumer service stopped.....");
		context.ungetService(customerServiceReference);
	}

}
