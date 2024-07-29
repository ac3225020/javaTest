package LinkedList;

import javafx.scene.chart.ValueAxis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.cn/problems/lru-cache
public class LRUCache {

    class CacheNode {
        Integer value;
        Integer key;

        CacheNode(Integer value, Integer key) {
            this.value = value;
            this.key = key;
        }
    }

    //如果满了 head指针最先淘汰 如果没满
    Queue<CacheNode> queue = new LinkedList<>();

    Map<Integer, CacheNode> nodeMap = null;
    int size = 0;
    int capacity = 0;


    public LRUCache(int capacity) {
        nodeMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        CacheNode oldNode = nodeMap.get(key);
        //塞到队尾去
        queue.remove(oldNode);
        queue.offer(oldNode);
        return oldNode.value;
    }

    public void put(int key, int value) {
        CacheNode newNode = new CacheNode(value, key);
        if (nodeMap.containsKey(key)) {
            CacheNode oldNode = nodeMap.get(key);
            queue.remove(oldNode);
            queue.offer(newNode);
            nodeMap.put(key, newNode);
        }else {
            if (size + 1 <= capacity) {
                size++;
            } else {
                //满了 要驱逐
                CacheNode oldNode = queue.poll();
                nodeMap.remove(oldNode.key);
            }
            queue.offer(newNode);
            nodeMap.put(key, newNode);
        }


    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2, 6); //
        System.out.println(lRUCache.get(1));
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));

    }
}
