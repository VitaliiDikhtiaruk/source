package lesson9;


@SuppressWarnings("rawtypes")
public class Demo extends DefaultMyList implements MyList {
	public static void main(String[] args) {
		DefaultMyList<Object> newArr = new DefaultMyList<>();
		int i = 1;
		Integer a = 23;
		newArr.add(a);
//		newArr.clear();
		newArr.add(a);
//		newArr.remove(a);
		newArr.add(a);
		newArr.add(new Object());
		newArr.add(i);
		newArr.add(new String());
		newArr.add("sd");
		newArr.add("sa");
		System.out.println(newArr.toString());
		System.out.println(newArr.contains("sddd"));
		System.out.println(newArr.contains("sd"));
	}
}
