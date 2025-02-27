package serviceconsumer;

import serviceconsumer.CustomerSystem;
import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import serviceproducer.ICustomerService;
import serviceproducer.IFoodMenu;
import serviceproducer.IPaymentService;
import serviceproducer.IDeliveryService;

public class Activator implements BundleActivator {
	

	private ServiceReference deliveryServiceReference;

	private ServiceReference foodMenuServiceReference;

	private ServiceReference paymentServiceReference;
	private ServiceReference customerServiceReference;

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println("Consumer services strated....");
		
		//Get references to the producer services
		
		deliveryServiceReference = context.getServiceReference(IDeliveryService.class.getName());
		paymentServiceReference = context.getServiceReference(IPaymentService.class.getName());
		foodMenuServiceReference = context.getServiceReference(IFoodMenu.class.getName());
		paymentServiceReference = context.getServiceReference(IPaymentService.class.getName());
		
		IFoodMenu foodMenuService = (IFoodMenu) context.getService(foodMenuServiceReference);
		IPaymentService paymentService = (IPaymentService) context.getService(paymentServiceReference);
		IDeliveryService deliveryService = (IDeliveryService) context.getService(deliveryServiceReference);
		RestaurantSystem restaurantSystem = new RestaurantSystem(deliveryService);
		//PaymentSystem paymentSystem = new PaymentSystem(paymentService,foodMenuService);
		//paymentSystem.processPayment("Pizza", 2, "Credit Card", foodMenuService, "Credit Card");
		ICustomerService customerService = (ICustomerService) context.getService(customerServiceReference);

		
		// Initialize consumer services


		

		// Create an object of CustomerSystem using the retrieved customerService

		OrderProcessor orderProcessor = new OrderProcessor(foodMenuService);
		CustomerSystem customerSystem = new CustomerSystem(customerService);
		// Create an object of CustomerSystem using the retrieved customerService

		orderProcessor.placeOrder("Pizza", 2);
		orderProcessor.processOrder("Pizza", 2);
		paymentSystem.processPayment("Pizza", 2, "Credit Card", foodMenuService, "Credit Card");
		customerSystem.inputCustomerDetails("Amali", "amali@gmail.com", "Kurunegala", "0110000000");
		restaurantSystem.notifyCustomer("12345","delivered");
		// Provide notification

		customerSystem.notifyCustomer("Order is comfirmed");

	}

	@Override
	public void stop(BundleContext context) throws Exception {

		System.out.println("Consumer services stopped");

		context.ungetService(deliveryServiceReference);
		context.ungetService(foodMenuServiceReference);
		context.ungetService(customerServiceReference);
		context.ungetService(paymentServiceReference);

	}

}
