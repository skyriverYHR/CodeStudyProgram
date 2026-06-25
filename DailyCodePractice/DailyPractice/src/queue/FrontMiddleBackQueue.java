package queue;

import java.util.ArrayList;

public class FrontMiddleBackQueue {
    ArrayList<Integer> queue;
    int length;
    public FrontMiddleBackQueue() {
        this.queue = new ArrayList<>();
        length = 0;
    }

    public void pushFront(int val) {
        queue.addFirst(val);
        length++;
    }

    public void pushMiddle(int val) {
        if (length == 0){
            queue.addFirst(val);
        }else {
            queue.add(length/2,val);
        }
        length++;
    }

    public void pushBack(int val) {
        queue.addLast(val);
        length++;
    }

    public int popFront() {
        if (length == 0){
            return -1;
            }
        int a = queue.removeFirst();
        length--;
        return a;
    }

    public int popMiddle() {
        int a = 0;
        if (length == 0){
            return -1;
        } else if(length%2 == 0) {
            a = queue.remove(length/2-1);
        }else {
            a = queue.remove(length/2);
        }
        length--;
        return a;
    }

    public int popBack() {
        if (length == 0){
            return -1;
        }
        int a = queue.removeLast();
        length--;
        return a;
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue f = new FrontMiddleBackQueue();
        f.pushFront(1);
        f.pushBack(2);
        f.pushMiddle(3);
        f.pushMiddle(4);
        System.out.println(f.popFront());
        System.out.println(f.popMiddle());
        System.out.println(f.popMiddle());
        System.out.println(f.popBack());
    }
}
//可以通过两个队列优化，自己写的时候使用队列的思想不清晰
