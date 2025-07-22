// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

// Example 1:

// Input: x = 2.00000, n = 10
// Output: 1024.00000


class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        long pow = n;
        return solve(x, pow);
    }

    double solve(double x, long pow){
        
        if(pow < 0){
            x = 1/x;
            pow = -1 * pow;
        }
        if(pow == 1) return x;


        double half = solve(x, pow/2);
        if(pow % 2 ==1){
            return half * half * x;
        }
        return half * half;


    }
}