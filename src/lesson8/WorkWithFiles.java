package lesson8;

import java.io.File;

public class WorkWithFiles {
	public static void main(String[] args) {
		
		System.out.println("Колличесво файлов с расширением \".java\" по заданному пути");
		System.out.println(someCounter("C:\\Users\\vitalii\\eclipse-workspace\\Homework\\src\\lesson7"));
		System.out.println("конкатинированная строка по заданному пути");
		System.out.println(getNames("C:\\Users\\vitalii\\eclipse-workspace\\Homework\\src\\lesson7"));
	}
	public static int someCounter(String path) {
		File file = new File(path);
		int counter = 0;
		File[] s = file.listFiles();
		for(int i = 0; i < s.length; i++) {
			if(!s[i].isDirectory() && s[i].getName().endsWith(".java")) {
				counter++;
			} 
			if (s[i].isDirectory()) {
				someCounter(s[i].getPath());
			}
		}
		return counter;
}
	public static StringBuilder getNames(String path) {
		StringBuilder conNames = new StringBuilder();
		File file = new File(path);
		File[] arr = file.listFiles();
		for(int i = 0; i < arr.length; i ++) {
			if(!arr[i].isDirectory()) {
				conNames.append(arr[i].getName());
			}
			if (arr[i].isDirectory()) {
				getNames(arr[i].getPath());
			}
		}
		return conNames;
	}
	
	
	
}