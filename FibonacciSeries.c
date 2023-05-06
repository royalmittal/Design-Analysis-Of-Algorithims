#include<stdio.h>
#include<time.h>

//TIME COMPLEXITY: O(n^2)
//SPACE COMPLEXITY: O(1)
//BEST CASE: O(n)
//WORST CASE: O(n^2)
//AVERAGE CASE: O(n^2)
//FIBONACCI SERIES

int fibonacci(int n)
{
    if(n==0)
    {
        return 0;
    }
    else if(n==1)
    {
        return 1;
    }
    else
    {
        return fibonacci(n-1)+fibonacci(n-2);
    }
}

int main()
{
    int n,i;
    printf("Enter the number of terms: \n");
    scanf("%d",&n);
    clock_t t;
    t=clock();
    double time_taken=((double)t)/CLOCKS_PER_SEC;
    printf("Current Time: %lf\n",time_taken);
    printf("Fibonacci series: \n"); 
    for(i=0;i<n;i++)
    {
        printf("[%d -> %d]\t",i+1,fibonacci(i));
    }
    t=clock()-t;
    time_taken=((double)t)/CLOCKS_PER_SEC;
    printf("\nTime taken: %lf\n",time_taken);
    return 0;
}