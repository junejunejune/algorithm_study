package baekjoon;

import java.util.*;

public class findpath 
{
   static int bfs(HashMap<Integer,ArrayList<Integer>> g,int i,int j)
   {
      Vector<Integer> visited=new Vector<Integer>();
      LinkedList<Integer> queue=new LinkedList<Integer>();
      
      visited.add(i);
      queue.add(i);
      
      int pulled;
      while(queue.size()!=0)
      {
         pulled=queue.poll();
         for(int k=0;k<g.get(pulled).size();k++)
         {
            if(g.get(pulled).get(k).equals(j))            
            {
               return 1;
            }
            if(!visited.contains(g.get(pulled).get(k)))
            {
               visited.add(g.get(pulled).get(k));
               queue.add(g.get(pulled).get(k));   
            }
         }
      }
      return 0;
   }
   
   public static void main(String[] args)
   {   
      Scanner scanner=new Scanner(System.in);
      int input;
      input=scanner.nextInt();
      HashMap<Integer,ArrayList<Integer>> graph=new HashMap<Integer,ArrayList<Integer>>();
      
      for(int i=0;i<input;i++)//make graph
      {
         ArrayList<Integer> temp=new ArrayList<Integer>();
         graph.put(i, temp);
         
         for(int j=0;j<input;j++)
         {
            String nums=scanner.next();
            if(nums.charAt(0)=='1')
               graph.get(i).add(j);
         }
      }
      
      for(int i=0;i<input;i++)
      {
         for(int j=0;j<input;j++)
         {
            int result;
            result=bfs(graph,i,j);
            System.out.print(result+" ");
         }   
         System.out.println();
      }
      scanner.close();
   }
}