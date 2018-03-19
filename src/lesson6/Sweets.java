package lesson6;

public class Sweets {

	private String sweetType;
	private String name;
	private int sugar;
	private int weight;

	Sweets(String sweetType, String name, int sugar, int weight) {
		this.sweetType = sweetType;
		this.name = name;
		this.sugar = sugar;
		this.weight = weight;
	}

	public String getSweetType() {
		return sweetType;
	}

	public String getName() {
		return name;
	}

	public int getSugar() {
		return sugar;
	}

	public int getWeight() {
		return weight;
	}

}
