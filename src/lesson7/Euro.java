package lesson7;

import java.util.ArrayList;
import java.util.List;

public class Euro {

	public static void main(String[] args) {
	Euro euro = new Euro();
	System.out.println(euro);
	}
	
	List<Territories> euro = new ArrayList<Territories>(){
		{
			add(new Territories("Country1", "ter1", "ter2", 1845));
			add(new Territories("Country2", "ter3", "ter2", 1731));
			add(new Territories("Country3", "ter2", "ter3", 1124));
			add(new Territories("Country4", "ter3", "ter4", 1602));
			add(new Territories("Country5", "ter1", "ter6", 1432));
		}
	};
	static class Territories{
	private String countryName;
	private String madeFrom1;
	private String madeFrom2;
	private int yearUnited;
	
		Territories(String countryName, String madeFrom1, String madeFrom2, int yearUnited){
			this.countryName = countryName;
			this.madeFrom1 = madeFrom1;
			this.madeFrom2 = madeFrom2;
			this.yearUnited = yearUnited;
		}
		
	}
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Territories t : euro) {
		s.append("Country " + t.countryName + " found in " + t.yearUnited + " by " + t.madeFrom1 
				+ " and " + t.madeFrom2 + "\n");
		}
		return s.toString();
	}
	
}
