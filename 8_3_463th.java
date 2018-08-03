class Solution {
    //1.每个cell根据周围四个是否有cell可区分为5种周长显性可能性：0,1,2,3，4；
    //其中==4的情况只有当island.size==1时可能
    //2.构造一个cell数据结构，将四边中已经去过的方向更新
    //按从左到右从上到下的顺序遍历开始找到第一个1；将此时的位置丢入hashmap；number（island.size）++
    //按左下右上的顺序找第一个相邻的1，前往没有去过的方向，当hashmap中没有此位置时number++；i（临边个数）++
    public int islandPerimeter(int[][] grid) {
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    int side=4;
                    if(j>0){
                        if(grid[i][j-1]==1)side--;
                    }
                    if(j<grid[0].length-1){
                        if(grid[i][j+1]==1)side--;
                    }       
                    if(i>0){
                        if(grid[i-1][j]==1)side--;
                    }
                    if(i<grid.length-1){
                        if(grid[i+1][j]==1)side--;
                    }
                    result=result+side;
                }
            }
            
        }
        return result;
    }
}
