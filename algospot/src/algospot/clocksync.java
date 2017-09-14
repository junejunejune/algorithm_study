package algospot;

import java.util.*;
public class clocksync 
{
   static int[][] sw={{0,1,2},{3,7,9,11},{4,10,14,15},{0,4,5,6,7},{6,7,8,10,12},{0,2,14,15},{3,14,15},{4,5,7,14,15},{1,2,3,4,5},{3,4,5,9,13}};
   
   static void push(int clock[],int swtch)
   {
      int linkedClocksNum=sw[swtch].length;
      for(int k=0;k<linkedClocksNum;k++)
      {
         clock[sw[swtch][k]]+=3;
         if(clock[sw[swtch][k]]==15)
            clock[sw[swtch][k]]=3;
      }   
   }
   
   static boolean areAligned(int clock[])
   {
      int flag=0;//if all clocks are at 12
      for(int j=0;j<16;j++)
      {
         if(clock[j]!=12)
         {   flag=1;
            break;
         }
      }
      if(flag==0)
         return true;
      else 
         return false;
   }
   
   static int solve(int clock[],int swtch)
   {   
      if(swtch==10)
         return areAligned(clock) ? 0:31;
      if(areAligned(clock))
         return 0;
      
      int ret=31;
      for(int r=0;r<4;++r)
      {      
         ret=Math.min(ret, r+solve(clock,swtch+1));
         push(clock,swtch);
      }
      return ret;
   }
   
   public static void main(String[] args)
   {   
      Scanner scanner=new Scanner(System.in);
      int input;
      input=scanner.nextInt();
      int clock[]=new int[16];
      for(int i=0;i<input;i++)//for-loop number of testcases
      {   
         for(int j=0;j<16;j++)
         {
            clock[j]=scanner.nextInt();//set time for every clock input
         }
         
         int result;
         result=solve(clock,0);
         if(result>30)
            System.out.println(-1);
         else
            System.out.println(result);
      }      
      scanner.close();
   }
}