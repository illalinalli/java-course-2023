package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Сlusterize {
    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        clusters.add(input.substring(start, i + 1));
                        start = i + 1;
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input: unbalanced parentheses");
                }
            }
        }
        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: unbalanced parentheses");
        }
        return clusters;
    }
}
