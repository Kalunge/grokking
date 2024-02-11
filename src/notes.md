# Grokking coding interview patterns in java
two key things
* how each pattern works 
* how to decide which pattern to apply to a given problem

## Two Pointers
- The two pointers pattern uses two pointers to iterate over an array of or list until the conditions of the problem are satisfied. This is useful because it allows us to keep track of the values of two different indexes in a single iteration. whenever there is a requirement to find two data elements in an array that satisfy a certain condition, the two pointers pattern should be the first strategy to come to mind. 
- The pointers can be used to iterate the data structure in one or both directions, depending on the problem statement. for example, to identify whether a string is a palindrome, we can use one pointer to iterate the string from the beginning and the other to iterate it from the end. at each step we can compare the values of the two pointers and see if they meet the palindrome prperties. 
- The naive approach to solving this problem would be using nested loops, with a time complexity ofO(N ** 2). howver, by using two pointers moving towards the middle