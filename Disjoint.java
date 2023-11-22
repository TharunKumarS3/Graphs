import java.util.*;
public class Disjoint {
    //two things rank and parent

    ArrayList<Integer> rank=new ArrayList<>();
    ArrayList<Integer> parent=new ArrayList<>();
    public Disjoint(int n)
    {
        //initailizing
        for(int i=0;i<=n;i++)
        {
            rank.add(0);
            parent.add(i);
        }
    }
    //find the parent of the node
    public int findUPar(int u)
    {
        if(u==parent.get(u))
        {
            //we found ultimate parent of the node
            return u;
        }
        int ultimateParent=findUPar(parent.get(u));
        //after finfing the ultimate parent of u , we set the parent of u to ultimate parent
        parent.set(u, ultimateParent);
        return parent.get(u);

    }
    public void unionByRank(int u,int v)
    {
        //step 1 - >find parent of u and v
        int uPar=findUPar(u);
        int vPar=findUPar(v);

        //step 2 - >check the rank of its parent
        if(uPar==vPar)
        return ;

        if(rank.get(vPar)>rank.get(uPar))
        {
            parent.set(uPar, vPar);
        }

        else if (rank.get(uPar)>rank.get(vPar))
        {
            //upar>vpa
            //then join v -> u
            parent.set(vPar, uPar);


        }
        else
        {
            //if both parent is diff then join anyone to anyone
            //and get the rank of parent
            //and increase its rank by 1
            parent.set(vPar,uPar);
            int ranku=rank.get(uPar);
            rank.set(uPar, ranku+1);

        }


    }












    
        public static void main (String[] args) {
            Disjoint ds = new Disjoint(7);
            ds.unionByRank(1, 2);
            ds.unionByRank(2, 3);
            ds.unionByRank(4, 5);
            ds.unionByRank(6, 7);
            ds.unionByRank(5, 6);
    
            // if 3 and 7 same or not
            if (ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else
                System.out.println("Not Same");
    
            ds.unionByRank(3, 7);
            if (ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else
                System.out.println("Not Same");
        
    
    
}
}
