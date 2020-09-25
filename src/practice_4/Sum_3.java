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

        sort(arr);


        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                sum_2 = (arr[i] + arr[j])*(-1);
                int bs = binarySearch(arr,sum_2);
                if(bs > j){
                    cnt++;
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[bs]);
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

    private static void sort(int []a){      //selection sort

        for(int i=0; i<a.length; i++){
            int min = i;
            for(int j=i+1; j<a.length;j++){
                if(a[j]< a[min]){
                    min = j;
                }
            }
            int temp;
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}
