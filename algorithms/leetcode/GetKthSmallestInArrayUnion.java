/**

Given array {1, 4, 8, 12, 16, 20}
            {3, 6, 9, 13, 17, 19}

Find Kth smallest in the union of the two arrays

For instance, if k = 5,  it returns 8

The main idea is to find i, j such that

(1) i + j +1 = k

(2) a[i] is right in between b[j-1] and b[j] 

when we find i and j and match above condition, we are done,

so the problem becomes how we adjust i, j to narrow our scope


say that we choose i = 1, and j=5-1-1=3, so a[i]=4 and b[j-1]= 9 and b[j]=13
apparently a[i] << b[j-1] so now we have too many large numbers !

Let's choose a smaller value for j --> say j1=2
and i1=k-1-j1=2

now a[i1]=8, and 







**/

public class GetKthSmallestInArrayUnion {

















}
