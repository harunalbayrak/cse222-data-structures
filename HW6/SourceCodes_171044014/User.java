/**
 * The User interface.
 */
public interface User {
    /**
     * Print menu.
     *
     * @param system the system
     * @return the int
     */
    int printMenu(LibraryAutomationSystem system);

    /**
     * Gets user type.
     *
     * @return the user type
     */
    UserType getUserType();
}
