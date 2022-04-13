package com.company;

import java.util.*;
import java.io.*;
public class Solution {

    //public static Exception Impossible = new Exception(){};
    static class Impossible extends Exception { }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String correct = in.next();
            String typed = in.next();


            try {
                int result = matchPossible(correct, typed);
                System.out.println("Case #" + i + ": " + result);

            } catch (Impossible e){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    public static int matchPossible(String correct, String typed) throws Impossible {
        

        return 0;
    }


}
