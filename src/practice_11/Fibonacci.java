package practice_11;

public class Fibonacci {
    public static long F(int N){
        if( N <= 2){
            return 1;
        }

        return F(N-1) + F(N-2);

    }

    public static void main(String[] args) {

        long beforeTime = System.currentTimeMillis();       //시작 시각

        for(int N=0; N<45;N++)
            System.out.println(N + " " + F(N));

        long afterTime = System.currentTimeMillis();        //종료 시각
        double secDiffTime = (afterTime - beforeTime)/1000.0;   //연산 시간 계산

        System.out.println("동적 계획 아닌 것의 연산시간 : " + secDiffTime);
    }
}


