package main;
import java.util.*;
//import java.lang.Math;
import static java.lang.Math.abs;
import static java.lang.Math.ceil;

public class GA {
	

	public Member[] mutation(Member[] arr)
	{
		Random random = new Random(); helpers h = new helpers();
		int add1, add2, add3, add4, sz=arr.length;
		
		for(int i=0;i<sz;i++) {
		add1 = (random.nextInt())%10;
		add2 = (random.nextInt())%10;
		add3 = (random.nextInt())%2;
		add4 = (random.nextInt())%2;
		arr[i].rownum += add1; if(arr[i].rownum<1) {arr[i].rownum=1;}
		arr[i].colnum += add2; if(arr[i].colnum<1) {arr[i].colnum=1;}
		if(add3>0) {arr[i].w_sw=true;} else {arr[i].w_sw=false;}
		if(add4>0) {arr[i].r_sw=true;} else {arr[i].r_sw=false;}
		h.shufflepart(arr[i].shuffle, 3);
		}
		return arr;
	}
	
	public Member[] crossbreeding(Member[] arr) 
	{
		int sz=arr.length, cond, tmp;
		boolean hlp;
		Random random = new Random();
		
		for(int i=0;i<sz;i+=2){
			cond=random.nextInt(4)+1;
			
			if(cond==1) {}
			else if(cond==2) {}
			else if(cond==3) {}
			else if(cond==4) {}
		}
		
		return arr;
	}
	
	public double[] fitness(Member[] arr, String input){
		double[] result = new double[arr.length]; helpers h = new helpers();
		Matrix matrix1 = new Matrix();
		String[] strings = new String[arr.length], hlpstring;
		
		for(int i=0;i<arr.length;i++) {
		  hlpstring = matrix1.matrix_W(arr[i].rownum, arr[i].colnum, arr[i].w_sw, input);
		  //System.out.println(hlpstring[0]);
		  hlpstring=h.shuffleC(arr[i].shuffle, hlpstring);
		  strings[i]=matrix1.matrix_R(arr[i].rownum, arr[i].colnum, arr[i].r_sw, hlpstring, input.length());
		  System.out.println(strings[i]);
		}
		return result;
	}
	
	public Member create(double length)
	{
		Member member = new Member(); helpers h = new helpers();
		Random random = new Random();
		
		int add1;
		
		for(;;){
		add1 = random.nextInt((int)length)+1;
		if(length%add1 == 0) break;
		}
		int add2 = random.nextInt();
		int add3 = random.nextInt();
		
		if(add2>0){member.w_sw=true;}else{member.w_sw=false;}
		if(add3>0){member.r_sw=false;}else{member.r_sw=true;}
		
		//add1=abs(add1); add2=abs(add2);
		member.colnum=add1;
		double hlp=ceil(length/add1);
		member.rownum=(int)hlp;
		
		member.shuffle = new int[member.colnum]; for(int i=1;i<member.colnum +1;i++){member.shuffle[i-1]=i;}
		h.shuffleArray(member.shuffle);
		
		return member;
	}
	
	public Member recreate(double length, Member member)
	{
        Random random = new Random(); helpers h = new helpers();
		
        int add1;
		for(;;){
		add1 = random.nextInt((int)length)+1;
		if(length%add1 == 0) break;
		}
		int add2 = random.nextInt();
		int add3 = random.nextInt();
		
		if(add2>0){member.w_sw=true;}else{member.w_sw=false;}
		if(add3>0){member.r_sw=false;}else{member.r_sw=true;}
		
		//add1=abs(add1); add2=abs(add2);
		member.colnum=add1;
		double hlp=ceil(length/add1);
		member.rownum=(int)hlp;
		member.shuffle = new int[member.colnum]; for(int i=1;i<member.colnum +1;i++){member.shuffle[i-1]=i;}
		h.shuffleArray(member.shuffle);
		
		return member;
	}
	
	public void evolution(String input, double length, int iterations) 
	{
		Member[] pole=new Member[50], best = new Member[10], breed = new Member[20];
		double[] fitsub = new double[50];
		
		for(int i=0;i<50;i++){pole[i]=create(length);
		//pole=mutation(pole);
		System.out.println(pole[i].rownum+" ,"+pole[i].colnum+" ,"+pole[i].w_sw+" ,"+pole[i].r_sw);
		//System.out.println(pole[i].shuffle[0]);
		}
		
		fitsub = fitness(pole, input);
		int count = 0;
		while(count<iterations){
			for(int i=0;i<50;i++){pole[i]=recreate(length, pole[i]);}
			
			fitsub = fitness(pole, input);
			
			
			count++;
		}
	}
}
