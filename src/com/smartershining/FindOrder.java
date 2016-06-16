package com.smartershining;

import java.util.*;

/**
 * Created by smartershining on 16-5-5.
 */

/**
 *
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.

 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]

 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should
 * take to finish all courses.

 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all
 * courses, return an empty array.

 * For example:

 * 2, [[1,0]]

 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 * 4, [[1,0],[2,0],[3,1],[3,2]]

 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
 * Another correct ordering is[0,2,1,3].
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
}
