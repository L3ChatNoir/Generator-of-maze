public class Node{
    int x;
    int y;

    public Node(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y;
    }
    
    public boolean equals(Node n){
        return this.x == n.getx() && this.y == n.gety() ? true : false;
    }

    public String toString() {
        return "Node(" + this.x +", " + this.y + ")";
    }

}