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

to change the order of characters, we call the strRev function with the starting and ending positions of the word. this will reverse the characters in the word. 
now update the start and end pointers to the next of end pointer, which is basically the first character of the next word. Now, repeat this process for the next word. at the end of all iterations, we get the reversed words in the string

# Fast and Slow pointers
- similar to the two pointers pattern, the fast and slow pointers pattern uses two pointers to traverse an iterable data structure at different speeds. it is ususally used to identify distinguishable features of directional data structures, such as linked list or an array.
- the pointers can be used to traverse the array or list in either direction, however one moves faster than the other. generally the slow pointer moves forward by a factor of one  and the fast poiner moves by a factor of two in each step. however, the speed can be adjusted according to the problem statement. 
- unlike the two pointers approach, which is concerned with data values, the slow and fast pointers approach is used to determine data sturcture traits using indices in arrays or node pointers in linked lists. the approach is commonly used to detect cycles in the given data structure, so it is known as Floyd's cycle detection
- the key idea is that the pointers start at the same location but they move forward at different speeds. if therre is a cycle, the two are bound to meet at some point in the traversal. to understand the concept, think of two runners on a track. while they start from the same point, they have different running speeds. if the race track is a circle, the first runner will overtake the slower one after completing a lap. on the other hand, if the track is straight, the faster runner will end the race before the slower one, hence never meeting on the track again. the fast and slow pointers pattern uses the same intuition.
## Does my problem match this pattern?
**yes** if either these conditions are fulfilled
* Either as an intermediate step, or as the final solution, the problem requires identifying 
  * the first x % of the elements in a linked list or
  * the element at the k-way point in a linked list, for example, the middle element, or the element at the start of the second quartile
  * the kth last element in a linked list
* solving the problem requires detecting the presence of a cycle in a linked list
* solving the problem requires detecting the presence of a cycle in a sequence of symbols
**No** if either of these conditions is fulfilled
* the input data cannot be traversed in a linear fashion, that is, it is neither in an array nor in a linked list nor in a string of caharacters
* the problem can be solved with two pointers traversing an array or a linked list at the same pace.
## Real-world problems
* **symlink verification**: Fast and slow pointers can be used in a symlink verification utility in an operating system. a symbolic link, or symlink, is simply a shortcut to another file. Essentially, it is a file that points to another file. Symlinks can easily create loops or cycles where shortcuts points to each other. to avoid such ccurences, a symlink verification utility can be used. similar to a linked list, fast and slow pointers can detect a loop in the symlinks by moving along the connected files or directories at different speeds.
* **compiling an object-oriented programme**: uUsually, programs are not contained in a single file. particularly, for large applications, modules can be divided into different files for better maintenance. dependency relationships are then defined to specify the order of compilation for these files. However, sometimes, there might be a cyclic dependencies that can lead to an error. fast and slow pointers can be used to identify and remove these cycles for seamless compilation and execution of the program.

## Happy Number
write an algorithm to determine if number n is a happy number.
we use the following process to check if a given number is a happy number
* starting with the given number n, replace the number with the sum of the squares of its digits.
* repeat the process until
  * the number equals 1, which will depict that the given number is a happy number
  * it enters a cycle, which will depict that the given number n is not a happy number
* return TRUE if n is a happy number and FALSE if not. 

## Solution
### naive approach
the brute force approach is to repeatedly calculate the squared sum of digits of the input number and store the computed sum in a hash set. for every calculation, we check if the sum is already present in the set. if yes, we have detected a cycle and should return false. otherwise, we add it to our hashset and continue further. if our sum converges to 1 we have found a happy number.
while this approach works well for small numbers, we might have to perform several computations for large numbers to get the required result. so, it might get infeasible for such cases. the time complexity of this approach is O(log n). the space complexity is O(log n) since we are using additional space to store our calculated sums.

