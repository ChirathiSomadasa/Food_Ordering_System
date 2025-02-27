package serviceproducer;

public class DeliveryService implements IDeliveryService {

	private ICustomerService customerService;
	public DeliveryService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Override
	public void updateDeliveryStatus(String orderId, String status) {
		System.out.println("Order Id: " + orderId + " |Delivery Status: " + status);
		if("Delivered".equalsIgnoreCase(status)) {
			customerService.notifyCustomer("Your order" + orderId + "has been delivered successfully");
		}
	}
}
