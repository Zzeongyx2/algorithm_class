package practice_2;

import com.jeongyy.pack.Counter;
import com.jeongyy.pack.StdRandom;

public class Rolls {
    public static void main(String[] args) {
        int T = Integer.parseInt("100000");
        int SIDES = 6;
        Counter[] rolls = new Counter[SIDES+1];

        for (int i = 1; i <= SIDES; i++) {
            rolls[i] = new Counter(i + "s");
        }

        for (int t = 0; t < T; t++) {
            int result = StdRandom.uniform(1, SIDES+1);
            rolls[result].increment();
        }

        for (int i = 1; i <= SIDES; i++) {
            System.out.println(rolls[i]);
        }
    }
}


