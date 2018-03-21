package lesson7;

import java.util.ArrayList;
import java.util.List;

/*
 * 10. Создать класс Mobile с внутренним классом, с помощью объектов которого
 *	можно хранить информацию о моделях телефонов и их свойствах.
 */

public class Mobile {
	public static void main(String[] args) {
		Mobile mobile = new Mobile();
		System.out.println(mobile);
	}

	List<Phone> mobile = new ArrayList<Phone>() {
		{
			add(new Phone("a1", 2012, false));
			add(new Phone("a10", 2016, true));
			add(new Phone("a2", 2012, true));
		}

	};

	public class Phone {
		private String model;
		private int year;
		private boolean web;
		private boolean mms;

		Phone(String model, int year, boolean web) {
			this.model = model;
			this.year = year;
			this.web = web;
			if (web == false) {
				mms = false;
			} else
				mms = true;

		}
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		for (Phone mob : mobile) {
			System.out.println("Модель телефона " + mob.model + " год выпуска " + mob.year + " наличие Интернета "
					+ (mob.web ? "есть " : "нет ") + " наличие MMS " + (mob.mms ? "есть" : "нет"));
		}
		return str.toString();
	}

}
