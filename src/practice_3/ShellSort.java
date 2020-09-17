package practice_3;

import static java.lang.Math.random;

public class ShellSort {
    public static void main(String[] args) {
        double [] sh_arr = new double[10000];

        for(int i=0; i<sh_arr.length; i++){
            sh_arr[i] = random();
        }

        long beforeTime = System.currentTimeMillis();

       int h = 1;

       while(h< sh_arr.length/3){
           h = 3*h +1;
       }

       while(h>=1){
           for(int i=h; i<sh_arr.length;i++){
               for(int j=i; j>=h && less(sh_arr[i], sh_arr[i-h]); j-=h) {
                   exch(sh_arr, j, j - h);
               }
           }
           h = h/3;
       }

        long afterTime = System.currentTimeMillis();

        System.out.println("쉘 정렬 수행시간 : " + (afterTime-beforeTime));

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