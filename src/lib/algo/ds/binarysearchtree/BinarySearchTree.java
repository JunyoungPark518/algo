package lib.algo.ds.binarysearchtree;

public class BinarySearchTree {

    private Node root;
    
    public void insert(int data) {
        Node n = new Node(data);
        
        if(root == null) {
            root = n;
        }
        else {
            Node tmp = root;
            while(tmp != null) {
                if(n.data > tmp.data) {
                    if(tmp.right == null) {
                        tmp.right = n;
                        return;
                    }
                    else {
                        tmp = tmp.right;
                    }
                    
                }
                else {
                    if(tmp.left == null) {
                        tmp.left = n;
                        return;
                    }
                    else
                        tmp = tmp.left;
                }
            }
        }
    }

    public void delete(Node n) {
        if(root != null) {
            Node tmp = root;
            Node parent = root;
            while(tmp != null) {
                if(tmp.data < n.data) {
                    parent = tmp;
                    tmp = tmp.right;
                }
                else if(tmp.data > n.data) {
                    parent = tmp;
                    tmp = tmp.left;
                }
                else {
                    if(tmp.left != null || tmp.right == null) {
                        if(parent.left == tmp) {
                            if(tmp.left != null)
                                parent.left = tmp.left;
                            else
                                parent.left = tmp.right;
                        }
                        else {


                        }

                    }
                }
            }

        }

    }

    public void print() {
        
    }
    
    public Node search(int data) {
        Node tmp = root;
        while(tmp != null) {
            if(tmp.data < data)
                tmp = tmp.right;
            else if(tmp.data > data)
                tmp = tmp.left;
            else if(tmp.data == data)
                break;
        }
        return tmp;
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
}

class Node {
    Node left;
    Node right;
    int data;
    
    public Node(int data) {
        this.data = data;
    }
}
