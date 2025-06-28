package binaryTreeHW;

import java.util.ArrayList;

public class BE8Tree {
    BE8Node root;

    public boolean isBalance() {
        return findImbalanceNode().isEmpty();
    }

    public ArrayList<BE8Node> findImbalanceNode() {
        ArrayList<BE8Node> result = new ArrayList<>();
        ArrayList<BE8Node> allNodes = new ArrayList<>();

        if (root != null) {
            allNodes.add(root);
        }
        for (int i = 0; i < allNodes.size(); i++) {
            if (allNodes.get(i).left != null) {
                allNodes.add(allNodes.get(i).left);
            }
            if (allNodes.get(i).right != null) {
                allNodes.add(allNodes.get(i).right);
            }
        }

        for (BE8Node node : allNodes) {
            int leftHeight = getHeight(node.left, allNodes);
            int rightHeight = getHeight(node.right, allNodes);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                result.add(node);
            }
        }

        return result;
    }

    public int getHeight(BE8Node node, ArrayList<BE8Node> allNodes) {
        if (node == null) return 0;

        int maxDepth = 0;
        ArrayList<BE8Node> currentLevel = new ArrayList<>();
        currentLevel.add(node);

        while (!currentLevel.isEmpty()) {
            maxDepth++;
            ArrayList<BE8Node> nextLevel = new ArrayList<>();

            for (BE8Node current : currentLevel) {
                if (current.left != null) {
                    nextLevel.add(current.left);
                }
                if (current.right != null) {
                    nextLevel.add(current.right);
                }
            }

            currentLevel = nextLevel;
        }

        return maxDepth;
    }

}
