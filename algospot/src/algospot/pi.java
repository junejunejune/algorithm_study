package algospot;

import java.util.Scanner;

public class pi 
{
   static int difficulty(int start,int len)
   {
      //1
      
      //2
      
      //4
      
      //5
      
      //10
      
   }
   static int cut_pi(String s, int index)
   {
      int leng=s.length();
      
      if(leng-index<6)//last partition
      {
         if(leng-index==3)
         {
            if(s.charAt(index)==s.charAt(index+1)&&s.charAt(index+1)==s.charAt(index+2))
               return 1;
            else if(s.charAt(index+1)-s.charAt(index)==1&&s.charAt(index+2)-s.charAt(index+1)==1)
               return 2;
            else if(s.charAt(index+1)-s.charAt(index)==-1&&s.charAt(index+2)-s.charAt(index+1)==-1)
               return 2;
            else if(s.charAt(index+2)==s.charAt(index))
               return 4;
            else if(s.charAt(index+1)-s.charAt(index)==s.charAt(index+2)-s.charAt(index+1))
               return 5;
            else
               return 10;
            
         }
         else if(leng-index==4)
         {
            if(s.charAt(index)==s.charAt(index+1)&&s.charAt(index+1)==s.charAt(index+2)&&s.charAt(index+2)==s.charAt(index+3))
               return 1;
            else if(s.charAt(index+1)-s.charAt(index)==1&&s.charAt(index+2)-s.charAt(index+1)==1&&s.charAt(index+3)-s.charAt(index+2)==1)
               return 2;
            else if(s.charAt(index+1)-s.charAt(index)==-1&&s.charAt(index+2)-s.charAt(index+1)==-1&&s.charAt(index+3)-s.charAt(index+2)==-1)
               return 2;
            else if(s.charAt(index+2)==s.charAt(index)&&s.charAt(index+3)==s.charAt(index+1))
               return 4;
            else if(s.charAt(index+1)-s.charAt(index)==s.charAt(index+2)-s.charAt(index+1)&&s.charAt(index+1)-s.charAt(index)==s.charAt(index+3)-s.charAt(index+2))
               return 5;
            else
               return 10;
         }
         else if(leng-index==5)
         {
            if(s.charAt(index)==s.charAt(index+1)&&s.charAt(index+1)==s.charAt(index+2)&&s.charAt(index+2)==s.charAt(index+3)&&s.charAt(index+3)==s.charAt(index+4))
               return 1;
            else if(s.charAt(index+1)-s.charAt(index)==1&&s.charAt(index+2)-s.charAt(index+1)==1&&s.charAt(index+3)-s.charAt(index+2)==1&&s.charAt(index+4)-s.charAt(index+3)==1)
               return 2;
            else if(s.charAt(index+1)-s.charAt(index)==-1&&s.charAt(index+2)-s.charAt(index+1)==-1&&s.charAt(index+3)-s.charAt(index+2)==-1&&s.charAt(index+4)-s.charAt(index+3)==-1)
               return 2;
            else if(s.charAt(index+2)==s.charAt(index)&&s.charAt(index+3)==s.charAt(index+1)&&s.charAt(index+2)==s.charAt(index+4))
               return 4;
            else if(s.charAt(index+1)-s.charAt(index)==s.charAt(index+2)-s.charAt(index+1)&&s.charAt(index+1)-s.charAt(index)==s.charAt(index+3)-s.charAt(index+2)&&s.charAt(index+1)-s.charAt(index)==s.charAt(index+4)-s.charAt(index+3))
               return 5;
            else
               return 10;
         }
         return 0;
      }   
      else
      {
         int ret3=0,ret4=0,ret5=0;
         int result;
         result=
      }
   }
   
/*   static int cut_pi(String s, int index)
   {
      int leng=s.length();
      
      if(leng-index<6)//last partition
      {
         if(leng-index==3)
         {
            if(s.charAt(index)==s.charAt(index+1)&&s.charAt(index+1)==s.charAt(index+2))
               return 1;
            else if(s.charAt(index+1)-s.charAt(index)==1&&s.charAt(index+2)-s.charAt(index+1)==1)
               return 2;
            else if(s.charAt(index+1)-s.charAt(index)==-1&&s.charAt(index+2)-s.charAt(index+1)==-1)
               return 2;
            else if(s.charAt(index+2)==s.charAt(index))
               return 4;
            else if(s.charAt(index+1)-s.charAt(index)==s.charAt(index+2)-s.charAt(index+1))
               return 5;
            else
               return 10;
            
         }
         else if(leng-index==4)
         {
            if(s.charAt(index)==s.charAt(index+1)&&s.charAt(index+1)==s.charAt(index+2)&&s.charAt(index+2)==s.charAt(index+3))
               return 1;
            else if(s.charAt(index+1)-s.charAt(index)==1&&s.charAt(index+2)-s.charAt(index+1)==1&&s.charAt(index+3)-s.charAt(index+2)==1)
               return 2;
            else if(s.charAt(index+1)-s.charAt(index)==-1&&s.charAt(index+2)-s.charAt(index+1)==-1&&s.charAt(index+3)-s.charAt(index+2)==-1)
               return 2;
            else if(s.charAt(index+2)==s.charAt(index)&&s.charAt(index+3)==s.charAt(index+1))
               return 4;
            else if(s.charAt(index+1)-s.charAt(index)==s.charAt(index+2)-s.charAt(index+1)&&s.charAt(index+1)-s.charAt(index)==s.charAt(index+3)-s.charAt(index+2))
               return 5;
            else
               return 10;
         }
         else if(leng-index==5)
         {
            if(s.charAt(index)==s.charAt(index+1)&&s.charAt(index+1)==s.charAt(index+2)&&s.charAt(index+2)==s.charAt(index+3)&&s.charAt(index+3)==s.charAt(index+4))
               return 1;
            else if(s.charAt(index+1)-s.charAt(index)==1&&s.charAt(index+2)-s.charAt(index+1)==1&&s.charAt(index+3)-s.charAt(index+2)==1&&s.charAt(index+4)-s.charAt(index+3)==1)
               return 2;
            else if(s.charAt(index+1)-s.charAt(index)==-1&&s.charAt(index+2)-s.charAt(index+1)==-1&&s.charAt(index+3)-s.charAt(index+2)==-1&&s.charAt(index+4)-s.charAt(index+3)==-1)
               return 2;
            else if(s.charAt(index+2)==s.charAt(index)&&s.charAt(index+3)==s.charAt(index+1)&&s.charAt(index+2)==s.charAt(index+4))
               return 4;
            else if(s.charAt(index+1)-s.charAt(index)==s.charAt(index+2)-s.charAt(index+1)&&s.charAt(index+1)-s.charAt(index)==s.charAt(index+3)-s.charAt(index+2)&&s.charAt(index+1)-s.charAt(index)==s.charAt(index+4)-s.charAt(index+3))
               return 5;
            else
               return 10;
         }
         return 0;
      }
   
      else
      {
         int ret3=0,ret4=0,ret5=0;
         if(s.charAt(index)==s.charAt(index+1)&&s.charAt(index+1)==s.charAt(index+2))
         {
            ret3=1+cut_pi(s,index+3);
            if(s.charAt(index+2)==s.charAt(index+3))
            {
               ret4=1+cut_pi(s,index+4);
               if(s.charAt(index+3)==s.charAt(index+4))
                  ret5=1+cut_pi(s,index+5);
            }   
         }
         else if(s.charAt(index+1)-s.charAt(index)==1&&s.charAt(index+2)-s.charAt(index+1)==1)
         {
            ret3=2+cut_pi(s,index+3);
            if(s.charAt(index+3)-s.charAt(index+2)==1)
            {
               ret4=2+cut_pi(s,index+4);
               if(s.charAt(index+4)-s.charAt(index+3)==1)
                  ret5=2+cut_pi(s,index+5);
            }
         }
         else if(s.charAt(index+1)-s.charAt(index)==-1&&s.charAt(index+2)-s.charAt(index+1)==-1)
         {
            ret3=2+cut_pi(s,index+3);
            if(s.charAt(index+3)-s.charAt(index+2)==-1)
            {
               ret4=2+cut_pi(s,index+4);
               if(s.charAt(index+4)-s.charAt(index+3)==-1)
                  ret5=2+cut_pi(s,index+5);
            }
               
         }
         else if(s.charAt(index+2)==s.charAt(index))
         {
            ret3=4+cut_pi(s,index+3);
            if(s.charAt(index+3)==s.charAt(index+1))
            {
               ret4=4+cut_pi(s,index+4);
               if(s.charAt(index+2)==s.charAt(index+4))
                  ret5=4+cut_pi(s,index+5);
            }
         }
         else if(s.charAt(index+1)-s.charAt(index)==s.charAt(index+2)-s.charAt(index+1))
         {
            ret3=5+cut_pi(s,index+3);
            if(s.charAt(index+1)-s.charAt(index)==s.charAt(index+3)-s.charAt(index+2))
            {
               ret4=5+cut_pi(s,index+4);
               if(s.charAt(index+1)-s.charAt(index)==s.charAt(index+4)-s.charAt(index+3))
                  ret5=5+cut_pi(s,index+5);
            }
         }
         if(ret3==0)
            ret3=10+cut_pi(s,index+3);
         if(ret4==0)
            ret4=10+cut_pi(s,index+4);
         if(ret5==0)
            ret5=10+cut_pi(s,index+5);
         
         return Math.min(ret3, Math.min(ret4, ret5));
      }
   }
   */
   public static void main(String[] args)
   {   
      Scanner scanner=new Scanner(System.in);
      int input;
      String temp;
      temp=scanner.nextLine();
      input=temp.charAt(0);
      String nums;
      for(int i=0;i<input;i++)//for-loop number of testcases
      {
         nums=scanner.nextLine();
         int total;
         total=cut_pi(nums,0);
         System.out.println(total);
      }
      scanner.close();
   }
}