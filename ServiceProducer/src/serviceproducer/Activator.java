package serviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration paymentServiceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Producer service started");
		PaymentService paymentService = new PaymentService();
		paymentServiceRegistration = context.registerService(
				IPaymentService.class.getName(), paymentService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Producer services stopped");
		paymentServiceRegistration.unregister();
	}

}
