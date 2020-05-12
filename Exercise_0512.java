package java_0512;

import java.util.PriorityQueue;

public class Exercise_0512 {
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (o1, o2) -> -o1 + o2);
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {
            Integer head1 = maxHeap.poll();
            Integer head2 = maxHeap.poll();

            maxHeap.offer(head1 - head2);
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        Exercise_0512 solution = new Exercise_0512();
        int[] stones = {1, 3};
        int res  = solution.lastStoneWeight(stones);
        System.out.println(res);
    }
}
