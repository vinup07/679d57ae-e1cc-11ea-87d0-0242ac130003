package com.telstra.b2b.dig.Tester;

import java.util.List;

public class BasicQuestions {

    public static void main(String[] args){
        String[] testArray = new String[]{
                "this", "is", "a", "test", "array"
        };

        //TODO: print out the contents of testArray on a single line
        System.out.println("Hi");


        //The method "checkAvailability" is a third party method
        // "checkAvailability"checks and returns success if the name is available.
        
        //Q1: Create a list of all the strings that are available (using Check Availability method) in testArray.

    }


    //treat this method as a black box. - you don't know what's inside.
    public static boolean checkAvailability(String name){
        //Does Stuff
        if(Math.random()<.5) return true;
        return false;
    }



}
