public class FloodFill {

    //GFG

    public int[][] floodFill(int[][] image,int r,int c,int newcolor)
    {
        int iniColor=image[r][c];
        int[] delrow={-1,0,+1,0}; //this is for moving in 4 directions
        int[] delcol={0,+1,0,-1};//this is for moving in 4 directions
        int[][] ans=image;//coping to the duplicate array
        dfs(r,c,iniColor,delrow,delcol,ans,image,newcolor);
        return ans;
    }

    private void dfs(int r, int c, int iniColor, int[] delrow, int[] delcol, int[][] ans, int[][] image,int newcolor) {

        ans[r][c]=newcolor; //changing to new color
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++) // 4 directions moment
        {
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&  
                ans[nrow][ncol]!=newcolor && image[nrow][ncol]==iniColor) //conditions
                {
                    dfs(nrow, ncol, iniColor, delrow, delcol, ans, image, newcolor);
                }
        }





    }
    
}
