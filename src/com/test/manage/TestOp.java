package com.test.manage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

public class TestOp {
	static HashMap<String, Integer> testScores = ParseData.parseData();
	
	public static String calculateScore(String studentName) {
		if(testScores.containsKey(studentName))
			return Integer.toString(testScores.get(studentName));
		return "not found!";
	}
		
	public static void showSorted() {
		try {
			ParseData.sortAndViewByScores();
		} catch (FileNotFoundException e) {
			System.out.println(" File not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(" IO Exception!");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println(" Error occured while parsing!");
			e.printStackTrace();
		}
	}
}