### Optimized approach using fast and slow pointers pattern
- an efficient approach to solve this problem is to use fast and slow pointers. we know that a unhappy number eventually gets stuck in an infinite loop. However, there is no way for our program to detect this loop and terminate, unless we keep track of the calculated sums, which requires additional space.
- if we use the fast and slow pointers approach here, the fast pointer would eventually reach 1, in which case we will return True. otherwise it would meet the slow pointer, which would mean that the two pointers are in an endless loop, and we can return FALSE
- as an example, suppose we have the number 2 as our n. this is what infinite loop would look like.

### step by step solution construction
we will start off our solution by constructing a helper function to calculate the squared sum of digits of the input number. we know that we need to isolate the digits in our number and adding its squared value to the total sum.
the helper function will find the last digit of the given number by taking its modulus with 10. we will store this in a variable digit. now since we have already separated the last digit we can get the remaining digits by dividing the number by 10. lastly we will store the squared sum of digit in a variable named totalSum. we will repeat this until our number becomes zero.
to understand this better consider a number 19.

first iteration
* digit = 19 % 10 = 9(last digit)
* number = 19 / 10 = 1(remaining digits)
* totalSum = 81

second iteration
* digit = 1 % 10 = 1(last digit)
* number = 1 / 10 = 0(remaining digits)
* total sum = 81 + 1^2 = 82
as the number has become 0, we will terminate our program here. the square sum of the digits in 19 is 82. 

Next, we will initialize two variables fast and slow with the input number, and the sum of its digits respectively. in each iteration, we will move slow one step forward and fast two steps forward. that is we will call the sumofsquaredigits function once for slow and twice for fast.
slow = sumofsquaredigits(slow);
fast = sumofsquaredigits(sumofsquaredigits(fast))

if at any instance fast becomes 1, we have found a happy number. we will return True in this case. otherwise if fast becomes equal to slow, we have found a loop and we will return FALSE.

### solution summary
we maintain track of two values using a slow pointer and a fast pointer. the slow runner advances one number at each step, while the fast runner advances two number. we detect if there is any cycle by comparing the two values and checking if the fast runner has inded reached the number one. we return True or False depending on if those conditions. 

### Time complexity
the time complexity for this algorithm is O(log n), where n is the input number.
the worst case complexity of this algorithim is given by the case of a non-happy number since it gets stuck in a cycle, whereas a happy number quickly converges to 1. let us first calculate the time complexity of the sum digits function. since we are calculating the sum of all digits in a number, the time complexity of this function is O(log n), because the number of digits in the number n is log 10n
before delving into the detailed complexity analysis , let us first consider the largest possible next number for each given number of digits

| Digits | largest number | sum of squareddigits |
|--------|----------------|----------------------|
| 1      | 9              | 81                   |
| 2      | 99             | 162                  |
| 3      | 999            | 243                  |
| 4      | 9999           | 324                  |
| 12     | 999999999999   | 927                  |
| 13     | 9999999999999  | 1053                 |
| 14     | 99999999999999 | 1134                 |

to estimate the count of numbers in a cycle, let us consider the following two cases.
1. **Numbers with three digits**: the largest 3 digit number is 999. the sum of the squares of its digits is 243. therefore, for three digits , no number in the cycle can go beyond 243. therefore the time complexity in this case is given asO(243 * 3), where 243 is the maximum count of numbers in a cycle and 3 is the number of digits in a three-digit number. this is why the time complexity in the case of numbers with three digits comes out to be O(1)
2. **Number with more than 3 digits**: any number with more than three digits will lose at least one digit at every step until it becomes a three-digit number . for example, the first-four digits number that we can get in the cycle is 1053 which is the sum of the square of the digits in 99999999999. therefore, the time complexity of any number with more than three digits can be expressed as O(log n + log log n + log log log n+ ....) since O(log n) is the dominating term, we can write the time complexity as O(log n)
therefore, the total time complexity comes out to be O(1 + log n), which is O(log n)
### space complexity
the space complexity for this algorithm is O(1)
## Linked List Cycle
### Naive approach
the naive approach is to traverse the linked list and store the current node in a set. At each iteration, we check if the current node is already present in the set. if it is, we have found a cycle and return TRUE. otherwise we add the node to the set. if the traversal has been completed, return FALSE, sine we have reached the end of the linked list without encountering a cycle.

