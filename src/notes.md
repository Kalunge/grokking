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

# Sum of three values
## Statement
- given an array of integers , ```nums```, and an interger value, ```target```, determine if any three integers in ```nums``` whose sum is equal to the target, that is ```nums[i] + nums[j] + nums[k] == target```. Return True if three such integers exists in the array. otherwise return false. 
### solution
### Naive approach
- the naive approach to solving this problem is to use three nested loops. each nested loop starts at the index greater than it parent loop. for example f we use the iterators i, j and k in the loops, j will start from i + 1 and k will start from j + 1. this approach will check all the possible triplests to see if they sum uo to the current value
- we have the required solution , but at what cost? since we are using three nested loops, the overall time complexity for this solution ido(n^3). however, we are not using any extra space to get the final output, so the space complexity is o(1)

### Optimized approach using two pointers
- the two pointers pattern is used to solve a similar problem where we find two integers instead of three that sum up to the target value. we place one pointer at each end of the sorted array , the low pointer and the high pointer, and then traverse the array conditionally to find the two imtegers that sum up to the target value.
- now, in this problem since we need to find the three integers that sum up to the target value, we slightly enhance the two pointers pattern. we use this pattern inside an additional loop. in the loop we keep one value of the array with us and then look for the other two integers against this selected value that complete the triplet whose sum equals the target value.
- first, we sort the input array, ```nums```, in ascending order. this is because traversing an unsorted array would lead to a bad time complexity. if the input array is sorted, we can easily decide, depending on the sum of the current triplet, whether to move the low pointer toward the end or the higher pointer toward the start. next we iterate over the elements in nums using the index i, where i < nums.length - 2. against each nums[i], we find the other two integers that complete the triplet whose sum equals the target value, that is nums[i] + nums[low] + nums[high] == target. we do this by traversing nums with the low and high pointers. in each iteration, the traversal wtarts with the low pointer being nums[i+1] and high pointer at the last element of nums. then, depending on the current sum value, we move the pointers as follows
* if the sum of the triplet is equal to the target, we return TRUE otherwise we continue
* if the sum of the triplet is less than the target we move the low pointer foward that is toward the end. the aim is to increase the value of the sum so that it gets closer or equal to the target value
* if the sum of the triplet is greater than the target we move the high pointer towards the start. the aim is to reduce the value of the sum so that it gets closer or equal to the target value .
* we repeat this for each iteration unitll we get the reuired triplet

### Solution Summary
* store the current array element and set up two pointers(```low``` and ```high```) to find the other two elements that complete the required triplet.
  * the low pointer is set to the current loop's inde + 1
  * the high is set to the last index of the array
* calculate the sum of array elements pointed to by the current loop's index and the low and high pointers
* if the sum is equal to target return TRUE
* if the sum is less than target move the low pointer forward
* if the sum is greater than target, move the high pointer backward
repeat until the loop has processed the entire array. if after processing the entire array, we don't find any triplet that matches our requirement, we return FALSE
### Time complexity
- the solution above, sorting the array takes o(nlog(n)) and the nested loop takes o(n^2) to find the triplet. Here, n is the number of elements in the input array. therefore the total time complexity of this solution is O(nlog(n) + n^2), which simplifies to O(n^2)

### Space complexity
the space complexity of this solution, primarily depends on the sorting algorithm we use. we use the built-in java function, Arrays.sort(), so the space complexity of the provided solution is O(1)

## Remove nth Node from End of list
### Naive solution
- the naive approach calculates the length of the linked list by traversing the complete list. Then, we set a pointer say ```ptr```, at the start of the list and move it through the list unitll it reaches (k -n - 1) node. the ```ptr``` pointer now points to the node before the target node i.e the nth last node. save the next node of the ```ptr``` in a temporary pointer. Relink th eptr node to the node following ptr next node. delete the node pointed by the temporary pointer. by doing so the nth last node will be removed. However, this approach traverses the linked list twice. let us see if we can use two pointers pattern to implement our solution in a single pass.
### Optimized approach using two pointers
Two pointers, ```left``` and ```right```, are set at the head nod. Move the right pointer n steps forward. after doing that, both pointers are exactly separated by n nodes apart. start moving both pointers forward untill the right pointer reaches the last node. at this point, the left pointer will be pointing to the node before the target node i.e the nth last node. we relink the left node to the node following the left's next node. 
if the right pointer reaches null while moving n steps forward, it means that the head node should be removed. we return the head's next node. 

