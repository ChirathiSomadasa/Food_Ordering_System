package serviceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import serviceproducer.IFoodMenu;
import serviceproducer.IPaymentService;

public class Activator implements BundleActivator {
	
	private ServiceReference foodMenuReServiceReference;
	private ServiceReference paymentServiceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Consumer services strated....");
		
		//Get references to the producer services
		foodMenuReServiceReference = context.getServiceReference(IFoodMenu.class.getName());
		paymentServiceReference = context.getServiceReference(IPaymentService.class.getName());
		
		IFoodMenu foodMenuService = (IFoodMenu) context.getService(foodMenuReServiceReference);
		IPaymentService paymentService = (IPaymentService) context.getService(paymentServiceReference);
	
		//Initialize consumer services
		
		//PaymentSystem paymentSystem = new PaymentSystem(paymentService,foodMenuService);
		
		//Sample data
		//paymentSystem.processPayment("Pizza", 2, "Credit Card", foodMenuService, "Credit Card");
	
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Consumer services stopped");
		
		context.ungetService(foodMenuReServiceReference);
		context.ungetService(paymentServiceReference);
		
	}

}
