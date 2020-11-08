package demo;


import java.util.Arrays;
import java.util.Stack;

class Solution {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void append(int value){
        stack1.push(value);
    }

    public int delete(){

        if (stack2.empty()){
            return Integer.parseInt(null);
        }
        for (int i = 0; i < stack1.size(); i++) {
            stack2.push(stack1.peek());
        }
        stack1.remove(stack1.lastElement());
        stack2.removeAllElements();
        return stack2.pop();
    }
}
