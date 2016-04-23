package com.smartershining;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by smartershining on 16-3-22.
 */

/**
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.

 *  Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 *  which is expressed as a pair: [0,1]

 *  Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all
 *  courses?

 *  For example:

 *  2, [[1,0]]

 *  There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 *  2, [[1,0],[0,1]]

 *  There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0
 *  you should also have finished course 1. So it is impossible.

 *  Note:
 *  The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 *  Read more about how a graph is represented.
 */
public class CanFinish {
    public  boolean canFinish(int numCourses, int [][]prerequisites){
        ArrayList[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int i = 0; i  < numCourses; ++ i){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i  < prerequisites.length; ++ i){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            ++indegree[prerequisites[i][0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i =0 ; i < indegree.length; ++ i){
            if(indegree[i] == 0)
                queue.add(i);
        }


        // 判断一个无向图是否有环
        int cnt = 0;
        while(! queue.isEmpty()){
            Integer cur = queue.poll();
            cnt++;
            ArrayList<Integer> list = graph[cur];
            for(int i = 0; i < list.size(); ++ i){
                int next = list.get(i);
                indegree[next] --;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }

        }
        return cnt == numCourses;

    }
}
