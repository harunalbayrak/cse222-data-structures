/**
 * The BinarySearchTree class.
 *
 * @param <E> the type parameter
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E> {
    /**
     * The Added item.
     */
    protected boolean addReturn;
    /**
     * The Deleted item.
     */
    protected E deleteReturn;

    @Override
    public boolean add(E item) {
        root = add(root,item);
        return addReturn;
    }

    /**
     * Add method.
     *
     * @param localRoot the local root
     * @param item      the item
     * @return the node
     */
    protected Node<E> add(Node<E> localRoot,E item){
        if(localRoot == null){
            addReturn = true;
            return new Node<E>(item);
        } else if(item.compareTo(localRoot.data) == 0){
            addReturn = false;
            return localRoot;
        } else if(item.compareTo(localRoot.data) < 0){
            localRoot.left = add(localRoot.left,item);
            return localRoot;
        } else{
            localRoot.right = add(localRoot.right,item);
            return localRoot;
        }
    }

    @Override
    public boolean contains(E target) {
        E x = find(root,target);
        return x != null;
    }

    @Override
    public E find(E target) {
        return find(root,target);
    }

    private E find(Node<E> localRoot,E target){
        if(localRoot == null)
            return null;

        int compResult = target.compareTo(localRoot.data);
        if(compResult == 0)
            return localRoot.data;
        else if(compResult < 0)
            return find(localRoot.left,target);
        else
            return find(localRoot.right,target);
    }

    @Override
    public E delete(E target) {
        root = delete(root,target);
        return deleteReturn;
    }

    /**
     * Delete method.
     *
     * @param localRoot the local root
     * @param item      the item
     * @return the node
     */
    protected Node<E> delete(Node<E> localRoot,E item){
        if(localRoot == null){
            deleteReturn = null;
            return localRoot;
        }
        int compResult = item.compareTo(localRoot.data);
        if(compResult < 0){
            localRoot.left = delete(localRoot.left,item);
            return localRoot;
        } else if(compResult > 0){
            localRoot.right = delete(localRoot.right,item);
            return localRoot;
        } else {
            deleteReturn = localRoot.data;
            if(localRoot.left == null){
                return localRoot.right;
            } else if(localRoot.right == null){
                return localRoot.left;
            } else{
                if(localRoot.left.right == null){
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else{
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    /**
     * Find largest child method.
     *
     * @param parent the parent
     * @return the e
     */
    protected E findLargestChild(Node<E> parent){
        if(parent.right.right == null){
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else{
            return findLargestChild(parent.right);
        }
    }

    @Override
    public boolean remove(E target) {
        delete(root,target);
        return deleteReturn != null;
    }
}
