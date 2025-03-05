package serviceproducer;

public class DeliveryService implements IDeliveryService {

	private ICustomerService customerService;
	
	public DeliveryService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Override
	public void updateDeliveryDetails(String name, String address, String item, int quantity, String paymentStatus ) {
		System.out.println();
		System.out.println("=============DELIVERY DETAILS==============\n");
		System.out.println("Ordered By     : " + name);
		System.out.println("Ordered To     : " + address);
		System.out.println("Items          : " + item);
		System.out.println("Quantity       : " + quantity);
		System.out.println("Payment Status : " + paymentStatus);
		System.out.println("===========================================\n");
	}
	
	public void updateDeliveryStatus(String orderId, String status ) {
		
		
		System.out.println("=========DELIVERY STATUS===================\n");
		System.out.println("Order ID      : "+ orderId);
		System.out.println("Order Status  :" + status);
		
		
		
		if("Delivered".equalsIgnoreCase(status)) {
			customerService.notifyCustomer("Your order " + orderId + " has been delivered successfully.\nThankyou for ordering from us!!");
			System.out.println("=========================================\n");
		}
	}
}
