package serviceconsumer;
import serviceproducer.IDeliveryService;
public class RestaurantSystem {
private IDeliveryService deliveryService;

public RestaurantSystem(IDeliveryService deliveryService) {
	this.deliveryService = deliveryService;
}

public void notifyCustomerr(String orderId, String status) {
	deliveryService.updateDeliveryStatus(orderId,  status);
}
}
