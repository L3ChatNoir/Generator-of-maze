import java.util.concurrent.ThreadLocalRandom;

public class Edge{
    Node parent1;
    Node parent2;

    int weight;

    public Edge(Node parent1, Node parent2) {
        this.parent1 = parent1;
        this.parent2 = parent2;

        this.weight = ThreadLocalRandom.current().nextInt(0, 999);
    }

    public Edge(Node parent1, Node parent2, int weight) {
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.weight = weight;
    }

    public Node getParent1() {
        return parent1;
    }

    public Node getParent2() {
        return parent2;
    }

    public int getWeight() {
        return weight;
    }

    public Node getOtherParent(Node n) {
        if(this.parent1 == n){
            return parent2;
        }
        else {
            return parent1;
        }
    }

    public boolean contains(Node n){
        return this.parent1 == n || this.parent2 == n ? true : false;
    }
    
    public String toString() {
        return "Edge [parent1=" + parent1 + ", parent2=" + parent2 + ", weight=" + weight + "]";
    }
    
}