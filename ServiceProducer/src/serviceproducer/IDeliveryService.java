package serviceproducer;

public interface IDeliveryService {
void updateDeliveryStatus(String orderId, String status, String item, int quantity, String paymentMethod);


}
