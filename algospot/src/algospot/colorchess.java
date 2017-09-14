package algospot;

import java.util.Scanner;

public class colorchess 
{
   public static void main(String[] args) 
   {
      Scanner scanner=new Scanner(System.in);
      int row,column;
      row=scanner.nextInt();
      column=scanner.nextInt();
      
      char[][] white=new char[][]{{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}};
      char[][] black=new char[][]{{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}};
      
      char[][] input=new char[50][50];
      int a=0,b;
      String temp;
      for(a=0;a<=row;a++)
      {
         temp=scanner.nextLine();
         if(!temp.isEmpty())
         {
            for(b=0;b<column;b++)
            {
            
               input[a-1][b]=temp.charAt(b);
               //System.out.print(input[a][b]);
            }
            //System.out.println();
         }
      }

      int q,k,i,j,wht_cnt=0,blk_cnt=0,min_cnt=64,cnt=0;
      for(q=0;q<row-8+1;q++)
      {
         for(k=0;k<column-8+1;k++)
         {   wht_cnt=0;
            blk_cnt=0;
            for(i=q;i<q+8;i++)            
            {
               for(j=k;j<k+8;j++)
               {
                  if(input[i][j]!=white[i-q][j-k])
                  {
                     wht_cnt++;
                  }
                  if(input[i][j]!=black[i-q][j-k])
                  {
                     blk_cnt++;
                  }
               }
            }
            cnt=(Math.min(wht_cnt, blk_cnt));
            if(cnt<min_cnt)
               min_cnt=cnt;
         }
      }
      System.out.println(min_cnt);
      scanner.close();
   }

}