/*Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109*/

import java.util.HashSet;

class ContainsDuplicate {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!hashSet.add(nums[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
}