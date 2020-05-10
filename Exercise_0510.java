package java_0510;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise_0510 {
    int[] arr;
    int size;
    int front;
    int last;

    public void MyCircularDeque(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("Deque size is less than 0");
        }
        this.arr = new int[k];
        this.size = 0;
        this.front = 0;
        this.last = 0;
    }

    public boolean insertFront(int value) {
        if (size == arr.length) {
            return false;
        }
        if (front == 0) {
            arr[arr.length - 1] = value;
            front = arr.length - 1;
        } else {
            arr[--front] = value;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == arr.length) {
            return false;
        }
        arr[last] = value;
        size++;
        last = last == arr.length - 1 ? 0 : last + 1;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        front = front == arr.length - 1 ? 0 : front + 1;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        if (last == 0) {
            last = arr.length - 1;
        } else {
            last--;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return last == 0 ? arr[arr.length - 1] : arr[last - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public ArrayList<Integer> asylum(int[][] ope) {
        Queue<Integer> dog = new LinkedList<>();
        Queue<Integer> cat = new LinkedList<>();
        Queue<Integer> all = new LinkedList<>();
        ArrayList<Integer> animal = new ArrayList<>();
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1) {
                all.add(ope[i][1]);
                if (ope[i][1] > 0) {
                    dog.add(ope[i][1]);
                } else if (ope[i][1] < 0) {
                    cat.add(ope[i][1]);
                } else if (ope[i][0] == 2) {
                    if (ope[i][1] == 0) {
                        if (!all.isEmpty()) {
                            int tmp = all.poll();
                            animal.add(tmp);
                            if (tmp > 0) {
                                dog.poll();
                            } else {
                                cat.poll();
                            }
                        } else if (ope[i][1] > 0) {
                            if (!dog.isEmpty()) {
                                int tmp = dog.poll();
                                animal.add(tmp);
                                all.remove(tmp);
                            }
                        }
                    } else {
                        if (!cat.isEmpty()) {
                            int tmp = cat.poll();
                            animal.add(tmp);
                            all.remove(tmp);
                        }
                    }
                }
            }
        }
        return animal;
    }
}
