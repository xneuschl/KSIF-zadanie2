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
	
	private static void permuteHelper(Member obj, int[] arr, int index){
	    if(index >= arr.length - 1){ //If we are at the last element - nothing left to permute
	        //System.out.println(Arrays.toString(arr));
	        //Print the array
	        System.out.print("[");
	        for(int i = 0; i < arr.length - 1; i++){
	            //System.out.print(arr[i] + ", ");
	        }
	        if(arr.length > 0) 
	            System.out.print(arr[arr.length - 1]);
	        System.out.println("]");
	        return;
	    }

	    for(int i = index; i < arr.length; i++){ //For each index in the sub array arr[index...end]

	        //Swap the elements at indices index and i
	        int t = arr[index];
	        arr[index] = arr[i];
	        arr[i] = t;

	        //Recurse on the sub array arr[index+1...end]
	        permuteHelper(obj, arr, index+1);

	        //Swap the elements back
	        t = arr[index];
	        arr[index] = arr[i];
	        arr[i] = t;
	    }
	}
	
	public static void permute(Member obj, int[] arr){
		//int[][] var = new int[24][4];
	    permuteHelper(obj, arr, 0);
	}

}
