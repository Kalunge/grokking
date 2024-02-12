import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        int[] colors = new int[] {1,0,2,1,2,2};
        Arrays.sort(colors);
        System.out.println(Arrays.toString(colors));




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

    public static boolean findSumOfThree(int[] nums, int target) {

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    int sum = nums[i] + nums[j] + nums[k];
//                    if (sum == target) {
//                        return true;
//                    }
//                }
//            }
//        }

        for (int i = 0; i < nums.length; i++) {
            int lower = i + 1;
            int higher = nums.length - 1;

            while (lower < higher) {
                int sum = nums[i] + nums[lower] + nums[higher];
                if (sum == target) {
                    return true;
                }
                lower++;
                higher--;
            }
        }

        return false;
    }

//    the time complexity of the function findSumOfThree is o(n**3), where n is the length of the input array ```nums```. this is because there are three nested loops that iterate over the array resulting in a cubic time complexity. the buil-in java functions used in the code such as array.length and addtion and comparison, all have constant time complexity and do not affect the overall time complexity of the fucntion
//    the space complexity of the function findSumOfThree is o(1) because it only uses a constant amount of space for the two pointers.

}