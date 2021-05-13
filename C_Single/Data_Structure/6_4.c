#include <stdio.h>
#include <stdlib.h>

typedef int ElementType;
typedef struct Node *PtrToNode;
struct Node {
    ElementType Data;
    PtrToNode   Next;
};
typedef PtrToNode List;

List Read(); /* 细节在此不表 */
void Print( List L ); /* 细节在此不表 */

List Reverse( List L );

int main()
{
    List L1, L2;
    L1 = Read();
    L2 = Reverse(L1);
    Print(L1);
    Print(L2);
    return 0;
}

List Reverse( List L )
{
    if(L==NULL)return NULL;
    List tmp=L;
    int i=0;
    while(tmp!=NULL)
    {
        i++;
        tmp=tmp->Next;
    }
    tmp=L;
    ElementType a[i];
    for(int j=0;j<i;j++)
    {
        a[j]=tmp->Data;
        tmp=tmp->Next;
    }
    List reverseL=(List)malloc(sizeof(List));
    List ret=reverseL;
    for(int j=i-1;j>0;j--)
    {
        ret->Data=a[j];
        ret->Next=(List)malloc(sizeof(List));
        ret=ret->Next;
    }
    ret->Data=a[0];
    ret->Next=NULL;
    L->Next=NULL;
    return reverseL;
}