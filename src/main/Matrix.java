package main;

//import java.util.*;

public class Matrix {
	
	public String[] matrix_W(int rownum, int colnum, boolean r_c, String input) 
	{
		String[] matrix = new String[colnum]; for(int i=0;i<colnum;i++) {matrix[i]="";}
		int x=0, count=0, lngt=input.length();
		
		if(r_c==true){ //zapisovanie po riadkoch
			while(count<lngt){
				if(x==colnum) {x=0;}
				matrix[x]+=input.charAt(count);
				count++;x++;
			}
		}
		else{
			int cnt=0;
			while(count<lngt){ //zapisovanie po stlpcoch
				if(x>colnum){break;}
				matrix[x]= matrix[x]+input.charAt(count);
				count++;cnt++;
				if(cnt==rownum) {x++;cnt=0;}
			}
			
		}
		
		int ln=matrix[0].length();
		for(int i=1;i<colnum;i++)
		{
			if(matrix[i].length()<ln) 
			{
				int hlp1=ln-matrix[i].length();
				for(int i2=0;i2<hlp1;i2++) 
				{
					matrix[i]=matrix[i]+'x';
				}
			}
		}
		//System.out.println(matrix[1]);
		
		return matrix;
	}
	
	public String matrix_R(int rownum, int colnum, boolean r_c, String[] input, int length) 
	{
		String result = "";
		int x=0, y=0, count=0;
		
		if(r_c==true){
			while(count<length){    //citanie po riadkoch
				if(y>rownum){break;}
				if(x==colnum){x=0;y++;}
				//if(y>input[x].length()){x++;continue;}
				result+=input[x].charAt(y);
				x++;count++;
			}
		}
		else{
			while(count<length){   //citanie po stlpcoch
				if(y==rownum){y=0;x++;}
				//if(y>input[x].length()){}
				result+=input[x].charAt(y);
				y++;count++;
			}
		}
		
		return result;
		
	}

}