the time complexity is O(n), since we only traverse the linked list once, where n represents the total number of nodes in a linked list. the space complexity of the naive approach is also O(n), since in the worst case, we store n nodes in the set.

### Optmized approach using fast and slow pointers
This problem can be solved efficiently using the fast and slow pointers technique, where the fast pointer moves two steps, and the slow pointer moves one step in the linked list.
if there is no cycle in the linked list, the fast pointer will reach the end of the linked list before the slow pointer. if there is a cycle, the fast pointer will eventually catch up to the slow pointer, since it is moving faster. when this happens, that we have a cycle in the linked list. te following steps can be performed to implement the algorithm above
* we initialize two pointers fast and slow which point to the head of the linked list
* we traversee the linked list using these two pointers, they move in the following way
  * the slow pointer moves only one node forward in each iteration
  * the fast pointer moves two nodes forward in each iteration, which means that it skips a node.
* if the fast pointer becomes null, we have reached the end of the linked list. since no cycle exists in the linked list return FALSE
* if both slow and fast pointers become equal to each other, return TRUE, since a cycle exists in the linked list.
### solution summary
to recap, the solution to this problem can be divided into the following three parts
* initialize both the slow and fast pointers to the head
* move both pointers at different rate, i.e, the slow pointer will move one step ahead while the fast pointer will move two steps ahead.
* if both pointers are equal at some point we know that a cycle exists.

### Time complexity
the time complexity of the algorithm is O(n), where n is the number of nodes in the linked list.
### space complexity
the space complexity of the algorithm is O(1)

# Middle of the Linked List
### Naive approach
in the naive approach, we can use an external array to store the elements of the linked list, and then we return the element present at the index array.length / 2 as the middle of the linked list. the time and space complexity of this approach is O(n), where n is the number of nodes in the linked list. let us see if we can solve this problem better time and space complexity

### Optimized approach using fast and slow pointers
we can use the fast and slow pointers to solve this problem with constant space complexity. the slow pointer traverses the linked list one step at atime while the fast pointer takes two steps at a time. this makes the fast pointer reach the end of the linked list in n//2 iterations, and the slow pointer, by this time reaches the middle of the linked list.

the following steps are applied when identifying the middle of the linked list
1. create two pointers slow and fast initially at the head of the linked list, i.e, pointing to the first node.
2. traverse the linked list using both pointers, where the slow pointer will move one step forward, and the fast will move two steps forward
3. when the fast pointer reaches the last element of the linked list or becomes equal to nulll, the slow pointer at that time will point to the middle node. Return the node that the slow pointer points to. 
### Solution summary
1. create two pointers, slow and fast initially at the head of the linked list.
2. while traversing the linked list, move the slow pointer one step forward and the fast pointer two steps forward
3. when the fast pointer reaches the last node or NULL the slow pointer will point to the middle node of the linked list. Return the node that the slow pointer points to.
### Time complexity
the time complexity of the solution above is O(n), where n is the number of the nodes in the linked list.
### space complexity
the space complexity of theis solution is constant, that is O(1)

