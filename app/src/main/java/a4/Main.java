package a4;

class Main {
  public static void main(String[] args) {
    //Postfix.postfix(Tokenizer.readTokens("21 3 /"));
    //Postfix.postfix(Tokenizer.readTokens("70 5 / 2 /"));
    Postfix.postfix(Tokenizer.readTokens("70 100 10 / /"));
    //Postfix.postfix(Tokenizer.readTokens("15 10 2 - -"));
    //Postfix.postfix(Tokenizer.readTokens("1 1 1 1 1 1 1 + + + + + +"));
    //Postfix.postfix(Tokenizer.readTokens("2 2 + 2 1 + +"));
    System.out.println("Calls from the command line:");
    System.out.println("    java Postfix <postfix-expr>");
    System.out.println("    java Calculate <infix-expr>");
  }
}