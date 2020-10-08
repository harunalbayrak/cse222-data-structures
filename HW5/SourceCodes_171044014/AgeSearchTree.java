/**
 * The AgeSearchTree class
 *
 * @param <E> the type parameter
 */
public class AgeSearchTree<E extends Comparable<E>> extends BinarySearchTree<AgeData> {

    protected Node<AgeData> add(Node<AgeData> localRoot,AgeData item){
        if(localRoot == null){
            addReturn = true;
            return new Node<AgeData>(item);
        } else if(item.compareTo(localRoot.data) == 0){
            localRoot.data.incrementNumberOfAge();
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

    protected Node<AgeData> delete(Node<AgeData> localRoot,AgeData item){
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
            if(localRoot.data.getNumberOfAge() > 1){
                localRoot.data.decrementNumberOfAge();
                deleteReturn = null;
                return localRoot;
            }
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
     * Younger than method.
     *
     * @param age the age
     * @return the int
     */
    public int youngerThan(int age){
        int sum=0;
        for(int i=0;i<age;++i){
            AgeData n = find(new AgeData(i));
            if(n != null)
                sum += n.getNumberOfAge();
        }
        return sum;
    }

    /**
     * Older than method.
     *
     * @param age the age
     * @return the int
     */
    public int olderThan(int age){
        int sum=0;
        AgeData largest = findLargestChild(root);

        for(int i=age+1;i<=largest.getAge();++i){
            AgeData n = find(new AgeData(i));
            if(n != null)
                sum += n.getNumberOfAge();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        printSystem(root,str,0);

        return str.toString();
    }

    /**
     * Print system.
     *
     * @param localRoot the local root
     * @param str       the str
     * @param count     the count
     */
    public void printSystem(Node<AgeData> localRoot,StringBuilder str,int count){

        if(localRoot == null){
            str.append("null\n");
        } else{
            str.append(localRoot+"\n");
            printSystem(localRoot.left,str,count+1);
            printSystem(localRoot.right,str,count+1);
        }
    }


}
