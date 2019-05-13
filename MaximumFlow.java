package MAxFlowAlgorithm;
/**
 *
 * The MaxFlowAlgorithm.MaximumFlow describes the how the maximum flow is calculated.
 * The visited nodes and the used data structure is linked list and array
 * AS the final output the maxflow is returned..
 *
 * Done by:- A.Purushoth
 * UOW No:- W16995826
 * IIT NO:- 2017152
 * Done at :15/04/2019
 *
 */

import java.util.LinkedList;

class MaximumFlow {
    static final int V = 6;

    int fordFulkerson(int graph[][], int s, int t) {
        int u, v;

        int residualGraph[][] = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                residualGraph[u][v] = graph[u][v];

        // This array is filled by BFS and to store path
        int parentNode[] = new int[V];

        int maxuimum_flow = 0;  //  no flow


        while (bfs(residualGraph, s, t, parentNode)) {

            String value = "";

            int path_flow = Integer.MAX_VALUE;

            for (v = t; v != s; v = parentNode[v]) {

                u = parentNode[v];
                value += String.valueOf(v) + ">-";
                path_flow = Math.min(path_flow, residualGraph[u][v]);
            }
            System.out.println("Visited path = " + "0" + new StringBuilder(value).reverse().toString());

            // update residual capacities of the edges and
            // reverse edges along the path
            for (v = t; v != s; v = parentNode[v]) {
                u = parentNode[v];
                residualGraph[u][v] -= path_flow;
                residualGraph[v][u] += path_flow;
            }

            //prints the induvidual path
            System.out.println("Now the path flow is = : " + path_flow);
            System.out.println("____________________________________");

            // Add path flow to overall flow
            maxuimum_flow += path_flow;

        }

        // Return the flow
        return maxuimum_flow;
    }

    boolean bfs(int rGraph[][], int s, int t, int parent[]) {

        // visitedNodes
        boolean visitedNodes[] = new boolean[V];
        for (int i = 0; i < V; ++i)
            visitedNodes[i] = false;

        // Create a queue, enqueue source vertex and mark
        // source vertex as visitedNodes
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visitedNodes[s] = true;
        parent[s] = -1;

        System.out.println();
       // System.out.print("Augmented path :");
        //System.out.print(1 + "->" + 0);

        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (visitedNodes[v] == false && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                   // System.out.print("," + parent[v] + "->" + v);
                    visitedNodes[v] = true;
                }
            }
        }
        System.out.println();



        return (visitedNodes[t] == true);
    }



}