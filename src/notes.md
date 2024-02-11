# Grokking coding interview patterns in java
two key things
* how each pattern works 
* how to decide which pattern to apply to a given problem

## Two Pointers
- The two pointers pattern uses two pointers to iterate over an array of or list until the conditions of the problem are satisfied. This is useful because it allows us to keep track of the values of two different indexes in a single iteration. whenever there is a requirement to find two data elements in an array that satisfy a certain condition, the two pointers pattern should be the first strategy to come to mind. 
- The pointers can be used to iterate the data structure in one or both directions, depending on the problem statement. for example, to identify whether a string is a palindrome, we can use one pointer to iterate the string from the beginning and the other to iterate it from the end. at each step we can compare the values of the two pointers and see if they meet the palindrome prperties. 
- The naive approach to solving this problem would be using nested loops, with a time complexity ofO(N ** 2). however, by using two pointers moving towards the middle from either end, we explot the symmetry property of palindromic strings. this allows us to compare the elements in a single loop, making the algorithm more efficient with a time complexity of O(n)
- ![Screenshot 2024-02-11 at 21.20.42.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fjd%2F_tr5km9d1bn2rtnrw8k2rxsc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_kpKLmf%2FScreenshot%202024-02-11%20at%2021.20.42.png)

- Essentially the two pointers pattern is an application of the prune-and -search strategy, in which, at every step, we are able to safely prune, that is eliminate a set of possible solutions.

### Reversing an Array















