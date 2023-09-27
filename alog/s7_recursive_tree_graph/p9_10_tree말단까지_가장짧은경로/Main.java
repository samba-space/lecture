package s7_recursive_tree_graph.p7_이진트리레벨탐색;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class Node {
        private Node lt;
        private Node rt;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt = new Node(3);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        bfs(root);
    }

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print(L + " : ");
            for (int i = 0; i < size; i++) {
                Node findNode = queue.poll();
                System.out.print(findNode.value + " ");
                if (findNode.lt != null ) {
                    queue.offer(findNode.lt);
                }
                if(findNode.rt != null) {
                    queue.offer(findNode.rt);
                }
            }
            L++;
            System.out.println();
        }
    }
}
