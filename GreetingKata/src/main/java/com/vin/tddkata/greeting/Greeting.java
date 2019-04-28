package com.vin.tddkata.greeting;

import java.util.ArrayList;
import java.util.List;

public class Greeting {
	
	private static final String NORMAL = "Hello, ";
	private static final String SHOUT = "HELLO ";
	private static final String NORMAL_END = ".";
	private static final String SHOUT_END = "!";

	public String hello(String name) {

		String greeting = null;

		if (name != null && name.equals(name.toUpperCase())) {
			greeting = SHOUT + name + SHOUT_END;
		} else {
			greeting = NORMAL + name + NORMAL_END;
		}

		return (name != null) ? greeting : "Hello, my friend.";
	}

	public String hello(String[] names) {

		String greet = NORMAL;
		boolean isShout = false;

		List<String> shout = new ArrayList<String>();
		List<String> normal = new ArrayList<String>();

		for (String name : names) {
			if (name.equals(name.toUpperCase())) {
				shout.add(name);
				isShout = true;
			} else {
				if(!name.contains(",")) {
					normal.add(name);
				} else {
					String[] splitNames = name.split(", ");
					for(String splitName : splitNames) {
						normal.add(splitName);
					}
				}
			}
		}

		int normalN = normal.size();

		// "Hello, Amy and Charlotte. AND HELLO BRIAN!"
		if (normal != null && normal.size() == 1) {
			greet = hello(normal.get(0));
		} else if (normal != null && normal.size() == 2) {
			greet = greet + normal.get(0) + " and " + normal.get(1) + NORMAL_END;
		} else { // "Hello, Amy, Brian, and Charlotte."
			for (int i = 0; i < normalN - 1; i++) {
				greet = greet + normal.get(i) + ", ";
			}
			greet = greet + "and " + normal.get(normalN - 1) + NORMAL_END;
		}
		
		//Hello, Amy and Charlotte. AND HELLO BRIAN AND DAX!
		if(isShout) {
			String shoutGreet = " AND HELLO ";
			if(shout.size() == 1) {
				greet = greet + shoutGreet + shout.get(0) + SHOUT_END;
			} else if (shout.size() == 2) {
				greet = greet + shoutGreet + shout.get(0) 
							  + " AND " 
							  + shout.get(1) + SHOUT_END;
			}
		}

		return greet;
	}

}
