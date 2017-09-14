package algospot;

import java.util.Scanner;

public class fibonacci 
{
   public static void main(String[] args)
   {   
      Scanner scanner=new Scanner(System.in);
      int input;
      input=scanner.nextInt();
      for(int i=0;i<input;i++)//for-loop number of testcases
      {
         int[][] cache=new int[1000][2];
         cache[0][0]=1;
         cache[0][1]=0;
         cache[1][0]=0;
         cache[1][1]=1;
         
         int fibo_input=scanner.nextInt();
         if(fibo_input<=1)
         {
            System.out.println(cache[fibo_input][0]+" "+cache[fibo_input][1]);
         }
         else
         {
            for(int j=2;j<fibo_input;j++)
            {
               cache[j][0]=cache[j-1][0]+cache[j-2][0];
               cache[j][1]=cache[j-1][1]+cache[j-2][1];
            }
            cache[fibo_input][0]=cache[fibo_input-1][0]+cache[fibo_input-2][0];
            cache[fibo_input][1]=cache[fibo_input-1][1]+cache[fibo_input-2][1];
            System.out.println(cache[fibo_input][0]+" "+cache[fibo_input][1]);
         }
         
      }
      scanner.close();
   }
}
