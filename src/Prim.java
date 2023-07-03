import java.util.ArrayList;
import java.util.HashSet;

public class Prim {
    Graph graph;
    ArrayList<Edge> select_edge;

    Prim(Graph graph) {
        this.graph = graph;
        this.select_edge = prim();
    }

    public ArrayList<Edge> prim() {
        HashSet<Node> selected_nodes = new HashSet<Node>();
        ArrayList<Edge> edges = new ArrayList<Edge>();

        //take a first Node
        selected_nodes.add(this.graph.getNode(0,0));

        //While we haven't select all nodes 
        while(selected_nodes.size() != graph.getNodes().size()) {
            Edge nextedge = new Edge(null, null, Integer.MAX_VALUE);

            //search minum edge with a parent that not select
            for(Node n : selected_nodes) {
                for(Edge e : graph.getNeighbors(n)){
                        if((e.getWeight() < nextedge.getWeight() ) && (!selected_nodes.contains(e.getOtherParent(n)))) {
                            nextedge = e;
                        }
                    }
                }
            try {
                selected_nodes.add(nextedge.getParent1());
                selected_nodes.add(nextedge.getParent2());
                edges.add(nextedge);
            }
            catch(Exception e) {
                System.out.println("DOUBLONS");
                System.out.println(selected_nodes.size());
                return edges;
            }
        }
        return edges;
    }

    public ArrayList<Edge> getEdges() {
        return this.select_edge;
    }
}