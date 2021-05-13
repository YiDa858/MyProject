#include<stdio.h>
#include<string.h>


#define MAXSIZE 100

int main()
{
    int flag=1;
    char input[MAXSIZE];
    gets(input);
    char left[MAXSIZE];
    int top=0;
    for(int i=0;i<strlen(input);i++)
    {
        if(input[i]=='('||input[i]=='[')left[top++]=input[i];
        if(input[i]==')'&&left[--top]!='(')
        {
            flag=0;
            break;
        }
        if(input[i]==']'&&left[--top]!='[')
        {
            flag=0;
            break;
        }
    }
    if(flag==1&&top==0)
    {
        printf("Right match!\n");
    }
    else
    {
        printf("Wrong match!\n");
    }
    return 0;
}