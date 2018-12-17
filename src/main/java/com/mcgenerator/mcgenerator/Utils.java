package com.mcgenerator.mcgenerator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utils {

	private static Random rand = new Random();
	private static Set<String> identifiers = new HashSet<>();


	public static Integer generateRandom(int limit) {
		int returnVal;
		do {
			returnVal = rand.nextInt(limit);
		} while (returnVal == 0);

		return returnVal;
	}

	public static String randomIdentifier() {
		StringBuilder builder = new StringBuilder();
		while(builder.toString().length() == 0) {
			int length = rand.nextInt(5)+5;
			for(int i = 0; i < length; i++) {
				String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if(identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			}
		}
		return builder.toString();
	}
}
