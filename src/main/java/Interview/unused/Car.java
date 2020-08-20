package Interview.unused;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public String maker;
    public String model;
    public String colour;
    public int serialNumber;
    public List<String> optionalExtras;

    public Car(String maker, String model,String colour){
        this.maker = maker;
        this.model = model;
        this.colour = colour;
        this.serialNumber = (int)Math.random()*10000;
        optionalExtras = new ArrayList<String>();
    }

    //Takes in the name of an extra feature and adds it to the optionalExtras list.
    //example use - addExtra("Power Windows");
    public void addExtra(String extra){
        //to implement
    }

    //Takes in a List of Extras and adds them to the Cars optionalExtras list.
    public void addExtras(List<String> extras){
        //to implement
    }

    //PrintCar should print the output like so:
    //Subaru Impreza grey 6534 Power Windows Self Driving
    public void printCar(){
        System.out.print(maker);
        System.out.print(model);
        System.out.print(colour);
        System.out.print(serialNumber);
        //implment: print out the optional extras.

    }


    public static void main(String[] args){



        //Question 1: Instantiate 2 car objects with the following properties
        //maker = "Subaru", model = "Impreza", colour = "grey"
        //maker = "Toyota", model = "Corolla", colour = "blue";



        //Question 2: Implement the addExtras function and use it to add Power Windows and Self Driving to the Subaru.


        //Question 3: implement the addExtras function, and use it to add the Same extras to the Toyota.


        //Question 4: Identify and fix the bug in the existing printCar() method and finish the Implementation. Call the print function for the Toyota



        int i = 3;
        changeInt(i);
        //Question 5: what would be the output of System.out.println(i);

    }


    public static void changeInt(int i){
        i = 0;
        i *= 20;
    }
}





