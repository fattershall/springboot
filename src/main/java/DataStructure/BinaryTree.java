package DataStructure;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author pengh
 */
public class BinaryTree {

    private TreeNode root;

    private TreeNode find(int key) {

        Date date = new Date();

        ArrayList list = new ArrayList();

        TreeNode current = root;
        while (current.getId() != key) {
            if (current.getId() == key) {
                return current;
            } else if (current.getId() > key) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }

            if (current == null) {
                break;
            }
        }

        return current;
    }

    private void insert(int id, String name) {
        TreeNode t = new TreeNode(id, name);
        TreeNode current;
        if (root == null) {
            root = t;
        } else {
            current = root;
            while (current != null) {
                if (id < current.getId()) {
                    if (current.getLeftNode() != null) {
                        current = current.getLeftNode();
                    } else {
                        current.setLeftNode(t);
                        break;
                    }

                } else if (id > current.getId()) {
                    if (current.getRightNode() != null) {
                        current = current.getRightNode();
                    } else {
                        current.setRightNode(t);
                        break;
                    }

                }

            }

        }


    }

    private void preNode(TreeNode treeNode) {


        if (treeNode != null) {
            System.out.println(root.getId());
            preNode(root.getLeftNode());


            preNode(root.getRightNode());

        }

    }

    private void inNode(TreeNode treeNode) {

        if (treeNode != null) {

            inNode(treeNode.getLeftNode());
            System.out.println(treeNode.getId());
            inNode(treeNode.getRightNode());
        }
    }


    private void postNode(TreeNode treeNode) {
        root = treeNode;
        while (root != null) {
            preNode(root.getLeftNode());
            preNode(root.getRightNode());
            System.out.println(root.getId());
        }
    }

    private TreeNode getMaxNode()
    {
        TreeNode current = root;
        TreeNode lastnode = null;
        while (current != null) {
            lastnode = current;
            current = current.getRightNode();
        }
        return lastnode;
    }

    private TreeNode getMinNode() {
        //region Description
        TreeNode current = root;
        //endregion

        TreeNode lastnode = null;
        while (current != null) {
            lastnode = current;
            current = current.getLeftNode();
        }
        return lastnode;
    }

    private boolean delete(int key) {


        return false;
    }


    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.insert(6, "6");
        t.insert(5, "6");
        t.insert(8, "6");
        t.insert(3, "6");
        t.insert(7, "6");
        t.insert(9, "6");
        System.out.println(t.root.toString());
        t.inNode(t.find(6));
        TreeNode max = t.getMaxNode();
        System.out.println("max == " + max);
        TreeNode min = t.getMinNode();
        System.out.println("min == " + min);

    }
}
