package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mordor 
{
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine());
		for(int i=0;i<testcase;i++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int N,Q;
			N=Integer.parseInt(st.nextToken());
			Q=Integer.parseInt(st.nextToken());
			int [] h=new int[N];
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
				h[j]=Integer.parseInt(st.nextToken());
			for(int j=0;j<Q;j++)
			{
				st=new StringTokenizer(br.readLine()," ");
				int a,b;
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				int max=0,min=20000;
				for(int k=a;k<=b;k++)
				{
					if(h[k]>max)		max=h[k];
					if(h[k]<min)		min=h[k];
				}
				System.out.println(max-min);
			}
			
		}
	}
}
