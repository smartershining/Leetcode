package com.smartershining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by smartershining on 16-5-26.
 */

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * Example:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

public class MinStack {
    int size;
    List<Integer> list;
    List<Integer> order;
    int min;


    public MinStack() {
        list = new ArrayList<Integer>();
        order = new ArrayList<Integer>();
        size = 0;
    }

    public void push(int x) {
        list.add(x);
        order.add(x);
        Collections.sort(order);
        size++;
    }

    public void pop() {
        order.remove(list.get(size - 1));
        Collections.sort(order);
        list.remove(--size);
    }

    public int top() {
        return list.get(size - 1);
    }

    public int getMin() {
        return order.get(0);
    }
}

class MinStack2 {

    Stack<Integer> s;
    Stack<Integer> min;


    public MinStack2() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if (min.empty() || x <= min.peek()) {
            min.push(x);
        }
        s.push(x);
    }

    public void pop() {
        if (s.peek().equals(min.peek())) {
            min.pop();
        }
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
