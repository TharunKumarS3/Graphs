import java.util.*;
public class ValidateBinaryTree {

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[]parent=new int[n];
        int[] vis=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i>0)
            {
                if(parent[i]!=1)
                return false;
            }
            if(parent[i]!=1)
            {
            parent[i]=1;
            vis[i]=1;
            if(! bfs(i,leftChild,rightChild,parent,vis))
            {
                return false;
            }
            }
            

        }
        return true;
    }
   static boolean bfs(int index,int[]left,int[] right,int[] parent,int[] vis)
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(index);
        while(!queue.isEmpty())
        {
            int ind=queue.poll();
            parent[ind]=1;
            int l=left[ind];
            int r=right[ind];
            if(l==-1 && r==-1)
            continue;
            if(l!=-1)
            {
                if(vis[l]==1)
                return false;
            }
             if(r!=-1)
            {
                if(vis[r]==1)
                return false;
            }
            if(ind==ind-1)
            return false;
            
           
            if(l!=-1)
            {
                queue.add(l);
                vis[l]=1;
            }
            if(r!=-1)
            {
                queue.add(r);
                vis[r]=1;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        int[] left={1,-1,-1,4,-1,-1};
        int[] right={2,-1,-1,5,-1,-1};
        System.out.println(validateBinaryTreeNodes(6,left,right));
        
    }
    
}
