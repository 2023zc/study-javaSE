package algorithm;


import java.util.Scanner;

//project->module->package->class..
public class dfs {
    static int n,m,start_x,start_y,point_x,point_y,count=0,top=0;
    static int[] rutinue_x=new int[2505];
    static int[] rutinue_y=new int[2505];
    static boolean[][] book=new boolean[50][50];
    static char[][] place=new char[50][50];
    static int[] dir_y={1,0,-1,0};
    static int[] dir_x={0,-1,0,1};
    public static void add(int x,int y){
        rutinue_x[top]=x;
        rutinue_y[top++]=y;
    }
    public static boolean check(int now_x,int now_y){
        if(now_x>=1&&now_x<=n&&now_y>=1&&now_y<=m){
            return true;
        }
        return false;
    }
    public static void dfs(int now_x,int now_y){
        //搜索
        if(now_x==point_x && now_y==point_y){
            count++;
            for (int i = 0; i < top; i++) {
                if(i==top-1){
                    System.out.print("("+rutinue_x[i]+","+rutinue_y [i]+")");
                    break;
                }
                System.out.print("("+rutinue_x[i]+","+rutinue_y[i]+")"+"--->");
            }
            System.out.print("\n");
            return;
        }
        int next_x,next_y;
        for (int i = 0; i <4 ; i++) {
            next_x=now_x+dir_x[i];
            next_y=now_y+dir_y[i];
            if(book[next_x][next_y]==false&&check(next_x,next_y)){
                book[next_x][next_y]=true;
                // 没搜过就要搜,添加要去的点,相当于入栈
                add(next_x,next_y);
                dfs(next_x,next_y);   //没搜过就搜
                //回溯法,找所有的路径
                book[next_x][next_y]=false;
                top--;  //让栈顶减一相当于删去最顶上的数据
            }
        }

    }

    public static void main(String[] args) {

        Scanner cin= new Scanner(System.in);
        n=cin.nextInt();
        m=cin.nextInt();
        start_x=cin.nextInt();
        start_y=cin.nextInt();
        point_x=cin.nextInt();
        point_y=cin.nextInt();
        for (int i = 1; i <=n; i++) {
            String str=cin.next();
            for (int i1 = 0; i1 < m; i1++) {
                place[i][i1+1]=str.charAt(i1);
            }
        }
        for (int i = 1; i <=n; i++) {
            for (int i1 = 1; i1 <= m; i1++) {
                if(place[i][i1]!='.'){
                    book[i][i1]=true;
                }
            }
        }
        book[start_x][start_y]=true;
        add(start_x,start_y);
        dfs(start_x,start_y);
        System.out.println("最后的路径总数为:"+count);
//        for (int i = 1; i <=n; i++) {
//            for (int i1 = 1; i1 <=m; i1++) {
//                System.out.print(place[i][i1]+" ");
//            }
//            System.out.print("\n");
//        }

    }
}
