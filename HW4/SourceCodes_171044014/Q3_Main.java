/**
 * The Main of Question3
 */
public class Q3_Main {
    /**
     * The Main of Question3
     *
     * @param args the args
     */
    public static void main(String[] args){
        testMethod();
    }

    /**
     * Test method.
     */
    public static void testMethod(){
        Question3.reverseString("this function writes the sentence in reverse");
        System.out.println();
        Question3.reverseString("Harun Albayrak Gebze Teknik Üniversitesi 2.sınıf öğrencisidir");
        System.out.println();

        if(Question3.isElfish("unfriendly")){
            System.out.println("Yes it is Elfish word!");
        } else {
            System.out.println("No it is not Elfish word.");
        }
        if(Question3.isElfish("merhabalar")){
            System.out.println("Yes it is Elfish word!");
        } else {
            System.out.println("No it is not Elfish word.");
        }

        int[] array = new int[8];
        array[0] = 3;
        array[1] = 2;
        array[2] = 1;
        array[3] = 9;
        array[4] = 11;
        array[5] = 2;
        array[6] = 3;
        array[7] = -4;
        Question3.selectionSort(array);
        for(int x : array){
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("The evaluated Value(Postfix): "+Question3.evaluatePostfix("1211*-1/+6+82/-"));
        System.out.println("The evaluated Value(Prefix): "+Question3.evaluatePrefix("-++1/-2*1116/82"));

        int[][] array2 = new int[4][4];
        array2[0][0] = 1;
        array2[0][1] = 2;
        array2[0][2] = 3;
        array2[0][3] = 4;
        array2[1][0] = 5;
        array2[1][1] = 6;
        array2[1][2] = 7;
        array2[1][3] = 8;
        array2[2][0] = 9;
        array2[2][1] = 10;
        array2[2][2] = 11;
        array2[2][3] = 12;
        array2[3][0] = 13;
        array2[3][1] = 14;
        array2[3][2] = 15;
        array2[3][3] = 16;
        Question3.printArray(array2);
        System.out.println();
    }
}
