package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenkx
 * @Date 2019/3/11 20:43
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 **/
public class TwoSum {

    /**
     * 遍历数组,在数组内部求@target与@num1的差,将差放入map中判断是否已经存在该键值,如果存在返回结果,
     * 如果不存在,以差为key,下标为value存入map
     * @param nums 数组
     * @param target 两数之和
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for (int i=0; i<nums.length; i++){
            int num1 = target - nums[i];
            if(map.containsKey(num1)){
                int[] result = {map.get(num1),i};
                return result;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
