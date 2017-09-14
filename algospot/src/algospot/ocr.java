package algospot;

import java.util.Scanner;

public class ocr 
{
	static String[] words=new String[100];
	static double[] first_possi=new double[100];
	static double[][] next_possi=new double[501][501];
	static double[][] wrong_possi=new double[501][501];
	
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int 	word_num,sent_num;
		word_num=scanner.nextInt();
		sent_num=scanner.nextInt();
		
		for(int a=0;a<word_num;a++)
		{
			words[a]=scanner.next();
		}
		
		for(int a=0;a<word_num;a++)
		{
			first_possi[a]=scanner.nextDouble();
		}
		
		for(int a=0;a<word_num;a++)
		{
			for(int b=0;b<word_num;b++)
			{
				next_possi[a][b]=scanner.nextDouble();
			}
		}
		
		for(int a=0;a<word_num;a++)
		{
			for(int b=0;b<word_num;b++)
			{
				wrong_possi[a][b]=scanner.nextDouble();
			}
		}
		
		for(int j=0;j<sent_num;j++)//result of classifier
		{
			
			int leng;
			leng=scanner.nextInt();
			String[] result=new String[leng];
			for(int c=0;c<leng;c++)
			{
				result[c]=scanner.next();
			}
			
			double ori_ocr=0.0;//calculate original score of ocr
			for(int c=0;c<leng;c++)
			{
				if(c==0)//the first word
				{
					for(int d=0;d<word_num;d++)
					{
						if(result[0].equals(words[d]))
						{
							ori_ocr+=first_possi[d];
							break;
						}
					}
				}
				else//rest
				{
					int prev=0,curr=0;
					for(int d=0;d<word_num;d++)
					{
						if(result[c-1].equals(words[d]))
						{
							prev=d;
						}	
						if(result[c].equals(words[d]))
						{
							curr=d;
						}	
					}
					ori_ocr+=next_possi[prev][curr];	
				}
			}
			
			
		}
		
		scanner.close();
	}
}
