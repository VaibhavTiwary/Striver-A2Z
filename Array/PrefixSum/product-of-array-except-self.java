// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] pref = new int[n]; //store prefix prodcut for each index //har index ke pehle ke elements ka product
        //ex- 1,2,3,4
        // pref[] = 1,1,1*2,1*2*3
        
        int[] suff = new int[n]; //har index k aage k elements ka product
        // suff[] = 2*3*4, 3*4, 4, 1

        pref[0] = 1 ;//there is no element behind 0th index so initialized with 1
        suff[n-1] = 1;//as there is no element after last index so 1

        for(int i = 1; i < n; i++){
            pref[i] = pref[i-1] * nums[i-1];
        }

        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
// Now, at any index i our final answer ans[i] would be given by ans[i] = pref[i] * suff[i]. Why? Because the pref[i] * suff[i] contains product of every element before i and every element after i but not the element at index i (and that is the reson why we excluded a[i] in our prefix and suffix product).
        for(int i = 0; i < n; i++) {
            ans[i] = pref[i] * suff[i];
        }
        return ans;
    }
}


//Can optimze the space by storing prefix and suffix array
//we can directly store the product of them into ans array

// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int ans[] = new int[n];
//         Arrays.fill(ans, 1);
//         int curr = 1;
//         for(int i = 0; i < n; i++) {
//             ans[i] *= curr;
//             curr *= nums[i];
//         }
//         curr = 1;
//         for(int i = n - 1; i >= 0; i--) {
//             ans[i] *= curr;
//             curr *= nums[i];
//         }
//         return ans;
//     }
// }