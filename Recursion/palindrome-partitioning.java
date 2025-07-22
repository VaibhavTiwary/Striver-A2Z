// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

// O(2^n * n)

class Solution {
    public List<List<String>> partition(String s) {

        List<String> partitions = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        solve(ans, partitions, s, 0);
        return ans;
    }

    void solve(List<List<String>> ans, List<String> partitions, String s, int start){
        if(start == s.length()){
            ans.add(new ArrayList<>(partitions));
            return;
        }

        for(int i = start; i < s.length(); i++){
            String substring = s.substring(start, i+1);
            if(is_pallindrome(substring)){
                partitions.add(substring);
                solve(ans, partitions, s, i+1);
                partitions.remove(partitions.size()-1);
            }
        }
    }

    boolean is_pallindrome(String str){
        int left = 0;
        int right = str.length() - 1;

        while(right >= left){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}