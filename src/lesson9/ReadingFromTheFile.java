package lesson9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * 6. считать текст из файла. 
Вывести информацию в консоль по частоте использования букв в таком формате:
буква: количество раз в файле
При чем вверху должны выводиться буквы самые редкие, внизу самые частые

 */
public class ReadingFromTheFile {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// пользователь вводит путь к файлу который будет читать
		System.out.println("введите путь к файлу");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		mapMeth(reader.readLine());

	}

	// читаем файл, добавляем и считаем буквы
	private static void mapMeth(String s) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(s));
		String str;
		String str2;
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		while ((str = br.readLine()) != null) {

			str2 = str.replaceAll("[^a-zA-z]", ""); // земеняем все символы кроме латиницы
			for (int i = 0; i < str2.length(); i++) {
				char ch = str2.charAt(i);
				if (!map.containsKey(ch)) {
					map.put(ch, 1);
				} else {
					map.put(ch, map.get(ch) + 1);
				}
			}
		}
		System.out.println("список букв и кол. их использвания в заданном файле");
		System.out.println(entriesSortedByValues(map));
	}

	// компаротор редкости букв
	static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
		SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
				int res = e1.getValue().compareTo(e2.getValue());
				return res != 0 ? res : 1;
			}
		});
		sortedEntries.addAll(map.entrySet());
		return sortedEntries;
	}
}
// не сортирует

// читаем файл, инкрементируем кол. считаных букв через int-ое значение char
// public static int[] reading(String path) throws FileNotFoundException,
// IOException {
// int[] arr = new int[26];
// BufferedReader br = new BufferedReader(new FileReader(path));
// String line;
// while((line = br.readLine()) !=null) {
// line.toLowerCase();
// for(int i = 0; i < line.length(); i++ ) {
// char ch = line.charAt(i);
// int numericValue = (int) ch;
// if(numericValue >=97 && numericValue <=122) {
// arr[ch - 'a']++;
// }
// }
// }
// return arr;
// }
// выводим на экран буквы, приводя к char
// public static void print(int [] arr) {
// System.out.println("файл по заданной директории содержит следующие буквы");
// for (int i = 0; i < arr.length; i++) {
// if(arr[i]>0){
//// char ch = (char) (i+97);
// System.out.println(((char)(i + 97)) +" : "+arr[i]);
// }
// }
// }
