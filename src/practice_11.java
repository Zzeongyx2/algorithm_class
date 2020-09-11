import java.util.Scanner;

public class practice_11 {
    static int[] arr = new int[6];
    static int[] sum = new int[6];


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            System.out.println("숫자 6개를 입력하세요 : ");

            for(int i=0; i<arr.length; i++){
                arr[i] = scan.nextInt();
            }

            System.out.println("누적합 : ");

            for(int i =0; i<arr.length; i++){
                System.out.println(SumFunction(i));
        }
    }

    public static int SumFunction(int n){
        if(n == 0){
            return arr[0];
        }
        else{
            sum[n] = arr[n] + SumFunction(n-1);
        }
        return sum[n];
    }
}


