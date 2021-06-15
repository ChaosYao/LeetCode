package com.leetcode.string;

public class IntToRoman {
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] reps={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            if (num >= values[i]) {
                while(num >= values[i]) {
                    num -= values[i];
                    result.append(reps[i]);
                }
            }
        }

        return result.toString();
    }
}
