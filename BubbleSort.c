#include<stdio.h>
#include<time.h>

//TIME COMPLEXITY: O(n^2)
//SPACE COMPLEXITY: O(1)
//BEST CASE: O(n)
//WORST CASE: O(n^2)
//AVERAGE CASE: O(n^2)
//SWAP ADJACENT ELEMENTS

int main()
{
    int i,j,n,k;
    printf("Enter the number of elements: \n");
    scanf("%d",&n);
    int arr[n];
    printf("Random Genrated Elements are: \n");
    for(i=0;i<n;i++)
    {
        arr[i]=(int)rand()%999999;
    }
    for(i=0;i<n;i++)
    {
        printf("[%d -> %d]\t",i+1,arr[i]);
    }
    clock_t t;
    t=clock();
    for(i=0;i<n;i++)
    {
        for(j=0;j<n-i-1;j++)
        {
            if(arr[j]>arr[j+1])
            {
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
    printf("\nSorted Elements are: \n");
    for(i=0;i<n;i++)
    {
        printf("[%d -> %d]\t",i+1,arr[i]);
    }
    t=clock()-t;
    double time_taken=((double)t)/CLOCKS_PER_SEC;
    printf("====================================================================="")
    printf("\nTime taken: %lf\n",time_taken);
    return 0;
}