# Circular Array Loop
### Naive approach
The naive approach is to traverse the whole array and check for each element whether we can for =m a cycle starting from each element or not. we will run a loop on every array element and keep track of the visisted element using an aditional array. we will check the condition for both the forward and backward cycles. if the condition of the cycle changes at any point, we will come out of that loop and continue verifying the loop condition formthe remaining elements.
we get the required solution, but at what cost? the time complexity is O(n^2) as we run a loop every array element. the space complexity is O(n) because we use extra space to keep track of the visited elements. if our array contains thousands of elements, we will need a lot of our memory resources to solve this problem.
### optimized approach using fast and slow pointers
the circular array loop can be found efficiently using no extra memory with the fast and slow pointers technique. the algorithm uses fast and slow pointers that move through the array following the values at the array indexes. we move the fast pointer twice as fast as the slow pointer. if the pointers reach the same index, a cycle is detected. this is because the fast pointer coves twice the distance as slow pointer does in each iteration, so the fast pointer guarantees to meet the slow pointer if the cycle exists. if the loop is found we will return true.
if the values at the array indexes of the slow and fast pointers have different signs i.e one pointer is pointing to a positive ad the other is pointing to a negative the loop cannot exist. additionally, if a moving pointer takes it to the current position again, it forms a loop with one element. since we are not considering it, we will skip it. if any of these conditions are TRUE, we will move to the next element.
we start the algorithm by defining the following functions.
* **nextStep(pointer, value, size)**: This function will be used to find the next location of our pointer based on the value present at the current location. it will do so by adding the current index to the value present at the index and taking the modulus with the size of the array. in case of the negative value obtained, it will add size to it to make it a valid index value
* **isNotCycle(nums, prevDirection, pointer)**: this function will return TRUE if the cycle is not possible. it will retun FALSE otherwise. a cycle is not possible if either of the following conditions is true
  * if both pointers have different directions i.e one pointer's value is negative and the other pointer's value is positive
  * if the absolute value of nums[i] is equal to the length of the array, which will return to the same location. this means we have a loop with just one element, which is not the condition we are trying to detect.
we iterate through each index i of the array nums, and in each iteration we set both fast and slow pointers to the current index. the variable forward determines the direction of the loop. we set it TRUE if the current element is positive and set FALSE if the current element is negative.
* then we iterate a loop till we find the result and perform the following actions
  * move the slow pointer nums[i] steps forward it its value is positive and move backward if the value of nums[i] is negative by calling the next step function.
  * now after moving the slow pointer, check whether or not the cycle is possible with existing pointers locations using the isNotCycle fucntion
  * if the cycle is not possible we dont need to continue with the locations of the current pointers, we break the inner loop and set both slow and fast pointers to the next index, i, and repeat the process.
  * now move the fast pointer twice and after every move, we check whether the cycle is possible or not. if it is not possible, break the loop and set both slow and fast pointers at the next index i  and repeat the process.
  * after moving both slow adn fast pointers, if they both meet at the same time location, return TRUE, since it means we have found a cycle.
* if the cycle is ot found after traversing all the elements, return FALSE

# Find the duplicate number
Given a unsorted array of positive numbers , ```nums```, such that the values lie in the range(1, n), inclusive and that there are n+1 numbers in that array, find and return the duplicate number present in ```nums```. there is only one repeated number in nums

## Solution
- we solve this problem using fast and slow pointers technique, without modifying the ```nums``` array and using only constant extra space. 
- for this problem, the duplicate number will create a cycle in the ```nums``` array. the cycle in the array helps identify the duplicate number. 
- to find the cycle, we will move in the nums array using the f(x) = nums[x] function, where x is the index of the array. this function constructs the following sequence to move

      x, nums[x], nums[nums[x]], nums[nums[nums[x]]], ...
- in the sequence above, every new element is an element in nums present at the index of the previous element. 
- let us say we have an array ```[2,3,1,3]```. we will start with x = nums[0], which is 2, present at the 0th index of the array and then move to nums[x], which is 1, present at the 2 nd index. since we have found 1 at the 2 nd index, we will move to the 1st index, and so on. this example shoows that if we are given an array of length n + 1, with values in the range [1,n], we can use this traversal technique to visit all the locations in the array.
![Screenshot 2024-02-13 at 14.27.18.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fjd%2F_tr5km9d1bn2rtnrw8k2rxsc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_DaqYIy%2FScreenshot%202024-02-13%20at%2014.27.18.png)
as illustrated above, we have found that there is a cycle in an array with a duplicate number.Now the problem is to find the entry point of the cycle, which will be our duplicate number.
- we solve this problem in two parts using the slow and fast pointers
- in **the first part**: the slow pointer moves once, while the fast pointer is moving twice as fast as the slow pointer, it will be the first one to enter and move around the cycle. at some point after the slow pointer also enters and moves in the cycle, the fast pointer will meet the slow pointer. this will be the intersection point. 
- **NB**: the intersection point of the two pointers is, in the general case, not the entry point of the cycle.
- **in part two**: we will start moving again in the cycle, but this time, we will slow down the fast pointer so that it moves with the same speed as the slow pointer. 
  - let us look at the journeys of the two pointers in part two
  * the slow pointer will start from 0th position.
  * the fast pointer will start from the intersection point.
  * after a certain number of steps, let us call it F, the slow pointer meets the fast pointer. 
  * this common ending will be the entry point of the cycle.
