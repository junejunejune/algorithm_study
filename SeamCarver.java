import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class SeamCarver 
{ 	
	private int height;
	private int width;
	static public Picture given_pic;
	static public double[][] energy;
	public SeamCarver(Picture picture)// create a seam carver object based on the given picture
	{
		 if (picture == null) throw new IllegalArgumentException();
		 given_pic=picture;
		 height=given_pic.height();
		 width=given_pic.width();
		 energy=new double[width][height];
		 
		 for(int i=0;i<width;i++)
		 {
			 for(int j=0;j<height;j++)
			 {
				 energy[i][j]=energy(i,j);
			 }
		 }
	}
	public Picture picture()// current picture
	{
		return given_pic;
	}
	public int width()// width of current picture
	{
		return width;
	}
	public int height()// height of current picture
	{
		return height;
	}
	public double energy(int x, int y)// energy of pixel at column x and row y
	{
		if(x<0 || y<0 || x>width()-1||y>height-1) throw new IllegalArgumentException();
		if(energy[x][y]!=0)
			return energy[x][y];
		else
			return computeX(x,y)+computeY(x,y);
	}
	public double computeX(int x, int y)
	{
		if(x!=0 &&x!=given_pic.width()-1)
		{
			Color left=given_pic.get(x-1,y);
			Color right=given_pic.get(x+1,y);
			int Rx,Gx,Bx;
			Rx=Math.abs(left.getRed()-right.getRed());
			Gx=Math.abs(left.getGreen()-right.getGreen());
			Bx=Math.abs(left.getBlue()-right.getBlue());
			int X;
			X=Rx*Rx+Gx*Gx+Bx*Bx;
			return X;
		}
		else 
		{
			return 1000;
		}
	}
	public double computeY(int x,int y)
	{
		if(y!=0 && y!=given_pic.height()-1)
		{
			Color up=given_pic.get(x,y-1);
			Color down=given_pic.get(x, y+1);
			int Ry,Gy,By;
			Ry=Math.abs(up.getRed()-down.getRed());
			Gy=Math.abs(up.getGreen()-down.getGreen());
			By=Math.abs(up.getBlue()-down.getBlue());
			int Y;
			Y=Ry*Ry+Gy*Gy+By*By;
			return Y;
		}
		else
			return 1000;
	}

	public int[] findVerticalSeam()
	{
		double[][] S=new double[given_pic.width()][given_pic.height()];
		for(int i=0;i<given_pic.width();i++)
		{
			for(int j=0;j<given_pic.height();j++)
			{
				if(j==0)
					S[i][j]=energy(i,j);
				else
				{	if(i==0)
						S[i][j]=energy(i,j)+ Math.min(S[i][j-1],S[i+1][j-1]);
					else if(i==given_pic.width()-1)
						S[i][j]=energy(i,j)+Math.min(S[i-1][j-1], S[i][j-1]);
					else	
						S[i][j]=energy(i,j)+Math.min(S[i-1][j-1], Math.min(S[i][j-1],S[i+1][j-1] ));
				}
			}
		}	
		int[] ret=new int[given_pic.height()];
		double minimum=Double.MAX_VALUE;
		int min_index=0;
		for(int i=0;i<given_pic.width();i++)
		{
			double temp;
			temp=S[i][given_pic.height()-1];
			if(temp<minimum)
			{	minimum=temp;
				min_index=i;
			}
		}
		ret[given_pic.height()-1]=min_index;
		for(int i=given_pic.height()-2;i>=0;i--)
		{
			double mini;
			int prev=ret[i+1];
			if(prev==0)
			{
				
				mini=Math.min(S[prev][i], S[prev+1][i]);
				if(mini==S[prev][i])
					ret[i]=prev;
				else
					ret[i]=prev+1;
			}
			else if(prev==given_pic.width()-1)
			{
				mini=Math.min(S[prev-1][i], S[prev][i]);
				if(mini==S[prev-1][i])
					ret[i]=prev-1;
				else
					ret[i]=prev;
			}
			else
			{
				mini=Math.min(S[prev-1][i], Math.min(S[prev][i], S[prev+1][i]));
				if(mini==S[prev-1][i])
					ret[i]=prev-1;
				else if(mini==S[prev][i])
					ret[i]=prev;
				else
					ret[i]=prev+1;
			}
		}
		return ret;
	}
	public int[] findHorizontalSeam()// sequence of indices for horizontal seam
	{
		double[][] S=new double[given_pic.width()][given_pic.height()];
		for(int i=0;i<given_pic.width();i++)
		{
			for(int j=0;j<given_pic.height();j++)
			{
				if(i==0)
					S[i][j]=energy(i,j);
				else
				{	if(j==0)
						S[i][j]=energy(i,j)+ Math.min(S[i-1][j],S[i-1][j+1]);
					else if(j==given_pic.height()-1)
						S[i][j]=energy(i,j)+Math.min(S[i-1][j-1], S[i-1][j]);
					else	
						S[i][j]=energy(i,j)+Math.min(S[i-1][j-1], Math.min(S[i-1][j],S[i-1][j+1] ));
				}
			}
		}	
		int[] ret=new int[given_pic.width()];
		double minimum=Double.MAX_VALUE;
		int min_index=0;
		//find minimum value at the last line
		for(int i=0;i<given_pic.height();i++)
		{
			double temp;
			temp=S[given_pic.width()-1][i];
			if(temp<minimum)
			{	minimum=temp;
				min_index=i;
			}
		}
		ret[given_pic.width()-1]=min_index;
		for(int i=given_pic.width()-2;i>=0;i--)
		{
			double mini;
			int prev=ret[i+1];
			if(prev==0)
			{
				
				mini=Math.min(S[i][prev], S[i][prev+1]);
				if(mini==S[i][prev])
					ret[i]=prev;
				else
					ret[i]=prev+1;
			}
			else if(prev==given_pic.width()-1)
			{
				mini=Math.min(S[i][prev-1], S[i][prev]);
				if(mini==S[i][prev-1])
					ret[i]=prev-1;
				else
					ret[i]=prev;
			}
			else
			{
				mini=Math.min(S[i][prev-1], Math.min(S[i][prev], S[i][prev+1]));
				if(mini==S[i][prev-1])
					ret[i]=prev-1;
				else if(mini==S[i][prev])
					ret[i]=prev;
				else
					ret[i]=prev+1;
			}
		}
		return ret;
	}
	public double computeHorizontalSeam(int x, int y)
	{
		if(x==given_pic.width()-1)
			return energy(x,y);
		else
		{
			if(y==0)
				return energy(x,y)+Math.min(computeHorizontalSeam(x+1,y),computeHorizontalSeam(x+1,y+1));
			else if(y==given_pic.height()-1)
				return energy(x,y)+Math.min(computeHorizontalSeam(x+1,y-1),computeHorizontalSeam(x+1,y));
			else
				return energy(x,y)+Math.min(computeHorizontalSeam(x+1,y-1), Math.min(computeHorizontalSeam(x+1,y),computeHorizontalSeam(x+1,y+1)));
		}
	}
	public void removeHorizontalSeam(int[] seam)// remove horizontal seam from current picture
	{
		if (given_pic.height()<=1)
			throw new IllegalArgumentException();
		if(seam.length !=given_pic.width())
			throw new IllegalArgumentException();

		//Update
        Picture update=new Picture(given_pic.width(),given_pic.height()-1);
        double[][] update_energy=new double[given_pic.width()][given_pic.height()-1];
        for(int i=0;i<given_pic.width();i++)
        {
        		for(int j=0;j<seam[i];j++)
        		{
        			update.set(i, j, given_pic.get(i, j));
        			update_energy[i][j]=energy[i][j];
        		}
        		for(int j=seam[i]+1;j<given_pic.height();j++)
        		{
        			update.set(i, j-1, given_pic.get(i, j));
        			update_energy[i][j-1]=energy[i][j];
        		}
        }
        given_pic=update;
        energy=update_energy;
	}
	public void removeVerticalSeam(int[] seam)// remove vertical seam from current picture
	{
		//EXCEPTIONS
        if (seam == null || seam.length != height) throw new IllegalArgumentException();
        if (seam[0] < 0 || seam[0] > width()-1) throw new IllegalArgumentException();
        for (int i = 1; i < height; i++) 
        {
            if (seam[i] < 0 || seam[i] > width()-1) throw new IllegalArgumentException();
            if (Math.abs(seam[i] - seam[i-1]) > 1) throw new IllegalArgumentException();
        }
		//Update
        Picture update=new Picture(given_pic.width()-1,given_pic.height());
        double[][] update_energy=new double[given_pic.width()-1][given_pic.height()];
        for(int i=0;i<given_pic.height();i++)
        {
        		for(int j=0;j<seam[i];j++)
        		{
        			update.set(j, i, given_pic.get(j, i));
        			update_energy[j][i]=energy[j][i];
        		}
        		for(int j=seam[i]+1;j<given_pic.width();j++)
        		{
        			update.set(j-1, i, given_pic.get(j, i));
        			update_energy[j-1][i]=energy[j][i];
        		}
        }
        given_pic=update;
        energy=update_energy;
	}
    public static void main(String[] args)
    {
    		Picture new_pic=new Picture("seam/chameleon.png");
    		SeamCarver seamcarver=new SeamCarver(new_pic);
System.out.println("3");
    		int[] res_vertical_seam,res_horizon_seam;
    		res_vertical_seam=seamcarver.findVerticalSeam();
System.out.println("4");
    		seamcarver.removeVerticalSeam(res_vertical_seam);
System.out.println("5");   		
    		res_horizon_seam=seamcarver.findHorizontalSeam();
System.out.println("6");
    		seamcarver.removeHorizontalSeam(	res_horizon_seam);
System.out.println("7");
    		seamcarver.picture().show();
    }
}
    