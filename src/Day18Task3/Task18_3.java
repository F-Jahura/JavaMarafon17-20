package Day18Task3;

public class Task18_3 {
    public static void main(String[] args) {
        Node root = new Node(20);
        int[] treeNumbers = {5, 8, 11, 14, 15, 16, 18, 22, 23, 24, 27, 150};
        for (int treeNumber : treeNumbers){
            addNewNode(treeNumber, root);
        }
        dfs(root);
    }

    public static void addNewNode(int addNumber, Node root){
        Node nextNode = root;
        Node currentNode = null;

        while (nextNode != null) {
            currentNode = nextNode;

            if (currentNode.getNumber() > addNumber) {
                nextNode = currentNode.getLeft();
            } else {
                nextNode = currentNode.getRight();
            }
        }

            if (currentNode.getNumber() > addNumber){
                currentNode.setLeft(new Node(addNumber));
            }else {
                currentNode.setRight(new Node(addNumber));
            }
    }

    public static void dfs(Node root){
        if (root == null)
            return;
        dfs(root.getLeft());
        System.out.print(root.getNumber() + " ");
        dfs(root.getRight());

    }

}
