package baekjoon;

import java.util.*;
public class hanoi
{
	static int cnt=0;
	static void move(int start, int goal) {
		// Fill your code to print a log message.
		System.out.println(start+" "+goal);
	}

	static int towerOfHanoi(int n, int start, int temp, int end) 
    {
		if(n==1)
		{	move(start,end);
			cnt++;
			return cnt;
		}
		else
		{
			towerOfHanoi(n-1,start,end,temp);	cnt++;
			move(start,end);
			towerOfHanoi(n-1,temp,start,end);	
		}
		return cnt;
	}

    
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) 
		{
			int n = sc.nextInt();
			//System.out.println("Move "+n+" rings!");
			int num=1;
			for(int i=0;i<n;i++)
				num*=2;
			System.out.println(num-1);
			int answer=towerOfHanoi(n,1,2,3);		
			//System.out.println(answer);
			// Run your method here to solve Tower of Hanoi problem!
		}
		
		sc.close();
	}

}


