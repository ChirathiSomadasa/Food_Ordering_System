package serviceproducer;

public interface IDeliveryService {
void updateDeliveryDetails(String name,String address, String item, int quantity, String paymentStatus );
void updateDeliveryStatus(String orderId, String status);


}
