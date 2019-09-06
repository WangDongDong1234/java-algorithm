package one字符串;

import java.util.HashMap;

/**
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *  * 输入: "abcabcbb"
 *  * 输出: 3
 *  * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *  *
 *  * 输入: "bbbbb"
 *  * 输出: 1
 *  * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *  *
 *  * 输入: "pwwkew"
 *  * 输出: 3
 *  * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *  *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @program: java-algorithm
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-09-03 00:44
 * 思路：子串必须是连续的，当一个子串中出现连续的字符的时候，比如A***A说明不满足要求，起始位置应该从A的下一位置开始，
 * 所以需要一个容器来记录A的位置
 *
 * 特殊情况
 * 输入“abba”  输出2
 * 输入“abcabcbb” 输出3
 **/
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution1 solution=new Solution1();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
}


class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        HashMap<String,Integer> map=new HashMap<>();
        int left=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.substring(i,i+1))){
                //说明重复了(这了也要注意，下一个left可能小于当前left)
                left=Math.max(map.get(s.substring(i,i+1))+1,left);
                //跟新下map
                //map.put(s.substring(i,i+1),i);

            }
            //不包含就放入
            map.put(s.substring(i,i+1),i);
            //关键的地方，争对上面出现的特殊形况，可能更新后的left比起点小，所以用max
            max=Math.max(max,i-left+1);
        }
        return max;
    }
}


// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s.length()==0) {return 0;}
//         //记录字符对应的位置
//         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//         int max = 0;
//         int left = 0;
//         for(int i = 0; i < s.length(); i ++){
//             if(map.containsKey(s.charAt(i))){
//                 //注意这是一个字串（字串必须连续），不是子序列
//                 //更新左起点的位置
//                 left = Math.max(left,map.get(s.charAt(i)) + 1);
//             }
//             map.put(s.charAt(i),i);
//             max = Math.max(max,i-left+1);
//         }
//         return max;
//
//     }
// }

//求子串
// class Solution2 {
//     public List lengthOfLongestSubstring(String s) {
//         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//         ArrayList<String> list=new ArrayList<>();
//         int max = 0;
//         int newMax =0;
//         int left = 0;
//         for(int i = 0; i < s.length(); i ++){
//             if(map.containsKey(s.charAt(i))){
//                 //注意这是一个字串（字串必须连续），不是子序列
//                 left = Math.max(left,map.get(s.charAt(i)) + 1);
//             }
//             map.put(s.charAt(i),i);
//             newMax = Math.max(max,i-left+1);
//             if(newMax>max){
//                 list=new ArrayList<>();
//                 max=newMax;
//             }else{
//                 list.add(s.substring(left,i+1));
//             }
//         }
//         return list;
//
//     }
// }
//
//