let us look at the visual presentation

* the fast pointer is traversing two times faster than the slow pointer. this can be represented by the following equation

d <sub>fast</sub> == 2d <sub>slow</sub> ---(1)
- here, d represent the number of elements traversed.
![Screenshot 2024-02-13 at 14.40.36.png](..%2F..%2F..%2FScreenshot%202024-02-13%20at%2014.40.36.png)
in the diagram above:
  * green represent the entry point of the cycle.
  * blue represent the intersection point 
  * yellow represent the starting point
  * F represents the steps taken from the starting point to the entry point 
  * a represents the steps taken to reach the intersection point from the entry point
  * C represents the cycle length, in terms of the number of steps taken to go once around the cycle.
with this set up in mind, let us see the distance travelled by the slow and fast pointers.
* the slow pointer travels F steps from starting point to the entry point of the cycle and then takes a steps from the entry point to the intersection point of the cycle, that is, the point where both pointers intersect. So, we can express the distance travelled by the slow pointer in the form of this equation.
* d <sub>slow</sub> = F + a ---(2)
* in the time it takes the slo pointer to travel F + a steps, the fast pointer, since it is travelling twice as fast as the slow pointer, will have also travelled around the cycle atleast once. so we can say the fast pointer, first, travels F steps from the starting point to the entrycpoint of the cycle., then travels atleast a cycle, and at the end travels a steps from the entry point to the intersection point of the cycle. now we can express the distance travelled by the fast pointer as the following equation:
* d <sub>fast</sub> = F + C + a --- (3)
* recall eq.(1)
*  d<sub>fast</sub> = 2d <sub>slow</sub> ---(1)
if we substitute the equivalent expression of d <sub>slow</sub> given in the second equation and the equivalent equation expression of d <sub>fast</sub> given in the third equation intoo the first equation we get:
* F+C+a = 2(F+a)
* let's simplify the equation

F+C+a = 2f + 2a
C = F + a

therefore the distance from the starting point to the intersection point F+a, equals C.
we can also rearrange the equation as follows
F = C - a
as we can see from our diagram, C - a is, in fact, the distance from the intersection point back to the entry point. This illustrates why, when we move one pointer forward, starting at the intersection point, and another pointer from the starting point , the point where they meet is the entry point of the cycle.
## Time complexity
The time complexity of the algorithm is O(n) where n is the length of nums. this is because, in each part of the solution the slow pointer traverses the nums just once. 
## space complexity
the algorithm takes O(1) space complexity, since we only used constant space to store the fast and slow pointers.

# Palindrome Linked List
the fast and slow pointers technique helps determine whether a linked list is a plaindrome or not , because it allows us to efficiently traverse the list and find the middle node in a single pass. we can do this in linear time and with constant extra space
to determine whether a linked list is a palindrome, we first finde the middle node of the linked list using the fast and slow pointers approach. Then, we will reverse the second half of the linked list, starting from the node after the middle node until the end of the list. next we will compare the first half with the second half.

if both halves of the list match, the linked list is a palindrome. otherwise, it is not. in the end, we reverse the second half of the linked list again. this is done to revert it to the original structure of the linked list so that the input is not modified by the palindrome checking process.

