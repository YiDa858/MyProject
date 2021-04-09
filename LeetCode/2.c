struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    int c=0;
    struct ListNode *head=(struct ListNode *)malloc(sizeof(struct ListNode)),*cur=head,*del=head;
    while(l1!=NULL||l2!=NULL||c)
    {
        cur->next=(struct ListNode *)malloc(sizeof(struct ListNode));
        cur=cur->next;
        l1=l1!=NULL?(c+=l1->val,l1->next):l1;
        l2=l2!=NULL?(c+=l2->val,l2->next):l2;
        cur->val=c%10;
        c=c/10;
    }
    cur->next=NULL;
    head=head->next;
    free(del);
    return head;
}