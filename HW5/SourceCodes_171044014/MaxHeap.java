import java.util.ArrayList;

/**
 * The MaxHeap class.
 *
 * @param <E> the type parameter
 */
public class MaxHeap<E> implements myHeap<AgeData> {
    /**
     * The Array list.
     */
    public ArrayList<AgeData> arrayList;

    /**
     * Instantiates a new Max heap.
     */
    public MaxHeap(){
        arrayList = new ArrayList<>();
    }

    public void add(AgeData item){
        int child = 0,parent=0;
        boolean check=true;

        for(int i=0;i<arrayList.size();++i){
            if(arrayList.get(i).compareTo(item) == 0){
                check = false;
                arrayList.get(i).incrementNumberOfAge();
                child = i;
                parent = (child-1) / 2;
                break;
            }
        }

        if(check) {
            arrayList.add(arrayList.size(), item);
            child = arrayList.size() - 1;
            parent = (child - 1) / 2;
        }

        while(parent >= 0 && arrayList.get(parent).getNumberOfAge() < arrayList.get(child).getNumberOfAge()){
            AgeData temp = arrayList.get(parent);
            int parentIndex = indexOfAgeData(arrayList.get(parent));
            int childIndex = indexOfAgeData(arrayList.get(child));

            arrayList.set(parentIndex,arrayList.get(child));
            arrayList.set(childIndex,temp);

            child = parent;
            parent = (child-1)/2;
        }
    }

    public void remove(AgeData item){
        int indexItem = indexOfAgeData(item);
        if(indexItem == -1)
            return;

        arrayList.get(indexItem).decrementNumberOfAge();
        if(arrayList.get(indexItem).getNumberOfAge() <= 0){
            arrayList.set(indexItem,arrayList.get(arrayList.size()-1));
            arrayList.remove(arrayList.size()-1);
        }

        int parent = indexItem;
        while(true){
            int leftChild = 2*parent + 1;
            int rightChild = leftChild + 1;

            if(leftChild >= arrayList.size())
                break;

            int minChild = leftChild;

            if(rightChild < arrayList.size() && arrayList.get(rightChild).getNumberOfAge() > arrayList.get(leftChild).getNumberOfAge())
                minChild = rightChild;

            if(arrayList.get(parent).getNumberOfAge() < arrayList.get(minChild).getNumberOfAge()){
                AgeData temp = arrayList.get(parent);
                int minChildIndex = indexOfAgeData(arrayList.get(minChild));
                arrayList.set(indexOfAgeData(temp),arrayList.get(minChild));
                arrayList.set(minChildIndex,temp);
            } else{
                break;
            }
        }
    }

    public AgeData find(AgeData item){
        int index = indexOfAgeData(item);
        return index == -1 ? null : arrayList.get(index);
    }

    public int youngerThan(int age){
        int sum=0;
        for(int i=0;i<arrayList.size();++i){
            if(age > arrayList.get(i).getAge())
                sum += arrayList.get(i).getNumberOfAge();
        }
        return sum;
    }

    public int olderThan(int age){
        int sum=0;
        for(int i=0;i<arrayList.size();++i){
            if(age < arrayList.get(i).getAge())
                sum += arrayList.get(i).getNumberOfAge();
        }
        return sum;
    }

    private int indexOfAgeData(AgeData item){
        for(int i=0;i<arrayList.size();++i){
            if(item.getAge() == arrayList.get(i).getAge()){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(AgeData x : arrayList){
            str.append(x);
            str.append("\n");
        }
        return str.toString();
    }
}
