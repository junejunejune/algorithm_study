package algospot;

import java.util.Scanner;

public class klis 
{
	static int n;
	static int cache[]=new int [101];
	static int lis3(int [] sequence, int start)
	{	
		int ret=cache[start+1];
		if(ret!=-1)
			return ret;
		ret=1;
		for(int next=start+1;next<n;++next)
			if(start==-1||sequence[start]<sequence[next])
				ret=Math.max(ret, lis3(sequence,next)+1);
		return ret;
	}
	
	
	static int[] solve (int [] sequence,int num,int k_th)
	{
		int[] ret=new int[num];
		int[] size=new int[num];

		for(int i=0;i<num;i++)
		{
			ret[i]=sequence[i];
			size[i]=1;
		}
		
		for(int i=1;i<num;i++)
		{
			for(int j=i;j<i;j++)
			{
				if(sequence[i]>sequence[j] && size[i]<=size[j]+1)
				{
					size[i]=size[j]+1;
					if(size[i]<size[j]+1)
						
				}
			}
		}
		
		
		return ret;
	}
	
	public static void main(String[] args) 
	{
		 Scanner scanner=new Scanner(System.in);
	     int testcase_num;
	     testcase_num=scanner.nextInt();
	     for(int a=0;a<testcase_num;a++)
	     {
	    	 	int num,k_th;
	    	 	num=scanner.nextInt();
	    	 	k_th=scanner.nextInt();
	    	 	int[] sequence=new int[num];
	    	 	
	    	 	int retu;
	    	 	retu=lis3(sequence,0);
	    	 	
	    	 	int [] ret=solve(sequence,num,k_th);
	    	 	System.out.println(ret.length);
	    	 	System.out.println(ret);
	     }
	     
	     scanner.close();
	}
}
