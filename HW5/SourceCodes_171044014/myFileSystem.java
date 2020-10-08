/**
 * The interface for file system.
 */
public interface myFileSystem {
    /**
     * Add dir method.
     *
     * @param dir the dir
     */
    void addDir(String dir);

    /**
     * Add file method.
     *
     * @param file the file
     */
    void addFile(String file);

    /**
     * Remove method.
     *
     * @param path the path
     */
    void remove(String path);

    /**
     * Search method.
     *
     * @param path the path
     */
    void search(String path);

    /**
     * Print file system method.
     */
    void printFileSystem();
}
