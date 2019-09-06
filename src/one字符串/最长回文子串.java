package one字符串;

/**
 * @program: java-algorithm
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-09-03 01:24
 * 思路
 * p[i,j]表示以i开头以j结尾的是否是回文串，1表示是，0表示不是
 *  * 初始状态 p[i,i]=1  如果s[i]=s[i+1] p[i,i+1]=1
 *  * 如果s[i]=s[j] 且 p[i+1,j-1]=1 则p[i][j]=1;
 **/
public class 最长回文子串 {
}
