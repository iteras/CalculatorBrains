package com.example.ompzu.calculatorit;

import java.util.ArrayList;
import java.math.*;

/**
 * Created by Ompzu on 3/9/2016.
 */
public class CalcEngine {
    private static final String TAG = "CalcEngine";
    public static final String[] op = {"C", "X","D","E", "P", "M", "N", "S","W","K" };

    public static int compare(String str){  //detects if number or operation, returns 0 as operation, anything else is number
        int result = 9; //random number, must not be 0 at start
        for(int i = 0; i < 6; i++){
            if(str.compareTo(op[i]) == 0){ //the string inserted is one of the operations
                result = 0;
            }
        }
        return result;
    }

    public static ArrayList<String> operation(ArrayList<String> in){
        double result = 0;
        double a,b = 0;
        try {
            a = Double.parseDouble(in.get(0));
        } catch ( Exception e) {
            a = Double.parseDouble(in.get(1));
        }
        // a = Double.parseDouble(in.get(0));

        if(in.size() > 2){ //if given equation is not sin or cos
            b = Double.parseDouble(in.get(2));
        }


        if(in.contains("X")){ //multiply
            result = times(a, b);
        }
        if(in.contains("D")){ //divide
            result = divide(a, b);
        }
        if(in.contains("P")){ // plus
            result = plus(a, b);
        }
        if(in.contains("M")){ //minus
            result = minus(a, b);
        }
        if(in.contains("W")){ //power
            result = Math.pow(a, b);
        }
        if(in.contains("N")){ //sin
            result = Math.sin(a);
        }
        if(in.contains("S")){ //cos
            result = Math.cos(a);
        }
        in.clear();
        in.add(String.valueOf(result));
        return in;

    }

    public static double plus(double a, double b){
        return a + b;
    }

    public static double minus (double a, double b){
        return a - b;
    }

    public static double divide(double a, double b){
        return a/b;
    }

    public static double times(double a, double b){
        return a*b;
    }
}
