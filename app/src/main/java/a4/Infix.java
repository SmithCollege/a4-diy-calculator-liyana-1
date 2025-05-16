package a4;

import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Iterator;

public class Infix {

    /** 
     *  takes in ArrayDeque and converts from infix to Postfix to answer
     *  @param tokens
     *  @return finalAns
     */
    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Object> outputQueue = new ArrayDeque<>(); //numbers added here, operators added as needed
        ArrayDeque<Object> stack = new ArrayDeque<>(); //operators added here
        Object nextObj; //next object in tokens
        Object prevObj; //previously looked at object from tokens
        Character nextObjChar; //when the next object is a character and has been converted as such
        Object movingOper; //operator that is potentially moving from stack to outputQueue
        Character movingOperChar; //converting movingOper to a character
        Character existingObj; //existing character at top of stack
        Character firstChar; //stop of stack
        int i; //for loop
        int j; //for loop
        Double finalAns; //final answer returned
        Hashtable<Object, Integer> precedence = new Hashtable<>(); //to define precesdence for characters
        precedence.put('+', 2);
        precedence.put('-', 2);
        precedence.put('*', 3);
        precedence.put('/', 3);
        precedence.put('^', 4);
        Iterator<Object> tokensIterator = tokens.iterator(); //iterator for tokens
        ArrayDeque<Object> originalTokens = tokens; // original tokens ArrayDeque to compare to
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
            if (nextObj instanceof Double) {
                outputQueue.add(nextObj);
                tokensIterator = tokens.iterator();
                prevObj = nextObj;
            } else {
                nextObjChar = (Character) nextObj;
                if (nextObjChar == '(') {
                    stack.push(nextObj);
                } else if (nextObjChar == ')') {
                    if (stack.contains('(')) {
                        for (j=0; j<stack.size(); j++) {
                            movingOperChar = (Character) stack.peekFirst();
                            if (movingOperChar != '(') {
                                movingOper = stack.pop();
                                outputQueue.add(movingOper);
                            } else {
                                movingOper = stack.pop();
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
                    } else if (precedence.get(nextObjChar) <= precedence.get(stack.getFirst())) {
                        for (i=0; i<=stack.size(); i++) {
                            firstChar = (Character) stack.getFirst();
                            if (firstChar == '(') {
                                break;
                            } else if (precedence.get(nextObjChar) <= precedence.get(stack.getFirst())) {
                                movingOper = stack.pop();
                                outputQueue.add(movingOper);
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
        if (outputQueue == originalTokens) {
            throw new IllegalArgumentException("Please input a standard expression, not in postfix format.");
        }
        finalAns = Postfix.postfix(outputQueue);
        return finalAns;
    }
}

