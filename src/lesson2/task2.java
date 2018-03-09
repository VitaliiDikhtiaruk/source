package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task2 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("введите размеры треугольника:");
		double a = Double.parseDouble(reader.readLine());
		double b = Double.parseDouble(reader.readLine());
		double c = Double.parseDouble(reader.readLine());
		double p = (a + b + c) / 2;
		if ((p - a <= 0) || ((p - b <= 0) || (p - c <= 0))) {
			System.out.println("такого треугольника нет");
		} else {
			double s = Math.sqrt(p * ((p - a) * (p - b) * (p - c)));
			System.out.println("площадь треугольника: " + s);
		}

	}

}
