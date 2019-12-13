package main;

import java.util.Scanner;

//import java.lang.Object;

public class BFA {
	
	public Member2[] create(int length, String input) 
	{
		Member2[] member = new Member2[4]; 
		
		for(int i=0;i<4;i++){member[i]=new Member2(); member[i].input=input; member[i].length=input.length();}
		member[0].w_sw=true;member[1].w_sw=true;member[2].w_sw=false;member[3].w_sw=false;
		member[0].r_sw=true;member[1].r_sw=false;member[2].r_sw=true;member[3].r_sw=false;
		
		return member;
	}
	
	public static void rewrite(Member2 obj) 
	{
		Matrix matrix1 = new Matrix();
		String[] hlpstring; String string, comp="KRYPTOGRAFIA"; helpers h = new helpers();
		
		hlpstring = matrix1.matrix_W(obj.rownum, obj.colnum, obj.w_sw, obj.input);
		hlpstring=h.shuffleC(obj.shuffle, hlpstring);
		string=matrix1.matrix_R(obj.rownum, obj.colnum, obj.r_sw, hlpstring, obj.length);
		System.out.println(string); if(string.equals(comp)) {Scanner scan1 = new Scanner(System.in);scan1.nextLine();}
		return;
	}

	
	private static void permuteHelper(Member2 obj, int[] arr, int index){
	    if(index >= arr.length - 1){ //If we are at the last element - nothing left to permute
	        //System.out.println(Arrays.toString(arr));
	        //Print the array
	        //System.out.print("[");
	        for(int i = 0; i < arr.length; i++){
	            //System.out.print(arr[i] + ", ");
	        	obj.shuffle[i]=arr[i];
	        }
	       // if(arr.length > 0) 
	         //   System.out.print(arr[arr.length - 1]);
	        //System.out.println("]");
	        rewrite(obj);
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
	
	public static void permute(Member2 obj, int[] arr){
		//int[][] var = new int[24][4];
	    permuteHelper(obj, arr, 0);
	}
	
	
	
	public void basic(String input) 
	{
		int length=input.length();
		Member2[] member = create(length, input);
		int[] array;
		
		for(int i=1;i<length;i++){
			if((length % i) == 0){
				member[0].colnum=i;member[1].colnum=i;member[2].colnum=i;member[3].colnum=i;
				member[0].rownum=length/i;member[1].rownum=length/i;member[2].rownum=length/i;member[3].rownum=length/i;
			
			
			array = new int[i]; for(int y=1;y<i+1;y++){array[y-1]=y;}
			member[0].shuffle=new int[i]; member[1].shuffle=new int[i]; member[2].shuffle=new int[i]; member[3].shuffle=new int[i];
			
			System.out.println("Pocet stlpcov:"+i);
			System.out.println("T,T:"); permute(member[0], array);
			System.out.println("T,F:"); permute(member[1], array);
			System.out.println("F,T:"); permute(member[2], array);
			System.out.println("F,F:"); permute(member[3], array);
			}
		}
	}
}
