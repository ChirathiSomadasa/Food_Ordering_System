package serviceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import serviceproducer.IPaymentService;

public class Activator implements BundleActivator {
	
	private ServiceReference paymentServiceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Consumer services strated....");
		
		//Get references to the producer services
		paymentServiceReference = context.getServiceReference(IPaymentService.class.getName());
		
		
		IPaymentService paymentService = (IPaymentService) context.getService(paymentServiceReference);
	
		//Initialize consumer services
		
		//PaymentSystem paymentSystem = new PaymentSystem(paymentService,foodMenuService);
		
		//Sample data
		//paymentSystem.processPayment("Pizza", 2, "Credit Card", foodMenuService, "Credit Card");
	
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Consumer services stopped");
		context.ungetService(paymentServiceReference);
		
	}

}
