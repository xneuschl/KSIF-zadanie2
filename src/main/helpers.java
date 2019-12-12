package main;

import java.util.*;

public class helpers {
	
/*TENTO KOD BOL PREVZATY ZO STACK-OVERFLOW*/	
	
	public int[] shuffleArray(int[] array)
	{
	    int index;
	    Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        if (index != i)
	        {
	            array[index] ^= array[i];
	            array[i] ^= array[index];
	            array[index] ^= array[i];
	        }
	    }
	    
	    return array;
	}
	
	public int[] shufflepart(int[] array, int n)
	{
	    int index;
	    Random random = new Random();
	    for (int i = (array.length - 1)/n; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        if (index != i)
	        {
	            array[index] ^= array[i];
	            array[i] ^= array[index];
	            array[index] ^= array[i];
	        }
	    }
	    
	    return array;
	}
	
	public String[] shuffleC(int[] arr, String[] input)
	{
		String[] string1 = new String[arr.length];
		int hlp;
		
		for(int i=0;i<arr.length;i++){
			hlp=arr[i];
			string1[i]=input[hlp-1];
		}
		
		return string1;
	}

}
