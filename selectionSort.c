#include<stdio.h>
int selectionSort(int a[],int n)
{
    int i,j,temp,comp,swap;
    int res[2];
    for(i=0;i<n-1;i++)
    {
        for(j=i+1;j<n;j++)
        {
            comp++;
            if(a[i]>a[j])
            {
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                swap++;
            }
        }
    }
    res[0]=comp;
    res[1]=swap;
    return res;
}
int main()
{
    int i,j,n,temp,comp,swap;
    printf("Enter the number of elements: ");
    scanf("%d",&n);
    int a[n];
    printf("Enter the elements: ");
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    int res[2];
    res=selectionSort(a,n);
    printf("The sorted array is: ");
    for(i=0;i<n;i++)
    {
        printf("%d ",a[i]);
    }
    return 0;
}