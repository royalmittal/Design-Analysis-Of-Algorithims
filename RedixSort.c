#include<stdio.h>

int getMax(int arr[],int n)
{
    int max=arr[0];
    for(int i=1;i<n;i++)
    {
        if(arr[i]>max)
        {
            max=arr[i];
        }
    }
    return max;
}   

void countSort(int arr[],int n,int exp)
{
    int count[10];
    for(int i=0;i<10;i++)
    {
        count[i]=0;
    }
    for(int i=0;i<n;i++)
    {
        count[(arr[i]/exp)%10]++;
    }
    for(int i=1;i<10;i++)
    {
        count[i]=count[i]+count[i-1];
    }
    int output[n];
    for(int i=n-1;i>=0;i--)
    {
        output[count[(arr[i]/exp)%10]-1]=arr[i];
        count[(arr[i]/exp)%10]--;
    }
    for(int i=0;i<n;i++)
    {
        arr[i]=output[i];
    }
}

void redix_sort(int arr[],int n)
{
    int max=getMax(arr,n);
    for(int exp=1;max/exp>0;exp=exp*10)
    {
        countSort(arr,n,exp);
    }
}

void getarr(int arr[],int n)
{
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
}

void printarr(int arr[],int n)
{
    for(int i=0;i<n;i++)
    {
        printf("%d ",arr[i]);
    }
    printf("\n");
}

int main()
{
    int n;
    printf("Enter Size ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter Elements ");
    getarr(arr,n);
    printf("Sorted Array ");
    redix_sort(arr);
    printarr(arr,n);
    return 0;
}