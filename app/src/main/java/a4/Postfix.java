package a4;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Postfix {
    
    /** 
     *  takes in Postfix expression and solves for a final answer
     *  @param tokens
     *  @return ans
     */
    public static Double postfix(ArrayDeque<Object> tokens) {
        Object nextObj;
        Double ans;
        Character oper;
        oper = '*';
        Double num1;
        Double num2;
        ans = 2.0;
        Iterator<Object> tokensIterator = tokens.iterator();
        if (tokens.size() <=2) {
            if (tokens.getFirst() instanceof Character) {
                throw new IllegalArgumentException("Please enter valid expression");
            }
        }
        if (tokens.contains(')') || tokens.contains('(')) {
            throw new IllegalArgumentException("Please put expressions with parenthesis though Infix first.");
        }
        if (tokens.contains('0')) {
            throw new IllegalArgumentException("Please enter expressions without 0.");
        }
        while (tokensIterator.hasNext()) {
            nextObj = tokensIterator.next();
            if (!(nextObj instanceof Double) && !(nextObj instanceof Character)) {
                throw new IllegalArgumentException("Please only use operators and numbers.");
            }
            if (nextObj instanceof Double) {
                tokens.remove(nextObj);
                tokens.add(nextObj);
            } else {
                oper = (Character) nextObj;
                if (oper == '+') {
                    num2 = (Double) tokens.pollLast();
                    num1 = (Double) tokens.pollLast();
                    tokens.remove('+');
                    ans = num1 + num2;
                    tokens.push(ans);
                    tokensIterator = tokens.iterator();
                }
                if (oper == '-') {
                    num2 = (Double) tokens.pollLast();
                    num1 = (Double) tokens.pollLast();
                    ans = num1 - num2;
                    tokens.push(ans);
                    tokens.remove('-');
                    tokensIterator = tokens.iterator();
                }
                if (oper == '*') {
                    num2 = (Double) tokens.pollLast();
                    num1 = (Double) tokens.pollLast();
                    ans = num1 * num2;
                    tokens.push(ans);
                    tokens.remove('*');
                    tokensIterator = tokens.iterator();
                }
                if (oper == '/') {
                    num2 = (Double) tokens.pollLast();
                    num1 = (Double) tokens.pollLast();
                    ans = num1 / num2;
                    tokens.push(ans);
                    tokens.remove('/');
                    tokensIterator = tokens.iterator();
                }
                if (oper =='^') {
                    tokens.remove('^');
                    num2 = 1.0;
                    num1 = (Double) tokens.pollLast();
                    if (tokens.contains('^')) {
                        num2 = (Double) tokens.pollFirst();
                        ans = Math.pow(num1, num2);
                        tokens.push(ans);
                        tokensIterator = tokens.iterator();
                    } else {
                        num2 = (Double) tokens.pollLast();
                        ans = Math.pow(num2, num1);
                        tokens.push(ans);
                        tokensIterator = tokens.iterator();
                    }
                }
            }
        }
        if (tokens.size() > 1) {
            throw new IllegalArgumentException("Please use correct number of operators.");
        }
        ans = (Double) tokens.poll();
        return ans;
    }
}