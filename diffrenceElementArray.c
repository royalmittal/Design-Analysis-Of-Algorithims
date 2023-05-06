#include<stdio.h>
int main()
{
    int t,n,k,count=0;
    printf("Enter the number of test cases: ");
    scanf("%d",&t);
    for(int i=0;i<t;i++)
    {
        printf("Enter the number of elements in the array: ");
        scanf("%d",&n);
        printf("Enter the difference between the elements: ");
        scanf("%d",&k);
        int a[n];
        printf("Enter the elements of the array: ");
        for(int j=0;j<n;j++)
        {
            scanf("%d",&a[j]);
        }
        for(int j=0;j<n;j++)
        {
            for(int l=j+1;l<n;l++)
            {
                if(a[j]-a[l]==k || a[l]-a[j]==k)
                {
                    count++;
                }
            }
        }
        printf("The number of pairs of integers such that their difference is equal to %d is: %d\n",k,count);
    }
    return 0;
}