package com.smartershining;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;

/**
 * Created by smartershining on 16-6-22.
 */
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class MaxPoints {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int max = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int duplicate = 1;
            int vertical = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        duplicate++;
                    } else {
                        vertical++;
                    }
                } else {
                    Double slope = (points[j].y == points[i].y) ? 0.0 :
                            (1.0 * (points[j].y - points[i].y)) / (points[j].x - points[i].x);

                    if (map.get(slope) != null) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 1);
                    }
                }
            }
            for (Integer t : map.values()) {
                if (t + duplicate > max) {
                    max = t + duplicate;
                }
            }
            if (vertical + duplicate > max) {
                max = vertical + duplicate;
            }
            map.clear();
        }
        return max;

    }


}
