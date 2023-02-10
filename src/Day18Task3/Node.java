package Day18Task3;

public class Node {
    private int number;
    private Node left;
    private Node right;

    public Node(int number) {
        this.number = number;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getNumber() {
        return number;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
