package a4;

class Main {
  public static void main(String[] args) {
    //Postfix.postfix(Tokenizer.readTokens("28 1 4 / *"));
    //Postfix.postfix(Tokenizer.readTokens("70 5 / 2 /"));
    //Postfix.postfix(Tokenizer.readTokens("70 100 10 / /"));
    //Postfix.postfix(Tokenizer.readTokens("15 10 2 - -"));
    //Postfix.postfix(Tokenizer.readTokens("1 1 1 1 1 1 1 + + + + + +"));
    //Postfix.postfix(Tokenizer.readTokens("2 2 + 2 1 + +"));
    //Infix.infixToPostfix(Tokenizer.readTokens("(7*(5-(4*(5-(4*(5-4))))))"));
    //Infix.infixToPostfix(Tokenizer.readTokens("(3+1)^(5-3)"));
    //Infix.infixToPostfix(Tokenizer.readTokens("6+3^3-17"));
    //Infix.infixToPostfix(Tokenizer.readTokens("(20*0.2)^(10/5)"));
    Infix.infixToPostfix(Tokenizer.readTokens("2 5 +"));
    //Infix.infixToPostfix(Tokenizer.readTokens("40*6^3/540"));
    //Infix.infixToPostfix(Tokenizer.readTokens("(((((1+2)*3)-1)/4)+5)"));
    System.out.println("Calls from the command line:");
    System.out.println("    java Postfix <postfix-expr>");
    System.out.println("    java Calculate <infix-expr>");
  }
}