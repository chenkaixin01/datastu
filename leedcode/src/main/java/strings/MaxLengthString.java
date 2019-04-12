package strings;

import java.util.*;

/**
 * @Author chenkx
 * @Date 2019/4/12 14:43
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 **/
public class MaxLengthString {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        int max = 0;
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if(set.add(c)){
                list.add(c);
            }else {
                if(list.size()>max){
                    max = list.size();
                }
                int index = list.indexOf(c);
                for (int i = 0; i <= index; i++) {
                    list.remove(0);
                }
                list.add(c);
                set.clear();
                set.addAll(list);
            }
        }
        if(list.size()>max){
            max = list.size();
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));

    }
}
