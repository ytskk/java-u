import java.util.Iterator;
import java.util.NoSuchElementException;

public class ds_Queue<Item> implements Iterable<Item> {

    public int len;
    public int n;
    private Node first; // Старый
    private Node last;

    public ds_Queue() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean isFull() {
        return n == len;
    }

    public int size() {
        return n;
    }

    public int resize(int k) {
        len *= k;
        return len;
    }

    public void add(Item item) {

        Node node = last;
        last = new Node();
        last.item = item;
        last.next = null;
        n = n + 1 % (len + 1);
        if (isEmpty()) first = last;
        else if (isFull()) {
            last.next = first;
        } else
            node.next = last;

    }


    public void remove() {
        first = first.next;
        if (isEmpty()) last = null;
        n -= 1;
    }

    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }

    private class Node {
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current;

        public ListIterator(Node first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}
