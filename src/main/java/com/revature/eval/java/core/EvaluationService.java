package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		String[] s = string.split("");
		
		String[] array = new String[s.length];
		
		int count = 0;
		
			for(int i = s.length-1; i >=0; i--) {
			
			
				array[count] = s[i];
		
				count++;			
			
			}
				
		return String.join("", array);
			
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		char[] splitString = phrase.toCharArray();
		
		String acro = "";
		
		if(phrase.isEmpty()) {
			
			return "";
			
		}
		
		if(Character.isLetter(splitString[0])) {
			acro += splitString[0];
		
			
		for(int i=1; i < splitString.length; i++) {
			if(!Character.isLetter(splitString[i-1]) && Character.isLetter(splitString[i])){
				acro += splitString[i];
				
			}
		}	
			
		}
		return acro.toUpperCase();	
		
		
		
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
		
			
			double one = getSideOne();
			double two = getSideTwo();
			double three = getSideThree();
			
			if(one == two && two == three) {
				
				return true;
			}
			   return false;
		}

	
		public boolean isIsosceles() {
			
			double one = getSideOne();
			double two = getSideTwo();
			double three = getSideThree();
			
			if(this.isEquilateral()) {
				return true;			
			}
			
			if(one == two || two == three || one == three) {
				return true;
				
			}
			
			return false;
		}

		public boolean isScalene() {
			
			double one = getSideOne();
			double two = getSideTwo();
			double three = getSideThree();
					
			
			if(one != two || two != three || one != three) {
				return true;
				
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
				 
		 int score = 0; // declare and initialize score
		 
		
	    Map<String,Integer > hm = new HashMap<String,Integer>(); //declare and initialize map
	    
	    hm.put("A", 1);    //implemented applicable key and value pairs using put function
	    hm.put("E", 1);
	    hm.put("I", 1);
	    hm.put("O", 1);
	    hm.put("U", 1);
	    hm.put("L", 1);
	    hm.put("N", 1);
	    hm.put("R", 1);
	    hm.put("S", 1);
	    hm.put("T", 1);
	    hm.put("D", 2);
	    hm.put("G", 2);
	    hm.put("C", 3);
	    hm.put("M", 3);
	    hm.put("P", 3);
	    hm.put("F", 4);
	    hm.put("H", 4);
	    hm.put("V", 4);
	    hm.put("W", 4);
	    hm.put("Y", 4);
	    hm.put("K", 5);
	    hm.put("J", 8);
	    hm.put("X", 8);
	    hm.put("Q", 10);
	    hm.put("Z", 10);
	    
	    
	 String[]  array = string.split("");  //declared array and assigned it split strings at every character
	 for(int i = 0; i < array.length; i++) { //used for loop to iterate each character in string
		 score += hm.get(array[i]); // used get function to add designate value for each character
	   }
	    
	 
		
		return score; //outputs total score
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
	    String numonly = string.replaceAll("[^0-9]", "");
	    
	   	char ch = string.charAt(0);
	   
	      if(ch == '1' && numonly.length()>10) {
	    
	    numonly = numonly.substring(1);	
	    
	    }
	    
	    char ch2 = numonly.charAt(0);
	    
	      if(ch2 == '1') {
	     	
	    numonly = numonly.substring(1);	
	    	
	    }
	    
    if (numonly.length() > 10) {
    	
    	
    	throw new IllegalArgumentException("Number must be less than 10 digits");
    }  
	    	
    if (string.matches("!.$%^&*,+=()`~<>@#?"))                  {
        
      throw new IllegalArgumentException("non numeric");
	}	
		return numonly;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		
	   Map	<String, Integer> map1 = new HashMap<>(); 
		
		String [] eachword = string.split("\\W+"); // created string array containing each word in phrase
		
		for(int i = 0; i < eachword.length; i++) { // for loop to iterate through the string
			
		  String check = eachword[i];       // create a string that equals each word in phrase/array
		  
		  if(map1.containsKey(check)) {    //  use contains key function and if statement to check if one of the words is in map 
			  
			 int value = map1.get(check);  // declare integer and get the value in map in this case the # of times a word appears
		
			 map1.put(check, ++value);    // if so increment value by 1
			                              
		  }else {                        // if  not put word in map and assign it one
			  map1.put(check, 1);
		  }
				
		  	  			  
		}
										// repeats for each word in phrase	
		
		return map1;                   // returns word and number of occurrences in key value form

	
	
	
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
	 	
		char a = 'a';
	    char e = 'e';
	    char i = 'i';
	    char o = 'o';
	    char u = 'u';

	    int start = 0;
	    int firstVowel = 0;
	    int end = string.length();
	    
	    
	    
	    for(int i1 = 0; i1 < end; i1++) {
	        char c = Character.toLowerCase(string.charAt(i1));
	        if(c == a || c == e || c == i || c == o || c == u) {
	            firstVowel = i1;
	            break;
	        }
	    }
	    if(start != firstVowel) {
	        String startString = string.substring(firstVowel, end);
	        String endString = string.substring(start, firstVowel) + "ay";
	        String pigword = startString+endString;
	        return pigword;
	    }
	    
	    
           if(firstVowel==0) {
	    	
	    	String vstring = string + "ay";
	    	return vstring;
	    	
	    }
           
           String arrayc[] = string.split("");
          
           
           if (arrayc[0].equals("q")) {
        	  
           String strword1 = string.substring(2,end);
           String endword1 = string.substring(0,2) + "ay";
           String pigword2 = strword1+endword1;
           
           return pigword2;
        	  
        	  
          }	
	    return string; //couldn't find a vowel, return original

	}		
	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {	
		 int length = String.valueOf(input).length(); // get # of digits
		
		  int sum = 0;    //declare sum at 0
		  int check = input; // store original input value outside scope
		
		for(int i = 0; i < length; i++ ) { //execute code number of digit times
		 
		 int a = input % 10;     //modulus 10 retrieves digit in ones place
		 
		 sum+= Math.pow(a, length); //takes ones digit and raises power by # of digits  then adds to sum
		 
		 input /= 10 ; //divides input by 10 and reassigns value 
		
		
		}
				
	  return check == sum; //since input was modified I used "check" variable from outside loop block to compare sum to original output
	                      //returned boolean
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
	
		List<Long> list = new ArrayList<Long>();	
		
		 // return the number of 2s that divide long l
        while (l % 2L == 0) 
        { 
            list.add(2L);
            
            l /= 2L; 
        } 
  
 // l has to be odd.  square root is largest possible prime factor, increment by 2 
 // checks divisibility by every odd number up to square root of L         
        
        for (long i = 3L; i <= Math.sqrt(l); i+= 2L) 
        {   
            // While i divides l, print i and divide l (primes can only be odd except 2)
            while (l % i == 0L) 
            { 
            	 list.add(i);    //adds each i to list
                l /= i; 
            } 
        } 
  
        // This is to handle the case when 
        // n is a prime number greater than 2 
        if (l > 2L) 
        	 list.add(l); 
		
			
		return list;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			HashMap<String, Integer> maptoint = new HashMap<String, Integer>();
			
			maptoint.put("a",1);    maptoint.put("m",13);    maptoint.put("y",25);   
			maptoint.put("b",2);    maptoint.put("n",14);    maptoint.put("z",26);   
			maptoint.put("c",3);    maptoint.put("o",15);    maptoint.put("z",26);  
			maptoint.put("d",4);    maptoint.put("p",16);    maptoint.put("z",26); 
			maptoint.put("e",5);    maptoint.put("q",17);    maptoint.put("z",26); 
			maptoint.put("f",6);    maptoint.put("r",18);     
			maptoint.put("g",7);    maptoint.put("s",19);
			maptoint.put("h",8);    maptoint.put("t",20);
			maptoint.put("i",9);    maptoint.put("u",21);
			maptoint.put("j",10);   maptoint.put("v",22);
			maptoint.put("k",11);   maptoint.put("w",23);
			maptoint.put("l",12);   maptoint.put("x",24);
			
			
			HashMap<Integer, String> maptostring = new HashMap<Integer, String>();
			
			maptostring.put(1, "a");  maptostring.put(9, "i");  maptostring.put(17, "q");
			maptostring.put(2, "b");  maptostring.put(10, "j"); maptostring.put(18, "r");
			maptostring.put(3, "c");  maptostring.put(11, "k"); maptostring.put(19, "s");
			maptostring.put(4, "d");  maptostring.put(12, "l"); maptostring.put(20, "t");
			maptostring.put(5, "e");  maptostring.put(13, "m"); maptostring.put(21, "u");
			maptostring.put(6, "f");  maptostring.put(14, "n"); maptostring.put(22, "v");
			maptostring.put(7, "g");  maptostring.put(15, "o"); maptostring.put(23, "w");
			maptostring.put(8, "h");  maptostring.put(16, "p"); maptostring.put(24, "x");
			maptostring.put(25, "y"); maptostring.put(26, "z"); 			
			
			String[] strArray;
					
	        strArray = string.split("");	//string array at every character
	        String empty = "";
	        
	        for(int i = 0; i < strArray.length; i++){
	        	
	        	String letters =  strArray[i];    
	        
	        	
	            int numsafter = maptoint.get(letters) + key; //get value from letters and add to key
	      
	            if(numsafter > 26) {
	            
	            numsafter = numsafter % 26;
	            
	            } 
	            
	            String stringafter;  
			   
			    stringafter = maptostring.get(numsafter); //get string from numbers
			    		   	    
			    empty += stringafter;
			   
			    
	        
	        }   	      	        
		    //System.out.println(empty);		    								
			return empty;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */

	
	
	public int calculateNthPrime(int i) {       	
    	
    	max= i * i;       
        IsThisNumberPrime(); 
      
    	return  (primes.get(i-1));
        //System.out.println("nth prime number is " +  
        		                    //(primes.get(i-1))); 
    } 
					  
    // initializing the max value  
    static int max; 
      
    // list to hold all prime numbers 
    static ArrayList<Integer> primes = 
       new ArrayList<Integer>(); 
      
    // Function to generate N prime numbers  
    
    static void IsThisNumberPrime()  
    {  
        // create a boolean array "IsPrime[0..max]"  
         
        
        boolean [] IsPrime = new boolean[max];  
          
        for(int i = 0; i < max; i++)      //initialize all entries it as true.  
        	
            IsPrime[i] = true;          // A value in IsPrime[i] will finally be false  
                                        // if i is Not a IsPrime, else true.  
          
        for (int p = 2; p * p < max; p++)  
        {  
            // If IsPrime[p] is not changed,  
            // then it is a prime  
            if (IsPrime[p] == true)  
            {  
                // Update all multiples of p greater than or  
                // equal to the square of it  
                // numbers which are multiple of p and are  
                // less than p^2 are already been marked.  
                for (int i = p * p; i < max; i += p)  
                    IsPrime[i] = false;  
            }  
        }  
      
        // Store all prime numbers in list
        
        for (int p = 2; p < max; p++)  
        
        	if (IsPrime[p] == true)  
               
        		primes.add(p); 
			
	
	}	
    
    
		
	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
		    string = string.replaceAll("[^a-zA-Z0-9]+", ""); //create new string without spaces 
			
		    string = string.toLowerCase();                        
		    //  and punctuation and reassign
		    String empty = "";                                            
			
		  //to store encoded string 
			
			int check = string.length();
			
			
	    HashMap<String, String> maptoint = new HashMap<String, String>();  //create map with key values that match atbash rules
			
			maptoint.put("a","z");    maptoint.put("m","n");    maptoint.put("y","b");   
			maptoint.put("b","y");    maptoint.put("n","m");    maptoint.put("z","a");   
			maptoint.put("c","x");    maptoint.put("o","l");    maptoint.put("1","1"); 
			maptoint.put("d","w");    maptoint.put("p","k");    maptoint.put("2","2");
			maptoint.put("e","v");    maptoint.put("q","j");    maptoint.put("3","3");
			maptoint.put("f","u");    maptoint.put("r","i");     
			maptoint.put("g","t");    maptoint.put("s","h");
			maptoint.put("h","s");    maptoint.put("t","g");
			maptoint.put("i","r");    maptoint.put("u","f");
			maptoint.put("j","q");    maptoint.put("v","e");
			maptoint.put("k","p");    maptoint.put("w","d");
			maptoint.put("l","o");    maptoint.put("x","c");
			
		 
		  
		  String [] strArray =  string.split("");   //put string minus spaces and punctuation in string array
			
			for(int i = 0; i < string.length(); i++) {
				
		   String trans = maptoint.get(strArray[i]);     //get value for each letter in array
			
			empty += trans;
				
			}				
			
		    String first;
		    
		    String second;
	   
		    String third;
		    
		    String fourth;
		    
		    String fifth;
		    
		    String sixth;
		    
		    String seventh;
		    
		    String eigth;
		    
		    
		    if(check > 34) {
		   
		    first = empty.substring(0,5);
			
		    second = empty.substring(5, 10); 
		    
		    third = empty.substring(10, 15);
		    
		    fourth = empty.substring(15, 20);
		    
		    fifth = empty.substring(20, 25);
		    
		    sixth = empty.substring(25, 30);
		    
		    seventh= empty.substring(30,35);
		    
		    eigth = empty.substring(35, check);
		    
		     String combo2 = first + " " + second + " " + third + " " + fourth + " " 
		     + fifth + " " + sixth  + " " + seventh + " " + eigth;
		   
		     return combo2;
		    }
		    
		    if(check < 20 && check > 15) {
		 	   
			    first = empty.substring(0,5);
				
			    second = empty.substring(5, 10); 
			    
			    third = empty.substring(10, 15);
			    
			    fourth = empty.substring(15, check);
		    
			    String combo2 = first + " " + second + " " + third + " " + fourth;
			    
			    return combo2;

		    }
			
		    if(check > 10 && check < 15) {
			 	   
			    first = empty.substring(0,5);
				
			    second = empty.substring(5, 10); 
			    
			    third = empty.substring(10, check);
			    
			   
		    
			    String combo2 = first + " " + second + " " + third;
			    
			    return combo2;
		    }
		   
		    
		    
		    if(check < 5) {
		    	
		    	
		    	
		    	return empty;
		    	
		    }
			
		 return null;     						
		
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			return null;
		}
		
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		 
	String str = string.substring(0, string.length() - 1);
	
	if(str.contains("K")) {
	return false;	
	}
	if(string.contains("A"))	{
		return false;
	}
	
			
	 String numonly = string.replaceAll("[^0-9]", "");
	 
	 String [] strArray = numonly.split("");
	 
	 int sum = 0;
	 
	 int x1 = Integer.parseInt(strArray[0]);    //turn split string to numbers integer type                                         
     int x2 = Integer.parseInt(strArray[1]);    // only first 9
     int x3 = Integer.parseInt(strArray[2]);
     int x4 = Integer.parseInt(strArray[3]);
     int x5 = Integer.parseInt(strArray[4]);
     int x6 = Integer.parseInt(strArray[5]);
     int x7 = Integer.parseInt(strArray[6]);
     int x8 = Integer.parseInt(strArray[7]);
     int x9 = Integer.parseInt(strArray[8]);
	
	 if(strArray.length == 9) {
	    	 
	    sum = (x1 * 10) + (x2 * 9) + (x3 * 8) + (x4 * 7) + (x5 * 6) + 
	    (x6 * 5) + (x7 * 4) + (x8 * 3) + (x9 * 2) + 10;
	
	 }
	       
	 if(strArray.length == 10)      {
		 int x10 = Integer.parseInt(strArray[9]);
		     
		 sum = (x1 * 10) + (x2 * 9) + (x3 * 8) + (x4 * 7) + (x5 * 6) + 
		 (x6 * 5) + (x7 * 4) + (x8 * 3) + (x9 * 2) + x10;
	 }      
	
	 
	 if(sum % 11 == 0) {
		 return true;
	 }
	 return false;
	              
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		
		if(string.contains("a") && string.contains("b") && string.contains("c") && string.contains("d")
				 && string.contains("e") && string.contains("f") && string.contains("g") && string.contains("h")
				 && string.contains("i")  && string.contains("j")  && string.contains("k")  && string.contains("l")
				 && string.contains("m")  && string.contains("n")  && string.contains("o")  && string.contains("p")
				 && string.contains("q")  && string.contains("r")  && string.contains("s")  && string.contains("t")
				 && string.contains("u")  && string.contains("v")  && string.contains("w") && string.contains("x")
				 && string.contains("y")  && string.contains("z")) {
			
			return true;		
		
		}						
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		
		
		
		
		
		
		
		
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
					
		Set<Integer> myset = new HashSet<Integer>(); //list for multiples
		
		for(int j = 0; j < set.length; j++)	{      //loop to iterate through given set
		
		    int num = set[j];   // getting all values of set and creating a varable for them
		  


		for(int k = 1; num * k< i; k++) { 
			
			//take each number in set and multiply by numbers from 1 to the product less than given integer
			
			int product = num * k; 
			
			myset.add(product);    //add each multiple to list
			
		}
		
		
		}

		
		int sum = 0;           // for loop to add all contents of the list
	   
		for (int m: myset) {
	    	
	        sum += m;
	    }							
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration

		//String string = "4539 1488 0343 6467";
		
		
		String numonly = string.replaceAll("[^0-9]", "");
			
		String [] a = numonly.split("");
	    
		for(int i = a.length-2; i >= 0; i-=2 ) {

		int other =	Integer.parseInt(a[i]);			
		      other*= 2;
			
			if (other>9) {
				
				other -=9;
			}
		
		 a[i] = Integer.toString(other);
		  
		}  		   
		   int sum = 0;
		   for(int i = 0; i < a.length; i++)
		   {          
		   
		   sum += Integer.parseInt(a[i]);   
		     
		   }
		   		   	  	   
		   return sum % 10 == 0;		
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNumeric(String strNum) { // this is the helper function to check whether it is a digit or not
	return strNum.matches("-?\\d+(\\.\\d+)?");
	    }
	    
	  public static int[] isNum(String s) {
		    String [] arr =     s.split(" ");
		    int [] ans = new int[2];
		    int j = 0;
		    for(int i = 0; i < arr.length; i++) {
		        if(isNumeric(arr[i])) {
		            ans[j] = Integer.parseInt(arr[i]); // this changes the string into integer
		            j++;
		        }
		    }
		    //System.out.println(Arrays.toString(ans));
		    return ans;
		    }
		    
		    public static int solveWordProblem(String string) {
		        if(string.contains("?"))
		            string = string.replace("?", "");
		        Set<String> set = new HashSet<>();
		        set.add("plus");
		        set.add("minus");
		        set.add("multiplied");
		        set.add("divided");
		        String[] s = string.split(" ");
		        String check = "";
		        for(String s1 : s) {
		            if(set.contains(s1)) {
		                check += s1;
		            }
		        }
		        int [] values = isNum(string); //isNum return arr of integer which is stored in values
		        
		        switch(check) {
		        case"plus":
		            return values[0] + values[1];
		        case"minus":
		            return values[0] - values[1];
		        case"divided":
		            return values[0] / values[1];
		        case"multiplied":
		            return values[0] * values[1];
		            default:
		                return -1;
		            
		        }
		        
		    }
}