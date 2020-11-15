package practice_11;

import java.util.Scanner;

public class Tiling_BottomUp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int []arr = new int[n+1];

        arr[1] = 1;
        arr[2] = 2;

        if(n>2){
            for(int i=3; i<=n; i++){
                arr[i] = (arr[i-1] + arr[i-2]) %10007;
            }
        }
        System.out.println(arr[n]);
    }
}
