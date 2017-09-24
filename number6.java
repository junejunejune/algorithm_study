class Solution 
 {
    static int[][] cache=new int[100001][2];
    
	public int solution(int sticker[]) 
    {
		int answer=0, i ;
        int leng=sticker.length;
        if(leng==1)
            return sticker[0];
        if(leng==2)
            return Math.max(sticker[0],sticker[1]);
        else
        {
            for(i=0;i<leng-1;i++)
            {
                if(i==0)
                {
                    cache[0][0]=0;//if not pick first
                    cache[0][1]=sticker[0];//if pick first
                }
                else if(i==1 )
                {
                    cache[1][0]=sticker[i];
                    cache[1][1]=sticker[i];
                }
                else if(i==2)
                {
                    cache[i][0]=sticker[i];
                    cache[i][1]=sticker[i]+sticker[0];
                }
                else
                {   cache[i][0]=sticker[i]+Math.max(cache[i-2][0],cache[i-3][0]);
                    cache[i][1]=sticker[i]+Math.max(cache[i-2][1],cache[i-3][1]);
                }
            }
            cache[leng-1][0]=sticker[leng-1]+Math.max(cache[leng-3][0],cache[leng-4][0]);
            cache[leng-1][1]=Math.max(cache[leng-3][1],cache[leng-4][1]);
        }
        int temp=Math.max(cache[leng-2][0],cache[leng-2][1]);
        int temp2=Math.max(cache[leng-1][0],cache[leng-1][1]);
        return answer=Math.max(temp,temp2);
	}
}