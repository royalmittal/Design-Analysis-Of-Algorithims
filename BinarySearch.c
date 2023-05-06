#include<stdio.h>
#include<time.h>

//TIME COMPLEXITY: O(logn)
//SPACE COMPLEXITY: O(1)
//BEST CASE: O(1)
//WORST CASE: O(logn)
//AVERAGE CASE: O(logn)
//MIDDLE SEARCH

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
            return mid+1;
        }
        else if(arr[mid]>key)
        {
            return binary(arr,low,mid-1,key)+1;
        }
        else
        {
            return binary(arr,mid+1,high,key)+1;
        }
    }
}

int main()
{
    int k,i,n,l=1;
    printf("Enter the number of elements: \n");
    scanf("%d",&n);
    int arr[n]; 
    printf("Enter the elements: \n");
    for(i=0;i<n;i++)
    {
        arr[i]=l;
        l+=5;
    }
    for(i=0;i<n;i++)
    {
        printf("[%d -> %d]\t",i+1,arr[i]);
    }
    printf("\nEnter the number to be searched: \n");
    scanf("%d",&k);
    clock_t t;  
    t=clock();
    if(k<arr[0] || k>arr[n-1])
    {
        printf("Element not found!\n");
        return 0;
    }
    else{
        n=binary(arr,0,n-1,k);
    }
    // if(n==-1)
    // {
    //     printf("Element not found!\n");
    // }
    // else
    // {
    //     printf("Element found!\n");
    //     printf("Index: %d\n",n);
    // }
    (n==-1)?printf("Element not found!\n"):printf("Element found! at index %d\n",n);
    t=clock()-t;
    double time_taken=((double)t)/CLOCKS_PER_SEC;
    printf("Time taken: %lf\n",time_taken);
    return 0;
}