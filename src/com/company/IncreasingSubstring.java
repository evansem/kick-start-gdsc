package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * a string C of length L consisting of uppercase English characters is strictly increasing if, for every pair of
 * indices i and j such that 1≤i<j≤L (1-based), the character at position i is smaller than the character at position j.
 *
 * For example, the strings ABC and ADF are strictly increasing, however the strings ACC and FDA are not.
 *
 * given a string S of length N, you have to find out, for every position 1≤i≤N,
 * what is the length of the longest strictly increasing substring that ends at position i.
 *
 * Sample Input:
 * 2
 * 4
 * ABBC
 * 6
 * ABACDA
 *
 * Sample Output:
 * Case #1: 1 2 1 2
 * Case #2: 1 2 1 2 3 1
 */
public class IncreasingSubstring {

    public static int longestDescending(String s, int prevLongest) {
        if (prevLongest > 1) {
            return prevLongest - 1;
        }
        int longest = 1;

        //The last character, prev because we move backwards
        int prevValue = s.charAt(s.length() - 1);

        //Start from the second to last
        for (int i = s.length() - 2; i >=0; i--) {
            int currentValue = s.charAt(i);

            if (currentValue < prevValue) {
                longest++;
            } else {
                return longest;
            }
            prevValue = currentValue;
        }

        return longest;
    }

    public static void main(String[] args) {
        // Scanner has functions to read ints, longs, strings, chars, etc.
        Scanner in = new Scanner(new BufferedReader(
                new InputStreamReader(System.in)));

        //How many test cases
        int t = in.nextInt();

        StringBuilder output = new StringBuilder();

        //Go through each test case
        for (int i = 1; i <= t; ++i) {
            String tmpOut ="";
            //String length
            int n = in.nextInt();
            //Current string
            String s = in.next();

            output.append(String.format("Case #%d: ", i));
            StringBuilder sb = new StringBuilder(s);
            int prevLongest = 1;

            for (int substringIndex = n; substringIndex > 0; substringIndex--) {
                //Start from the back and remove one char at the time

                prevLongest =longestDescending(sb.toString(), prevLongest);

                tmpOut = prevLongest + " " + tmpOut;
                if (sb.length() > 1) {
                    //Ignore the last char and keep going
                    sb.setLength(sb.length() - 1);
                }

            }

            output.append(tmpOut).append("\n");
        }
        System.out.print(output);
    }
}
