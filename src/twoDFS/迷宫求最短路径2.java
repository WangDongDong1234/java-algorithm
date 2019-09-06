package twoDFS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: java-algorithm
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-09-06 09:33
 * 5 4
 * 0 0 1 0
 * 0 0 0 0
 * 0 0 1 0
 * 0 1 0 0
 * 0 0 0 1
 * 1 1 4 3
 **/
public class 迷宫求最短路径2 {
    //地图
    private static int[][] mp;
    private static int m,n,start_x,start_y,end_x,end_y,count=Integer.MAX_VALUE;
    //访问记录
    private static int[][] visit;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] m_n=scanner.nextLine().split(" ");
        m=Integer.parseInt(m_n[0]);
        n=Integer.parseInt(m_n[1]);
        mp=new int[m][n];
        String[] tmp=null;
        for(int i=0;i<m;i++){
            //next和nextline的区别是next中间不能加空格或符号,nextline是从当前行的某个位置读到行尾
            tmp=scanner.nextLine().split(" ");
            int[] tmp_t=new int[n];
            for(int j=0;j<n;j++){
                tmp_t[j]=Integer.parseInt(tmp[j]);
            }
            mp[i]=tmp_t;
        }
        start_x=scanner.nextInt()-1;
        start_y=scanner.nextInt()-1;
        end_x=scanner.nextInt()-1;
        end_y=scanner.nextInt()-1;
        System.out.println(m);
        System.out.println(n);
        System.out.println(Arrays.toString(mp));
        System.out.println(start_x);
        System.out.println(start_y);
        System.out.println(end_x);
        System.out.println(end_y);
        visit=new int[m][n];
        //初始化标记
        int[] visit_tmp=null;
        for(int i=0;i<m;i++){
            //注意这里的浅复制
            visit_tmp=new int[n];
            for(int j=0;j<n;j++){
                visit_tmp[j]=0;
            }
            visit[i]=visit_tmp;
        }
        dfs(start_x,start_y,0);
        System.out.println(count);
    }

    public static void dfs(int x,int y,int step){
        int[][] next={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
        };
        int tx,ty;
        if(x==end_x&&y==end_y){
            //更新最小值
            if(step<count){
                count=step;
                return;
            }
        }
        //枚举4种走法
        for(int k=0;k<=3;k++){
            //计算下一个点的坐标
            tx=x+next[k][0];
            ty=y+next[k][1];
            //判断下一步是否越界(坐标从0开始)
            if(tx<0||tx>=m||ty<0||ty>=n){
                continue;
            }
            if(visit[tx][ty]==0&&mp[tx][ty]==0){
                visit[tx][ty]=1;
                dfs(tx,ty,step+1);
                visit[tx][ty]=0;
            }
        }
        return;
    }
}
