package MAxFlowAlgorithm;

import MAxFlowAlgorithm.MaximumFlow;

/**
 *
 * MaxFlowAlgorithm.Tester class to test the max flow (Ford fulgerson)algorithm
 * prints the number of nodes and the max flow with the
 * augmented path,max flow and the no.of nodes.
 *
 *
 * Done by:- A.Purushohth
 * UOW No:- W16995826
 * IIT NO:- 2017152
 * Done at :15/04/2019
 *
 */

public class Tester {

    public static void main(String[] args) {

        int randomMatrice = (int)(Math.random() * 7 + 6);
        int rows = randomMatrice;
        int columns = randomMatrice;



        int graph[][] = new int[rows][columns];

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 1; j < columns; j++) {
                if (j==i)
                    graph[i][j] = 0;
                else
                    graph[i][j] = (int) (Math.random() * 16 + 5);
            }
        }
        //System.out.println(Arrays.deepToString(graph));
        System.out.println("Matrix representation of the flow network");
        System.out.println("=========================================");
        System.out.println("The number of nodes : " + rows+ " (including 'source' and 'destination') "+"\n");



        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(((graph[i][j] < 10) ? "0" : "") + (graph[i][j]) + " ");
            }
            System.out.println();

        }

        MaximumFlow mi = new MaximumFlow();
        System.out.println("\nThe maximum possible flow is : " + mi.fordFulkerson(graph, 0, 5));




    }




}
