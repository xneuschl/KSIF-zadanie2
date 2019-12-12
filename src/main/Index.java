package main;
//import java.util.*;

public class Index {

	public void indexOfC(String text)
    {
      int[] letters = new int[26];
      char c;
      int hlp1=0;
      double count=0, dcount=0;
      double ic;
      for(int i=0;i<26;i++){
        letters[i]=0;
      }
      //System.out.println("LETTERS-A:"+letters[0]);
      int lngt=text.length();
      
      for(int i=0;i<lngt;i++)
      {
        c=text.charAt(i);
        hlp1=c-65;
        //System.out.println(hlp1);
        letters[hlp1]+=1;
      }
      //System.out.println("LETTERS-A:"+letters[5]);
      
      for(int i=0;i<26;i++){
        if(letters[i]>1){
          hlp1=letters[i];
          //count+=hlp1;
          dcount+=hlp1*(hlp1-1);
        }
      }
      //System.out.println(count+"..."+dcount);
      count=lngt*(lngt-1);
      //System.out.println(count+"..."+dcount);
      ic=dcount/count;
      System.out.println(ic);
    }
}
