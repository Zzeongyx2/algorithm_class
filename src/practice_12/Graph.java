package practice_12;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private final int V;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = new List[V];
        for(int v=0; v<V; v++){
            adj[v] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
//        adj[w].add(v);        //텍스트 파일에서 양방향 전부 입력 받아서 지움
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }

    public int E(){
        int E=0;
        for(List<Integer> list : adj){
            E += list.size();
        }
        return E/2;
    }

    public String toString(){
        String s = V + " vertices, " + E() + " edges\n";
        for(int v=0; v<V; v++){
            s += v + " : ";
            for(int w: this.adj(v)){
                s+= w+ " ";
            }
            s += "\n";
        }
        return s;
    }
}
