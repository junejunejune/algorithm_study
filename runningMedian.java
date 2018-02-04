package baekjoon;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class runningmedian2 
{
	static int N,a,b;

	static long solve()
	{
		PriorityQueue<Long> minHeap=new PriorityQueue<Long>();
		PriorityQueue<Long> maxHeap=new PriorityQueue<Long>(Comparator.reverseOrder());
		long ret=0;
		long temp=1983;
		for(int j=1;j<=N;j++)
		{
		//maxheap: numbers that are equal to or less than median
		//minheap: numbers that are bigger than median
		//size should be equal, or maxheap is bigger by one
		//maxheap.top()<=minHeap.top()
			if(maxHeap.size()==minHeap.size())
				maxHeap.add(temp);
			else minHeap.add(temp);
			
			if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() <maxHeap.peek())
			{
				long A=maxHeap.poll(),B=minHeap.poll();
				maxHeap.add(B);
				minHeap.add(A);
			}
			ret+=maxHeap.peek();
			temp=(temp*a+b)%20090711;
		}	
		return ret%20090711;
	}
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine());
		for(int i=0;i<testcase;i++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			System.out.println(solve());
		}

	}
}
