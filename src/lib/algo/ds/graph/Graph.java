package lib.algo.ds.graph;

public class Graph {

    public static void main(String[] args) {
        AdjMatrix m = new AdjMatrix();
        for(int i =0; i<4 ;i++){
            m.insertVertex(i);
        }
        m.insertEdge(0, 3);
        m.insertEdge(0, 1);
        m.insertEdge(1, 3);
        m.insertEdge(1, 2);
        m.insertEdge(1, 0);
        m.insertEdge(2, 3);
        m.insertEdge(2, 1);
        m.insertEdge(3, 2);
        m.insertEdge(3, 1);
        m.insertEdge(3, 0);

        System.out.println("\n그래프 G의 인접행렬 : ");
        m.printAdjMatrix();
        System.out.println();


        AdjList l = new AdjList();
        for(int i =0; i<4 ;i++){
            l.insertVertex(i);
        }
        l.insertEdge(0, 3);
        l.insertEdge(0, 1);
        l.insertEdge(1, 3);
        l.insertEdge(1, 2);
        l.insertEdge(1, 0);
        l.insertEdge(2, 3);
        l.insertEdge(2, 1);
        l.insertEdge(3, 2);
        l.insertEdge(3, 1);
        l.insertEdge(3, 0);

        System.out.println("\n그래프 G의 인접행렬 : ");
        l.printAdjList();
        System.out.println();

    }


}

class AdjMatrix {

    private int matrix[][];
    private int vertexSize;

    public AdjMatrix() {
        matrix = new int[50][50];
        vertexSize = 0;
    }

    public void insertVertex(int v){
        vertexSize++;
    }

    public void insertEdge(int v1, int v2){
        if(v1 >= vertexSize || v2 >= vertexSize){
            System.out.println("vertex 값이 올바르지 않습니다.");
        }else{
            matrix[v1][v2]=1;
        }
    }

    public void printAdjMatrix(){
        for(int i=0; i<vertexSize;i++){
            for(int j =0; j<vertexSize; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}


class AdjList {

    private Node[] headList;
    private int headListSize;

    public AdjList() {
        // TODO Auto-generated constructor stub
        headList = new Node[10];
        headListSize = 0;
    }

    public void insertVertex(int i){
        headListSize++;
    }

    public void insertEdge(int v1, int v2){
        if(v1 >=headListSize || v2 >= headListSize){
            System.out.println("vertex 값이 올바르지 않습니다.");
        }else{
            Node gn = new Node(v2);
            gn.link=headList[v1];
            headList[v1]= gn;



            Node temp = headList[v1];
            int tempValue;
            //오름차준 정렬
            while(temp.link != null){
                if(temp.getVal() > temp.link.getVal()){
                    tempValue = temp.link.getVal();
                    temp.link.setVal(temp.getVal());
                    temp.setVal(tempValue);
                }
                temp = temp.link;
            }
        }

    }


    public void printAdjList(){

        for(int i =0; i <headListSize; i++){
            Node temp = headList[i];
            System.out.printf("정점 %c 의 인접리스트 -> ",(i+65));
            while(temp.link != null){
                System.out.printf("%c -> ", temp.getVal()+65);
                temp = temp.link;
            }
            System.out.printf("%c\n",(temp.getVal()+65));
        }
    }

}



class Node {
    Node link;
    int val;

    public Node(int val) {
        this.link = null;
        this.val = val;
    }
    
    public int getVal() {
        return val;
    }
    
    public void setVal(int val) {
        this.val = val;
    }
}