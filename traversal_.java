package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class traversal_ 
{
	static int N;
	static ArrayList<Integer> pre_order;
	static ArrayList<Integer> in_order;
	static ArrayList<Integer> post_order;


	static void printPostOrder(ArrayList<Integer> in_order, int root)
	{
		if(pre_order.isEmpty() || in_order.isEmpty())	return;
		root=pre_order.get(0);
		pre_order.remove(0);
		int L=in_order.indexOf(root);
		
		ArrayList<Integer> left=new ArrayList<Integer>(in_order.subList(0, L));
		ArrayList<Integer> right=new ArrayList<Integer>(in_order.subList(L+1, in_order.size()));

		printPostOrder(left,root);
		printPostOrder(right,root);
		post_order.add(root);	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine());
		for(int i=0;i<testcase;i++)
		{
			N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			pre_order=new ArrayList<Integer>();
			in_order=new ArrayList<Integer>();
			post_order=new ArrayList<Integer>();
			for(int j=0;j<N;j++)
			{
				pre_order.add(Integer.parseInt(st.nextToken()));
			}
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				in_order.add(Integer.parseInt(st.nextToken()));
			}
			printPostOrder(in_order,0);
			for(int j=0;j<post_order.size();j++)
				System.out.print(post_order.get(j)+" ");
		}	
	}

}
