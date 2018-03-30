package lesson9;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import static java.nio.file.StandardOpenOption.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *5. Написать программу Text editor 
 *Программа позволяет пользователю, взаимодействуя с консолью записывать в файл.
 *Программа завершается, если наберу слово “exit”
 *По завершению программы, вывести статистику файла:
 *Содержимое файла в консоль.
 *Общее количество символов
 *Номер строки с самым большим количеством гласных
 *количество слов (регулярное выражение для всех пробелов)
 *В программе использовать:
 *Files.write()
 *StandardOpenOption
 *Files.lines
 */

public class TextEditor {

	public static void main(String[] args) throws IOException {

		writeToFile();
		readFromFile();
		count();
	}

	// write the input to the file until exit
	private static void writeToFile() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("input the text to edit, when you done type EXIT and press ENTER");
		while (true) {
			String str = reader.readLine();
			if (str.equalsIgnoreCase("exit")) {
				break;
			}
			str = str + System.lineSeparator();
			Files.write(Paths.get("textEditor.txt"), str.getBytes(), CREATE, WRITE, APPEND);
		}
	}

	// output the file to console
	private static void readFromFile() {
		System.out.println("content of the file:");
		try (Stream<String> stream = Files.lines(Paths.get("textEditor.txt"), Charset.forName("UTF-8"))) {
			stream.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("smth is wrong with reading from the file");
		}
	}

	// get statistics from the file
	private static void count() {
		int charCount = 0;
		int wordCount = 0;
		int vowel = 0;
		int line = 0;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		Pattern vowelPattern = Pattern.compile("[AEIOUYaeiouy]");
		Matcher match;
		try (BufferedReader br = new BufferedReader(new FileReader("textEditor.txt"))) {
			String curStr = br.readLine();
			while (curStr != null) { // get the line with max vowels and put #line and amount of vowels to the map
				int vowelinLine = 0;
				line++;
				match = vowelPattern.matcher(curStr);
				while (match.find()){ //matching vowels in the string
					vowelinLine++;
				}
				vowel = vowel > vowelinLine ? vowel : vowelinLine;
				map.put(line, vowel);

				String[] words = curStr.split(" "); // get array of the words and count them
				wordCount = wordCount + words.length;
				for (String word : words) {
					charCount = charCount + word.length(); // get amount of the chars in the file
				}
				curStr = br.readLine();
			}
			System.out.println("some info about the file:");
			System.out.println("amount of characters in the file - " + charCount);
			System.out.println("amount of words in the file - " + wordCount);
			for (Integer i : map.keySet()) {
				if (map.get(i).equals(vowel)) {
					System.out.println("line with biggest amount of vowels - " + i);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("smth wrong with info output");
		}
	}
	
}
