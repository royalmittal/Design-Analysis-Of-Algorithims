#include<stdio.h>
#include<time.h>
#include<math.h>

// ARRAY MUST BE SORTED
// TIME COMPLEXITY: O(log n)
// SPACE COMPLEXITY: O(1)
// BEST CASE: O(1)
// WORST CASE: O(log n)
// AVERAGE CASE: O(log n)
// COMBINATION OF BINARY SEARCH AND LINEAR SEARCH

int binary(int arr[],int low,int high,int key)
{
    int mid,i;
    mid=(low+high)/2;
    if(low>high)
    {
        return -1;
    }
    else
    {
        if(arr[mid]==key)
        {
            return mid;
        }
        else if(arr[mid]>key)
        {
            return binary(arr,low,mid-1,key);
        }
        else
        {
            return binary(arr,mid+1,high,key);
        }
    }
}

int exponential(int arr[],int n,int key)
{
    int i=1;
    if(arr[0]==key)
    {
        return 0;
    }
    while(i<n && arr[i]<=key)
    {
        i=i*2;
    }
    int min= i/2;
    int max= min(i,n-1);
    return binary(arr,i/2,min(i,n-1),key);
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
        printf("%d\t",arr[i]);
    }
    printf("\nEnter the number to be searched: \n");
    scanf("%d",&k);
    clock_t t;
    t=clock();
    n=exponential(arr,n,k);
    if(n==-1)
    {
        printf("Element not found!\n");
    }
    else
    {
        printf("Element found!\n");
        printf("Index: %d\n",i);

    }
    t=clock()-t;
    double time_taken=((double)t)/CLOCKS_PER_SEC;
    printf("Time taken: %lf\n",time_taken);
    return 0;
}