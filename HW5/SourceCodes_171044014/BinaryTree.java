import java.io.Serializable;
import java.util.Scanner;

/**
 * The BinaryTree class
 *
 * @param <E> the type parameter
 */
public class BinaryTree<E> implements Serializable {
    /**
     * The Root.
     */
    protected Node<E> root;

    /**
     * The Node class.
     *
     * @param <E> the type parameter
     */
    protected static class Node<E> implements Serializable{
        /**
         * The Data.
         */
        public E data;
        /**
         * The Left.
         */
        protected Node<E> left;
        /**
         * The Right.
         */
        protected Node<E> right;

        /**
         * Instantiates a new Node.
         *
         * @param data the data
         */
        public Node(E data){
            this.data = data;
            left = null;
            right = null;
        }

        public String toString(){
            return data.toString();
        }
    }

    /**
     * Instantiates a new Binary tree.
     */
    public BinaryTree(){ root=null; }

    /**
     * Instantiates a new Binary tree.
     *
     * @param root the root
     */
    protected BinaryTree(Node<E> root){
        this.root = root;
    }

    /**
     * Instantiates a new Binary tree.
     *
     * @param data      the data
     * @param leftTree  the left tree
     * @param rightTree the right tree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
        root = new Node<E>(data);
        if(leftTree != null){
            root.left = leftTree.root;
        } else{
            root.left = null;
        }
        if(rightTree != null){
            root.right = rightTree.root;
        } else{
            root.right = null;
        }
    }

    /**
     * Get left subtree binary tree.
     *
     * @return the binary tree
     */
    public BinaryTree<E> getLeftSubtree(){
        if(root != null && root.left != null){
            return new BinaryTree<E>(root.left);
        } else{
            return null;
        }
    }

    /**
     * Get right subtree binary tree.
     *
     * @return the binary tree
     */
    public BinaryTree<E> getRightSubtree(){
        if(root != null && root.right != null){
            return new BinaryTree<E>(root.right);
        } else{
            return null;
        }
    }

    /**
     * Is leaf method.
     *
     * @return the boolean
     */
    public boolean isLeaf(){
        return (root.left == null) && (root.right == null);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root,1,sb);
        return sb.toString();
    }

    private void preOrderTraverse(Node<E> node,int depth,StringBuilder sb){
        for(int i=1;i<depth;i++){
            sb.append(" ");
        }
        if(node == null){
            sb.append("null\n");
        } else{
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left,depth+1,sb);
            preOrderTraverse(node.right,depth+1,sb);
        }
    }

    /**
     * Read binary tree method.
     *
     * @param scan the scan
     * @return the binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan){
        String data = scan.next();
        if(data.equals("null")){
            return null;
        } else{
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<String>(data,leftTree,rightTree);
        }
    }
}
