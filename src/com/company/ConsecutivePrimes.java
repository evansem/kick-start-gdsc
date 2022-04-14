package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Finds the secret code formed by taking the product of two consecutive prime numbers,
 * such that it is the largest number that is smaller than or equal to Z.
 *
 * Sample Input:
 * 2
 * 2021
 * 2020
 *
 * Sample Output:
 * Case #1: 2021
 * Case #2: 1763
 */
public class ConsecutivePrimes {
    public static boolean isPrime(int n) {
        if (n < 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long getCode(long z) {
        long output = 1;
        int p1 = 1;
        int p2 = 1;

        for (int j = 1; j < z; j++) {
            if (isPrime(j)) {
                p2 = p1;
                p1 = j;

                long tmp = p2 * p1;
                if (tmp > z) {
                    //maximum reached
                    return output;
                }
                output = tmp;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        // Scanner has functions to read ints, longs, strings, chars, etc.
        Scanner in = new Scanner(new BufferedReader(
                new InputStreamReader(System.in)));

        //How many test cases
        int t = in.nextInt();

        //Go through each test case
        for (int i = 1; i <= t; ++i) {
            //Limit
            long z = in.nextLong();

            //Output
            System.out.println("Case #" + i + ": " + getCode(z));
        }
    }
}
