package algospot;

import java.util.Scanner;
public class Morse 
{
   static char[] code(int lng,int sht, long kth_sig)
   {
      long curr=kth_sig;
      long ways=1,newways=1;
      int lng_sig=lng,sht_sig=sht;
      char[] temp=new char[lng+sht];
         
      for(int n=lng_sig+sht_sig;n>lng_sig;n--)
      {
         ways*=n;
      }
      for(int n=1;n<sht_sig+1;n++)
      {
         ways/=n;
      }
      
      //calculate factorial
      //System.out.println("ways:"+ways);
      int m;
      for(m=0;m<lng+sht;m++)
      {
         if(lng_sig==0||sht_sig==0)
         {
            break;
         }
         if(lng_sig==1)
         {
            newways=1;
         }
         else
         {
            newways=1;
            for(int n=lng_sig+sht_sig-1;n>lng_sig-1;n--)
            {
               newways*=n;
            }
            for(int n=1;n<sht_sig+1;n++)
            {
               newways/=n;
            }
         }
         
         if(curr<=newways)
         {
            temp[m]='-';
            lng_sig--;
         }
         else
         {   temp[m]='o';
            sht_sig--;
            
            curr=curr-newways;
            newways=ways-newways;
            ways=newways;
         }
      }
      for(int r=m;r<lng+sht;r++)
      {
         if(lng_sig==0)
         {
            temp[r]='o';
         }
         else
         {
            temp[r]='-';
         }
      }
      return temp;
      
   }
   
   public static void main(String[] args)
   {   
      Scanner scanner=new Scanner(System.in);
      int input;
      input=scanner.nextInt();
      for(int i=0;i<input;i++)//for-loop number of testcases
      {
         int lng,sht;
         long kth_sig;
         lng=scanner.nextInt();
         sht=scanner.nextInt();
         kth_sig=scanner.nextLong();
         
         if(lng==0)
         {
            for(int a=0;a<sht;a++)
            {
               System.out.print('o');
            }
            System.out.println();
         }
         if(sht==0)
         {
            for(int a=0;a<lng;a++)
            {
               System.out.print('-');
            }
            System.out.println();
         }
         else
            System.out.println(code(lng,sht,kth_sig));   
      }
      scanner.close();
   }
}