import java.io.*;
import java.util.*;

public class journey_to_the_moon 
{
    static int[] parent;  // parent[i] = parent of i
    static byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
    static int count; 
	
    static void UF(int n) 
    {
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    static int find(int p) 
    {
        while (p != parent[p]) 
        {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }
    static void union(int p, int q) 
    {
	    int rootP = find(p);
	    int rootQ = find(q);
	    if (rootP == rootQ) return;
	
	    // make root of smaller rank point to root of larger rank
	    if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
	    else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
	    else 
	    {
	        parent[rootQ] = rootP;
	        rank[rootP]++;
	    }
	    count--;
	}
    static boolean connected(int p, int q) 
    {
        return find(p) == find(q);
    }
    
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        UF(n);
        int p = scanner.nextInt();
        int first,second;
        for(int i=0;i<p;i++)
        {
        		first= scanner.nextInt();
        		second= scanner.nextInt();
        		union(first,second);
        }
        int answer=0;
        for(int i=0;i<n;i++)
        {
        		for(int j=i+1;j<n;j++)
        		{
        			if(!connected(i,j))
        			{	answer++;
        				//System.out.println("i:"+i+"j:"+j);
        			}
        		}
        }
        System.out.println(answer);
		scanner.close();
	}
}
