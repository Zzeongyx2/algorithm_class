public class Fibonacci {
    static long mem[] = new long[100];

    public static long F(int N){
        if(N == 0) return 0;
        if(N == 1) return 1;

        if(mem[N] != 0){   //이전에 계산해 둔 결과 재사용
            return mem[N];
        }
        mem[N] = F(N-1) + F(N-2);       //계산 결과 배열 저장
        return mem[N];
//        return F(N-1) + F(N-2);

    }

    public static void main(String[] args) {

        long beforeTime = System.currentTimeMillis();       //시작 시각

        for(int N=0; N<45;N++)
            System.out.println(N + " " + F(N));

        long afterTime = System.currentTimeMillis();        //종료 시각
        double secDiffTime = (afterTime - beforeTime)/1000.0;   //연산 시간 계산
        System.out.println("연산시간 : " + secDiffTime);
    }
}

