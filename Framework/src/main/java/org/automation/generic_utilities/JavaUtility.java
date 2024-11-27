package org.automation.generic_utilities;

import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {

	public static int giveRandomNumber(int boundary){
		Random random = new Random();
		return random.nextInt(boundary);
	}
	
	public static String timeStamp()
	{
		LocalDateTime ldt = LocalDateTime.now();
		String timeStamp=ldt.toString().replaceAll(":", "-");
		return timeStamp;
	}
}
