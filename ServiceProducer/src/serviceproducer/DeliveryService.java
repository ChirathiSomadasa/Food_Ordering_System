package serviceproducer;

public class DeliveryService implements IDeliveryService {

	private ICustomerService customerService;
	
	public DeliveryService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Override
	public void updateDeliveryStatus(String orderId, String status, String item, int quantity, String paymentMethod ) {
		System.out.println();
		System.out.println("===============DELIVERY STATUS================\n");
		System.out.println("Order Id:  " + orderId);
		System.out.println("Order Status: " + status);
		System.out.println("Items: " + item);
		System.out.println("Quantity: " + quantity);
		System.out.println("Payment Mode: " + paymentMethod);
		
		
		
		
		
		if("Delivered".equalsIgnoreCase(status)) {
			customerService.notifyCustomer("Your order " + orderId + " has been delivered successfully.\nThankyou for ordering from us!!");
			System.out.println("===========================================\n");
		}
	}
}
