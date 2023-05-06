//frequency of each element in an array
#include<stdio.h>
int main()
{
    int n,count = 0,key;
    printf("Enter the number of elements in the array: ");
    scanf("%d",&n); 
    int a[n];
    printf("Enter the elements of the array: ");
    for(int i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    printf("Enter the element whose frequency is to be found: ");
    scanf("%d",&key);
    for(int i=0;i<n;i++)
    {
        if(key == a[i])
        {
            count++;
        }
    }
    printf("The frequency of %d is %d",key,count);
    return 0;
}