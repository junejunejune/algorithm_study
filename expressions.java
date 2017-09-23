public class expressions 
{

	public int expressions(int num) 
  {
		int answer = 0;
    int temp,flag;
		for(int i=1;i<num;i++)
    {
      flag=0;
      temp=0;
      for(int j=i;j<num;j++)
      {
        temp+=j;
        if(temp==num)
        {  flag=1;
         break;
        }
        if(temp>num)
        	break;
      }
      if(flag==1)
        answer++;
    }
		return answer+1;
	}

	public static void main(String args[]) 
  {
		Expressions expressions = new Expressions();
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(expressions.expressions(15));
	}
}