package com.vin.tddkata.greeting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GreetingTest {
	
	private Greeting g;
	
	@Before
	public void objectSetup() {
		g = new Greeting();
	}

	/*Write a method greet(name) that interpolates name in a simple greeting. 
	 * For example, when name is "Bob", the method should return a string "Hello, Bob.".
	 */
	@Test
	public void whenGivenName_thenHelloName() {
		
		String expected = "Hello, Bob.";
		String actual = g.hello("Bob");
		
		assertEquals(expected, actual);
	}	
	/*
	 * Handle nulls by introducing a stand-in. For example, when name is null, 
	 * then the method should return the string "Hello, my friend."
	 * */
	@Test
	public void whenNameNull_thenHelloFriend() {
		
		String expected = "Hello, my friend.";
		String actual = g.hello((String)null); //cast to string to diff with String[] 
		
		assertEquals(expected, actual);
	}
	
	/*
	 * When name is all uppercase, then the method should shout back to the user. 
	 * For example, when name is "JERRY" then the method should return the 
	 * 	string "HELLO JERRY!"
	 * */
	@Test
	public void whenNameUpperCase_thenShoutHello() {
		String expected = "HELLO JERRY!";
		String actual = g.hello("JERRY");
		
		assertEquals(expected, actual);
	}
	
	/*
	 * For example, when name is ["Jill", "Jane"], 
	 * 	then the method should return the string "Hello, Jill and Jane."
	 * */
	@Test
	public void whenTwoNames_thenHelloBoth() {
		String[] names = new String[] {"Jill", "Jane"};
		String expected = "Hello, Jill and Jane.";
		String actual = g.hello(names);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * when name is ["Amy", "Brian", "Charlotte"], then the method should 
	 * 	return the string "Hello, Amy, Brian, and Charlotte."
	 * */
	@Test
	public void whenMoreThanTwoNames_thenHelloAllNames() {
		
		String[] names = new String[] {"Amy", "Brian", "Charlotte"};
		String expected = "Hello, Amy, Brian, and Charlotte.";
		String actual = g.hello(names);
		
		assertEquals(expected, actual);
	}
	
	/*Bonus! If Name array has just one name.*/
	@Test
	public void whenNamesArrayHasOneName_thenHelloName() {
		String[] names = new String[] {"Amy"};
		String expected = "Hello, Amy.";
		String actual = g.hello(names);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * when name is ["Amy", "BRIAN", "Charlotte"], then the method should 
	 * return the string "Hello, Amy and Charlotte. AND HELLO BRIAN!"
	 * */
	@Test
	public void whenNamesArrayhasUpperCase_thenReturnShout() {
		String[] names = new String[] {"Amy", "BRIAN", "Charlotte"};
		String expected = "Hello, Amy and Charlotte. AND HELLO BRIAN!";
		String actual = g.hello(names);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * Bonus! If shout array has more than one name
	 * ["Amy", "BRIAN", "Charlotte", "DAX"]
	 * Hello, Amy and Charlotte. AND HELLO BRIAN AND DAX!
	 * */
	@Test
	public void whenNamesArrayHasMoreShoutNames_thenReturnMultipleShout() {
		String[] names = new String[] {"Amy", "BRIAN", "Charlotte", "DAX"};
		String expected = "Hello, Amy and Charlotte. AND HELLO BRIAN AND DAX!";
		String actual = g.hello(names);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * when ["Bob", "Charlie, Dianne"], then "Hello, Bob, Charlie, and Dianne."
	 * */
	@Test
	public void whenNamesTogether_thenSeparateAndReturn() {
		String[] names = new String[] {"Bob", "Charlie, Dianne"};
		String expected = "Hello, Bob, Charlie, and Dianne.";
		String actual = g.hello(names);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * Bonus! Split test.
	 * */
	@Test
	public void DUMMYwhenNameCommaSeparated_thenSplitNames() {
		String[] names = new String[] {"Bob", "C, D"};
		String expected = "Bob C D ";
		List<String> list = new ArrayList<String>();
		for(String name : names) {
			if(!name.contains(",")) {
				list.add(name);
			} else {
				String[] splitNames = name.split(", ");
				for(String spName : splitNames)
					list.add(spName);
			}
		}
		
		String actual = "";
		
		for(String name : list) {
			actual = actual + name + " ";
		}
		
		assertEquals(expected, actual);
	}
	
	/*
	 * Bonus! Test the replace of double quotes for the next test case.
	 * */
	@Test
	public void whenStringHasQuotesAtStartAndEnd_removeThem() {
		String name = "\"Charlie, Dianne\"";
		
		String expected = "Charlie, Dianne";
		String actual = name.replace("\"", "");
		
		assertEquals(expected, actual);
	}
	
	/*
	 * when "Bob", "\"Charlie, Dianne\""
	 * then "Hello, Bob and Charlie, Dianne."
	 * */
	
	@Test
	public void whenNamesTogetherWithEscape_thenDontSplitNames () {
		String[] names = new String[] {"Bob", "\"Charlie, Dianne\""};
		String expected = "Hello, Bob and Charlie, Dianne.";
		String actual = g.hello(names);
		
		assertEquals(expected, actual);
		
	}
}
