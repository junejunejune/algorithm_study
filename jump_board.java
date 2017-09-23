	package baekjoon;
	
	import java.util.HashSet;
	import java.util.Scanner;
	
	public class jump_board 
	{
		static int[][] board=new int[5][5];
		static HashSet<String> nums= new HashSet<String>();
		static boolean is_in_board(int x, int y)
		{
			if(x<5 && x>=0 && y<5 && y>=0)
				return true;
			else
				return false;
		}
		static void dfs(String num, int x, int y, int cnt)
		{
			if(cnt>5)
			{	
				//System.out.println("num"+num);
				nums.add(num);
				return;
			}
			if(is_in_board(x+1,y))
			{
				dfs(num+board[x+1][y],x+1,y,cnt+1);
			}
			if(is_in_board(x,y+1))
			{
				dfs(num+board[x][y+1],x,y+1,cnt+1);
			}
			if(is_in_board(x-1,y))
			{
				dfs(num+board[x-1][y],x-1,y,cnt+1);
			}
			if(is_in_board(x,y-1))
			{
				dfs(num+board[x][y-1],x,y-1,cnt+1);
			}
				
		}
		
		public static void main(String[] args) 
		{
			Scanner scanner=new Scanner(System.in);
			for(int i=0;i<5;i++)
				for(int j=0;j<5;j++)	
				{	board[i][j]=	 scanner.nextInt();
					//System.out.print(board[i][j]);
				}
			for(int i=0;i<5;i++)
			{	for(int j=0;j<5;j++)	
				{
					dfs(board[i][j]+"",i,j,1);
				}
			}
			System.out.println(nums.size());
			scanner.close();
		}
	}
