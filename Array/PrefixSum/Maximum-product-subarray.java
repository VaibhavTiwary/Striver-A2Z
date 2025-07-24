// Given an integer array nums, find a subarray that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.


// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Why left and right products?
// left keeps track of the product of elements from the left side (index 0 to i).

// right keeps track of the product of elements from the right side (index n-1 to i).

// At each index, we take the maximum of both products because the subarray with the maximum 
// product could start anywhere, not necessarily from the left.


// Why reset to 1 when product becomes 0?
// If we encounter a 0, any product including this zero becomes zero.

// We "reset" the product (set left or right to 1) to start a new subarray after the zero.
// (A new subarray might give a larger product.)

class Solution {
    public int maxProduct(int[] nums) {
        int left = 1;
        int right = 1;

        int n = nums.length;
        int ans = nums[0];

        for(int i = 0; i < nums.length; i++){
            if(left == 0) left = 1;
            if(right == 0) right = 1;

            left *= nums[i];
            right *= nums[n-1-i];

            int max = Math.max(left, right);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}