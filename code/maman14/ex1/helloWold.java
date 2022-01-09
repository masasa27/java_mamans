package code.maman14.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class helloWold {
    public static void main(String[] args)
    {
        System.out.println("Hello World");

        Student a = new Student("123", "123", "123", 5, "123");
        Student b = new Student("124", "123", "123", 5, "123");
        Student c = new Student("125", "123", "123", 5, "123");
        

        List<String> listB = Arrays.asList("Saturday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Sunday");
        

        List<Integer> listA = Arrays.asList(6,1,2,3,4,5,0);

        List<Integer> copy = new ArrayList<>();
        copy.addAll(listA);
        Collections.sort(copy);


        Map<String, Integer> weekdayOrder = new HashMap<String, Integer>();
        for (int i : copy)
        {
            String weekday = listB.get(listA.indexOf(i));
            weekdayOrder.put(weekday, i);
        }
         System.out.println(weekdayOrder);

    }
    
}
