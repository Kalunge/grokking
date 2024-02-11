import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        System.out.println(Arrays.toString(pairWithGivenSum(11, new int[]{4, 5, 6, 7, 8})));


    }


    public static boolean palindromeChecker(String str) {
        int pointerOne = 0;
        int pointerTwo = str.length() - 1;
        String cleanStr = str.toLowerCase();
        while (pointerOne < pointerTwo) {
            if (cleanStr.charAt(pointerOne) != cleanStr.charAt(pointerTwo)) {
                return false;
            }

            pointerOne++;
            pointerTwo--;
        }

        return true;
//        the time complexity of the function valid palindrome is O(n), where n is the length of the input string. this is because the function uses two pointers to iterate over the string, comparing characters at each position. the while loop runs until the pointers meet in the middle of the string or until a mismatch is found, resulting in a linear time complexity. the built-in java functions used in the code, such as s.charAt() and s.length(), have constant time complexity
//        the space complexity of the valid palindrome function iis O(1) because it only uses the constant amount of space for the two pointers and the variables start and end. the space complexity of the built in java functions invoked by the code such as s.charat and s.length() is also O(1) because they access individual characters in the string t=without using any additional space
    }

    public static int[] reverseArray(int[] arr) {
        int pointer0ne = 0;
        int pointerTwo = arr.length - 1;

        while (pointer0ne < pointerTwo) {
            int elementAtPriorPosition = arr[pointer0ne];
            arr[pointer0ne] = arr[pointerTwo];
            arr[pointerTwo] = elementAtPriorPosition;
            pointer0ne++;
            pointerTwo--;

        }

        return arr;
    }

    public static int[] pairWithGivenSum(int sum, int[] arr) {
        int pointerOne = 0;
        int pointerTwo = arr.length - 1;
        int[] pair = new int[2];

        while (pointerOne < pointerTwo) {
            int sumOfPairs = arr[pointerOne] + arr[pointerTwo];
            if (sumOfPairs == sum) {
                pair[0] = arr[pointerOne];
                pair[1] = arr[pointerTwo];
                return pair;
            }
            pointerTwo--;
        }
        return pair;
    }
}