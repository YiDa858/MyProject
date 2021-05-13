#include <stdio.h>
#include <stdlib.h>

#define ERROR -1
typedef int ElementType;
typedef struct LNode *PtrToLNode;
struct LNode {
    ElementType Data;
    PtrToLNode Next;
};
typedef PtrToLNode List;

List Read(); /* 细节在此不表 */

ElementType FindKth( List L, int K );

int main()
{
    int N, K;
    ElementType X;
    List L = Read();
    scanf("%d", &N);
    while ( N-- ) {
        scanf("%d", &K);
        X = FindKth(L, K);
        if ( X!= ERROR )
            printf("%d ", X);
        else
            printf("NA ");
    }
    return 0;
}
int Length( List L )
{
    List tmp=L;
    int i=0;
    while(tmp!=NULL)
    {
        i++;
        tmp=tmp->Next;
    }
    return i;
}
ElementType FindKth( List L, int K )
{
    if(K<=0||K>Length(L))
    {
        return ERROR;
    }
    List ret=L;
    for(int i=1;i<K;i++)
    {
        ret=ret->Next;
    }
    return ret->Data;
}