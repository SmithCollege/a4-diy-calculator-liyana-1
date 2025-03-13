package a4;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Postfix {
    
    
    public static Double postfix(ArrayDeque<Object> tokens) {
        int i; 
        i = 1;
        Object nextObj;
        Double ans;
        Character oper;
        oper = '*';
        Double num1;
        Double num2;
        // Character plus = +;
        ans = 2.0;
        Iterator<Object> tokensIterator = tokens.iterator();
        while (tokensIterator.hasNext()) {
            nextObj = tokensIterator.next();
            System.out.println(tokens + "obj");
            System.out.println(nextObj);
            if (nextObj instanceof Double) {
                tokens.remove(nextObj);
                tokens.add(nextObj);
                System.out.println(tokens);
                //tokensIterator = tokens.iterator();
            } else {
                oper = (Character) nextObj;
                num2 = (Double) tokens.pollLast();
                num1 = (Double) tokens.pollLast();
                if (oper == '+') {
                    tokens.remove('+');
                    // num1 = (Double) tokens.poll();
                    System.out.println(num1+"num1");
                    // num2 = (Double) tokens.poll();
                    System.out.println(num2+"num2");
                    ans = num1 + num2;
                    System.out.println(ans+"ans");
                    tokens.push(ans);
                    tokensIterator = tokens.iterator();
                }
                if (oper == '-') {
                    // num1 = (Double) tokens.poll();
                    System.out.println(num1+"num1");
                    // num2 = (Double) tokens.poll();
                    System.out.println(num2+"num2");
                    ans = num1 - num2;
                    System.out.println(ans+"ans");
                    tokens.push(ans);
                    tokens.remove('-');
                    tokensIterator = tokens.iterator();
                }
                if (oper == '*') {
                    // tokens.remove('*');
                    // num1 = (Double) tokens.poll();
                    System.out.println(num1+"num1");
                    // num2 = (Double) tokens.poll();
                    System.out.println(num2+"num2");
                    ans = num1 * num2;
                    System.out.println(ans+"ans");
                    tokens.push(ans);
                    tokens.remove('*');
                    tokensIterator = tokens.iterator();
                }
                if (oper == '/') {
                    // tokens.remove('/');
                    // num1 = (Double) tokens.poll();
                    System.out.println(num1+"num1");
                    // num2 = (Double) tokens.poll();
                    System.out.println(num2+"num2");
                    ans = num1 / num2;
                    System.out.println(ans+"ans");
                    tokens.push(ans);
                    tokens.remove('/');
                    tokensIterator = tokens.iterator();
                }
            }
        }
        ans = (Double) tokens.poll();
        System.out.println("ANSWER " +ans);
        return ans;
        // System.out.println(tokens);
        // System.out.println(tokens.size());
        // System.out.println(i>=tokens.size());
        // if (tokens.size() <= 1) {
        //     return ans;
        // }

        // for (i=1; i<=tokens.size();) {
        //     nextObj = tokens.poll();
        //     System.out.println("here");
        //     System.out.println(tokens.toArray());
        //     System.out.println(nextObj);
            // System.out.println("in for");
            // nextObj = tokens.poll();
            // if (nextObj instanceof Double) { 
            //     tokens.push(nextObj);
            //     ans = (Double) nextObj;
            //     System.out.println("one");
            //     if (tokens.size() <= 1) {
            //         System.out.println("one.one");
            //         return ans;
            //     }
            // } else {
            //     oper = (Character) nextObj;
            //     if (nextObj == "+") {
            //         num1 = (Double) tokens.pop();
            //         num2 = (Double) tokens.pop();
            //         nextObj = num1 + num2;
            //         tokens.push(nextObj);
            //         ans = (Double) nextObj;
            //         System.out.println("two");
            //         if (tokens.size() <= 1) {
            //             System.out.println("two.two");
            //             return ans;
            //         }
            //     } if (nextObj == "/") {
            //         num1 = (Double) tokens.pop();
            //         num2 = (Double) tokens.pop();
            //         nextObj = num1 / num2;
            //         tokens.push(nextObj);
            //         ans = (Double) nextObj;
            //         System.out.println("three");
            //         if (tokens.size() <= 1) {
            //             System.out.println("three.three");
            //             return ans;
            //         }
            //     }
            //     if (nextObj == "*") {
            //         num1 = (Double) tokens.pop();
            //         num2 = (Double) tokens.pop();
            //         nextObj = num1 * num2;
            //         tokens.push(nextObj);
            //         ans = (Double) nextObj;
            //         System.out.println("four");
            //         if (tokens.size() <= 1) {
            //             System.out.println("four.four");
            //             return ans;
            //         }
            //     } if (nextObj == "-") {
            //         num1 = (Double) tokens.pop();
            //         num2 = (Double) tokens.pop();
            //         nextObj = num1 - num2;
            //         tokens.push(nextObj);
            //         ans = (Double) nextObj;
            //         System.out.println("five");
            //         if (tokens.size() <= 1) {
            //             System.out.println("five.five");
            //             return ans;
            //         }
            //     }
        // }

    //}
    //return tokens.poll();
    //System.out.println("not functional");
    //return 1.0;
}
}