// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]



class Solution {
    public List<String> generateParenthesis(int n) {
        
        int open = n;
        int close = n;
        List<String> ans = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        solve(open, close, ans, builder);
        return ans;
    }

    void solve(int open, int close, List<String> ans, StringBuilder builder){

        if(open == 0 && close == 0){
            ans.add(builder.toString());
            return;
        }

        if(open > 0){
            builder.append('(');
            solve(open-1, close, ans, builder);
            builder.deleteCharAt(builder.length() - 1);  

        }

        if(close > open){
            builder.append(')');
            solve(open, close-1, ans, builder);
            builder.deleteCharAt(builder.length() - 1); 
        }
    }


}