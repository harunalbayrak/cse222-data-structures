import java.util.Stack;

/**
 * The Question3 class
 */
public class Question3 {
    /**
     * Reverse string of the sentence.
     *
     * @param str the str
     */
    public static void reverseString(String str){
        if(str.length() == 0){
            return;
        }
        try {
            String[] x = str.split(" ");
            System.out.print(x[x.length - 1] + " ");
            if (x.length == 1) {
                return;
            }
            reverseString(str.substring(0, str.length() - x[x.length - 1].length() - 1));
        } catch (Exception ex){
            return;
        }
    }

    /**
     * Checks the word is elfish.
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isElfish(String str){
        boolean elfish = false;
        boolean fCount = false;
        boolean eCount = false;
        boolean lCount = false;
        int count = 0;
        elfish = isElfish(str,elfish,count,fCount,eCount,lCount);
        return elfish;
    }

    private static boolean isElfish(String str,boolean elfish,int count,boolean fCount,boolean eCount, boolean lCount){
        if(count == 3){
            elfish = true;
        }
        if(str.length() == 0){
            return elfish;
        }
        if(str.charAt(0) == 'f' || str.charAt(0) == 'F'){
            if(!fCount){
                count++;
                fCount = true;
            }
        } else if(str.charAt(0) == 'e' || str.charAt(0) == 'E'){
            if(!eCount){
                count++;
                eCount = true;
            }
        } else if(str.charAt(0) == 'l' || str.charAt(0) == 'L'){
            if(!lCount){
                count++;
                lCount = true;
            }
        }
        return isElfish(str.substring(1),elfish,count,fCount,eCount,lCount);
    }

    /**
     * Selection sort recursive method.
     *
     * @param arr the arr
     */
    public static void selectionSort(int[] arr){
        selectionSort(arr,0,arr.length-1);
    }

    private static void selectionSort(int[] arr,int minIndex,int maxIndex){
        if(minIndex == maxIndex)
            return;

        int min=arr[minIndex];
        int ind=minIndex;
        for(int m=minIndex;m<=maxIndex;m++){
            if(min > arr[m]) {
                min = arr[m];
                ind = m;
            }
        }
        int temp = arr[minIndex];
        arr[minIndex] = arr[ind];
        arr[ind] = temp;

        selectionSort(arr,minIndex+1,maxIndex);
    }

    /**
     * Evaluate prefix.
     *
     * @param prefix the prefix
     * @return the int
     */
    public static int evaluatePrefix(String prefix){
        Stack<Integer> stack = new Stack<>();
        return evaluatePrefix(prefix,stack);
    }

    private static int evaluatePrefix(String prefix, Stack<Integer> prefixStack){
        try {
            if(prefix.length() == 0){
                return prefixStack.get(0);
            }
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

        char character = prefix.charAt(prefix.length()-1);
        int op1;
        int op2;

        switch (character){
            case '-':
                op1 = prefixStack.pop();
                op2 = prefixStack.pop();
                prefixStack.push(op1-op2);
                return evaluatePrefix(prefix.substring(0,prefix.length()-1),prefixStack);
            case '+':
                op1 = prefixStack.pop();
                op2 = prefixStack.pop();
                prefixStack.push(op1+op2);
                return evaluatePrefix(prefix.substring(0,prefix.length()-1),prefixStack);
            case '/':
                op1 = prefixStack.pop();
                op2 = prefixStack.pop();
                if(op1 != 0) {
                    prefixStack.push(op1/op2);
                    return evaluatePrefix(prefix.substring(0,prefix.length()-1),prefixStack);
                } else {
                    return -1;
                }
            case '*':
                op1 = prefixStack.pop();
                op2 = prefixStack.pop();
                prefixStack.push(op1*op2);
                return evaluatePrefix(prefix.substring(0,prefix.length()-1),prefixStack);
            default:
                prefixStack.push(Integer.parseInt(String.valueOf(character)));
                return evaluatePrefix(prefix.substring(0,prefix.length()-1),prefixStack);
        }
    }

    /**
     * Evaluate postfix.
     *
     * @param postfix the postfix
     * @return the int
     */
    public static int evaluatePostfix(String postfix){
        Stack<Integer> stack = new Stack<>();
        return evaluatePostfix(postfix,stack);
    }

    private static int evaluatePostfix(String postfix,Stack<Integer> postfixStack){
        try {
            if(postfix.length() == 0){
                return postfixStack.get(0);
            }
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

        char character = postfix.charAt(0);
        int op1;
        int op2;

        switch (character){
            case '-':
                op1 = postfixStack.pop();
                op2 = postfixStack.pop();
                postfixStack.push(op2-op1);
                return evaluatePostfix(postfix.substring(1),postfixStack);
            case '+':
                op1 = postfixStack.pop();
                op2 = postfixStack.pop();
                postfixStack.push(op2+op1);
                return evaluatePostfix(postfix.substring(1),postfixStack);
            case '/':
                op1 = postfixStack.pop();
                op2 = postfixStack.pop();
                if(op1 != 0) {
                    postfixStack.push(op2/op1);
                    return evaluatePostfix(postfix.substring(1),postfixStack);
                } else{
                    return -1;
                }
            case '*':
                op1 = postfixStack.pop();
                op2 = postfixStack.pop();
                postfixStack.push(op2*op1);
                return evaluatePostfix(postfix.substring(1),postfixStack);
            default:
                postfixStack.push(Integer.parseInt(String.valueOf(character)));
                return evaluatePostfix(postfix.substring(1),postfixStack);
        }
    }

    /**
     * Print the array.
     *
     * @param arr the arr
     */
    public static void printArray(int[][] arr){
        int arrayLength_x = arr.length;
        int arrayLength_y = arr[0].length;
        int totalMove = 0;

        totalMove += arrayLength_x - 1;
        for(int i=1;i<arrayLength_y;++i)
            totalMove += arrayLength_y;

        printArray(arr,0,totalMove,0,0,"right");
    }

    private static void printArray(int[][] arr,int count,int totalNum,int x,int y,String direction){
        if(count == totalNum)
            return;

        try{
            if(direction.equals("right")){
                System.out.print(arr[x][y] + " ");
                y++;
                count++;
            }
        } catch (IndexOutOfBoundsException ex){
            direction = "down";
            y--;
            x++;
        }

        try{
            if(direction.equals("down")){
                System.out.print(arr[x][y] + " ");
                x++;
                count++;
            }
        } catch (IndexOutOfBoundsException ex){
            direction = "left";
            x--;
            y--;
        }

        try{
            if(direction.equals("left")){
                System.out.print(arr[x][y] + " ");
                y--;
                count++;
            }
        } catch (IndexOutOfBoundsException ex){
            direction = "up";
            y++;
            x--;
        }

        try{
            if(direction.equals("up")){
                System.out.print(arr[x][y] + " ");
                x--;
                count++;
            }
        } catch (IndexOutOfBoundsException ex){
            direction = "right";
            x++;
            y++;
        }

        printArray(arr,count,totalNum,x,y,direction);
    }
}
