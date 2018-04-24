package lesson14;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	int sum;

	public int add(String s) {
		  String delimiter = ",|n";
		    String numbersWithoutDelimiter = s;
		    if (s.startsWith("//")) {
		        int delimiterIndex = s.indexOf("//") + 2;
		        delimiter = s.substring(delimiterIndex, delimiterIndex + 1);
		        numbersWithoutDelimiter = s.substring(s.indexOf("n") + 1);
		    }
		    return add(numbersWithoutDelimiter, delimiter);
		}
		 
		private static int add(final String numbers, final String delimiter) {
			 int returnValue = 0;
			    String[] numbersArray = numbers.split(delimiter);
			    List negativeNumbers = new ArrayList();
			    for (String number : numbersArray) {
			        if (!number.trim().isEmpty()) {
			            int numberInt = Integer.parseInt(number.trim());
			            if (numberInt < 0) {
			                negativeNumbers.add(numberInt);
			            }
			            returnValue += numberInt;
			        }
			    }
			    if (negativeNumbers.size() > 0) {
			        throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
			    }
			    return returnValue;    
		}
}
