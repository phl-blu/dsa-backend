package treeHW;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Nodes root = new Nodes();
        root.value = 1;

        tree.root = root;

        Nodes node = new Nodes();
        node.value = 30;
        tree.root.children.add(node);

        node = new Nodes();
        node.value = 40;
        tree.root.children.add(node);

        tree.addChild(tree.root.children.get(0),10);
        tree.addChild(tree.root.children.get(0),14);
        tree.addChild(tree.root.children.get(1),48);
        tree.addChild(tree.root.children.get(1),83);

        Nodes findNode = tree.findNode(14);
        tree.addChild(findNode,20);

//        tree.printTree(tree.root, 1);
    }
}
