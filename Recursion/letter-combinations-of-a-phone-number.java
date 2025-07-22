
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

class Solution {

    public List<String> letterCombinations(String digits) {

        ArrayList <String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        HashMap <Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder res = new StringBuilder();
        solve(0, digits, res, map, ans);
        return ans;
    }

    void solve(int index, String digits, StringBuilder res, HashMap <Character,String> map,ArrayList <String> ans){
        if(index == digits.length()){
            ans.add(res.toString());
            return;
        }
        
        char ch = digits.charAt(index);
        String temp = map.get(ch);
        for(char alphabet : temp.toCharArray()){
            res.append(alphabet);
            solve(index + 1, digits, res, map, ans);
            res.deleteCharAt(res.length() - 1);
        }
    }
}