package lesson8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Написать метод, который принимает директорию, и расширения файла.
 *Подсчитать общее количество файлов с заданным расширением рекурсивно начиная от этой директории
 *
 *
 *Найти файлы с расширением .java
 *В методе принимается инт глубины поиска
 *Пас, откуда искать
 *Вывести в консоль конкатенированую строку всех названий файлов
 *
 *
 */
public class WorkWithFiles {
	
	public static int counter = 0;
	
	public static void main(String[] args) {
		System.out.println("Колличесво файлов с расширением \".java\" по заданному пути");
		System.out.println(someCounter("C:\\Users\\vitalii\\eclipse-workspace\\Homework\\src"));
		System.out.println("конкатинированная строка по заданному пути с определенной глубиной поиска");
		getNames("C:\\Users\\vitalii\\eclipse-workspace\\Homework\\src", 2);
		
	}

	// рекурсивный метод счетчика файлов по заданной директории
	public static int someCounter(String dir) {
		File file = new File(dir);
		File[] s = file.listFiles();
		for (int i = 0; i < s.length; i++) {
			if (!s[i].isDirectory() && s[i].getName().endsWith(".java")) {
				counter ++;
			}
			if (s[i].isDirectory()) {
				someCounter(s[i].getPath());
			}
		}
		return counter;
	}

	// считывания имен файлов по заданной директории при омощи Files c заданной глубиной
	public static void getNames(String dir, int depth) {
		try (Stream<Path> stream = Files.walk(Paths.get(dir), depth).map(Path::getFileName)) {

			String joined = stream.map(String::valueOf).filter(path -> path.endsWith(".java")).sorted()
					.collect(Collectors.joining(","));

			System.out.println(joined);
		} catch (IOException e) {

			System.out.println("smth is wrong");
		}
	}
}