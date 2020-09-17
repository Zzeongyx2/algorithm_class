package practice_3;


import static java.lang.Math.*;

public class SelectionSort {
    public static void main(String[] args) {
        double [] sel_arr = new double[10000];

        for(int i=0; i<sel_arr.length; i++){
            sel_arr[i] = random();
        }

        long beforeTime = System.currentTimeMillis();

        for(int i=0; i<sel_arr.length; i++){
            int min = i;
            for(int j=i+1; j<sel_arr.length;j++){
                if(less(sel_arr[j], sel_arr[min])){
                    min = j;
                }
            }
            exch(sel_arr, i, min);
        }

        long afterTime = System.currentTimeMillis();

        System.out.println("선택 정렬 수행시간 : " + (afterTime-beforeTime));

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
