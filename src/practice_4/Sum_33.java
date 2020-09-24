package practice_4;

import java.util.Arrays;
import java.util.Scanner;

public class Sum_33 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int [] arr = new int[8];
        int sum_2;
        int cnt = 0;
        System.out.println("정렬할 숫자 8개를 입력하세요.");

        for(int i=0;i<arr.length;i++){
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        System.out.print("오름차순으로 정렬된 배열 : ");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }

        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                sum_2 = arr[i] + arr[j];
                if(Search(arr,sum_2,j)){
                    cnt++;
                }
            }
        }

        System.out.println("\n조합 가능 개수 : " + cnt);

    }

    private static boolean Search(int[] arr, int sum_2, int j){

        for(int k=j+1;k<arr.length;k++){
            if(arr[k] == (sum_2*(-1))){
                return true;
            }
        }

        return false;
    }
}
