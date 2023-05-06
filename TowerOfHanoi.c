#include<stdio.h>
#include<time.h>

//TIME COMPLEXITY: O(n^2)
//SPACE COMPLEXITY: O(1)
//BEST CASE: O(n)
//WORST CASE: O(n^2)
//AVERAGE CASE: O(n^2)

int tower(int n,char from,char to,char aux)
{
    if(n==1)
    {
        printf("Move disk 1 from %c to %c\n",from,to);
        return 0;
    }
    tower(n-1,from,aux,to);
    printf("Move disk %d from %c to %c\n",n,from,to);
    tower(n-1,aux,to,from);
}

int main()
{
    int n;
    printf("Enter the number of disks: \n");
    scanf("%d",&n);
    clock_t t;
    t=clock();
    tower(n,'A','C','B');
    t=clock()-t;
    double time_taken=((double)t)/CLOCKS_PER_SEC;
    printf("Time taken: %lf\n",time_taken);
    return 0;
}