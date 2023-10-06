import java.util.*;
public class ListRepGraph {
    public static void main(String[] args) {
         //graph
        // 1 - 2 - 5
        // |   |  /
        // 3 - 4 
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>(); 
        for(int i=0;i<=5;i++)
        {
            adjList.add(i,new ArrayList<Integer>());
        }
        //1 - 2
        adjList.get(1).add(2);
        adjList.get(2).add(1);
         //1 - 3
        adjList.get(1).add(3);
        adjList.get(3).add(1);
         //2 - 3
        adjList.get(2).add(3);
        adjList.get(3).add(2);
         //2 - 5
        adjList.get(2).add(5);
        adjList.get(5).add(2);
         //3 - 4
        adjList.get(3).add(4);
        adjList.get(4).add(3);
         //4 - 5
        adjList.get(4).add(5);
        adjList.get(5).add(4); 
        for(int i=0;i<=5;i++)
        {
            System.out.print(adjList.get(i) + " -> " );
            for(int j=0;j<adjList.get(i).size();j++)
            {
                System.out.print(adjList.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
    
}
