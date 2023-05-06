#include<stdio.h>
int countSort(int arr1[],int arr2[])
{
    int max=arr1[0];
    for(int i=1;i<5;i++)
    {
        if(arr1[i]>max)
        {
            max=arr1[i];
        }
    }
    int count[max+1];
    for(int i=0;i<max+1;i++)
    {
        count[i]=0;
    }
    for(int i=0;i<5;i++)
    {
        count[arr1[i]]++;
    }
    for(int i=1;i<max+1;i++)
    {
        count[i]=count[i]+count[i-1];
    }
    for(int i=4;i>=0;i--)
    {
        arr2[count[arr1[i]]-1]=arr1[i];
        count[arr1[i]]--;
    }
    return 0;

}
int main()
{
    int n;
    printf("Enter Size ");
    scanf("%d",&n);
    printf("Enter Elements ");
    int arr1[n],arr2[n];
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr1[i]);
    }
    countSort(arr1,arr2);
    for(int i=0;i<n;i++)
    {
        printf("%d ",arr2[i]);
    }
    return 0;
}