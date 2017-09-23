import java.util.Scanner;

public class equal
{
    static int[][] cache=new int[3][100000];
	static int make_cache(int comp,int first_flag)
	{
        if(first_flag==1)
        {

            for(int i=0;i<3;i++)
            {
                for(int j=0;j<comp+1;j++)
                {
                    if(i==0)//1
                        cache[i][j]=j;
                    else if(i==1)//2
                    {
                        if(j<2)
                           cache[i][j]=cache[0][j];
                        else
                            cache[i][j]=Math.min(cache[0][j],cache[1][j-2]+1);    
                    }
                    else//5
                    {
                        if(j<5)
                            cache[i][j]=cache[1][j];
                        else
                            cache[i][j]=Math.min(cache[1][j],cache[2][j-5]+1);
                    }
                }
            }    
        }
        return cache[2][comp];
	}
	
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int 	testcase_num;
		testcase_num=scanner.nextInt();
		
		for(int a=0;a<testcase_num;a++)
		{
			int answer=0;
			int num_colleagues=scanner.nextInt();
			int[] num_choco=new int[num_colleagues];
			for(int b=0;b<num_colleagues;b++)
			{
				num_choco[b]=scanner.nextInt();	
			}
            
			int min=1000000,max=0;//find one with the least chocolates
			for(int b=0;b<num_colleagues;b++)
			{
				//System.out.println(1);
				if(num_choco[b]<min)
					min=num_choco[b];
                if(num_choco[b]>max)
                    max=num_choco[b];
			}
            make_cache(max-min,1);
			//System.out.println("min"+min);
            for(int b=0;b<num_colleagues;b++)
			{
                if(num_choco[b]!= min)
                    answer+=make_cache(num_choco[b]-min,0);
            }
			System.out.println(answer);
		}
		scanner.close();
	}
}


