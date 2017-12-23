import java.util.Arrays;
import java.util.*;
import java.util.Comparator;

//public class Solution 
public class sort
{
	static class myComparator implements Comparator<String>
	{
		public int compare(String x, String y)
		{
			if(x.length() == y.length())//if same length
				return x.compareTo(y);
			return x.length()-y.length();//if different length
		}
	}
	
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++)
        {
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here

        Arrays.sort(unsorted, new myComparator());

        for(int unsorted_i=0; unsorted_i < n; unsorted_i++)
        {
            System.out.println(unsorted[unsorted_i]);
        }
    }
}