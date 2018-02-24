import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long getWays(long n, long[] c){
        // Complete this function
long[][] T=new long[c.length][(int)n+1];
        for(long i=0;i<c.length;i++)
        {
            for(long j=0;j<=n;j++)
            {
            		if(i==0 && j%c[0]==0)
            			T[(int) i][(int) j]=1;
            		else if(i==0 && j%c[0]!=0)
            			T[(int) i][(int) j]=0;
            		else if(j==0)
            			T[(int) i][(int) j]=1;
            		else if(j>=c[(int) i])
            			T[(int) i][(int) j]=T[(int)i-1][(int)j]+T[(int)i][(int) (j-c[(int) i])];
            		else
            			T[(int)i][(int)j]=T[(int)i-1][(int)j];
            }
        }
        return T[c.length-1][(int) n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}

