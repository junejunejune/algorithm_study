package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class insertion 
{
	static int[] input;
	static int[] answer;
	static ArrayList<Integer> nums;
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine());
		for(int i=0;i<testcase;i++)
		{
			int N=Integer.parseInt(br.readLine());
			input=new int[N];
			answer=new int[N];
			nums=new ArrayList<Integer>();
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{	input[j]=Integer.parseInt(st.nextToken());	//get input	
				nums.add(j+1);	//make arraylist from 1 to N
			}
			for(int j=N-1;j>=0;j--)
			{
				int k=nums.size()-input[j]-1;
				int temp=nums.get(k);
				answer[j]=temp;
				nums.remove(k);
			}
			for(int j=0;j<N;j++)
				System.out.print(answer[j]+" ");
		}
	}

}
