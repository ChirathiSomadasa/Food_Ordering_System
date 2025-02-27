package serviceconsumer;

import serviceproducer.IDeliveryService;

public class RestaurantSystem {
	private IDeliveryService deliveryService;

	public RestaurantSystem(IDeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	public void notifyCustomer(String orderId, String status) {
		deliveryService.updateDeliveryStatus(orderId, status);
	}
}