package lesson9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 11. Написать метод, который принимает строку времени и который возвращает количество 
 * градусов между часовой и минутной стрелкой (в почасовом направлении)
 * Метод может принимать строки как в 24 так и в 12 часовом формате, разделенных двоеточием, пример строк:
 * 12:25, 20:12 и т.д.
 */

public class ClockHandsAngle {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Введите время в формате HH:MM чтобы получить угол между стрелками");
		String s;
		int h;
		int m;
		int hA;
		int mA;
		int angle;
		try {
			s = reader.readLine();
			h = Integer.parseInt(s.substring(0, 2)); 	//приводим строку к int и берем часы и минуты
			m = Integer.parseInt(s.substring(3, 5));
			if (m == 60)								//проверка параметров
				m = 0;
			if (h == 24 || h == 12)
				h = 0;
			if (h > 12)
				h -= 12;
			if ((h < 0) || (h > 24) || (m < 0) || (m > 60))
				System.out.println("wrong input");

			hA = (int) (0.5 * (h * 60 + m));			//считаем угол часов и минут, а далее берем их разницу
			mA = (int) (6 * m);
			angle = Math.abs(hA - mA);
			if (angle > 180)
				angle = 360 - angle;
			System.out.println("угол между минутной и часовой стрелкой часов при заданном времени составляет");

			System.out.println(angle + "\u00b0");
		} catch (Exception e) {
			System.out.println("wrong time input or smth else");
		}

	}
}
