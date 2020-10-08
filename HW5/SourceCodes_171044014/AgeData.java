/**
 * The Age Data Class
 */
public class AgeData implements Comparable<AgeData> {
    private final int age;
    private int numberOfAge;
    /**
     * Is searched parameter
     */
    protected boolean isSearched=false;

    /**
     * Instantiates a new Age data.
     *
     * @param age the age
     */
    public AgeData(int age){
        this.age = age;
        numberOfAge = 1;
    }

    /**
     * Instantiates a new Age data.
     *
     * @param node the node
     */
    public AgeData(AgeData node){
        this.age = node.getAge();
        this.numberOfAge = node.getNumberOfAge();
    }

    /**
     * Increment number of age.
     */
    public void incrementNumberOfAge(){
        numberOfAge++;
    }

    /**
     * Decrement number of age.
     */
    public void decrementNumberOfAge(){
        numberOfAge--;
    }

    /**
     * Get age.
     *
     * @return the int
     */
    public int getAge(){ return age; }

    /**
     * Get number of age.
     *
     * @return the number of age
     */
    public int getNumberOfAge() { return numberOfAge; }

    @Override
    public int compareTo(AgeData o) {
        if(age == o.getAge())
            return 0;
        else if(age < o.getAge())
            return -1;
        else
            return 1;
    }

    public String toString(){
        return String.valueOf(age) + " - " + String.valueOf(numberOfAge);
    }
}
