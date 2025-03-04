package serviceproducer;

public interface IFoodMenu {

	public void displayMenu();
	public Double getPrice(String item);
	
	public void processOrder(String item, int qty);

}
