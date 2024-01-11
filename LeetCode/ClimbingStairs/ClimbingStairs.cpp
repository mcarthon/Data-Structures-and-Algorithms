#include <iostream>
#include <unordered_map>
#include <string>

int climbStairs(int n);
int helper(int n, std::unordered_map<std::string, int> memo);

int main()
{
    std::cout << climbStairs(35) << "\n";

    std::cout << climbStairs(2) << "\n";
}

int climbStairs(int n) {

    std::unordered_map<std::string, int> memo;
    
    return helper(n, memo);

}

int helper(int n, std::unordered_map<std::string, int> memo) {

    std::string key = std::to_string(n);

    if (memo.find(key) != memo.end()) {

        return memo[key];

    }

    bool baseCase1 = n < 2;
    bool baseCase2 = n == 2;

    if (baseCase1) {
        return 1;
    }

    if (baseCase2) {
        return 2;
    }    

    memo[key] = helper(n - 1, memo) + helper(n - 2, memo);

    return memo[key];

}