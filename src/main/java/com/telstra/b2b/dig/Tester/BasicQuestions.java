package com.telstra.b2b.dig.Tester;

public class BasicQuestions {

    public static void main(String[] args){
        String[] testArray = new String[]{
                "this", "is", "a", "test", "array"
        };

        //TODO: print out the contents of testArray on a single line


        //The method "checkAvailability" below checks if a name is available and returns the result as a boolean.
        //TODO: create a new List of Strings, and populate it with values in testArray that are available.




    }


    //treat this method as a black box. - you don't know what's inside.
    public static boolean checkAvailability(String name){
        //Does Stuff
        if(Math.random()<.5) return true;
        return false;
    }



}
