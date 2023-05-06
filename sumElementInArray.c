#include<stdio.h>
int main() 
{
    int n;
    printf("Enter the number of elements in the array: ");
    scanf("%d",&n);
    int a[n];
    printf("Enter the elements of the array: ");
    for(int i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            for(int k=j+1;k<n;k++)
            {
                if(a[i]+a[j]==a[k])
                {
                    printf("The indices are %d, %d, %d",i,j,k);
                    return 0;
                }
            }
        }
    }
    printf("No such indices exist");
    return 0;
}