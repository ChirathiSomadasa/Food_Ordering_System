package serviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration foodMenuReServiceRegistration;
	private ServiceRegistration paymentServiceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Producer service started");
		
		RestaurantService restaurantService = new RestaurantService();
		foodMenuReServiceRegistration = context.registerService(
				IFoodMenu.class.getName(), restaurantService, null);
		
		PaymentService paymentService = new PaymentService();
		paymentServiceRegistration = context.registerService(
				IPaymentService.class.getName(), paymentService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Producer services stopped");
		
		foodMenuReServiceRegistration.unregister();
		paymentServiceRegistration.unregister();
	}

}
