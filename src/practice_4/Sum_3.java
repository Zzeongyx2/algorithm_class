package practice_4;

import java.util.Arrays;
import java.util.Scanner;

public class Sum_3 {
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
                sum_2 = (arr[i] + arr[j])*(-1) ;
                if(binarySearch(arr, sum_2)>j){
                    cnt++;
                }
            }
        }

        System.out.println("\n조합 가능 개수 : " + cnt);

    }

    private static int binarySearch(int[] a, int key){
        int lo = 0;
        int hi = a.length-1;

        while(lo <= hi){
            int mid = lo + (hi - lo) /2;
            if(key < a[mid]){
                hi = mid - 1;
            }else if(key > a[mid]){
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
