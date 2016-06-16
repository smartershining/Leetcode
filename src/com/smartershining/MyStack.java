package com.smartershining;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by smartershining on 16-4-23.
 */

/**
 * Implement the following operations of a stack using queues.

 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.

 * Notes:

 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front,
 * size, and is empty operations are valid.

 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or
 * deque (double-ended queue), as long as you use only standard operations of a queue.

 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty
 * stack).

 * Update (2015-06-11):
 * The class name of the Java function had been updated to MyStack instead of Stack.
 */
public class MyStack {

        private Queue<Integer> queue = new LinkedList<Integer>();
        public  void push(int x){
            queue.offer(x);
        }
        public  void pop(){
            int size = queue.size();
            for(int i = 1;  i < size ; ++ i){
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        public  int top(){
            int size = queue.size();
            for(int i = 1; i  < size ; ++ i){
                queue.offer(queue.poll());
            }
            int top = queue.peek();
            queue.offer(queue.poll());
            return top;
        }
        public  boolean empty(){
            return  queue.isEmpty();
        }
}

