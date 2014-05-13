package binarytree;

public class TreeNode {
	protected int item;
    protected TreeNode lChild;
    protected TreeNode rChild;

    TreeNode() {
    }

    TreeNode(int newItem) {
        item = newItem;
        lChild = null;
        rChild = null;
    }

    public void TreeNode(int newItem, TreeNode newlChild, TreeNode newrChild) {
        item = newItem;
        lChild = newlChild;
        rChild = newrChild;
    }

}
