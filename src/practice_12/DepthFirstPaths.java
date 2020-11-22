package practice_12;

import java.util.Iterator;
import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph G, int s){
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = G.adj(v).iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!marked[n])
                dfs(G, n);
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

}
