package lib.algo.ds.queue;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;

    public void add(T data) {
        Node<T> t = new Node(data);
        if(last != null) {
            last.next = t;
        }

        last = t;

        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null)
            throw new NoSuchElementException();

        T data = first.data;
        first = first.next;

        return data;
    }

    public T peek() {
        if(first == null)
            throw new NoSuchElementException();

        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println("q.peek() >>>>> " + q.peek());
        System.out.println("q.remove() >>> " + q.remove());
        System.out.println("q.remove() >>> " + q.remove());
        System.out.println("q.remove() >>> " + q.remove());
        System.out.println("q.isEmpty() >> " + q.isEmpty());
        System.out.println("q.remove() >>> " + q.remove());
        System.out.println("q.isEmpty() >> " + q.isEmpty());
    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}