class MatrixRepGraph
{
    public static void main(String[] args) {
        //graph
        // 1 - 2 - 5
        // |   |  /
        // 3 - 4 

        int nodes=5,edges=6;
        //for undirected graph
        int[][] undirected=new int[nodes+1][nodes+1];
        // 1 - 2
        undirected[1][2]=1;
        undirected[2][1]=1;
         // 1 - 3
        undirected[1][3]=1;
        undirected[3][1]=1;
         // 2 - 5
        undirected[2][5]=1;
        undirected[5][2]=1;
         // 2 - 4
        undirected[2][4]=1;
        undirected[4][2]=1;
        // 3 - 4
        undirected[3][4]=1;
        undirected[4][3]=1;
        // 4 - 5
        undirected[4][5]=1;
        undirected[5][4]=1;

        //matrix representation
        for(int i=0;i<=nodes;i++)
        {
            for(int j=0;j<undirected[i].length;j++)
            {
                System.out.print(undirected[i][j]+ " ");

            }
            System.out.println();
        }


    }

}