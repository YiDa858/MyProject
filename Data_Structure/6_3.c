#include <stdio.h>
#include <stdlib.h>

#define ERROR NULL
typedef enum {false, true} bool;
typedef int ElementType;
typedef struct LNode *PtrToLNode;
struct LNode {
    ElementType Data;
    PtrToLNode Next;
};
typedef PtrToLNode Position;
typedef PtrToLNode List;

List MakeEmpty(); 
Position Find( List L, ElementType X );
bool Insert( List L, ElementType X, Position P );
bool Delete( List L, Position P );

int main()
{
    List L;
    ElementType X;
    Position P;
    int N;
    bool flag;

    L = MakeEmpty();
    scanf("%d", &N);
    while ( N-- ) {
        scanf("%d", &X);
        flag = Insert(L, X, L->Next);
        if ( flag==false ) printf("Wrong Answer\n");
    }
    scanf("%d", &N);
    while ( N-- ) {
        scanf("%d", &X);
        P = Find(L, X);
        if ( P == ERROR )
            printf("Finding Error: %d is not in.\n", X);
        else {
            flag = Delete(L, P);
            printf("%d is found and deleted.\n", X);
            if ( flag==false )
                printf("Wrong Answer.\n");
        }
    }
    flag = Insert(L, X, NULL);
    if ( flag==false ) printf("Wrong Answer\n");
    else
        printf("%d is inserted as the last element.\n", X);
    P = (Position)malloc(sizeof(struct LNode));
    flag = Insert(L, X, P);
    if ( flag==true ) printf("Wrong Answer\n");
    flag = Delete(L, P);
    if ( flag==true ) printf("Wrong Answer\n");
    for ( P=L->Next; P; P = P->Next ) printf("%d ", P->Data);
    return 0;
}
//创建并返回一个空的线性表
List MakeEmpty()
{
    List i=(List)malloc(sizeof(List));
    i->Next=NULL;
    return i;
} 
//返回线性表中X的位置。若找不到则返回ERROR
Position Find( List L, ElementType X )
{
    List tmp=L->Next;
    if(L->Next==NULL)return ERROR;
    while(tmp->Data!=X&&tmp->Next!=NULL)                 //error!!!
    {
        tmp=tmp->Next;
    }
    if(tmp->Data==X)
    {
        return tmp;
    }
    else
    {
        return ERROR;
    }
}
//将X插入在位置P指向的结点之前，返回true。如果参数P指向非法位置，则打印“Wrong Position for Insertion”，返回false
bool Insert( List L, ElementType X, Position P )
{
    List tmp=L->Next;
    if(P==L->Next)
    {
        List i=(List)malloc(sizeof(List));
        i->Data=X;
        i->Next=L->Next;
        L->Next=i;
        return true;
    }
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
        return true;
    }
    printf("Wrong Position for Insertion\n");
    return false;
}
//将位置P的元素删除并返回true。若参数P指向非法位置，则打印“Wrong Position for Deletion”并返回false
bool Delete( List L, Position P )
{
    if(L==NULL||P==NULL)
    {
        printf("Wrong Position for Deletion\n");
        return false;
    }
    List tmp=L;
    if(P==L)
    {
        L=L->Next;
        return true;
    }
    while(tmp->Next!=P&&tmp->Next!=NULL)
    {
        tmp=tmp->Next;
    }
    if(tmp->Next==P)
    {
        tmp->Next=tmp->Next->Next;
        return true;
    }
    else
    {
        printf("Wrong Position for Deletion\n");
        return false;
    }
}