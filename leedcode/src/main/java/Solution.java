/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count1 = 0;
        int count2 = 0;
        int target = (nums1.length + nums2.length) / 2 + 1;
        boolean flag = true;
        int[] nums = new int[target];
        if (((nums1.length + nums2.length) % 2) == 1) {
            flag = true;
        } else {
            flag = false;
        }
        while (true) {
            if (count1 < nums1.length && count2 < nums2.length && (count1 + count2) < target) {
                if (nums1[count1] <= nums2[count2]) {
                    nums[count1 + count2] = nums1[count1];
                    count1++;
                }
                if (count1 < nums1.length && (count1 + count2) < target) {
                    if (nums1[count1] > nums2[count2]) {
                        nums[count1 + count2] = nums2[count2];
                        count2++;
                    }
                }
            } else if (count2 < nums2.length && (count1 + count2) < target) {
                nums[count1 + count2] = nums2[count2];
                count2++;
            } else {
                nums[count1 + count2] = nums1[count1];
                count1++;
            }
            if ((count1 + count2) >= target) {
                if (flag) {
                    return nums[target - 1];
                } else {
                    return (nums[target - 1] + nums[target - 2]) / 2.0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
