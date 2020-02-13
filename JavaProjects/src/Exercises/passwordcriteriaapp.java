/*Read a file that checks the criteria for a password.

Use this data for your test, or create your own:

*as=Hdflv
7234243&*
{=5Y9Y7qo
Y1{4?9Tff
05-;4uLZb
.)814WynN
72V$V5jn%
58.,3USfv
3{5;9OCnd
:Q%85pGi1
/?92QL4sp
(%6PiX61p
295+_OIun

1. Read a file that contains multiple sets of passwords (use http://www.theonegenerator.com/ to generate a set of test data)

2. Verify that the password contains all of the following criteria:
1. A number
2. A letter
3. Special character (! @ #)

3. Create three User Defined Exceptions for the corresponding criteria.

4. If the password does not meet the criteria, create and throw the appropriate exception*/

package Exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class passwordcriteriaapp {
           public static void main(String[] args) {
        	  //Read a file of passwords
        	   
        	   String filename ="C:\\Users\\aaserban\\Desktop\\Files\\Passwords.txt";
               String[] passwords = new String[13];
        	   File file = new File(filename);
        	   try {
   				BufferedReader br = new BufferedReader(new FileReader(file));
        	   for (int i=0; i<passwords.length; i++) {
        	        passwords[i] = br.readLine();
        	   }
			} catch (FileNotFoundException e) {System.out.println("ERROR: Could not open file");
			} catch (IOException e) {System.out.println("ERROR: Could not read the file");
			}
        	 //Test against our criteria
            for (String password : passwords ) {
            	System.out.println("****\n" +password + "\n");
            	boolean hasNumber = false;
            	boolean hasLetter = false;
            	boolean hasSpecialCharacter = false;

            	
            	for (int n=0; n<password.length(); n++) {
            		//Condition 1: contains number
                	if ("0123456789".contains(password.substring(n,n+1))) {
                		hasNumber = true;
                		//System.out.println("Position " + n + " contains a number");
                	}
                	//Condition 2: contains letter
                	else if ("abcdefghijklmnopqrstuvwxyz".contains(password.substring(n,n+1).toLowerCase())) {
                		hasLetter = true;
                		//System.out.println("Position " + n + " contains a letter");
                	}
                	//Condition 3: contains special character (! @ #)
                	else if ("!@#$%".contains(password.substring(n,n+1))) {
                		hasSpecialCharacter = true;
                		//System.out.println("Position " + n + " contains a special character");
                	}
                	else {

                		try {throw new InvalidCharacterException(password.substring(n,n+1));
                	} catch (InvalidCharacterException e) {e.toString(); }
                    
                	}
            	}
            	
            	//Test & exception handling
                	try {
            	if(!hasNumber) {throw new NumberCriteriaException(password);}
            	else if (!hasLetter) {throw new LetterCriteriaException(password);}
            	else if (!hasSpecialCharacter) {throw new SpecialCharacterCriteriaException(password);}
            	else { System.out.println("Valid password");}
			} catch (NumberCriteriaException | LetterCriteriaException | SpecialCharacterCriteriaException e) {
				System.out.println("Invalid password");
				System.out.println(e.toString());
			}
           }
}
}                     	

class InvalidCharacterException extends Exception {
	String ch;
	public InvalidCharacterException(String ch) {
		this.ch=ch;
	}
	public String toString() {
		return "InvalidCharacterException: " + ch;
	}
}
class NumberCriteriaException extends Exception {
	String password;
	public NumberCriteriaException(String password) {
		this.password=password;
	}
	public String toString() {
		return "NumberCriteriaException: " + password;
	}
}

class LetterCriteriaException extends Exception {
	String password;
	public LetterCriteriaException(String password) {
		this.password=password;
	}
	public String toString() {
		return "LetterCriteriaException: " + password;
	}
}
class SpecialCharacterCriteriaException extends Exception {
	String password;
	public SpecialCharacterCriteriaException(String password) {
		this.password=password;
	}
	public String toString() {
		return "SpecialCharacterCriteriaException: " + password;
	}
}

           


