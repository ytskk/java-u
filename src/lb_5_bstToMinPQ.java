import java.util.LinkedList;
import java.util.Queue;

public class lb_5_bstToMinPQ {

    static Node BSTToSortedLL(Node root, Node head_ref) {
        if (root == null) return head_ref;
        head_ref = BSTToSortedLL(root.right, head_ref);
        root.right = head_ref;
        if (head_ref != null) (head_ref).left = null;
        head_ref = root;
        head_ref = BSTToSortedLL(root.left, head_ref);
        return head_ref;
    }

    static Node SortedLLToMinHeap(Node root, Node head) {
        if (head == null) return null;
        Queue<Node> q = new LinkedList<>();
        root = head;
        head = head.right;
        root.right = null;
        q.add(root);

        while (head != null) {
            Node p = q.peek();
            q.remove();
            Node leftC = head;
            head = head.right;
            leftC.right = null;
            q.add(leftC);
            p.left = leftC;
            if (head != null) {
                Node rightC = head;
                head = head.right;
                rightC.right = null;
                q.add(rightC);
                p.right = rightC;
            }
        }
        return root;
    }

    static Node BSTToMinHeap(Node root) {
        Node head = null;
        head = BSTToSortedLL(root, head);
        root = null;
        root = SortedLLToMinHeap(root, head);
        return root;
    }

    static Node add(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;
        node.left = node.right = null;
        return node;
    }

    static class Node {
        int value;
        int key;
        Node left, right;
    }
}
