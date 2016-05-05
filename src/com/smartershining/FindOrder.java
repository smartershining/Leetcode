package com.smartershining;

import java.util.*;

/**
 * Created by smartershining on 16-5-5.
 */
public class FindOrder {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> adjLists = new ArrayList<Set<Integer>>();
         for (int i = 0; i < numCourses; i++) {
             adjLists.add(new HashSet<Integer>());
         }

        for (int i = 0; i < prerequisites.length; i++) {
            adjLists.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int x: adjLists.get(i)) {
                indegrees[x] ++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int count = 0;
        while (queue.size() != 0) {
            int cur = queue.poll();
            for (int x : adjLists.get(cur)) {
                indegrees[x] --;
                if (indegrees[x] == 0)
                    queue.offer(x);
            }
            result[count ++] = cur;
        }

        if (count == numCourses)
            return result;
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] prerequisities = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(findOrder(4, prerequisities)[3]);


    }
}
