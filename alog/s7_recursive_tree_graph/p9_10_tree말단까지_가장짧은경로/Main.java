package s7_recursive_tree_graph.p9_10_tree말단까지_가장짧은경로;

import java.util.LinkedList;
import java.util.Queue;

// 최단거리문제는 bfs로 푸는게 맞음 -> 최단거리에 도달하면 종료됨 -> bfs는 모든경로를 다 가봐야함
// 비가중치는 bfs, 가중치는 다익스트라로 푼다
// dfs는 제약이 있음(자식노드가 한쪽만 있으면 에러남, 즉 이진트리여야함)
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

        dfs(0, root);
    }

    public static void dfs(int L, Node node) {
        if (node == null) {
            answer = Math.max(answer, L);
            return;
        }

        dfs(L + 1, node.lt);
        dfs(L + 1, node.rt);
    }

}
