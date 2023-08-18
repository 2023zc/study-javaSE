package leetcode;

//leetcode刷题:https://leetcode.cn/leetbook/read/illustration-of-algorithm/9h6vo2/
public class Robot_Move {

    private int range_x;
    private int range_y;

    private int ans;
    private int condition;

    private boolean[][] book;
    public int movingCount(int m, int n, int k) {
        range_x=m;
        range_y=n;
        condition=k;
        book=new boolean[range_x][range_y];
        ans++;    //初始化
        book[0][0]=true;
        dfs(0,0);   //从(0,0)点开始搜索
        return ans;
    }
    private void dfs(int start_x,int start_y){
        int[] de_x={0,-1,0,1};
        int[] de_y={-1,0,1,0};  //方向数组
        for(int i=0;i<4;i++){
            int new_x=start_x+de_x[i];
            int new_y=start_y+de_y[i];
            if(new_x>=0&&new_x<range_x&&new_y>=0&&new_y<range_y&&!book[new_x][new_y]){
                if(check(new_x,new_y)) {
                    book[new_x][new_y]=true;
                    ans++;   //无需回溯
                    dfs(new_x,new_y);
                }
            }
        }
    }

    private boolean check(int new_x,int new_y){
    int sum=0;
        while(new_x>0) {
            sum+=(new_x%10);
            new_x/=10;
        }
        while(new_y>0) {
            sum+=(new_y%10);
            new_y/=10;
        }   //处理数据
        return sum <= condition;
    }

    public static void main(String[] args) {
        Robot_Move robot_move=new Robot_Move();
        System.out.println(robot_move.movingCount(2,3,1));
    }
}
