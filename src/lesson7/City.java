package lesson7;

import java.util.List;
import java.util.ArrayList;
/*
 * 8. Создать класс City с внутренним классом, с помощью объектов которого
 *	можно хранить информацию о проспектах, улицах, площадях.
 */

public class City {
	public static void main(String[] args) {
		City city = new City();
		System.out.println(city);
	}

	// создали обьекты в которых будут хранится данные о улицах
	List<SightSee> sightSee = new ArrayList<SightSee>() {
		{
			for (int i = 0; i < 3; i++) {
				add(new SightSee("Prospect", "someProspect", 1915 + i));
			}
			for (int i = 3; i < 7; i++) {
				add(new SightSee("Street", "someStreet", 1915 + i));
			}
			for (int i = 7; i < 10; i++) {
				add(new SightSee("Squere", "someSquare", 1915 + i));
			}
		}
	};

	// параметризируем обьект SightSee
	public static class SightSee {
		private String type;
		private String name;
		private int year;

		public SightSee(String type, String name, int year) {
			this.type = type;
			this.name = name;
			this.year = year;
		}

	}

	// переопределил toString()
	@Override
	public String toString() {
		StringBuilder someString = new StringBuilder();
		for (SightSee sight : sightSee) {
			someString.append(sight.type + " " + sight.name + " " + " " + sight.year + "\n");
		}
		return someString.toString();

	}

}
