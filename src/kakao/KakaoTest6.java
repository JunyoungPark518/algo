package kakao;

import java.util.*;

public class KakaoTest6 {

    public static void main(String[] args) {

        int[][] arr = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        new KakaoTest6().solution(arr);
    }

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        List<Node> list = new LinkedList<Node>();

        for(int i = 0; i < nodeinfo.length; i++){
            list.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(list, new Comparator<Node>(){
            @Override
            public int compare(Node i1, Node i2){
                if(i1.y > i2.y){
                    return -1;
                } else if(i1.y < i2.y){
                    return 1;
                } else {
                    if(i1.x > i2.x){
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        Tree tree = new Tree();
        for(int i = 0; i < list.size(); i++){
            tree.addNode(list.get(i));
        }

        tree.preOrder(tree.root);
        String pre = tree.pre;

        String[] a = pre.split(" ");
        answer = new int[2][a.length];
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
            answer[0][i] = Integer.parseInt(a[i]);
        }


        tree.postOrder(tree.root);
        String post = tree.post;
        String b[] = post.split(" ");
        for(int i = 0; i < b.length; i++){
            System.out.println(b[i]);
            answer[1][i] = Integer.parseInt(b[i]);
        }

        return answer;
    }

    class Tree{
        public Node root;
        public String pre = "";
        public String post = "";
        public void addNode(Node i){
            if(root == null){
                root = i;
            } else {
                addNNode(i, root);
            }
        }
        public void addNNode(Node i, Node root){
            if(i.y < root.y){
                if(i.x < root.x){
                    if(root.left == null){
                        root.left = i;
                    } else {
                        addNNode(i, root.left);
                    }
                } else {
                    if(root.right == null){
                        root.right = i;
                    } else {
                        addNNode(i, root.right);
                    }
                }
            }
        }
        public void preOrder(Node root){
            if(root == null) return;

            pre += root.value + " ";
            preOrder(root.left);
            preOrder(root.right);
        }
        public void postOrder(Node root){
            if(root == null) return;


            postOrder(root.left);
            postOrder(root.right);
            post += root.value + " ";
        }
    }
    class Node{
        public int value;
        public int x;
        public int y;
        public Node left;
        public Node right;

        public Node(int value, int x, int y){
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
}



