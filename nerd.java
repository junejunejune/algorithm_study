package baekjoon;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
//Time-out
public class nerd 
{
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine());
		for(int i=0;i<testcase;i++)
		{
			int N=Integer.parseInt(br.readLine());
			int sum=0,curr=1,cannot=0;
			TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();//sorts by key
			for(int j=1;j<=N;j++)
			{
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				int temp_prob=Integer.parseInt(st.nextToken());
				int temp_ram=Integer.parseInt(st.nextToken());
				map.put(temp_prob, temp_ram);
				Iterator<Integer> it=map.keySet().iterator();
				while(it.hasNext() )
				{
					Integer key=it.next();
					if(key== temp_prob)
						break;
					if(map.get(key)<temp_ram)
					{
						cannot++;
						map.replace(key, Integer.MAX_VALUE);
					}
				}
				curr=j-cannot;
				sum+=curr;
			}
			System.out.println(sum);
		}
	}
}
