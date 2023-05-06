#include<stdio.h>
#include<time.h>

//TIME COMPLEXITY: O(n)
//SPACE COMPLEXITY: O(1)
//BEST CASE: O(1)
//WORST CASE: O(n)
//AVERAGE CASE: O(n)
//SIMPLE SEARCH 

int linear(int arr[],int n,int key)
{
    int i;
    for(i=0;i<n;i++)
    {
        if(arr[i]==key)
        {
            return i+1;
        }
    }
    return -1;
}

int main()
{
    int i,j,n,k;
    printf("Enter the number of elements: \n");
    scanf("%d",&n);
    int arr[n];
    printf("Enter the elements: \n");
    for(i=0;i<n;i++)
    {
        arr[i]=(int)rand()%999999;
    }
    for(i=0;i<n;i++)
    {
        printf("[%d -> %d]\t",i+1,arr[i]);
    }
    printf("\nEnter the number to be searched: \n");
    scanf("%d",&k);
    clock_t t;
    t=clock();
    n=linear(arr,n,k);
    (n==-1)?printf("Element not found!\n"):printf("Element found! at index %d\n",n);
    t=clock()-t;
    double time_taken=((double)t)/CLOCKS_PER_SEC;
    printf("Time taken: %lf\n",time_taken);
    return 0;
}