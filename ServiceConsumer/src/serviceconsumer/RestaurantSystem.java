package serviceconsumer;

import serviceproducer.IDeliveryService;

public class RestaurantSystem {
	private IDeliveryService deliveryService;

	public RestaurantSystem(IDeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	public void notifyCustomer(String name, String address, String item, int quantity, String paymentStatus,
			String orderId, String status) {
		deliveryService.updateDeliveryDetails(name, address, item, quantity, paymentStatus);
		deliveryService.updateDeliveryStatus(orderId, status);
	}
}