#include<stdio.h>
#include<stdlib.h>

typedef struct Node* Ptrnode;

struct Node{
    int Data;
    Ptrnode Next;
};

int main()
{
    Ptrnode front=(Ptrnode)malloc(sizeof(Ptrnode));
    Ptrnode rear=(Ptrnode)malloc(sizeof(Ptrnode));
    
    front->Next=rear;
    front->Data=1;
    
    rear->Next=front;
    rear->Data=1;

    printf("Please enter the order of the number you want:");
    int n;
    scanf("%d",&n);

    for(int i=3;i<=n;i++)
    {
        int ret=front->Data;
        front->Data=rear->Data;
        rear->Data=ret+front->Data;
    }
    printf("The number you want is %d.\n",rear->Data);
    
    return 0;
}