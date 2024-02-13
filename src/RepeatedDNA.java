import java.util.*;

public class RepeatedDNA {

    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            System.out.println((i + 1) + ".\tInput sequence: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) + "\n");
            findRepeatedSequences(inputsString.get(i), inputsK.get(i));
//            System.out.println(Print.repeat("-", 100));
        }
    }
    public static void findRepeatedSequences(String s, int k) {

        int n = s.length();

        // Mapping of characters
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);

        // Base value
        int a = 4;

        // Numeric representation of the sequence
        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));
        Arrays.fill(numbers.toArray(), 0);
        for (int i = 0; i < n; i++) {
            numbers.set(i, mapping.get(s.charAt(i)));
        }

        System.out.println("\tConverted sequence: " + numbers);
    }
}
