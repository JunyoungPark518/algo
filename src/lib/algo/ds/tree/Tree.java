package lib.algo.ds.tree;

public class Tree {
    public Node root;

    public Node insert(Node left, int data, Node right) {
        Node n = new Node();
        n.data = data;
        n.left = left;
        n.right = right;
        return n;
    }

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot(){
        return root;
    }

    // 중위 순회
    public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    // 전위 순회
    public void preOrder(Node node) {
        if(node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 후위 순회
    public void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        Node n1 = t.insert(null, 4, null);
        Node n2 = t.insert(null, 5, null);
        Node n3 = t.insert(n1, 2, n2);
        Node n4 = t.insert(null, 3, null);
        Node n5 = t.insert(n3, 1, n4);

        t.setRoot(n5);
        System.out.println(">>>>>>>>>>>> IN_ORDER >>>>>>>>>>>>>>>");
        t.inOrder(t.getRoot());
        System.out.println(">>>>>>>>>>>> PRE_ORDER >>>>>>>>>>>>>>>");
        t.preOrder(t.getRoot());
        System.out.println(">>>>>>>>>>>> POST_ORDER >>>>>>>>>>>>>>>");
        t.postOrder(t.getRoot());
    }

}

class Node {
    int data;
    Node left;
    Node right;
}