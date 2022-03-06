package kakao.k2020;

import java.util.Stack;

// https://www.youtube.com/watch?v=Bc34h7xPTL8
public class Q2Answer {

    int pos;

    boolean isCorrect(String str) {
        boolean ret = true;
        int left = 0, right = 0;
        Stack<Character> myStack = new Stack<Character>();

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                left++;
                myStack.push('(');
            } else {
                right++;
                if (myStack.empty()) {
                    ret = false;
                } else {
                    myStack.pop();
                }
            }

            if (left == right) {
                pos = i + 1;
                return ret;
            }
        }

        return true;
    }

    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }

        boolean correct = isCorrect(p);
        String u = p.substring(0, pos);
        String v = p.substring(pos, p.length());

        if (correct) {
            return u + solution(v);
        }

        String answer = "(" + solution(v) + ")";
        for (int i = 1; i < u.length() - 1; ++i) {
            if (u.charAt(i) == '(') {
                answer += ")";
            } else {
                answer += "(";
            }
        }
        return answer;
    }
}
