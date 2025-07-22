// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

// Example 1:

// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.

// Time Complexity:
// Worst-case combinations = C(9, k), because you're choosing k numbers out of 1–9.

// So max = C(9, 4) = 126 if k = 4

// For each combination, you're storing a list of size k

// So:

// Time Complexity = O(C(9, k) × k)

// Space Complexity = O(k) recursion stack + O(C(9, k) × k) for result storage


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();

        if(k > n) return ans;

        solve(ans, combinations, k, n, 1);
        return ans;
    }

    void solve(List<List<Integer>> ans, List<Integer> combinations, int k, int target, int start){
        if(combinations.size() == k && target == 0){
            ans.add(new ArrayList<>(combinations));
            return;
        }
        
        if (k < 0 || target < 0) return;

        for(int i = start; i <= 9; i++){
            combinations.add(i);
            solve(ans, combinations, k, target - i, i + 1);
            combinations.remove(combinations.size() - 1);
        }
        
    }
}