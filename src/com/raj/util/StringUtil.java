package com.raj.util;



import java.util.Collections;
import java.util.List;

public class StringUtil {

	public static void replaceTrailingDot(String[] stringArray) {
		for (int i=0;i<stringArray.length;i++)
			stringArray[i] = stringArray[i].replaceAll("\\.(?!.*\\.)","").toLowerCase();
	}

	public static String[] getStringArrayForPattern(String stringValue,String pattern) {
		return stringValue.split(pattern);
	}

	public static int getNumberOfOccurences(List<String> stringList, String word) {
		return Collections.frequency(stringList, word);		
	}

	

}
