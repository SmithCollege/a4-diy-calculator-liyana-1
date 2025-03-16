package a4;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Postfix {
    
    
    public static Double postfix(ArrayDeque<Object> tokens) {
        Object nextObj;
        Double ans;
        Character oper;
        oper = '*';
        Double num1;
        Double num2;
        ans = 2.0;
        Iterator<Object> tokensIterator = tokens.iterator();
        while (tokensIterator.hasNext()) {
            nextObj = tokensIterator.next();
            if (!(nextObj instanceof Double) && !(nextObj instanceof Character)) {
                throw new IllegalArgumentException("Please only use operators and numbers.");
            }
            if (nextObj instanceof Double) {
                tokens.remove(nextObj);
                tokens.add(nextObj);
                System.out.println(tokens + "toekns");
            } else {
                oper = (Character) nextObj;
                if (oper == '+') {
                    num2 = (Double) tokens.pollLast();
                    num1 = (Double) tokens.pollLast();
                    tokens.remove('+');
                    System.out.println(num1+"num1");
                    System.out.println(num2+"num2");
                    ans = num1 + num2;
                    System.out.println(ans+"ans");
                    tokens.push(ans);
                    tokensIterator = tokens.iterator();
                }
                if (oper == '-') {
                    num2 = (Double) tokens.pollLast();
                    num1 = (Double) tokens.pollLast();
                    System.out.println(num1+"num1");
                    System.out.println(num2+"num2");
                    ans = num1 - num2;
                    System.out.println(ans+"ans");
                    tokens.push(ans);
                    tokens.remove('-');
                    tokensIterator = tokens.iterator();
                }
                if (oper == '*') {
                    num2 = (Double) tokens.pollLast();
                    num1 = (Double) tokens.pollLast();
                    System.out.println(num1+"num1");
                    System.out.println(num2+"num2");
                    ans = num1 * num2;
                    System.out.println(ans+"ans");
                    tokens.push(ans);
                    tokens.remove('*');
                    tokensIterator = tokens.iterator();
                }
                if (oper == '/') {
                    num2 = (Double) tokens.pollLast();
                    num1 = (Double) tokens.pollLast();
                    System.out.println(num1+"num1");
                    System.out.println(num2+"num2");
                    ans = num1 / num2;
                    System.out.println(ans+"ans");
                    tokens.push(ans);
                    tokens.remove('/');
                    tokensIterator = tokens.iterator();
                }
                if (oper =='^') {
                    tokens.remove('^');
                    System.out.println(tokens + "tokens");
                    num2 = 1.0;
                    num1 = (Double) tokens.pollLast();
                    System.out.println(tokens + "tokens");
                    System.out.println(num2+"num2");
                    if (tokens.contains('^')) {
                        System.out.println("hello");
                        num2 = (Double) tokens.pollFirst();
                        System.out.println(num2+"num2");
                        ans = Math.pow(num1, num2);
                        System.out.println(ans);
                        tokens.push(ans);
                        System.out.println("tokens" + tokens);
                        tokensIterator = tokens.iterator();
                    } else {
                        num2 = (Double) tokens.pollLast();
                        System.out.println("heyyyy");
                        System.out.println(num1+"num1");;
                        ans = Math.pow(num2, num1);
                        System.out.println(ans);
                        tokens.push(ans);
                        System.out.println("tokens" + tokens);
                        tokensIterator = tokens.iterator();
                    }
                }
            }
        }
        ans = (Double) tokens.poll();
        System.out.println("ANSWER " +ans);
        return ans;
    }
}