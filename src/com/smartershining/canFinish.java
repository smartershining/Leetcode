package com.smartershining;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by smartershining on 16-3-22.
 */
public class canFinish {
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
