package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;
public class fortress 
{
	static int num;
	static int longest;
	static Vector<Vector<Integer>> fortresses;
	static LinkedList<LinkedList<Integer>> childs;
	static void createTree()//문제, 
	{
		for(int k=0;k<num;k++)//start from one with smallest radius
		{
			for(int q=k+1;q<num;q++)
			{
				if(k != q && encloses(q,k))//if q encloses k, q is parent of k
				{
					childs.get(q).add(k);
					break;
				}
			}
		}
		
	}
	static boolean encloses(int a, int b)//a encloses b
	{
		int r1,r2,x1,x2,y1,y2;
		r1=fortresses.elementAt(a).get(0);
		r2=fortresses.elementAt(b).get(0);
		x1=fortresses.elementAt(a).get(1);
		x2=fortresses.elementAt(b).get(1);
		y1=fortresses.elementAt(a).get(2);
		y2=fortresses.elementAt(b).get(2);
		
		double distance=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
		return (r1>r2) &&	distance<(r1-r2)*(r1-r2);
	}

	static int height(int root)
	{
		Vector<Integer>heights=new Vector<Integer>();
		for(int x=0;x<childs.get(root).size();x++)
			heights.add(height(childs.get(root).get(x)));
		if(heights.isEmpty())	return 0;
		Collections.sort(heights);
		int hei_size=heights.size();
		if(hei_size>=2)
			longest=Math.max(longest, 2+heights.elementAt(hei_size-1)+heights.elementAt(hei_size-2));
		return heights.elementAt(hei_size-1)+1;
	}
	static int solve(int root)
	{
		longest=0;
		int h=height(root);
		return Math.max(longest,h);
	}
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine());
		for(int i=0;i<testcase;i++)
		{
			num=Integer.parseInt(br.readLine());
			fortresses=new Vector<Vector<Integer>>();
			childs=new LinkedList<LinkedList<Integer>>();
			for(int j=0;j<num;j++)
			{
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				Vector<Integer> temp=new Vector<Integer>();
				Integer x,y,r;
				x=Integer.parseInt(st.nextToken());
				y=Integer.parseInt(st.nextToken());
				r=Integer.parseInt(st.nextToken());
				temp.add(r);
				temp.add(x);
				temp.add(y);
				fortresses.add(temp);
				//System.out.println(fortresses.get(0));	
				LinkedList<Integer> link=new LinkedList<Integer> ();
				childs.add(link);
				
			}
			Collections.sort(fortresses,new Comparator<Vector<Integer>>() {
			@Override public int compare(Vector<Integer> v1, Vector<Integer>v2)
			{	return v1.get(0).compareTo(v2.get(0));
			}});
	
			createTree();
			int maximum=0,tmp;
			for(int j=0;j<num;j++)
			{	tmp=solve(j);
				if(tmp>maximum)
					maximum=tmp;
			}
			System.out.println(maximum);
		}
	}

}
