import java.util.ArrayList;

public class Graph{
    ArrayList<Node> nodes;
    ArrayList<Edge> edges;

    public Graph(int width, int lenght) {
        //initialisation des arraylist
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();

        //ajout de chaque nodes
        for(int x = 0; x < lenght; x++) {
            for(int y=0; y < width; y++) {
                this.nodes.add(new Node(x,y));
            }
        }

        //ajout des edges verticaux
        for(int x = 0; x < lenght; x++) {
            for(int y=0; y < width-1; y++) {
                this.edges.add(new Edge(this.getNode(x, y), this.getNode(x, y+1)));
            }
        }

        //ajout des edges horizontaux
        for(int x = 0; x < lenght-1; x++) {
            for(int y=0; y < width; y++) {
                this.edges.add(new Edge(this.getNode(x, y), this.getNode(x+1, y)));
            }
        }
    }
    
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public Node getNode(int x, int y) {
        for(Node n : this.nodes) {
            if(n.getx() == x && n.gety() == y) {
                return n;
            }
        }
        return null;
    }

   public boolean contains(Node n1, Node n2){
        for(Edge e : this.edges){
            if(e.getParent1() == n1 && e.getParent2() == n2){
                return true;
            }
            else if(e.getParent1() == n2 && e.getParent2() == n1){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Edge> getNeighbors(Node n) {
        ArrayList<Edge> neighbors = new ArrayList<Edge>();
        for(Edge e : this.edges){
            if(e.contains(n)){
                neighbors.add(e);
            }
        }
        return neighbors;
    }

    public void prim() {
        Prim prim = new Prim(this);
        this.edges = prim.getEdges();
    }
}