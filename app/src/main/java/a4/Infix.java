package a4;

import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Iterator;

public class Infix {

    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Object> outputQueue = new ArrayDeque<>(); //numbers added here
        ArrayDeque<Object> stack = new ArrayDeque<>(); //operators added here
        Object nextObj;
        Object prevObj;
        Character nextObjChar;
        Object movingOper;
        Character movingOperChar;
        Character existingObj;
        Character firstChar;
        int i;
        int j;
        Double finalAns;
        Hashtable<Object, Integer> precedence = new Hashtable<>();
        precedence.put('+', 2);
        precedence.put('-', 2);
        precedence.put('*', 3);
        precedence.put('/', 3);
        precedence.put('^', 4);
        Iterator<Object> tokensIterator = tokens.iterator();
        ArrayDeque<Object> originalTokens = tokens;
        if (tokens.contains(')')) {
            if (!tokens.contains('(')) {
                throw new IllegalArgumentException("Incorrect use of parenthesis");
            }
        }
        if (tokens.contains('(')) {
            if (!tokens.contains(')')) {
                throw new IllegalArgumentException("Incorrect use of parenthesis");
            }
        }
        if (tokens.size() <=2) {
            if (tokens.getFirst() instanceof Character) {
                throw new IllegalArgumentException("Please enter valid expression");
            }
        }
        while (tokensIterator.hasNext()) {
            nextObj = tokensIterator.next();
            tokens.pop();
            System.out.println(tokens + " tokens obj" + " INFIX");
            System.out.println(nextObj + " next obj INFIX");
            System.out.println(outputQueue + "output queue infix");
            System.out.println(stack + " stack INFIX");
            if (nextObj instanceof Double) {
                outputQueue.add(nextObj);
                tokensIterator = tokens.iterator();
                prevObj = nextObj;
            } else {
                System.out.println("stack size = " + stack.size() + "infix");
                nextObjChar = (Character) nextObj;
                if (nextObjChar == '(') {
                    stack.push(nextObj);
                    System.out.println("hi1");
                } else if (nextObjChar == ')') {
                    if (stack.contains('(')) {
                        System.out.println("hi2");
                        for (j=0; j<stack.size(); j++) {
                            System.out.println("hi3");
                            movingOperChar = (Character) stack.peekFirst();
                            if (movingOperChar != '(') {
                                System.out.println("hi4");
                                movingOper = stack.pop();
                                System.out.println("hi5");
                                outputQueue.add(movingOper);
                                System.out.println("hi6");
                            } else {
                                movingOper = stack.pop();
                                System.out.println("hi7");
                                break;
                            }
                        }
                    } 
                    else {
                        throw new IllegalArgumentException("Incorrect use of parenthesis");
                    }
                    
                } else if (stack.size()>=1) {
                    existingObj = (Character) stack.getFirst();
                    if (existingObj == '(') {
                        stack.push(nextObj);
                        // if (!tokens.contains(')')) {
                        //     throw new IllegalArgumentException("Incorrect use of parenthesis");
                        // }
                    } else if (precedence.get(nextObjChar) <= precedence.get(stack.getFirst())) {
                        System.out.println("adding" + precedence.get(nextObjChar) + " exisitng " + precedence.get(stack.getFirst()) + "infix");
                        System.out.println("stack size = " + stack.size() + "infix");
                        for (i=0; i<=stack.size(); i++) {
                            firstChar = (Character) stack.getFirst();
                            if (firstChar == '(') {
                                break;
                            } else if (precedence.get(nextObjChar) <= precedence.get(stack.getFirst())) {
                                System.out.println(stack.size());
                                System.out.println("hiiiiii" +i);
                                movingOper = stack.pop();
                                System.out.println("hiiiiii" +i);
                                outputQueue.add(movingOper);
                                System.out.println("hiiiiii"+ i);
                            }
                        }
                        stack.push(nextObj);
                    } else {
                        stack.push(nextObj);
                    }
                } else {
                    stack.add(nextObj);
                }
            }
        }
        while (!stack.isEmpty()) {
            nextObj = stack.pop();
            outputQueue.add(nextObj);
        }
        outputQueue.remove('(');
        outputQueue.remove(')');
        System.out.println(outputQueue + " outputqueue FINAL");
        if (outputQueue == originalTokens) {
            throw new IllegalArgumentException("Please input a standard expression, not in postfix format.");
        }
        finalAns = Postfix.postfix(outputQueue);
        System.out.println( " returning:  " + finalAns);
        return finalAns;
    }
}

