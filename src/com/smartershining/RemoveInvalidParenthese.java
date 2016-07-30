package com.smartershining;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smartershining on 16-7-30.
 */
public class RemoveInvalidParenthese {
    ArrayList<String> list = new ArrayList<>();
    private int max;

    public List<String> removeInvalidParentheses(String s) {
        if (s == null) {
            return list;
        }
        dfs(s, "", 0, 0);
        if (list.size() == 0) {
            list.add("");
        }
        return list;
    }

    public void dfs(String left, String right, int leftCount, int maxLeft) {
        if (left.length() == 0) {
            if (leftCount == 0 && right.length() != 0) {
                if (maxLeft > max) {
                    max = maxLeft;
                }
                if (maxLeft == max && !list.contains(right)) {
                    list.add(right);
                }
            }
            return;
        }

        if (left.charAt(0) == '(') {
            dfs(left.substring(1), right + "(", leftCount + 1, maxLeft + 1);        //keep
            dfs(left.substring(1), right, leftCount, maxLeft);                      //drop
        } else if (left.charAt(0) == ')') {
            if (leftCount > 0) {
                dfs(left.substring(1), right + ")", leftCount - 1, maxLeft);
            }
            dfs(left.substring(1), right, leftCount, maxLeft);
        } else {
            dfs(left.substring(1), right + left.charAt(0), leftCount, maxLeft + 1);
        }
    }
}
