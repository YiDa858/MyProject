#include <stdio.h>
#include <stdlib.h>

#define ERROR NULL
typedef int ElementType;
typedef struct LNode *PtrToLNode;
struct LNode {
    ElementType Data;
    PtrToLNode Next;
};
typedef PtrToLNode Position;
typedef PtrToLNode List;

Position Find( List L, ElementType X );
List Insert( List L, ElementType X, Position P );
List Delete( List L, Position P );

int main()
{
    List L;
    ElementType X;
    Position P, tmp;
    int N;

    L = NULL;
    scanf("%d", &N);
    while ( N-- ) {
        scanf("%d", &X);
        L = Insert(L, X, L);
        if ( L==ERROR ) printf("Wrong Answer\n");
    }
    scanf("%d", &N);
    while ( N-- ) {
        scanf("%d", &X);
        P = Find(L, X);
        if ( P == ERROR )
            printf("Finding Error: %d is not in.\n", X);
        else {
            L = Delete(L, P);
            printf("%d is found and deleted.\n", X);
            if ( L==ERROR )
                printf("Wrong Answer or Empty List.\n");
        }
    }
    L = Insert(L, X, NULL);
    if ( L==ERROR ) printf("Wrong Answer\n");
    else
        printf("%d is inserted as the last element.\n", X);
    P = (Position)malloc(sizeof(struct LNode));
    tmp = Insert(L, X, P);
    if ( tmp!=ERROR ) printf("Wrong Answer\n");
    tmp = Delete(L, P);
    if ( tmp!=ERROR ) printf("Wrong Answer\n");
    for ( P=L; P; P = P->Next ) printf("%d ", P->Data);
    return 0;
}
//返回线性表中首次出现X的位置。若找不到则返回ERROR
Position Find( List L, ElementType X )
{
    if(L==NULL)return ERROR;
    List ret=L;
    while(ret->Data!=X&&ret->Next!=NULL)      //遍历，结束条件为找到X或已经寻找到线性表末尾
    {
        ret=ret->Next;
    }
    if(ret->Data==X)
    {
        return ret;
    }
    return ERROR;
}
//将X插入在位置P指向的结点之前，返回链表的表头。如果参数P指向非法位置，则打印“Wrong Position for Insertion”，返回ERROR
List Insert( List L, ElementType X, Position P )
{
    if(P==L)
    {
        List i=(List)malloc(sizeof(List));
        i->Data=X;
        i->Next=L;
        return i;
    }
    List tmp=L;
    while(tmp->Next!=P&&tmp->Next!=NULL)
    {
        tmp=tmp->Next;
    }
    if(tmp->Next==P)
    {
        List i=(List)malloc(sizeof(List));
        i->Data=X;
        i->Next=P;
        tmp->Next=i;
        return L;
    }
    printf("Wrong Position for Insertion\n");
    return ERROR;
}
//将位置P的元素删除并返回链表的表头。若参数P指向非法位置，则打印“Wrong Position for Deletion”并返回ERROR
List Delete( List L, Position P )
{
    if(P==NULL||L==NULL)
    {
        printf("Wrong Position for Delection\n");
        return ERROR;
    }
    if(P==L)
    {
        List ret=L->Next;
        free(P);
        return ret;
    }
    List tmp=L;
    while(tmp->Next!=P&&tmp->Next!=NULL)
    {
        tmp=tmp->Next;
    }
    if(tmp->Next==P)
    {
        free(P);
        tmp->Next=tmp->Next->Next;
        return L;
    }
    printf("Wrong Position for Delection\n");
    return ERROR;
}