The algorithm to solve this problem is as follows
* First, we will find the middle node of the linked list. to do this, we will traverse the linked list using two pointers, where the slow pointer will move one step forward, and the fast pointer will move two steps forward. we will do this untill the fast pointer reaches the end  of the list or a null node. at this point, the slow pointer will be pointing at the middle node of the list.
* next we reverse the second half of the linked list, starting from the node after the middle node. to reverse the list we will follow the following steps
  * initiate three pointers prev, next and current. the prev and next pointers are initialized as NULL, while curr is initialized to the head of the linked list.
  * Iterate over the linked list, while iterating perform the following steps
    * before changing the next of curr, store the next node using the following line
          
          next = curr.next
    * now we will update the next pointer of curr with the prev pointer. this will reverse the pointer of the current node from forward to backward, eventaully aiding the reversal of the linked list.
    * after reversing the pointer, we will update prev as curr and curr as nextusing the following lines of code respectively

          prev = curr; and curr = next;
  * after finding the mid of the linked list and reversing its second half , the last step is to compare every element of the first half of the linked list with the corresponding element in the second half of the reversed linked list. if both halves are the same, the list is a palindrome, and we will return true otherwise we will return FALSE.
let us look at the illustration
  
### Time complexity
the algorithm's time complexity is O(n), where n is the total number of nodes in the linked list

### space complexity
the space complexity of the algorithm above is O(1), because it does not use any extra space. 


# SLIDING WINDOW
let us go through the sliding window pattern its real-world application, and some problems we can sole
## Overview
- the **sliding window** pattern is used to process sequential data by maintaining a moving subset of elements, called a window. the pattern is aimed at reducing the use of nested loops in an algorithm. it may be viewed as a variation of the two pointers pattern, with the pointers being used to set the window bounds.
- a window is a sublist formed over a part of an iterable data structure. it can be used to slide over the data in chunks corresponding to the window size. the sliding window pattern allows us to process the data in segments instead of the entire list. the segment or window size can be set according to the problem's requirements. for example, if we have to find three consecutive integers with the largest sum in an array, we can set the window size to 3. this will allow us to process the data three elements ata time.
- why is this method more efficient? it isn't if, for each window, we iterate over all the elements of the window because that gives us the same O(kn) time complexity
- instead, what if we focused in the element entering the window and the element leaving it.? for example, after calculating the sum of the first three elements, we move the window one step ahead, subtract the element that is no longer in the window from the sum, and add the new element that has entered it. Next wwe check if the new sum is greater than the first. if it is, we update the max sum found so far. now, each time we move the window forward, we perform at most four operations, reducing the time complexity to O(4n), i.e O(n).
- the following illustration shows how the window moves along an array. 
![Screenshot 2024-02-13 at 18.31.17.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fjd%2F_tr5km9d1bn2rtnrw8k2rxsc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_MVCv4O%2FScreenshot%202024-02-13%20at%2018.31.17.png)

## Examples
![Screenshot 2024-02-13 at 18.32.00.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fjd%2F_tr5km9d1bn2rtnrw8k2rxsc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_GV03M8%2FScreenshot%202024-02-13%20at%2018.32.00.png)

## Does my problem match this pattern?

* **Yes** if these conditions are fulfilled.
  * the problem requires repeated computations on a contiguous set of data elements(a subarray or a substring), such that the window moves across the input array from one and to the other. the size of the window may be fixed or variable, depending on the requirements of the problem. the repeated computations may be a direct part of the final solution, or they may be intermediate steps building up towards the final solution
  * the computations performed every time the window moves take O(1) time or are a slow-growing function, such as log, of a small variable, say k, where k <<n.
* **No** if either of these conditions are fulfilled
  * the input data structure does not support random access
  * you have to process the entire data without segmentation
## Real-world problems
many problems in the real world use the sliding window pattern. let us look at some examples
* **Telecommunications**: find the maximum number of users connected to a cellular network's base station every k-millisecond sliding window.
* **E-commerce**: Given a dataset of product IDs in the order they were viewed by the user and a list of products that are likely to be similar, find how many times these products occur together in the dataset. 
* **Video streaming**: Given a stream of numbers representing the number of buffering events in a given user session, calculate the median number of buffering events in each one minute-interval.
* **Social media content mining**: Given the lists of topics that two users have posted about, find the shortest sequence of posts by one user that includes all the topics that the other user has posted. 

