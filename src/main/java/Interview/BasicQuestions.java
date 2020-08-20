package Interview;

import Interview.utils.getNames;

public class BasicQuestions {

    public static void main(String[] args){
        String[] nameArray = new String[]{
                "Sarah", "Bentley", "Adam", "Ben", "Jonathon"
        };

        //The method "checkAvailability" below checks and returns success if the given name is available.
        //TODO: capture all the strings that are available in nameArray.

    }


    //treat this method as a black box. - you don't need to know what's inside.
    public static boolean checkAvailability(String name){
        if(getNames.getTakenNames().contains(name)) return false;
        return true;
    }



}
