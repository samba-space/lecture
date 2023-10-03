package s7_recursive_tree_graph.p9_10_tree말단까지_가장짧은경로;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int answer = Integer.MAX_VALUE;

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

        System.out.println(dfs(0, root));
        System.out.println(bfs(root));
    }

    public static int dfs(int L, Node node) {
        if (node.lt == null && node.rt == null) {
            return L;
        }

        return Math.min(dfs(L + 1, node.lt), dfs(L + 1, node.rt));
    }

    public static int bfs(Node node) {
        int L = 0;
        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);

        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                Node findNode = Q.poll();
                if (findNode.lt == null && findNode.rt == null) {
                    return L;
                }
                if (findNode.lt != null) {
                    Q.offer(findNode.lt);
                }
                if (findNode.rt != null) {
                    Q.offer(findNode.rt);
                }
            }
            L++;
        }
        return -1;
    }
}