## Repeated DNA Sequence
Given a string, s, that represents a DNA subsequence, and a number , k, return all the contiguous subsequences(substrings) of length k that occur more than once in the string. the order of the returned subsequences does not matter. if no repeated substring is found, the funtion should retun an empty set
```java
the dna is a sequence composed of a series of ucleotides abbreviated as A,C,G and T. for example, ACGAATTCCG. wHEN SUDING dna, it is useful to identify repeated sequences in it.
```
## Solution
### Naive Approach
a naive approach would be to iterate through the input DNA sequence and add all the unique substrings of length k to a set. if a substring is already present in a set, it is a repeated substring.
here is how the algorithm works
* we iterate the string using a pointer i, ranging from 0 to (n - k + 1). this is the number of k-length substrings present in the sequence
* at each iteration, we generate the current k-length substring i.e s[i]... s[i - k + 1]
* next, we check if this substring is already present in the set.
  * if it is, the current substring is a repeated sequence, so we add it to our output
  * otherwise, the current substring has not yet been repeated so we just add it to the set.
* we repeat the above process for all the k-length substrings
* once all k-length substrings have been evaluated we return the output

the time complexity of this output is O((n - k) * K), where n is the length of the input sequence and k is the size of each contiguous subsequence we consider. this is because we iterate over (n - k + 1) substrings of length k, and at each iteration, the time taken to generate a k-length substring is O(k).

the space complexity of this approach is O((n - k) * k), since in the worst case, our set can contain (n - k +1) elements, and at each iteration of the traversal, we are allocating memory to generate new k-length substring.

## Optimized approach using sliding window
the problem can be optimized using sliding window approach. we use the Rabin-Karp algorithm that utilizes a sliding window with rolling hash for pattern matching.
here is the basic idea of the algorithm
* we traverse the string by using a sliding window of length k, which slides one character forward on each iteration.
* on each iteration, we compute the hash of the current k-length substring in the window
* we check if te hash is already present in the set
  * if it is, the substring is repeated, so we add it to the output.
  * otherwise, the substring has not yet been repeated, so we add the computed hash to the set.
* we repeat the above process for all k-length substrings by sliding the window one character forward on each iteration.
* after all k-length substrings have been evaluated we return the output.
There are multiple approaches for computing hash values, and the choice of the hash function can impact the algorithm's time complexity. let us look at some approaches below. 


consider the ACTCT with k = 2
1. initially, the sequence in the window is AC and its hash value is
    
       H(AC) = 65 + 67 = 132
    since the above hash value has not been repeated yet, we add this hash value to the set and slide the window one character forward.
2. The sequence in the window is now CT. to compute the hash value of CT, the ASCII of A will be removed from the previous hash value and the ASCII of T will then be added.

       H(CT) = 132 - 65 + 84 = 151
    Since the above hash value has not been repeated yet, we add this hash value to the set and slide the window one character forward

3. the sequence in the window is now TC. to compute the hash value ot TC , the ACII of C will be removed from the previous hash value and then again added

        H(TC)V=V151 - 67 + 67 = 151
    Here we have same hash value but different sequences - CT and TC. this means that if a hash value is already present in the set, we need to compare the corresponding sequences as well to confirm if they are identical. In this case they are not, so we add this hash value to the set and slide the window one character forward
4. the sequence in the window is now CT. to compute the hash value of CT, the ASCII of T will be removed from the previous hash value and then again added

        H(CT) = 151 - 84 + 84 = 151
    here, we have the same hash value, so we compare the two sequences. since they are identical the sequence has been repeated and is therefore added to the output. 
Computing the hash value and then comparing the strings if the hashes are equal will take linear time, O(k). in the worst case, the comparisons will occur after each slide, which will make the running time the same as that of the naive approach, which is O((n - k) * k)

