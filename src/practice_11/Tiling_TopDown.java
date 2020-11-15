package practice_11;

import java.util.Scanner;

public class Tiling_TopDown {

    static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        arr = new int[n+1];

        arr[1] = 1;
        arr[2] = 2;

        System.out.println(tiling(n));
    }

    public static int tiling(int n){
        if(arr[n] > 0){
            return arr[n];
        }else{
            arr[n] = (tiling(n-1) + tiling(n-2)) %10007;
            return arr[n];
        }
    }
}
