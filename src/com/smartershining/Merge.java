package com.smartershining;

import java.util.*;

/**
 * Created by smartershining on 16-5-6.
 */

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
class Interval {
    int start;
    int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Merge {
    public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if (result.get(result.size() - 1).end >= intervals.get(i).start) {
                result.get(result.size() - 1).end = Math.max(intervals.get(i).end, result.get(result.size() - 1).end);
            } else {
                result.add(intervals.get(i));
            }
        }
        return result;
    }
}