### Hashing and Comparison in constant time
we need a hash function that helps us achieve constant-time hashing. for this purpose we use the **polynomial rolling hash** technique:
using the polynomial hash function to compute values of the k-length substrings skips the need to compare two sequences if their hash values are the same and therefore helps us achieve constant time hashing and comparison.

## Step by Step Solution construction
we will first define the following variables to set ourselves up to implement the polynomial rolling hash fucntion.
* **mapping**: this is a hash map defining the numeric mapping of nucleotides. it will be of the form 

        {A:1, C:2, G:3, T:4}
* **a**: this is the base value used in the polynomial hash function. we will use a base value of 4 since there are 4 nucleotides in the sequence. 
* **numbers**: this is an array storing the integer form of the string s based on the mapping defined above. for example, the sequence ACTCT, numbers will consist of [1,2,4,2,4]. this array will make it easier to access the numeric value of the nucleotides when calculating the hash value. 
we declare a variable, ```hashvalue```, to store the hash value of the current k-length sequence in the window. it is initialized to 0.
next we slide the window along the string, s, using a pointer, i , ranging from 0 to (n - k + 1):
  * when i is 0, the window is at its starting position, i.e the first k-length substring. For this sequence, we calculate the hash value from scratch using the above-mentioned polynomial hash function.
```java
for(int j = 0; j < k; j++) {
    hashValue += numbers.get(j) * (int) Math.pow(a, k-j-1);
        }
```
* otherwise the window is not at its starting position, so we calculate the hash value of the current k-length substring by utilizing the hash value of the previous k-length susbtring.
```java
  int previousHashValue = hashValue;
  hashValue = ((previousHashValue - numbers.get(i - 1) * (int) Math.pow(a, k-1) * a)) + numbers.get(i + k -1)
```
* the above process is repeated by sliding the window one character forward
we declare the following variables to keep track of the hash values and store the repeated substrings:
  * **hashSet**: this is a set that stores all the unique hash values of the k-length substrings. It is initialized to empty.
  * **output**: this is a set that stores the repeated substrings
we check if the calculated hashvalue of the current k-length substring is present in hashset
  * if it is, the substring is repeated, so it is added to output
```java
  if(hashSet.contains(hashValue)) {
    output.add(s.substring(i, i+k));
  }
```
* otherwise, we will just add the hash value of the sustring to hashset
```java
    hashSet.add(hashValue);
```
when the hash values of all k-length substrings have been evaluated, i.e., the sliding window can not move forward, we return output
### Solution Summary
To recap, the solution to this problem can be divided into the following six main parts.
1. iterate over all k-length substrings
2. compare the hash value for the contents of the window 
3. add this hash value to the set that keeps track of the hashes of all substrings of the given length.
4. move the window one step forward and compute the hash of the new window using the rolling hash method.
5. if the hash value of a window has already been seen, the sequence in this window is repeated, so we add it to the ouput array
6. once all substrings have been evaluated, return the output array

### Time complexity
**Average case**
the average case time complexity of this solution is O(n), where n is the length of the input string. it is calculated as follows
  * time taken to populate the numbers array: O(n)
  * time taken to traverse all the k-length substrings: O(n -k + 1)
  * Time taken to calculate the hash value of a k-length substring: O(1)
so the dominating time complexity becomes O(n)
**Worst case**
to understand the worst case time complexity of this solution, consider the input string "AAAAAAAA" WITH K = 2. This combination of inputs ensures that a repeated sequence "AA" is detected and added to the output each time the window slides forward. therefore, we must generate a k-length substring on each (n - k + 1) iteration of the loop. the time to generate a k-length substring is O(k). therefore the overall time complexity becomes O((n - k) * k)

### Space Complexity
the space complexity of this solution is O(n). it is calculated as follows:
  * space occupied by the mapping hash map: O(1);
  * space occupied by the numbers array: O(n)
  * space occupied by the hashSet: O(n - k + 1);
so the dominating space complexity becomes O(n).





















