package twoDFS;

import java.util.Arrays;

/**
 * @program: java-algorithm
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-09-04 02:18
 * 思路
 * public void dfs1(int step){
 *         判断边界
 *         尝试每一种可能for(i=1;i<=n;i++){
 *             继续下一步 dfs(step+1)
 *             可能需要回退
 *         }
 *         返回
 *     }
 **/
public class 全排列1 {
    //存放全排列的结果
    private static int[] a;
    //标记是否在手中，1表示放在容器中，0表示在手里
    private static int[] visit;
    //全排列的长度
    private static int n;
    private static int count=0;

    //step表示现在站在第几个盒子前面
    public static void dfs(int step){
        if(step==n+1){
            count++;
            System.out.println(Arrays.toString(a));
            return;
        }
        //此时站在第step个盒子面前，应该放那张牌
        //牌按照1，2，3,....n的顺序放
        for(int i=1;i<=n;i++){
            if(visit[i]==0){
                a[step]=i;
                visit[i]=1;
                dfs(step+1);
                visit[i]=0;
            }
        }
        return;
    }

    public static void main(String[] args) {
        //1-9 9个数
        n=9;
        a=new int[n+1];
        visit=new int[n+1];
        dfs(1);
        System.out.println(count);
    }


}
