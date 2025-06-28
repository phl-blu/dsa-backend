package binaryTreeHW;

public class Main {
    public static void main(String[] args) {
        BE8Tree tree = new BE8Tree();
        tree.root = new BE8Node(1);
        tree.root.left = new BE8Node(2);
        tree.root.right = new BE8Node(3);
        tree.root.left.left = new BE8Node(4);
        tree.root.left.right = new BE8Node(5);
        tree.root.right.left = new BE8Node(6);
        tree.root.left.left.left = new BE8Node(7);
        tree.root.left.left.right = new BE8Node(8);
        tree.root.left.right.left = new BE8Node(9);
        tree.root.left.left.left.left = new BE8Node(10);
        tree.root.left.left.left.right = new BE8Node(11);
        tree.root.left.left.right.left = new BE8Node(12);
        tree.root.left.left.left.left.left = new BE8Node(13);


        System.out.println("Is balanced: " + tree.isBalance());
        for (BE8Node node : tree.findImbalanceNode()) {
            System.out.println("Imbalanced nodes: " + node.value);
        }
    }
}
