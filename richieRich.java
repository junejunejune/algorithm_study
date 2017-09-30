import java.io.*;
import java.util.Scanner;

public class richieRich 
{
	static int cnt_change_needed(String s,int n)
	{
		int cnt=0;
		for(int i=0;i<n/2;i++)
		{
			if(s.charAt(i) != s.charAt(n-i-1))
				cnt++;
		}
		return cnt;
	}
	
	static void solve(String s, int n, int k)
    {	
		int minimum_cnt=cnt_change_needed(s,n);
		int more_cnt=k-minimum_cnt;
		if(n==1&&k>=1)
		{
			System.out.println(9);
			return;
		}
		if(k<minimum_cnt)//not possible
		{
			System.out.println(-1);
			return;
		}
		else if(k==minimum_cnt)
		{
			for(int j=0;j<n;j++)
			{
				if(s.charAt(j)>=s.charAt(n-j-1))
					System.out.print(s.charAt(j));
				else 
					System.out.print(s.charAt(n-j-1));
			}
			return;
		}
		else
		{
			char[] s_char=s.toCharArray();
			for(int j=0;j<n/2;j++)
			{
				if(s.charAt(j) != s.charAt(n-j-1))//already one changed used, so additional one change
				{
					if(more_cnt>=1 && s.charAt(j)!='9' && s.charAt(n-j-1)!='9')
					{	
						s_char[j]='9';
						s_char[n-j-1]='9';
						more_cnt--;
					}
					else
					{						
						if(s.charAt(j)>s.charAt(n-j-1))
							s_char[n-j-1]=s.charAt(j);
						else
							s_char[j]=s.charAt(n-j-1);
					}
				}
				else//no change yet, so to change need 2 more_cnt
				{	
					if(more_cnt>1&&s.charAt(j)!='9')
					{	
						more_cnt-=2;
						s_char[j]=s_char[n-j-1]='9';
					}

				}		
			}			
			if(more_cnt>=1&& n%2==1)
			{	
				s_char[n/2]='9';
				more_cnt-=1;
			}
			System.out.println(s_char);
			return;
		}
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        solve(s, n, k);
        in.close();
    }
}
