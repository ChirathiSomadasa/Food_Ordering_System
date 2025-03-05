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
	
	private ServiceReference foodMenuServiceReference;
	private ServiceReference customerServiceReference;
	private ServiceReference deliveryServiceReference;
	private ServiceReference paymentServiceReference;

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println(".....Consumer services strated.....\n");
		
		//Get references to the producer services
		
		foodMenuServiceReference = context.getServiceReference(IFoodMenu.class.getName());
		customerServiceReference = context.getServiceReference(ICustomerService.class.getName());
		paymentServiceReference = context.getServiceReference(IPaymentService.class.getName());
		deliveryServiceReference = context.getServiceReference(IDeliveryService.class.getName());
		
		IFoodMenu foodMenuService = (IFoodMenu) context.getService(foodMenuServiceReference);
		ICustomerService customerService = (ICustomerService) context.getService(customerServiceReference);
		IPaymentService paymentService = (IPaymentService) context.getService(paymentServiceReference);
		IDeliveryService deliveryService = (IDeliveryService) context.getService(deliveryServiceReference);

		// Initialize consumer services
		RestaurantSystem restaurantSystem = new RestaurantSystem(deliveryService);
		PaymentSystem paymentSystem = new PaymentSystem(paymentService,foodMenuService);
		OrderProcessor orderProcessor = new OrderProcessor(foodMenuService);
		CustomerSystem customerSystem = new CustomerSystem(customerService);// Create an object of CustomerSystem using the retrieved customerService

		//sample data
		orderProcessor.placeOrder("Pizza", 2);
		orderProcessor.processOrder("Pizza", 2);

		customerSystem.inputCustomerDetails("Amali", "amali@gmail.com", "Kurunegala", "0110000000");
		paymentSystem.processPayment("Pizza", 2, "Credit Card", foodMenuService, "Credit Card");
		
		customerSystem.notifyCustomer("Order is comfirmed");// Provide notification
		restaurantSystem.notifyCustomer("Amali","kurunegala", "Pizza", 2,"Paid" , "1234", "Delivered" );
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		System.out.println(".....Consumer services stopped.....");

		context.ungetService(foodMenuServiceReference);
		context.ungetService(customerServiceReference);
		context.ungetService(paymentServiceReference);
		context.ungetService(deliveryServiceReference);

	}

}
