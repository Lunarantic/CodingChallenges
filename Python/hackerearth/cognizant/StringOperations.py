#!/bin/python

'''
String Operations
You are given a string S.

Q number of operations are performed on string S.
In each of these Q operations, you are given an index ind and a character ch.
For each operation, you have to update character at index ind in string S to ch, that is,
after this operation S[ind]=chS[ind]=ch.
It is guaranteed that any index is updated atmost once.
We call the final string after performing Q number of operations as str.

After this, M number of operations are performed on string str.
In each of these M operations, you are given two indices a and b.
For each operation, you have to reverse the substring that lies between the indices a and b (inclusive).
We call the final string after performing M operations as fin.

Example: If string is "xyz" and one of the Q operations is 1a,
then string "xyz" now becomes "ayz" as S[1]=a after the operation.
one of the M operations is 13, then "ayz" now becomes "zya" as the substring lying between indices 1 and 3 is reversed.

You have to print string str, string fin and the number of indices
which have same characters at them in both strings str and fin.

Input Format:
First line consists of string S.
Next line consists of an integer denoting Q.
Following Q lines contain two integers each: 
ind and ch.
Next line consists of an integer denoting M.
Following M lines contain two integers each: 
a and b.

Output Format:
In first line, print string str.
In second line, print string fin.
In third line, print the number of indices which have same characters at them in both strings str and fin.

Input Constraints:
1≤|S|≤10^2
|S| denotes length of string S. 
1≤Q≤|S|
1≤M≤10^3
1≤ind≤|s|, all ind values are unique. 
1≤a≤b≤|s|
ch will always be a lowercase English alphabet.
String S consists of lowercase English alphabets only.
All indices are 1 based.

Sample Input
helloworld
2
1 a
8 x
2
2 3
2 4
Sample Output
aellowoxld
alelowoxld
8
Explanation
Performing first Q (=2) operations: In first operation, S[1] = 'a', so string becomes "aelloworld"
In first operation, S[8] = 'x', so string becomes "aellowoxld"

After performing Q operations, the string becomes "aellowoxld".

We have to perform M(=2) operations on the string "aellowoxld".
In first operation, we have to reverse the string lying between indices 2 and 3,
so the string now becomes "alelowoxld". ("el" now becomes "le")
Similarly in second operation, we reverse the string lying between indices 2 and 4,
so the string becomes "alelowoxld". ("lel" on reversing remains the same)

String str= "aellowoxld"
String fin= "alelowoxld"
No of characters same in both of them = 8.
'''

srtstr = raw_input()
q = int(input())

srtstr = list(srtstr)

for i in xrange(0, q):
    qrun = raw_input().split(' ')
    srtstr[int(qrun[0])-1] = qrun[1]

srtstr = ''.join(srtstr)
finstr = srtstr

m = int(input())

for i in xrange(0, m):
    mrun = raw_input().split(' ')
    mrun = [int(mr) for mr in mrun]
    finstr = finstr[:mrun[0]-1] + finstr[mrun[0]-1:mrun[1]][::-1] + finstr[mrun[1]:]
    print finstr

print srtstr + '\n' + finstr

c = 0

for i in xrange(0, len(srtstr)):
    if finstr[i] == srtstr[i]:
        c += 1

print str(c)
