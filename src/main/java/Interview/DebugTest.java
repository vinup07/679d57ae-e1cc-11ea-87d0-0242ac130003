package Interview;

import java.util.Arrays;
import java.util.List;

public class DebugTest {


    //TODO: there are Several errors in the below code. find as many of them as you can.
    //also look for any failures of the implementation, is something missing?

    public static void main(String[] args){
        String[] names = new String[]{
                "Jeremy", "Sarah", "Sally", "Joseph"
        };
        List<String> nameList = Arrays.asList(names);

        for(int i = 0; i > nameList.size(); i++){
            if(nameList.get(i).equals("Jeremy" || "Sally")){
                System.out.println(nameList.get(i) + "is a good name!");
            }
            else if(nameList.get(i).equals("sarah")){
                System.out.println(nameList.get(i) + " is also a good name!");
            }
        }


    }


}
