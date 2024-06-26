# leetcode-vault

Storing my solutions for Leetcode

## Definitions

#### Lexicographically Smaller

A string `a` is **lexicographically smaller** than a string `b` if in the first position where `a` and `b` differ, string `a` has a letter that appears earlier in the alphabet than the corresponding letter in `b`.

If the first `min(a.length, b.length)` characters do not differ, then the shorter string is the lexicographically smaller one.

#### Height-Balanced

A **height-balanced** binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

#### Monotonic Stack

It means that the values in the stack are either increasing/decreasing/equal in order.

## Interesting Knowledge

#### Greatest Common Divisor of Strings

- If s1 + s2 = s2 + s1, there exists a substring `x` in both s1 and s2 where `x` divides `s1` and `s2`
- A string `x` divides `y` if and only if `y = x + ... + x`

## Algorithms to Remember

#### Euclidean Algorithm

- TODO: find a good explanation

#### Tortoise and Hare Algorithm

- Find duplicate number in linked listed (FindDuplicateNumber.java)
-

## Useful Functions in Java

#### Create a sublist from an int array

https://www.geeksforgeeks.org/java-util-arrays-copyofrange-java/

## Notes

#### Strings

1. Lowercase strings -> consider using new int[26] to store frequency of characters

#### Backtracking

1. Save the result outside of the function
2. Need a temp stack for the result when backtracking
3. usually call another function(backtrack) to initialise the DP

#### Priority Heap/Queue

- Usually when question looks for kth...., we use heaps

#### Bit Manipulation

- If question requies O(1) and its an array of integers, usually its two pointers or bit manipulation
