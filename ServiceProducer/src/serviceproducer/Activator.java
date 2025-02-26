package serviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration customerServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println(".....Producer Services started......");

		// create an object of customer service
		ICustomerService customerService = new CustomerService();

		// register the service with the OSGI framework
		customerServiceRegistration = context.registerService(ICustomerService.class.getName(), customerService, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println(".....Producer Services stopped......");

		// unregister the customer service before the stopping the bundle
		customerServiceRegistration.unregister();
	}

}
