package practice_12;

public class Processing {

    public static int degree(Graph G, int v){
        int degree = 0;
        for(int w : G.adj(v)){
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph G){
        int max = 0;
        for(int v=0; v<G.V(); v++){
            if(degree(G, v) > max){
                max = degree(G, v);
            }
        }
        return max;
    }

    public static double averageDegree(Graph G){
        int count = 0;
        for(int v=0; v<G.V(); v++){
            for(int w : G.adj(v)){
                if(v == w){
                    count++;
                }
            }
        }
        return count/2;
    }
}
