package com.test.manage;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseData {
	public static HashMap<String, Integer> parseData() {
		HashMap<String, Integer> testScores = new HashMap<String, Integer>();
		JSONParser parser = new JSONParser();		
		
	    try {
	    	// Read and parse the data
	    	Object obj = parser.parse(new FileReader("/home/abhishek/eclipse-workspace/StudentResultsApp/src/list.json"));
	        JSONArray students = (JSONArray) obj;
            // Process each student's quiz
            for (Object studentObj : students) {
                JSONObject studentJson = (JSONObject) studentObj;
                String studentName = (String) studentJson.get("student");
                JSONArray questions = (JSONArray) studentJson.get("questions");

                // Calculate and display individual scores
                int totalScore = calculateScore(questions);
                testScores.put(studentName, totalScore);
            }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return testScores;
	}
	
	@SuppressWarnings("unchecked")
	public static void sortAndViewByScores() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("/home/abhishek/eclipse-workspace/StudentResultsApp/src/list.json"));
	        JSONArray students = (JSONArray) obj;
			Collections.sort(students, Comparator.comparingInt(o -> -calculateScore((JSONArray) ((JSONObject) o).get("questions"))));

	        // Displaying overall ranking
	        System.out.println("\n All Students Ranking:");
	        for (int i = 0; i < students.size(); i++) {
	            JSONObject studentJson = (JSONObject) students.get(i);
	            String studentName = (String) studentJson.get("student");
	            int totalScore = calculateScore((JSONArray) studentJson.get("questions"));
	            System.out.println(" "+ (i + 1) + ". " + studentName + " - Total Score: " + totalScore);
	        }
		} catch (Exception e) {
	        e.printStackTrace();
		}
		
		System.out.println("\n Sorted by scores and printed in descening order!!");
	}
	
	private static int calculateScore(JSONArray questions) {
        int totalScore = 0;

        // Process each question
        for (Object questionObj : questions) {
            JSONObject questionJson = (JSONObject) questionObj;
            String correctAnswer = (String) questionJson.get("correct_answer");
            String userAnswer = (String) questionJson.get("user_answer");

            // Check if the user's answer is correct and update the score accordingly
            if (correctAnswer.equals(userAnswer)) {
                totalScore += 4;
            } else {
                totalScore -= 1;
            }
        }
        
        return totalScore;
	}
}
