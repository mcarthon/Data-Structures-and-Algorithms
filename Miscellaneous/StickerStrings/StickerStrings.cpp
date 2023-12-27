#include <iostream>
#include <string>
#include <unordered_map>

int stickerString(std::string& input, std::string& target);

int main()
{
    std::string input = "facebook";
    std::string target = "fee";

    int output = stickerString(input, target);

    std::cout << output << std::endl;
}

int stickerString(std::string &input, std::string &target) {

    std::unordered_map<char, int> inputFrequencyMap;
    std::unordered_map<char, int> targetFrequencyMap;

    int inputIndex = 0;
    int targetIndex = 0;

    while (inputIndex < input.size()) {

        inputFrequencyMap[input.at(inputIndex ++)] ++;

        if (targetIndex < target.size()) {

            targetFrequencyMap[target.at(targetIndex++)] ++;

        }

    }

    int maxStickers = 0;

    for (const auto& entry : targetFrequencyMap) {

        const char key = entry.first;

        if (inputFrequencyMap.find(key) != inputFrequencyMap.end()) {

            int numStickers = targetFrequencyMap[key] / inputFrequencyMap[key];

            maxStickers = numStickers > maxStickers ? numStickers : maxStickers;

        }

        else {

            return -1;

        }

    }

    return maxStickers;

}