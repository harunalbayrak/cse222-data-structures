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
    int printMenu(SoftwareStore system);

    /**
     * Search.
     *
     * @param store the store
     */
    void search(SoftwareStore store);

    /**
     * Add software.
     *
     * @param store the store
     */
    void addSoftware(SoftwareStore store);

    /**
     * Update software.
     *
     * @param store the store
     */
    void updateSoftware(SoftwareStore store);

    /**
     * Delete software.
     *
     * @param store the store
     */
    void deleteSoftware(SoftwareStore store);

    /**
     * Gets user type.
     *
     * @return the user type
     */
    UserType getUserType();
}
