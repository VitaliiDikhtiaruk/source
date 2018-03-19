package lesson6;

import java.io.IOException;

public class Program {
	public static void main(String[] args) throws IOException {

		Sweets[] arr = new Sweets[10];
		arr[0] = new Sweets("конфета", "марцепан", 1, 10);
		arr[1] = new Sweets("конфета", "красный мак", 1, 10);
		arr[2] = new Sweets("конфета", "коровка", 5, 15);
		arr[3] = new Sweets("конфета", "козинак", 0, 12);
		arr[4] = new Sweets("конфета", "ириска", 21, 16);
		arr[5] = new Sweets("конфета", "карамелька", 12, 18);
		arr[6] = new Sweets("конфета", "капри", 8, 19);
		arr[7] = new Sweets("конфета", "шипучка", 0, 11);
		arr[8] = new Sweets("конфета", "зефир", 2, 14);
		arr[9] = new Sweets("конфета", "грельяж", 5, 1);

		GiftMaker giftMaker = new GiftMaker();

		for (Sweets sweets : arr) {
			giftMaker.addSweet(sweets);
		}

		try {
			giftMaker.getCandies(); // выводим список сладостей для выбора
			giftMaker.newYearPack(); // добавляем сладости в подарок
			System.out.println("----------------------");
			giftMaker.getSums(); // выводим характеристики подарка
			System.out.println("----------------------");
			giftMaker.someSort(); // сортировка по кол. сахара
		} catch (NullPointerException e) {

			System.out.println("одна из сладостей введена неверно, список не полный");
		}

	}
}