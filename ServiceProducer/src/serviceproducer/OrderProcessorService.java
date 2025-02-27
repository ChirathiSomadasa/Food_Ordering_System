package serviceproducer;

public class OrderProcessorService implements IOrderProcessor {

	public OrderProcessorService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processOrder(String item, int qty) {
		// TODO Auto-generated method stub
		
		System.out.println("Processing order : " + item + "x" + qty );
		
	}

}
