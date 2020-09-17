package practice_3;

import static java.lang.Math.random;

public class InsertionSort {
    public static void main(String[] args) {
        double [] ins_arr = new double[10000];

        for(int i=0; i<ins_arr.length; i++){
            ins_arr[i] = random();
        }

        long beforeTime = System.currentTimeMillis();

        for(int i=0; i<ins_arr.length; i++){
            for(int j=i; j>0 && less(ins_arr[j], ins_arr[j-1]); j--){
                exch(ins_arr, j, j-1);
            }
        }

        long afterTime = System.currentTimeMillis();

        System.out.println("삽입 정렬 수행시간 : " + (afterTime-beforeTime));

    }

    private static boolean less(double current, double min){
        if(current<min){
            return true;
        }else {
            return false;
        }
    }


    private static void exch(double[] arr, int i, int min){
        double temp;
        temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

}
