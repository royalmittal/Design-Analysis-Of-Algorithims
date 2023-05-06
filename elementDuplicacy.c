//time complexity: O(n log n)
//space complexity: O(n)

#include<stdio.h>
int main()
{
    int i,j,n,temp;
    printf("Enter the number of elements: ");
    scanf("%d",&n);
    int a[n];
    printf("Enter the elements: ");
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    for(i=0;i<n-1;i++)
    {
        for(j=i+1;j<n;j++)
        {
            if(a[i]>a[j])
            {
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
            if(a[i]==a[j])
            {
                printf("The element %d is duplicated",a[i]);
                return 0;
            }
        }
    }
    
    return 0;
}