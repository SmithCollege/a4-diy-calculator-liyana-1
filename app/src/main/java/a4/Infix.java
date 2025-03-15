package a4;

import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Iterator;

public class Infix {

    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Object> outputQueue = new ArrayDeque<>(); //numbers added here
        ArrayDeque<Object> stack = new ArrayDeque<>(); //operators added here
        Object nextObj;
        Character nextObjChar;
        Object movingOper;
        Character movingOperChar;
        Character existingObj;
        int i;
        int j;
        Double finalAns;
        Hashtable<Object, Integer> precedence = new Hashtable<>();
        precedence.put('+', 2);
        precedence.put('-', 2);
        precedence.put('*', 3);
        precedence.put('/', 3);
        Iterator<Object> tokensIterator = tokens.iterator();
        //Iterator<Object> stackIterator = stack.iterator();
        while (tokensIterator.hasNext()) {
            nextObj = tokensIterator.next();
            tokens.pop();
            System.out.println(tokens + " tokens obj" + " INFIX");
            System.out.println(nextObj + " next obj INFIX");
            System.out.println(outputQueue + "output queue infix");
            System.out.println(stack + " stack INFIX");
            if (nextObj instanceof Double) {
                //tokens.remove(nextObj);
                //nextObjChar = (Character) nextObj;
                outputQueue.add(nextObj);
                //tokens.remove(nextObj);
                //System.out.println(tokens + " tokens INFIX");
                //System.out.println(outputQueue + "output queue infix");
                tokensIterator = tokens.iterator();
            } else {
                System.out.println("stack size = " + stack.size());
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
                                //tokens.remove(movingOper);
                            } else {
                                movingOper = stack.pop();
                                System.out.println("hi7");
                            }
                        }
                    } else {
                        System.out.println("Error: mismatched parenthesis.");
                    }
                    
                } else if (stack.size()>=1) {
                    existingObj = (Character) stack.getFirst();
                    if (existingObj == '(') {
                        outputQueue.add(nextObj);
                    } else if (precedence.get(nextObjChar) <= precedence.get(stack.getFirst())) {
                        System.out.println("adding" + precedence.get(nextObjChar) + " exisitng " + precedence.get(stack.getFirst()));
                        System.out.println("stack size = " + stack.size());
                        for (i=0; i<=stack.size(); i++) {
                            movingOper = stack.pop();
                            outputQueue.add(movingOper);
                            //tokens.remove(movingOper);
                            //System.out.println(outputQueue + "output queue after stacsize1");
                        }
                        stack.push(nextObj);
                    } else {
                        stack.push(nextObj);
                    }
                } else {
                    stack.add(nextObj);
                    //tokens.remove(nextObj);
                }
            }
        }
        while (!stack.isEmpty()) {
            nextObj = stack.pop();
            //nextObjChar = (Character) nextObj;
            outputQueue.add(nextObj);
        }

        System.out.println(outputQueue + " outputqueue FINAL");
        finalAns = Postfix.postfix(outputQueue);
        System.out.println( " returning:  " + finalAns);
        return finalAns;
    }
}

