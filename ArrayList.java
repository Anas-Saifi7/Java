
// import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class ArrayList {
  
  public static void main(String[] args) {
   ArrayList<Integer> list = new  ArrayList<Integer>();
   // ArrayList<String> list1 = new ArrayList<String>();
    // add elements to the list
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    System.out.println(list);

    // get elements to the list
   int element =  list.get(2);
     System.out.println(element);
    // add element in b/w
    list.add(2,5);
     System.out.println(list);
    
    list.set(1,9);   
    System.out.println(list);
    // list ele remove;
    list.remove(4);
    System.out.println(list);
    // found the size;
    int size = list.size();
    System.out.println( size);
    // loops
    for(int i=0;i<list.size();i++){
      System.out.print(list.get(i));
    }
    System.out.println();
    // Sorting 
    Collections.sort(list);
    System.out.println(list);
  }

}

