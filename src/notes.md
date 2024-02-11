# Grokking coding interview patterns in java
two key things
* how each pattern works 
* how to decide which pattern to apply to a given problem

## Two Pointers
- The two pointers pattern uses two pointers to iterate over an array of or list until the conditions of the problem are satisfied. This is useful because it allows us to keep track of the values of two different indexes in a single iteration. whenever there is a requirement to find two data elements in an array that satisfy a certain condition, the two pointers pattern should be the first strategy to come to mind. 
- The pointers can be used to iterate the data structure in one or both directions, depending on the problem statement. for example, to identify whether a string is a palindrome, we can use one pointer to iterate the string from the beginning and the other to iterate it from the end. at each step we can compare the values of the two pointers and see if they meet the palindrome properties. 
- The naive approach to solving this problem would be using nested loops, with a time complexity ofO(N ** 2). however, by using two pointers moving towards the middle from either end, we explot the symmetry property of palindromic strings. this allows us to compare the elements in a single loop, making the algorithm more efficient with a time complexity of O(n)
- ![Screenshot 2024-02-11 at 21.20.42.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fjd%2F_tr5km9d1bn2rtnrw8k2rxsc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_kpKLmf%2FScreenshot%202024-02-11%20at%2021.20.42.png)

- Essentially the two pointers pattern is an application of the prune-and -search strategy, in which, at every step, we are able to safely prune, that is eliminate a set of possible solutions.

examples of problems solved with two pointers
* Reversing an Array
* Pair with Given sum in a sorted array
* ![Screenshot 2024-02-11 at 21.30.41.png](..%2F..%2F..%2FScreenshot%202024-02-11%20at%2021.30.41.png)

### Does My problem match this pattern?
YES if all these conditions are fulfilled
* The input data can be traversed in a linear fashion, that is, it is an array, in a linked list, or in a string of characters
* we limit our focus to a specific range of elements within the input data, as dictated by the positions of the two pointers, allowing us to consider a small subset of elements rather than the entire set. 
additionally, problems in this pattern usually involve comparing or swapping values pointed to by two indexes. in less common cases, each index may move along a separate array or string. 

NO if either of these conditions is fulfilled
* the input data cannot be traversed in a linear fashion, that is, it is neither in an array, nor in a linked list, nor in a string of characters
* the problem requires an exhaustive search of the solution space, that is, eliminating one solution does not eliminate any others. 
## Real-world problems
* **Memory management** - Two pointers are vital in memory allocation and deallocation. The memory pool is initialized with two pointers; the start pointer , pointing at the beginning of the available memory block, and the end pointer, indicating the end of the block. when a process or data structure requests memory allocation, the start pointer is moved forward, designating a new memory block for allocation. Conversely, when memory is released(deallocated), the start pointer is shifted backward marking the deallocated memory as available for future allocations. 
* **Product suggestions** - while shopping online, when customers view their cart and the current total doesn't qualify for free shipping, we want to show them pairs of products that can be bought together to make the total amount equal to the amount required to be elligible for free delivery. Two pointers can be used to suggest the pairs that add up to the required cost for free shipping. 

### Check if a string is a palindrome - YES two pointers
- By utilizing two pointers, one starting from the beginning of the string and the other from the end, we can compare the corresponding characters. if the characters match at each step, we continue moving the pointers inward until the pointers cross each other
### find any three values in a sorted array that sum up to 825 - YES two pointers
- by iterating through the array and considering each value, we calculate the sum of the current value and the other two values. to find the other two values, we can utilize two pointers in each iteration: one starting from the left most element and the other from the right most element . comparing this sum with 825, we increment or decrement the pointers accordingly
### find all permutations of the following set of elements - No two pointers
- finding permutations requires generating all possible combinations, which involves exploring various branches of a decision tree. this process doe not allign with the linear traversal approach of the two pointers pattern, making it unsuitable for solving permutation probllems
### generate a string of n balanced parenthesis - No two pointers
- Generating a string of balanced parenthesis requires a different approach, such as backtracking, since it involves forming a specific pattern with nested parenthesis. this kind of pattern generation iis not supported by the Two Pointers Pattern

## isPalindrome
### Naive approach
- the naive approach to solve this problem is to reverse the string and then compare the reversed string with the original string. if they match the original string is a valid palindrome. although this problem has a linear time complexity, it requires extra space to store the reversed string, making it less efficient in terms of space complexity. therefore, we can use an optimized approach to save extra space.
### optimized approach using two pointers
- a palindrome is a word or phrase that reads the same way when it is reversed. this means that the characters at both ends of the word or phrase should be exactly the same. 
- the two pointers approach would allow us to solve this problem in linear time, without any additional space complexity or the use of in built functions. this is because we will traverse the array from the start and the end simultaneously to reach the middle of the string
### step by step solution construction
- we will have two pointers, where the first pointer is at the starting element of our string , while the second pointer is at the end of the string. we move two pointers towards the middle of the string and at each iteration, we compare each element. the moment we encounter a nonidentical pair we can return false because our string cant be a palindrome.
- we will construct the solution step by step and the first step is to set up two pointers and move them toward the middle of the string. we can do that with the following code snippet. 
```java
class ValidPalindrome {

  public static String isPalindrome(String s) {
    System.out.println("String to check: " + s + ". Length of string: " + s.length());
    int left = 0;
    int right = s.length() - 1;
    int i = 1;
    // The terminating condition for the loop is when both the pointers reach the same element or when they cross each other.
    while (left < right) {
      System.out.println("In iteration " + i + ", left = " + left + ", right = " + right);
      System.out.println("The current element being pointed to by the left pointer is '" + s.charAt(left) + "'");
      System.out.println("The current element being pointed to by the right pointer is '" + s.charAt(right) + "'");
      left = left + 1; // Heading towards the right
      right = right - 1; // Heading towards the left
      i = i + 1;
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
    System.out.println("Loop terminated with left = " + left + ", right = " + right);
    return "The pointers have either reached the same index, or have crossed each other, hence we don't need to look further.";
  }

  //Driver code
  public static void main(String[] arg) {
    String[] testCase = {
      "RACECAR",
      "ABBA",
      "TART"
    };
    for (int k = 0; k < testCase.length; k++) {
      System.out.println("Test Case # " + (k + 1));
      System.out.println(isPalindrome(testCase[k]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}
```

this is how we always traverse in opposite directions. the termination condition for our code is that the left pointer should always be less than the right pointer,, because the moment they cross each other, we reach the middle of the string and don't need to go any further. we can check how this works with our example.


### Solution summary
1. initiate two pointers and move from opposite ends
2. the first pointer starts at the beginning of the string and moves toward the middle , while the second pointer starts at the end and moves toward the middle.
3. compare the elements at each position to detect a non-matching pair
4. if both pointers reach the middle of the string without encountering a non-matching pair, the string is a palindrome

### Time complexity
the time complexity id O(n), where n is the number of characters in the string. However, our algorithm will only run(n/2) times since two pointers patterns are traversing toward each other.
### space complexity
the space complexity is O(1), since we use constant space to store two indexes