### Solution Summary
1. Two pointers ```right``` and ```left```, are set at the head node.
2. move the ```right``` pointer n steps forward
3. if right reaches null, return heads next node
4. move both right and left pointers forward till right reaches the last node
5. relink the left node to the node at left's next to the next node. 
6. return head

### Time complexity
- the time complexity id O(n), where n is the number of nodes in the linked list

### Space complexity
- the space complexity is O(1) because we use constant space to store two pointers

## Sort colors
given an array, colors, which contains a combination of the following three elements
  * 0(representing red)
  * 1(representing white)
  * 2(representing blue)
sort the array in place so that the elements of the same color are adjacent, with the colors in the order of red, white and blue. the function should return the same array
### solution
### Naive approach
- the naive approach would be to sort the array. this would arrange the elements in the desired positions, i.e 0s, then 1s and lastly 2s. the time complexity of this approach would be O(n log(n)), which is the time required to sort the array. the space complexity of this approach would be O(1) since no extra space is being used

### Optimized approach using two pointers
- the idea is to use two pointers to traverse the array from either end. they keep track of the read and blue elements, respectively. in addition,we maintain another pointer to keep track of the white elements. These pointers are used to traverse the array in one pass. they are initialized as follows
  * ```red```: This pointer will initially point to the 0th index of the array.
  * ```white```: This pointer will initially point to the 0th index of the array
  * ```blue```: This pointer will initially point to the last index of the array
### How the algorithm works
1. Condition 1: if ```colors[white]``` is 0, the white pointer points to red. so we check further condition
   1. Condition 1.1: if the ```colors[red]``` is not 0, we swap the elements of ```colors[white]``` and ```colors[red]```. next we move both the red and white pointers one position forward.
   2. otherwise ```colors[red]``` will be 0, and there is no point in swapping. so we move both the red and white pointers one position forward
2. Condition 2: otherwise if ```colors[white]``` is 1, the white pointer points to white. so we increment the white pointer by 1 to analyze the next element.
3. Condition 3: otherwise the ```colors[white]``` will be 2, i.e the white pointer points to blue. so we check two further conditions
   1. cCondition 3.1: if ```colors[blue]``` is not 2, we swap the elements of ```colors[white]```and ```colors[blue]```. next we move the blue pointer one position backward
   2. Condition 3.3 otherwise both ```colors[white]``` and ```colors[blue]``` will be 2, there is no point in swapping. so we move the blue pointer one position backward.
Note: when we decrement the blue pointer, the white pointer remains unchanged since it has to analyze the swapped element to determine if further swapping is required with the red pointer.
* the three steps above are repeated until the blue pointer becomes less than the white pointer i.e no elements are left to swap. 


### solution Summary
the solution of this problem van be divided into 5 main parts
* we traverse through the array using three pointers, red, white and blue
* if the element pointed by the white pointer is 0, we swap it with the element pointed by the red pointer if it is not pointing to 0, and increment bith the red and white pointers
* if the element pointed by the white pointer is 1, we increment the white pointer
* if the element pointed by the white pointer is2, we swap it with the element pointed by the blue pointer if it is not pointing to 2 and decrement the blue pointer
* the array is sorted when the blue pointer become less than the white pointer.

### Time complexity
- the time complexity of this solution is O(n), since we are only traversing the array once

### Space complexity
- the space complexity of this solution is O(1) since no extra space is used. 



## Reverse words in a string
Given a sentence, reverse the order of ots words without affecting the order of letters within a given word.

in this problem, we first reverse the complete string. Now take two pointers ```start``` and ```end```, initialized with the start of the list which is index 0
Now iterate a loop until start is less than the length of the list, and in each iteration move the end pointer until it hits a space. at this point, we have a complete work starting from the start index to the end - 1index, but with the characters in reverse order. 

to change the order of characters, we call the strRev function with the starting and ending poisitins of the word. this will reverse the characters in the word. 
now update the start and end pointers to the next of end pointer, which is basically the first character of the next word. Now, repeat this process for the next word. at the end of all iterations, we get the reversed words in the string






























