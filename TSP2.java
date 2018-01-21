package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSP2_baekjoon {
	static int[][]G;
	static int N;
	static boolean[] check;
	static int min_dis;
	static void dfs(int start, int k, int sum, int cnt)
	{
		if(cnt==N && start==k)//ending condition
		{
			if(sum<min_dis)//update minimum distance
				min_dis=sum;
			return;
		}
		for(int x=0;x<N;x++)
		{
			if(G[k][x]==0)	continue;
			if(check[k]==false && G[k][x] >0)
			{
				check[k]=true;
				sum+=G[k][x];
				if(sum<=min_dis)
					dfs(start,x,sum,cnt+1);
				
				check[k]=false;//undo
				sum-=G[k][x];
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		G=new int[N][N];
		check=new boolean[N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
				G[i][j]=Integer.parseInt(st.nextToken());
		}
		min_dis=Integer.MAX_VALUE;
		for(int k=0;k<N;k++)
		{
			dfs(k,k,0,0);
		}
		System.out.println(min_dis);
	}
}
