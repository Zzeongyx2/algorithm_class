package practice_12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class DFSmain {
    public static void main(String[] args) throws IOException {

        int j=1;
        Graph graph = new Graph(7);
        
        File file = new File("/Users/jeongyunyoung/documents/dfs.txt");
        
        if(file.exists()) {
            BufferedReader inFile = new BufferedReader(new FileReader(file));
            
            String sLine = null;
            
            while ((sLine = inFile.readLine()) != null){

                String txt[] = sLine.split(",");
                
                for(int i=0 ; i<txt.length; i++){
                    graph.addEdge(j,Integer.parseInt(txt[i]));
                }
                j++;
            }
        }
        
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph ,2);

        for (int v = 0; v < graph.V(); v++) {
            if (depthFirstPaths.hasPathTo(v)) {
                for (int x : depthFirstPaths.pathTo(v)) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }
}
