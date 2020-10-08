/**
 * The type Q 3 main.
 */
public class Q3_Main {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        testMethods();
    }

    /**
     * Test methods.
     */
    public static void testMethods(){
        Q3_TestDriver driver = new Q3_TestDriver();

        driver.testMethods(10000);
        driver.testMethods(20000);
        driver.testMethods(40000);
        driver.testMethods(80000);

        driver.verifyMethods();

        driver.testMethods(10);

        driver.testDeleteMethods(10000,10);
        driver.testDeleteMethods(100000,99999);
    }
}
