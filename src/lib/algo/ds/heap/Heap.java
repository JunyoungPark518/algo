package lib.algo.ds.heap;

public class Heap {
    private int[] heap = new int[50];
    private int size;

    public void insert(int data) {
        int idx = ++size;
        int tmp;

        heap[idx] = data;
        while(idx != 1 && heap[idx] > heap[idx/2]) {
            tmp = heap[idx/2];
            heap[idx/2] = heap[idx];
            heap[idx] = tmp;
            idx = idx/2;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int delete() {
        if(isEmpty())
            return 0;

        int root = heap[1];
        heap[1] = heap[size];
        size--;

        int idx = 1;
        int tmp;
        while(idx*2 <= size || idx*2+1 <= size) {
            if(heap[idx*2] > heap[idx*2+1]) {
                tmp = heap[idx*2];
                heap[idx*2] = heap[idx];
                heap[idx] = tmp;
                idx = idx*2;
            }
            else if(heap[idx*2] < heap[idx*2+1]) {
                tmp = heap[idx*2+1];
                heap[idx*2+1] = heap[idx];
                heap[idx] = tmp;
                idx = idx*2+1;
            }

        }

        return root;
    }

    public static void main(String[] args) {
        int n, item;
        Heap h = new Heap();

        h.insert(13);
        h.insert(8);
        h.insert(10);
        h.insert(15);
        h.insert(20);
        h.insert(19);
        h.insert(30);

        for(int i=1; i<=h.getSize() ; i++){
            item = h.delete();
            System.out.println("\n delete >>> " + item);
        }

    }

}
