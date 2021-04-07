package com.leetcode.bfs;

import java.util.*;
/*
https://leetcode-cn.com/problems/clone-graph/
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Queue<Node> oriQueue = new LinkedList<>();
        oriQueue.offer(node);
        Node nodeClone = new Node(node.val);
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, nodeClone);

        while(!oriQueue.isEmpty()) {
            Node oriRoot = oriQueue.poll();
            if (oriRoot.neighbors == null) {
                continue;
            }

            for (Node neighborNode : oriRoot.neighbors) {
                if (!map.containsKey(neighborNode.val)) {
                    Node cloNode = new Node(neighborNode.val);
                    oriQueue.offer(neighborNode);
                    map.put(cloNode.val, cloNode);
                }
                map.get(oriRoot.val).neighbors.add(map.get(neighborNode.val));
            }
        }

        return nodeClone;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
