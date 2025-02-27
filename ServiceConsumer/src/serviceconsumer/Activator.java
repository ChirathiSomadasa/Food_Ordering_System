package serviceconsumer;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import serviceproducer.IFoodMenu;
import serviceproducer.IPaymentService;
import serviceproducer.IDeliveryService;

public class Activator implements BundleActivator {
	

	private ServiceReference deliveryServiceReference;

	private ServiceReference foodMenuServiceReference;

	private ServiceReference paymentServiceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Consumer services strated....");
		
		//Get references to the producer services
		
		deliveryServiceReference = context.getServiceReference(IDeliveryService.class.getName());
		paymentServiceReference = context.getServiceReference(IPaymentService.class.getName());
		
		
		IDeliveryService deliveryService = (IDeliveryService) context.getService(deliveryServiceReference);

		foodMenuServiceReference = context.getServiceReference(IFoodMenu.class.getName());
		paymentServiceReference = context.getServiceReference(IPaymentService.class.getName());
		
		IFoodMenu foodMenuService = (IFoodMenu) context.getService(foodMenuServiceReference);
		IPaymentService paymentService = (IPaymentService) context.getService(paymentServiceReference);
	
		//Initialize consumer services
		

		RestaurantSystem restaurantSystem = new RestaurantSystem(deliveryService);
		//PaymentSystem paymentSystem = new PaymentSystem(paymentService,foodMenuService);
		
		//Sample data
		restaurantSystem.notifyCustomer("12345","delivered");
		//paymentSystem.processPayment("Pizza", 2, "Credit Card", foodMenuService, "Credit Card");

		PaymentSystem paymentSystem = new PaymentSystem(paymentService,foodMenuService);
		
		//Sample data
		paymentSystem.processPayment("Pizza", 2, "Credit Card", foodMenuService, "Credit Card");
	
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Consumer services stopped");

		context.ungetService(deliveryServiceReference);

		
		context.ungetService(foodMenuServiceReference);

		context.ungetService(paymentServiceReference);
		
	}

}
