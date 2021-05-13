/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if(l1==NULL&&l2==NULL)return NULL;
    if(l1==NULL&&l2!=NULL)return l2;
    if(l1!=NULL&&l2==NULL)return l1;
    struct ListNode* l=(struct ListNode*)malloc(sizeof(struct ListNode));
    l->next=NULL;
    struct ListNode* tail=l;
    while(l1&&l2)
    {
        if(l1->val<=l2->val)
        {
            tail->val=l1->val;
            if(l1->next==NULL)
            {
                l1=NULL;
                break;
            }
            l1=l1->next;
        }
        else
        {
            tail->val=l2->val;
            if(l2->next==NULL)
            {
                l2=NULL;
                break;
            }
            l2=l2->next;
        }
        tail->next=(struct ListNode*)malloc(sizeof(struct ListNode));
        tail=tail->next;
        tail->next=NULL;
    }
    tail->next=(struct ListNode*)malloc(sizeof(struct ListNode));
    tail=tail->next;
    tail->next=NULL;
    while(l1)
    {
        tail->val=l1->val;
        if(l1->next==NULL)break;
        l1=l1->next;
        tail->next=(struct ListNode*)malloc(sizeof(struct ListNode));
        tail=tail->next;
        tail->next=NULL;
    }
    while(l2)
    {
        tail->val=l2->val;
        if(l2->next==NULL)break;
        l2=l2->next;
        tail->next=(struct ListNode*)malloc(sizeof(struct ListNode));
        tail=tail->next;
        tail->next=NULL;
    }
    return l;
}