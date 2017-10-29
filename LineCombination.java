import java.util.Arrays;

class LineCombination 
{
	static int factorial(int n)
	{
		if(n==0)
			return 1;
		int fact=1;
		for(int i=1;i<=n;i++)
		{
			fact *= i;
		}
		return fact;
	}
	public int[] setAlign(int n, long i) 
	{
		int[] answer = new int[n];
		int fac=factorial(n);
		for(int k=0;k<n;++k)
		{
			int fact=factorial(n-1-k);
			answer[k]=(int)(i)/fact;
			i=(i)%fact;
		}
		for(int k=n-1;k>0;--k)
		{
			for(int j=k-1;j>=0;--j)
			{
				if(answer[j]<=answer[k])
					answer[k]++;
			}
		}
		if(n>1)
		{for(int r=0;r<n;r++)
			answer[r]++;
		}
		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		LineCombination lc = new LineCombination();
		System.out.println(Arrays.toString(lc.setAlign(8, 10180)));
	}
}

