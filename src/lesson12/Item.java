package lesson12;


public class Item {

	
	private String name;
	private int price;
	private String description;
	private int id;
	private int quantity;
	public Item(int id, String name, int price, String description, int quantity) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public String toString() {
		return "[ " + name + ", price - " + price + "$, item description -"
				+ description + "]";
	}
}
