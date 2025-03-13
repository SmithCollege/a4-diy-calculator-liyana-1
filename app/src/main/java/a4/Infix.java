package a4;

import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Iterator;

public class Infix {

    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Object> outputQueue = new ArrayDeque<>(); //numbers added here
        ArrayDeque<Object> stack = new ArrayDeque<>(); //operators added here
        Object nextObj;
        Object movingOper
        Hashtable<Object, Integer> precedence = new Hashtable<>();
        precedence.put('+', 2);
        precedence.put('-', 2);
        precedence.put('*', 3);
        precedence.put('/', 3);
        Iterator<Object> tokensIterator = tokens.iterator();
        while (tokensIterator.hasNext()) {
            nextObj = tokensIterator.next();
            System.out.println(tokens + "obj");
            System.out.println(nextObj);
            if (nextObj instanceof Double) {
                tokens.remove(nextObj);
                outputQueue.add(nextObj);
                System.out.println(tokens);
                tokensIterator = tokens.iterator();
            } else {
                if (stack.size()>=1) {
                    nextObj = (Character) nextObj;
                    if (precedence.get(nextObj) <= precedence.get(stack.getFirst())) {
                        movingOper = stack.pop();

                    }
                }
            }

        return 1.0;
        
    }

}}

