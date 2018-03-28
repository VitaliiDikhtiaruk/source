package lesson9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToUpperCase {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("введите строку и она будет возвращена с верхним регистром");
		String s = reader.readLine();
		String[] arr = s.split(" ");
		
		for(int i = 0; i < arr.length; i++) {
			
			System.out.print(arr[i].substring(0,1).toUpperCase() + arr[i].substring(1).toLowerCase() + " ");
		
		}
	}

}
