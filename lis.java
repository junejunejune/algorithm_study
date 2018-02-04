import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

public class lis_2 {
	static int N; 
    static int[] A;
    

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        String line=null;
        while((line=br.readLine())!= null)
        {
	        N = Integer.parseInt(line.trim());
	        A = new int[N];
	        StringTokenizer st = new StringTokenizer(br.readLine().trim());
	        for (int i = 0; i < N; i++) 
	            A[i] = Integer.parseInt(st.nextToken());
	        
	        TreeSet<Integer> set=new TreeSet<Integer>();
	        for (int i = 0; i < N; i++) 
	        {
	        		Integer ceil=set.ceiling(A[i]);
	        		if(ceil==null)
	        			set.add(A[i]);
	        		else
	        		{
	        			set.remove(ceil);
	        			set.add(A[i]);
	        		}
	        }
	        System.out.println(set.size());
        }
	}
}
