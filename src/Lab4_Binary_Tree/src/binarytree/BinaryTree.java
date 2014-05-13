package binarytree;


public class BinaryTree {
    TreeNode root;
    TreeNode newNode;
    TreeNode parent;
    TreeNode NodeDelete;
    char child;
    int countLevel;
    //���ʹ��Ǩ�ͺ��ҷ����ҧ�����������    

    public boolean isEmpty() {
        return root == null;
    }
    //���ʹ���ҵ��˹�㹡�������˹��亹��շ��        

    public void insertItem(TreeNode bst, int newItem) {
        if (newItem < bst.item) {
            if (bst.lChild == null) {
                newNode = new TreeNode(newItem);
                bst.lChild = newNode;
            } else {
                insertItem(bst.lChild, newItem);
            }
        } else {
            if (bst.rChild == null) {
                newNode = new TreeNode(newItem);
                bst.rChild = newNode;
            } else {
                insertItem(bst.rChild, newItem);
            }
        }
    }
    //�����������亹��շ��  

    public TreeNode insert(int newItem) {
        if (isEmpty()) {
            newNode = new TreeNode(newItem);
            root = newNode;
        } else {
            insertItem(root, newItem);
        }
        return root;
    }
    //�����˹��亹��շ�����ͷӡ��ź�˹�

    public void search(TreeNode bst, int searchKey) {
        if (searchKey == bst.item) {
            NodeDelete = bst;
        } else if (searchKey < bst.item) {
            parent = bst;
            child = 'l';
            search(bst.lChild, searchKey);
        } else {
            parent = bst;
            child = 'r';
            search(bst.rChild, searchKey);
        }
    }
//�����˹�������ѡ��� inordersuccessor
    public void inordersuccessor(TreeNode bst) {
        if (bst.lChild != null) {
            parent = bst;
            ++countLevel;
            inordersuccessor(bst.lChild);
        } else {
            NodeDelete.item = bst.item;
            if (countLevel == 0) {
                NodeDelete.rChild = null;
            } else {
                parent.lChild = null;
            }
        }
    }
    //ź�˹��亹��շ��   

    public void delete(int deleteItem) {
        if (isEmpty()) {
            System.out.println("Tree Empty");
        } else {
            parent = root;
            NodeDelete = null;
            search(root, deleteItem);
            TreeNode lChild = NodeDelete.lChild;
            TreeNode rChild = NodeDelete.rChild;
            if ((lChild == null) && (rChild == null)) {
                //�˹�����ͧ���ź������˹��
                if (child == 'l') {
                    parent.lChild = null;
                } else {
                    parent.rChild = null;
                }
            } else if ((lChild != null) && (rChild != null)) {
                //�˹�����ͧ���ź���˹��١�ͧ�˹�
                countLevel = 0;
                inordersuccessor(NodeDelete.rChild);
            } else {
                //�˹�����ͧ���ź���˹��١˹���˹� 
                if (NodeDelete.lChild != null) {
                    if (child == 'l') {
                        parent.lChild = NodeDelete.lChild;
                    } else {
                        parent.rChild = NodeDelete.lChild;
                    }
                } else {
                    if (child == 'l') {
                        parent.lChild = NodeDelete.rChild;
                    } else {
                        parent.rChild = NodeDelete.rChild;
                    }
                }
            }
        }
    }
    //��ͧ�����亹��շ�մ�����ѡ��� preOrder   

    public void preOrder(TreeNode rootNode) {
        if (rootNode != null) {
            System.out.print(rootNode.item + " ");
            preOrder(rootNode.lChild);
            preOrder(rootNode.rChild);
        }
    }
    //��ͧ�����亹��շ�մ�����ѡ��� inOrder   

    public void inOrder(TreeNode rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.lChild);
            System.out.print(rootNode.item + " ");
            inOrder(rootNode.rChild);
        }
    }
    //��ͧ�����亹��շ�մ�����ѡ��� postOrder  

    public void postOrder(TreeNode rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.lChild);
            postOrder(rootNode.rChild);
            System.out.print(rootNode.item + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode();
        root = tree.insert(60);
        tree.insert(20);
        tree.insert(10);  
        tree.insert(40);
        tree.insert(30);
        tree.insert(50);
        tree.insert(70);
        System.out.println("Insert: 60 20 10 40 30 50 70 ");
        System.out.print("Preorder: ");
        tree.preOrder(root);
        tree.delete(20);
        System.out.println("\nDelete: 20");
        System.out.print("Preorder: ");
        tree.preOrder(root);
        System.out.print("\nInorder: ");
        tree.inOrder(root);
        System.out.print("\nPostorder: ");
        tree.postOrder(root);
    }
}
