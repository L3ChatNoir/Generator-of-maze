public class Main {

    public static void main(String[] args){
        //create new graph with specific dimension
        Graph Graph = new Graph(15, 25);

        //generate the maze
        Graph.prim();

        //show the maze
        GUI window = new GUI(Graph);
        window.setVisible(true);
    }
}