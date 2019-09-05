package lib.algo.ds.stack;

import java.util.EmptyStackException;

public class Stack<T> {

    Node<T> top = null;
    int size = 0;

    public void push(T data) {
        Node<T> node = new Node<T>(data);
        node.next = top;
        top = node;

        size++;
    }

    public T peek() {
        if(size <= 0 || top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public T pop() {
        if(size <= 0 || top == null)
            throw new EmptyStackException();

        size--;

        T data = top.data;
        top = top.next;

        return data;
    }

    public boolean isEmpty() {
        return top  == null && size == 0;
    }

    public int size() {
        return size;
    }

    public void empty() {
        size = 0;
        top = null;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(3);
        s.push(6);
        s.push(2);

        System.out.println(">>>>> size >>>> " + s.size());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(">>>>> size >>>> " + s.size());
        System.out.println(s.peek());
        System.out.println(">>>>> isEmpty >>>> " + s.isEmpty());
        System.out.println(">>>>> size >>>> " + s.size());
        System.out.println(s.pop());
        System.out.println(">>>>> isEmpty >>>> " + s.isEmpty());
        System.out.println(s.pop());
        System.out.println(">>>>> size >>>> " + s.size());
        System.out.println(">>>>> isEmpty >>>> " + s.isEmpty());

    }

}

class Node<T> {
    T data;
    Node<T> next;
    Node(T data) {
        this.data = data;
    }
}
