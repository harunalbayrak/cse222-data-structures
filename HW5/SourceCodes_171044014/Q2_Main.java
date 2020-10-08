/**
 * The Question2 Main Class
 */
public class Q2_Main {
    /**
     * Question2 Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        testMethods();
    }

    /**
     * Test methods.
     */
    public static void testMethods(){
        ExpressionTree prefix = new ExpressionTree("+ + 10 * 5 15 20");
        ExpressionTree postfix = new ExpressionTree("10 5 15 * + 20 +");
        ExpressionTree prefix2 = new ExpressionTree("- / * 20 * 50 + 3 6 300 2");

        System.out.println("1. expression(prefix): '+ + 10 * 5 15 20'");
        System.out.println("2. expression(postfix): '10 5 15 * + 20 +'");
        System.out.println("3. expression(prefix): '- / * 20 * 50 + 3 6 300 2'");
        System.out.println();

        System.out.println("toString2 Method (For first)");
        System.out.println(prefix.toString2());
        System.out.println("---------------------------");

        System.out.println("toString2 Method (For second)");
        System.out.println(postfix.toString2());
        System.out.println("---------------------------");

        System.out.println("toString2 Method (For third)");
        System.out.println(prefix2.toString2());
        System.out.println("---------------------------");

        System.out.println("Evaluate Method (For first)");
        System.out.println("Evaluate : " + prefix.eval());
        System.out.println("---------------------------");

        System.out.println("Evaluate Method (For second)");
        System.out.println("Evaluate : " + postfix.eval());
        System.out.println("---------------------------");

        System.out.println("Evaluate Method (For third)");
        System.out.println("Evaluate : " + prefix2.eval());
        System.out.println("---------------------------");
    }
}
