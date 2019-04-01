public class Tester {

    public static void main(String[] args) {

        int randomMatrice = (int)(Math.random() * 7 + 4);
        int rows = randomMatrice;
        int columns = randomMatrice;
        System.out.println("Rows : " + rows + ", Columns : " + columns);


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

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(((graph[i][j] < 10) ? "0" : "") + (graph[i][j]) + " ");
            }
            System.out.println();
        }

        MaxFlow mi = new MaxFlow();

        System.out.println("The maximum possible flow is " +
                mi.fordFulkerson(graph, 0, 5));

    }


}
