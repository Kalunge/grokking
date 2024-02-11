import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        boolean check = palindromeChecker("racecar");
        boolean checkTwo = palindromeChecker("muthomi");
        int[] toBeReversed =new int[]{1,2,3,4,5,6};

        System.out.println(Arrays.toString(reverseArray(toBeReversed)));


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
}