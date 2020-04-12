/*
 *Java program to encrypt and decrypt a phrase using two similar approaches
 *each insecure by modern standards.
 *The first approach is called the Caesar Cipher, and is a simple “substitution cipher” 
 *where characters in a message are replaced by a substitute character.
 *The second approach, due to Giovan Battista Bellaso (b 1505, d 1581), 
 *uses a key word, where each character in the word specifies the offset 
 *for the corresponding character in the message, with the key word 
 *wrapping around as needed.  
 * Programmer name: Odalis Flores
 * CMSC 203, CRN: 30503
 * Assignment 3
 * Due date: 03/26/2020
 */

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		for (int i =0; i< plainText.length();i++) {
			if (plainText.charAt(i)<LOWER_BOUND || plainText.charAt(i)>UPPER_BOUND)
				return false;
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		//if statement to compare the key entered by user to UPPER_BOUND
		if(key>UPPER_BOUND)
		{
			//nested do-while statement that will keep subtraction RANGE from key as long at key is greater than UPPER_BOUND
			do {key-=RANGE;}
			while(key>UPPER_BOUND);
			//if key is larger than range then subtract range from key
			key=key-RANGE;
		}
		//create new instance for char array to hold array size of plainText length
		char[] stringArr = new char [plainText.length()];
		//for loop that goes through all the characters in the string plainText
		for (int i=0; i <plainText.length();i++) {
			//initialize stringArr at index i to plainText character at index i plus key
			stringArr[i]=(char)(plainText.charAt(i)+key);
			//if statement to test range, if stringArr at index i is larger than UPPER_BOUND subtract it by range
			if(stringArr[i]>UPPER_BOUND)
				stringArr[i]-=RANGE;
			//if statement to test range, if stringArr at index i is smaller than LOWER_BOUND add it by range
			if(stringArr[i]<LOWER_BOUND)
				stringArr[i]+=RANGE;
		}
		//create new instance for string variable encryptString to hold concatenate stringArr
		String encryptString = new String(stringArr);
		//return encryptString
		return encryptString;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		//while loop to test if plainText length is larger than bellasoStr length
		while(plainText.length()>bellasoStr.length()) {
			//if true increment bellasoStr by itself
			bellasoStr+=bellasoStr;
		}
		//create new instance for char array plainTextArr to hold array with plainText length
		char[]plainTextArr= new char[plainText.length()];
		//create for loop to analyze all values of plainText string
		for (int i = 0; i < plainText.length();i++) {
			//initialize plainTextArr at index i to char type plainText character at index i plus 
			//bellasoStr character at index i minus RANGE
			plainTextArr[i]=(char) (plainText.charAt(i)+bellasoStr.charAt(i)-RANGE);
			//if plainTextArr is larger than UPPER_BOUND, initialize plainTextArr to itself minus RANGE
			if(plainTextArr[i]>UPPER_BOUND)
				plainTextArr[i]-=RANGE;
			//if plainTextArr is less than LOWER_BOUND, initialize plainTextArr to itself plus RANGE
			if(plainTextArr[i]<LOWER_BOUND)
				plainTextArr[i]+=RANGE;
		}
		//declare string instance encryptString and initialize to concatenate stringArr
		String encryptString = new String(plainTextArr);
		//return encryptString
		return encryptString;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		
		//if key is larger than UPPER_BOUND
		if(key>UPPER_BOUND)
		{
			//subtract key by range while key is larger than UPPER_BOUND
			do {
				key-=RANGE;
			}
			while(key>UPPER_BOUND);
			//if key is greater than RANGE
			if(key>RANGE)
				//subtract key by range and initialize to key
				key= key-RANGE;
		}
		//create new char array instance  for stringArr of encryotedText length
		char[] stringArr = new char [encryptedText.length()];
		//for loop to analyze all values of encryptedText string
		for (int i=0; i <encryptedText.length();i++) {
			//initialize stringArr at index i to character type encryptedText at character index i minus key
			stringArr[i]=(char)(encryptedText.charAt(i)-key);
			//if stringArr at index i is greater than UPPER_BOUND
			if(stringArr[i]>UPPER_BOUND)
				//subtract stringArr at index i by RANGE and initialize to itself
				stringArr[i]-=RANGE;
			//if stringArr at index i is less than LOWER_BOUND
			if(stringArr[i]<LOWER_BOUND)
				//add stringArr at index i plus RANGE and initialize to itself
				stringArr[i]+=RANGE;
		}
		//create new string instance decryptString and initialize to concatenate stringArr
		String decryptString = new String(stringArr);
		//return decryptString
		return decryptString;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//while loop to test if plainText length is larger than bellasoStr length
		while(encryptedText.length()>bellasoStr.length()) {
			//if true increment bellasoStr by itself
			bellasoStr+=bellasoStr;
		}
		//declare array of type character
		char[]encryptedTextArr, bellasoStrArr;
		//convert encryptedText to array and initialize to encryptedTextArr
		encryptedTextArr= encryptedText.toCharArray();
		//convert bellasoStr to array and initialize to bellasoStrArr
		bellasoStrArr=bellasoStr.toCharArray();
		//for loop to analyze all values in string encryptedTextArr
		for (int i = 0; i < encryptedTextArr.length;i++) {
			//initialize encryptedTextArr to character type encryptedTextArr at index i
			//plus range minus bellasoStrArr at index i
			encryptedTextArr[i]=(char)((encryptedTextArr[i]+RANGE)-bellasoStrArr[i]);
			//if encryptedTextArr at index i is larger than UPPER_BOUND
			if(encryptedTextArr[i]>UPPER_BOUND)
				//decrement encrytedText by range
				encryptedTextArr[i]-=RANGE;
			//if encryptedTextArr at index i is less than UPPER_BOUND
			if(encryptedTextArr[i]<LOWER_BOUND)
				//increment encrytedText by range
				encryptedTextArr[i]+=RANGE;
		}
		//declare string instance decryptString and initialize to concatenate encryptedTextArr
		String decryptString = new String(encryptedTextArr);
		//return decryptString
		return decryptString;
	}
}
