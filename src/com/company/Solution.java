package com.company;

import java.util.*;
import java.io.*;
public class Solution {

    //public static Exception Impossible = new Exception(){};
    static class Impossible extends Exception { }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String correct = in.nextLine();
            String typed = in.nextLine();


            try {
                int result = matchPossible(correct, typed);
                System.out.println("Case #" + i + ": " + result);

            } catch (Impossible e){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    public static int matchPossible(String correct, String typed) throws Impossible {
        int lengthDiff = typed.length() - correct.length();

        if (correct.equals(typed)){
            return 0;
        } else if (lengthDiff <= 0) {
            //Hence also covering if they are of the same length but different
            throw new Impossible();
        }

        for (int i = 0; i < correct.length(); i++) {
            if (correct.charAt(i) != typed.charAt(i)) {
                //Try to remove it
                return 1 + matchPossible(correct, removeAt(typed, i));
            }
        }

        return lengthDiff;
    }

    public static String removeAt(String data, int index){
        return new StringBuilder(data).deleteCharAt(index).toString();
    }

}
