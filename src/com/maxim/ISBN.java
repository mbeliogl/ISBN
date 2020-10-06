package com.maxim;

import java.util.Scanner;


public class ISBN
{
    public static void main(String [] args)
    {
	Scanner input = new Scanner(System.in);
	String ISBN;
	System.out.println("Please Enter The ISBN : ");
	ISBN = input.next();
	int length = ISBN.length();

	while(length != 9 && length != 12)
	    {
		System.out.println("Please Input a Valid ISBN : "); 
		ISBN = input.next();
		// reset the ISBN length
		length = ISBN.length();

	    }
	// if length is 9, call isbn10
	if(length == 9)
	    {
		System.out.println(isbn10(ISBN));
	    }
	// if length is 12, call isbn12
	if(length == 12)
	    {
		System.out.println(isbn13(ISBN));	
	    }
    }


    public static String isbn10(String ISBN)
    {
	String nums = ISBN;
	int sumOf9 = 0;
	for(int i = 0; i < 9; i++)
	    {
		String num = nums.substring(i, i + 1);
		// updating sumOf9
		sumOf9 = sumOf9 + ((i+1)* Integer.valueOf(num));
	    }
	// finish the calculation (mod method)
	int num10 = sumOf9 % 11;
	if (num10 == 10)
	    {
		return "X";
	    }
	// return the 10th digit
	return Integer.toString(num10);
    }


    public static String isbn13(String ISBN)
    {
	String nums = ISBN; 
	long sumOf12 = 0;
	for(int i = 0; i < 12; i++)
	    {
		String num = nums.substring(i, i + 1);
		
		long val = Long.valueOf(num);
		// appropriate computation according to whether the position of the character in the string is even or odd
		if (i % 2 == 0)
		    {
			sumOf12 = sumOf12 + ((val)*1);
		    }
		else
		    {
			sumOf12 = sumOf12 + ((val)*3);
		    }

		
	    }
	// combine the two and finish the calculation
	long num12 = 10 - (sumOf12 % 10);

	if (num12 == 10)
	    {
		return "0";
	    }
	// return the 13th value
	return Long.toString(num12);	
    }
    
}
