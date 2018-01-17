import java.io.*;

/**
 * Determine whether a user's input is an Integer, a Double, or a String.
 * 
 * @author Tim Williams
 * @version 1-12-17
 */
public class HW1 {
	
	public static void main(String[] args) throws IOException {
        
		BufferedReader reader;
		int sumInt = 0;
		int sumChar = 0;
		Boolean decimal = false;
		String displayMessage = "";
		
        reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print( "Please enter something: ");

        String input = reader.readLine();
        
        for (int i = 0; i < input.length(); i++) {
        		
        		if (testForInt(input.charAt(i)) == true) {
        			
        			sumInt++;
        			
        		} else if (testForDecimal(input.charAt(i)) == true) {
        			
        			decimal = true;
        		
        		} else {
        			
        			sumChar++;
        		
        		}
        }
        
        displayMessage = inputType(sumChar, sumInt, decimal, input);
        
        System.out.println( "You entered: " + input + displayMessage);
        
	}
	
	/**
	 * Determine whether a character is an Integer.
	 * 
	 * @param The character in question.
	 * @return The boolean value.
	 */
	public static boolean testForInt(char x) {
		
		String integers = "0123456789";
		
		for (int i = 0; i < integers.length(); i++) {
		
			if (x == integers.charAt(i)) {
			
				return true;
			
			}
		}
		
		return false;
		
	}
	
	/**
	 * Determine whether a character is a Decimal.
	 * 
	 * @param x The character in question.
	 * @return The boolean value.
	 */
	public static boolean testForDecimal(char x) {
		
		return x == '.';
	
	}
	
	/**
	 * Determine the user's input type.
	 * 
	 * @param sumChar The number of non-Integer characters.
	 * @param sumInt The number of Integer characters.
	 * @param decimal Whether or not a decimal was present.
	 * @param input The user's input.
	 * @return A String with the user's input type.
	 */
	public static String inputType(int sumChar, int sumInt, boolean decimal, String input) {
	   
		String message = "";
		
	    	if (sumChar == 1) {
	    		
	    		message = "(char)";
	    
	    	} else if (sumInt == input.length()) {
	    	
	    		message = "(int)";
	    
	    } else if (sumInt == input.length() - 1 && decimal == true) {
	    
	    		message = "(double)";
	    
	    } else {
	    
	    		message = "(String)";
	    
	    }
	    
	    return message;
	    
	}
}
