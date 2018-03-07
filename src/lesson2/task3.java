package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Введите радиус:");
		double a = Double.parseDouble(reader.readLine());
		if(a <= 0) {
			System.out.println("Радиус введен неверно");
		} else {
			System.out.println("Длина окружности: " + (2*Math.PI*a));
		}
		
	}

}
