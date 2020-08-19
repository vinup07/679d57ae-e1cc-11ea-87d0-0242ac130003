package com.telstra.b2b.dig.Tester;

import java.util.List;

public class BasicQuestions {

    public static void main(String[] args){
        String[] testArray = new String[]{
                "this", "is", "a", "test", "array"
        };

        //TODO: print out the contents of testArray on a single line
        System.out.println("Hi");


        //The method "checkAvailability" below checks and returns success if the name is available.
        //TODO: capture all the strings that are available in testArray.

    }


    //treat this method as a black box. - you don't know what's inside.
    public static boolean checkAvailability(String name){
        //Does Stuff
        if(Math.random()<.5) return true;
        return false;
    }



}
