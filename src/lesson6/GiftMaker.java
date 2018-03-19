package lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GiftMaker extends Program {
	private Sweets[] arr = new Sweets[10];
	protected Sweets[] pack = new Sweets[5];
	protected Sweets[] pack2 = new Sweets[5];
	int someSugVal = 20;
	int a = 0;
	private int sumSugar = 0;
	private int sumWeight = 0;
	private String str;

	void addSweet(Sweets sweets) {
		this.arr[a++] = sweets;
	}

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	// выводим список сладостей для выбора

	public void getCandies() {
		System.out.println("Cписок доступных сладостей для подарка:");
		for (Sweets s : arr) {
			if (s != null) {
				System.out.println(s.getSweetType() + " " + s.getName());
			}
		}
		System.out.println("подарок может содержать 5 сладостей, " + "введите название конфет через ENTER");
	}

	// добавляем сладости в подарок

	public void newYearPack() throws IOException {
		for (int i = 0; i < pack.length; i++) {
			str = reader.readLine();
			if (str != null) {
				for (Sweets s1 : arr) {

					if (str.equalsIgnoreCase(s1.getName())) {
						pack[i] = s1;
					}

				}
			}
		}

		System.out.println("подарок будет содержать следующие сладости:");

		for (Sweets s : pack) {
			if (s != null) {
				System.out.println(s.getSweetType() + " " + s.getName() + " содержание сахара " + s.getSugar()
						+ " вес конфеты " + s.getWeight());
			}
		}
	}

	// выводим характеристики подарка

	public void getSums() {
		for (Sweets s : pack) {
			sumSugar += s.getSugar();
			sumWeight += s.getWeight();
		}
		System.out.println("Общее содержание сахара " + sumSugar + "г. общий вес подарка " + sumWeight + "г.");
	}

	// сортировка по кол. сахара

	public void someSort() {
		System.out.println("Сладости с содержание сахара больше " + someSugVal);
		for (Sweets s : pack) {
			if ((s != null) && (s.getSugar() >= someSugVal)) {

				System.out.println(s.getName() + " кол сахара - " + s.getSugar());
			}
		}
	}
}