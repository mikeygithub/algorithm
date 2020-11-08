package demo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class CQueue {
    //["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
    //[[],[],[5],[2],[],[]]

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            int n = stack1.size();
            for (int i = 0; i < n; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }

    public static void main(String[] args) {
//        CQueue cQueue = new CQueue();
//        cQueue.deleteHead();
//        cQueue.appendTail(5);
//        cQueue.appendTail(2);
//        System.out.println(cQueue.deleteHead());
//        System.out.println(cQueue.deleteHead());
//        int[] arr = {1,2,3};
//        ArrayList<Integer> list = new ArrayList<>();
//        Arrays.asList(arr).forEach(v->list.add(v));
//        System.out.println(list.size());
    }
}
