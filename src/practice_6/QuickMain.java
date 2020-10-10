package practice_6;

import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import java.util.HashSet;
import java.util.Set;

public class QuickMain {

    public static void main(String[] args) {

        quick();

        quickselect();
    }

    private static void quick(){
        String[] array = {"K", "R", "A", "T", "E", "L", "E", "P", "U", "I", "M", "Q", "C", "X", "O", "X"};
        QuickSort<String> quickSort = new QuickSort<String>();

        quickSort.shuffle(array);
        quickSort.sort(array, 0, array.length-1);

        System.out.print("QuickSort : ");
        for(int i=0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static void quickselect(){
        Integer[] arr = new Integer[100];

        for(int i=0;i<arr.length; i++){
            arr[i] = i+1;
        }
        QuickSort<Integer> quickSelect = new QuickSort<Integer>();

        Integer[] aux = quickSelect.shuffle(arr);

        Integer boundaryIndex = 3;
        quickSelect.select(aux, boundaryIndex);
        Integer boundaryValue = arr[boundaryIndex];

        Set<Integer> expected = new HashSet<Integer>();
        Collections.addAll(expected, boundaryValue);

        Set<Integer> actual = new HashSet<Integer>();
        for(int i=boundaryIndex; i<aux.length; i++){
            Integer value = aux[i];
            if(boundaryValue >= value){
                actual.add(value);
            }
        }

        Assertions.assertEquals(expected, actual);

        System.out.print("Quick Selection : ");
        for(int i=0; i<boundaryIndex;i++){
            System.out.print(quickSelect.select(aux, i)+" ");
        }
    }
}
