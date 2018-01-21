package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TSP
{
	static int[][]G;
	static int N;
	static int dp[][];
	static int inf=Integer.MAX_VALUE;
	static int solve(int visit, int now)
	{
		visit |= (1<<now);//add city(now) to visit
		
		if(visit == (1<<N)-1)//if all cities are visited
		{
			if(G[now][0]>0)//if there exist way back to the start point
				return G[now][0];
			return Integer.MAX_VALUE;
		}
		int ret=dp[visit][now];
		if(ret>0)	return ret;
		dp[visit][now]=Integer.MAX_VALUE;
		for(int i=0;i<N;i++)
		{
			if(i != now && (visit &(1<<i))==0 && G[now][i]>0)//if path to ith city exists, and it is not yet visited
			{
				int temp=solve(visit,i)+G[now][i];
				if(dp[visit][now]>temp)	
					dp[visit][now]=temp;
			}
		}
		return dp[visit][now];
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new int[1<<N][N];
		for(int[] row:dp)
			Arrays.fill(row, 0);
		G=new int[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
				G[i][j]=Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(0,0));
	}
}
