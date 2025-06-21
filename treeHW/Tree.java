package treeHW;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    Nodes root;

    public void addChild(Nodes parent, int value) {
        Nodes newNode = new Nodes();
        newNode.value = value;
        parent.children.add(newNode);
    }

    public Nodes findNodeBFS(int value) {
        if (root == null)
            return null;

        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Nodes current = queue.poll();
            if (current.value.equals(value)) {
                return current;
            }
            for (Nodes child : current.children) {
                queue.add(child);
            }
        }
        return null;
    }

    public Nodes findNodeDFS(int value){
        return findNodeDFS(root, value);
    }

    public Nodes findNodeDFS(Nodes node, int value) {
        if (node == null) {
            return null;
        }
        for (Nodes child : node.children) {
            Nodes result = findNodeDFS(child, value);
            if (result != null) {
                return result;
            }
        }
        if (node.value.equals(value)) {
            return node;
        }
        return null;
    }


//    public static void printTree(Nodes node, int level) {
//        if (node == null) return;
//
//        // Print indentation based on level
//        for (int i = 0; i < level; i++) {
//            System.out.print("  ");
//        }
//        System.out.println("Node: " + node.value);
//
//        // Print all children
//        for (Nodes child : node.children) {
//            printTree(child, level + 1);
//        }
//    }
}
