public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        boolean check = palindromeChecker("racecar");
        boolean checkTwo = palindromeChecker("muthomi");
        System.out.println(check);
        System.out.println(checkTwo);
        System.out.println(palindromeChecker("civic"));
        System.out.println(palindromeChecker("level"));
        System.out.println(palindromeChecker("rotor"));
        System.out.println(palindromeChecker("kaYak"));
        System.out.println(palindromeChecker("Titoh"));




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
}