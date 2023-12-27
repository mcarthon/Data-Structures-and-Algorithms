// TribonacciLeetcode.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <unordered_map>
#include <string>

int tribonacci(int n);

int helper(int n, std::unordered_map<std::string, int>& memo);

int tribonacci(int n) {

    std::unordered_map<std::string, int> memo;
    
    return helper(n, memo);

}
int helper(int n, std::unordered_map<std::string, int>& memo) {

    std::string key = std::to_string(n);

    if (memo.find(key) != memo.end()) {

        return memo[key];

    }

    if (n <= 1) {

        return n;

    }

    if (n == 2) {

        return 1;

    }

    memo[key] = helper(n - 1, memo) + helper(n - 2, memo) + helper(n - 3, memo);

    return memo[key];

}

int main()
{
    std::cout<< tribonacci(5) <<"\n";
    std::cout << tribonacci(15) << "\n";
    std::cout << tribonacci(105) << "\n";
}



// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
