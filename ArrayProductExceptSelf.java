import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

        You must write an algorithm that runs in O(n) time and without using the division operation.



        Example 1:

        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]
        Example 2:

        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]


        Constraints:

        2 <= nums.length <= 105
        -30 <= nums[i] <= 30
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


        Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)*/
class ArrayProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        //Time complexity : O(N) where N represents the number of elements in the input array.
        // We use one iteration to construct the array L,
        // one to construct the array R and
        // one last to construct the answer array using LLL and RRR.

        //Space complexity : O(N) used up by the two intermediate arrays that
        // we constructed to keep track of product of elements to the left and right.
        /*
        int length = nums.length;
        int[] result = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        for(int i = 1; i < length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[length - 1] = 1;
        for(int i = length-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i = 0; i  < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
         */

        //Time: O(n)
        //space: O(1)

        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        for(int i = 1; i < length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        int right = 1;
        for(int i = length-1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums  = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}