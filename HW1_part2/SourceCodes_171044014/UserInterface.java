/**
 * The interface of User.
 */
public interface UserInterface {
    /**
     * Check if is there same string.
     *
     * @param string the string
     * @param system the system
     * @param which  the which
     * @return the boolean
     */
    public boolean checkIsThere(String string,AutomationSystem system,int which);

    /**
     * Print.
     *
     * @param system the system
     * @param which  the which
     */
    public void print(AutomationSystem system,int which);
}
