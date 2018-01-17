package homework2;

import java.io.*;

	public class Phrase_Handler{

		private BufferedReader input;                       
													
		private String phrase;
		
		private int numWords = 0;
		
		private int numConsonants = 0;

		private int numVowels = 0;
		
		private int numPunctuation = 0;

		private int numNumbers = 0;
		
	    private int numChars = 0;
		
		/**
		 * Default value constructor (PhraseHandler)
		 *
		 * @throws IOException
		 * @author Michael 
		 */
		public Phrase_Handler() throws IOException
		{
			input = new BufferedReader(new InputStreamReader( System.in ) );
		} 

		/**
	     * This method controls the action for this class
	     *
	     * @throws IOException
	     */
	    public void start() throws IOException
	    {
			
			System.out.print( "Please enter a string: " );
			phrase = input.readLine();
			
	        if (phrase == null)
			{
				System.out.println( "You have entered a null value.");
			} 
	        	else 
				{
					String[] words = phrase.split(" +");				//split words
					numWords = words.length;

					for (int i = 0; i < words.length; i++)     	 	//for each word
					{
						
						String thisWord = words[i];
						
						for (int x = 0; x < thisWord.length(); x++) 		//for each letter of each word
						{
							countType(thisWord.charAt(x));      	 		//add to count of that type of character
							numChars++;							   	    //add to total count of characters
						}
					}
					
					System.out.println ("You have entered:\n" + numWords + " words\n" +
							numChars + " characters\n" + numConsonants + " consonants\n" + 
							numVowels + " vowels\n" + numPunctuation + " punctuation marks");
	    
				}
	    }
	    
	    /**
	     * Determines the type of character and add's to the number of that type.
	     * 
	     * @param a character
	     */
	    private void countType( char x )
	    {
			if ( isConsonant(x) )
			{
				numConsonants++;
			}	
			else 
					if ( isVowel(x) )
					{
						numVowels++;
					}	
					else 
						if ( isNumber(x) )
						{
							numNumbers++;
						}	
						else
						{
							numPunctuation++;
						}	
	        }
		
	    /**
	     * Determines if a character is a consonant.
	     * 
	     * @param a character
	     * @return boolean 
	     */
		private boolean isConsonant( char x )
		{
			String consonant = "qwrtyplkjhgfdszxcvbnm";
			boolean isValid = false;
			
			if ( consonant.indexOf(x) > -1 )
			{
				isValid = true;
			}
			
			return isValid;
		}
		
		/**
		 * Determines of a character is a vowel.
		 * 
		 * @param a character
		 * @return boolean
		 */
		private boolean isVowel( char x )
		{
			String vowel = "aeiou";
			boolean isValid = false;
			
			if ( vowel.indexOf(x) > -1 )
			{
				isValid = true;
			}
			
			return isValid;
		}
		
		/**
		 * Determines if a character is a number.
		 * 
		 * @param a character
		 * @reeturn a boolean
		 */
		private boolean isNumber( char x )
		{
			String number = "0123456789";
			boolean isValid = false;
			
			if ( number.indexOf(x) > -1 )
			{	
				isValid = true;
			}
			
			return isValid;
		}

	}

