#include<stdio.h>
#include<time.h>

//TIME COMPLEXITY: O(n^2)
//SPACE COMPLEXITY: O(1)
//BEST CASE: O(n)
//WORST CASE: O(n^2)
//AVERAGE CASE: O(n^2)
//INSERTION SORT

int main()
{
    int i,j,n,k,com=0,swap=0;
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
    for(i=1;i<n;i++)
    {
        k=arr[i];
        j=i-1;
        com++;
        while(j>=0 && arr[j]>k)
        {
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=k;
    }
    printf("\n===========================================================================================================");
    printf("\nSorted Elements are: \n");
    for(i=0;i<n;i++)
    {
        printf("[%d -> %d]\t",i+1,arr[i]);
    }
    t=clock()-t;
    double time_taken=((double)t)/CLOCKS_PER_SEC;
    printf("\n============================================================================================================");
    printf("\nTime taken: %lf\n",time_taken);
    return 0;
}