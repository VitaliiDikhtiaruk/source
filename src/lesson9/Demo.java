package lesson9;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class Demo extends DefaultMyList implements MyList {
	public static void main(String[] args) {
		DefaultMyList<Object> newArr = new DefaultMyList<>();
		int i = 1;
		Integer a = 23;
		newArr.add(a);
		newArr.add(new Object());
		newArr.add(i);
		newArr.add(new String());
		newArr.add("sd");
		newArr.add("sa");
		Iterator<Object> it = newArr.iterator();
		while (it.hasNext())
		System.out.println(it.next());
		System.out.println(newArr);

	}
}
