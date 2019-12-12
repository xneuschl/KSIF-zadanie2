package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan1 = new Scanner(System.in);
        String input = scan1.nextLine();
        int len = input.length();
        int rownum, colnum;
        boolean w_sw, r_sw;
        
        Matrix tst1 = new Matrix();
        GA ga1=new GA();
        ga1.evolution(input, len, 10);
        //String[] matrix = tst1.matrix_W(3,6,true,input);
        //for(int i=0;i<6;i++)
        	//System.out.println(matrix[i]);
        //String string2=tst1.matrix_R(3,6,false,matrix,len);
        
        //System.out.println(string2);
        
	/*	String string = new String();
		string="aaa";
		char b= 'b';
		string=string+b;
		System.out.println(string);*/
        
	}

}
