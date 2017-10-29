import java.util.Scanner;
import java.util.Vector;
public class Crossword 
{
	static char[][]	board=new char[10][10];
	static String[] word;
	static Vector<String> used_word=new Vector<String>();
	static Vector<String> unused_word=new Vector<String>();
	static int[] word_leng;
	static void solve()
	{	
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
//System.out.println("inner loop");
				if(check()==true)
					return;
				if(board[i][j]=='-')
				{
					int flag=0;
					for(int k=0;k<word.length;k++)
					{
//System.out.println("6");
						String temp=word[k];
						if(unused_word.contains(word[k]))//if word is not used yet
						{
							boolean match1=match( i,j,temp,  1);
							if(match1==true)
							{
//System.out.println("7");
								fill(i,j,temp,1);
								unused_word.removeElement(word[k]);
								used_word.addElement(word[k]);
								flag=1;
							}
//System.out.println("8");						
							boolean match2=match( i ,j, temp,0);
							if(match2==true)
							{
//System.out.println("9");							
								fill(i,j,temp,0);
								unused_word.removeElement(word[k]);
								used_word.addElement(word[k]);
								flag=1;
							}
//System.out.println("10");
						}			
					}
				}
			}
		}
	}

	static boolean match(int i,int j,String temp, int dire)
	{
		int length=temp.length();//CHECK if LENGTH match
		if(dire==1)//garo
		{
			int b=j;
			int cnt_blk=1;
			while(board[i][++b]!='+'&&b<10)
				cnt_blk++;
			
			if(cnt_blk==length)//CHECK if letters match
			{
				for(int a=j;a<j+length;a++)
				{
					if(board[i][a]!=temp.charAt(a-j))
					{
						return false;
					}
				}
				return true;
			}
			else
				return false;
		}
		else if(dire==0)//sero
		{
			int b=i;
			int cnt_blk=0;
			while(b<10)
			{	
				if(board[b][j]!='+')
				{	cnt_blk++;
					b++;
				}
			}
			if(cnt_blk==length)//CHECK if letters match
			{
				for(int a=j;a<j+length;a++)
				{
					if(board[a][j]!=temp.charAt(a-j))
					{
						return false;
					}
				}
				return true;
			}
			else
				return false;
		}
		return false;
	}
	static void fill(int i,int j,String temp, int dire)
	{
		int length=temp.length();
		if(dire==1)//garo
		{
			for(int a=0;a<length;a++)
			{
				board[i][j++]=temp.charAt(a);
			}
		}
		else if(dire==0)//sero
		{
			for(int a=0;a<length;a++)
			{
				board[i++][j]=temp.charAt(a);
			}
		}
	}
	static boolean check()
	{
//System.out.println("here");
		for(int p=0;p<10;p++)
		{
			for(int q=0;q<10;q++)
			{
				if(board[p][q]=='-')
				{	
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);

		for(int i=0;i<10;i++)//FILL THE BOARD
		{
			String line=scanner.nextLine();
			for(int j=0;j<10;j++)
				board[i][j]=line.charAt(j);
		}
		String words=scanner.nextLine();
		
		word=words.split(";");
		//System.out.println(word.length);

		for(int i=0;i<word.length;i++)
			unused_word.add(word[i]);
//System.out.println("0");		
		solve();
//System.out.println("1");		
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
               System.out.print(board[i][j]);
            System.out.println();
        }
	}

}
