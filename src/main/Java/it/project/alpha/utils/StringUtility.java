package it.project.alpha.utils;

import java.util.regex.Pattern;

public class StringUtility {
	
	public static boolean containsOnlyLetters(String input){
		return Pattern.compile("^[a-zA-ZàèéìòùäöüÄÖÜ]*$").matcher(input).find();
	}
	
	public static boolean containsOnlyLettersAndNumbers(String input){
		return Pattern.compile("^[a-zA-Z0-9àèéìòùäöüÄÖÜ]*$").matcher(input).find();
	}
	
	public static boolean isValidEmail(String input){
		return Pattern.compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$").matcher(input).find();
	}
	
	

}
