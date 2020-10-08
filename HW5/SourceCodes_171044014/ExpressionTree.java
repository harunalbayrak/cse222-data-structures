import java.io.Serializable;
import java.util.Scanner;

/**
 * The ExpressionTree class.
 */
public class ExpressionTree extends BinaryTree<String> implements Serializable  {
    private static boolean isPrefix = false;
    /**
     * The Root.
     */
    protected Node root=null;

    /**
     * Instantiates a new Expression tree.
     */
    public ExpressionTree(){}

    /**
     * Instantiates a new Expression tree.
     *
     * @param data the data
     */
    public ExpressionTree(String data){
        isPrefix = isOperator(data.charAt(0));
        Scanner scanner;

        if(isPrefix) {
            scanner = new Scanner(data);
            root = (Node) readBinaryTree(scanner);
        }
        else {
            StringBuilder reverse = new StringBuilder();
            String[] arr = data.split(" ");
            for(int i=arr.length-1;i>=0;--i){
                reverse.append(arr[i]);
                reverse.append(" ");
            }
            scanner = new Scanner(reverse.toString());
            root = (Node) readBinaryTree(scanner);
        }
    }

    /**
     * Instantiates a new Expression tree.
     *
     * @param root the root
     */
    protected ExpressionTree(Node root){
        this.root = root;
    }

    /**
     * Instantiates a new Expression tree.
     *
     * @param data  the data
     * @param left  the left
     * @param right the right
     */
    public ExpressionTree(String data,ExpressionTree left,ExpressionTree right){
        root = new Node(data);
        root.left = (left != null) ? left.root : null;
        root.right = (right != null) ? right.root : null;
    }

    /**
     * ReadBinaryTree method(build tree from prefix or postfix equation).
     *
     * @param scan the scan
     * @return the expression tree
     */
    public static ExpressionTree readBinaryTree(Scanner scan){
        String data = scan.next();
        if(isPrefix) {
            if (!isOperator(data.charAt(0))) {
                return new Node(data);
            } else {
                Node temp = new Node(data);
                temp.left = (Node) readBinaryTree(scan);
                temp.right = (Node) readBinaryTree(scan);
                return temp;
            }
        } else{
            if (!isOperator(data.charAt(0))) {
                return new Node(data);
            } else {
                Node temp = new Node(data);
                temp.right = (Node) readBinaryTree(scan);
                temp.left = (Node) readBinaryTree(scan);
                return temp;
            }
        }
    }

    private void postOrderTraverse(Node node, StringBuilder sb){
        if(node != null){
            postOrderTraverse(node.left,sb);
            postOrderTraverse(node.right,sb);
            sb.append(node.toString()+ " ");
        }
    }

    /**
     * Evaluate the equation
     *
     * @return the int
     */
    public int eval(){
        String postfix = toString2();
        int evalValue=0;
        String[] exp = postfix.split(" ");
        return eval(evalValue,0,exp);
    }

    private int eval(int value,int index,String[] exp){
        if(exp.length == 1){
            return value;
        } else {
            if(isOperator(exp[index].charAt(0))){
                int val=0;
                switch (exp[index].charAt(0)){
                    case '+':
                        val = Integer.parseInt(exp[index-2]) + Integer.parseInt(exp[index-1]);
                        break;
                    case '-':
                        val = Integer.parseInt(exp[index-2]) - Integer.parseInt(exp[index-1]);
                        break;
                    case '*':
                        val = Integer.parseInt(exp[index-2]) * Integer.parseInt(exp[index-1]);
                        break;
                    case '/':
                        val = Integer.parseInt(exp[index-2]) / Integer.parseInt(exp[index-1]);
                        break;
                }
                value = val;
                String[] oldStringArray = exp;
                exp = new String[oldStringArray.length-2];
                for(int i=0,j=0;i<oldStringArray.length;++i,++j){
                    if(i==index-2){
                       exp[j] = String.valueOf(value);
                       i+=2;
                    } else{
                        exp[j] = oldStringArray[i];
                    }
                }
                index -= 2;
            }
        }
        return eval(value,index+1,exp);
    }

    public boolean isLeaf(){
        return (root.left == null && root.right == null);
    }

    private static boolean isOperator(char chr){
        return (chr == '+' || chr == '-' || chr == '*' || chr == '/');
    }

    /**
     * To string 2 method.
     *
     * @return the string
     */
    public String toString2(){
        StringBuilder sb = new StringBuilder();
        postOrderTraverse(root,sb);
        return sb.toString();
    }

    /**
     * The Node class.
     */
    protected static class Node extends ExpressionTree implements Serializable{
        /**
         * The Data.
         */
        protected String data;
        /**
         * The Left.
         */
        protected ExpressionTree.Node left=null;
        /**
         * The Right.
         */
        protected ExpressionTree.Node right=null;

        /**
         * Instantiates a new Node.
         *
         * @param data the data
         */
        public Node(String data){
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
