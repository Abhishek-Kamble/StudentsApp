import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.test.manage.TestOp;

public class Start {

    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	System.out.println("***** WELCOME TO STUDENTS RESULTS PROCESSING APP *****");
    	
    	while(true) {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" 1 -> Calculate score of a student");
			System.out.println(" 2 -> Sort all based on score in descending order");
			System.out.println(" 3 -> Exit from app...");
			System.out.print("\n Enter an option to proceed: ");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1) {
				// Calculate score of a student
				System.out.print("\n Enter name of student: ");
				String studentName = br.readLine();
				String score = TestOp.calculateScore(studentName);
				System.out.println("\n Score of " + studentName + " is " + score);				
			} 			
			else if(c == 2) {
				// Sort all based on score in descending order
				TestOp.showSorted();
			}
			else {
				System.out.println("\n Successfully exited !!!");
				break;
			}
			System.out.println("\n");
    	}
    	
    	System.out.println("\n Thank you for using our app :)");   	        
    }    
}
