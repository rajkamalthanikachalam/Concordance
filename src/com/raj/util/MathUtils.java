package com.raj.util;

import static java.lang.Math.floor;
import static java.lang.Math.log;

public class MathUtils {
	
	public static String getStringSequence(int n) {
		char[] buf = new char[(int) floor(log(25 * (n + 1)) / log(26))];
	    for (int i = buf.length - 1; i >= 0; i--) {
	        n--;
	        buf[i] = (char) ('a' + n % 26);
	        n /= 26;
	    }
	    return new String(buf);
	}

}
