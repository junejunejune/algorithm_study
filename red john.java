import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class redjohn {


    static boolean[] primes=new boolean[1000000];
    static boolean isPrime(int n) 
    {
    		return primes[n];
    }
    static int cnt_prime(int n)
    {
        int cnt=0;
        for(int i=2;i<=n;i++)
            if(isPrime(i))
                cnt++;
        return cnt;
    }
    static int redJohn(int n) 
    {
        // Complete this function
    		Arrays.fill(primes,true);       
    		primes[0]=primes[1]=false;       
    		for (int i=2;i<primes.length;i++) 
    		{
    			if(primes[i]) 
    			{
    				for (int j=2;i*j<primes.length;j++) 
    				{
    					primes[i*j]=false;
    				}
    			}
    		}    	
    	
    		int t[]=new int[n+1];
    		if(n<=3)		return 0;
    		else
    			t[0]=t[1]=t[2]=t[3]=1;
    		for(int k=4;k<=n;k++)
    			t[k]=t[k-1]+t[k-4];
    		//System.out.println(t[n]);
    		return cnt_prime(t[n]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = redJohn(n);
            System.out.println(result);
        }
        in.close();
    }
}

