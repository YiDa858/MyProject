/*�?�?队列，�?�理斐波那�?�数�?*/
#include<stdio.h>

typedef struct
{
	int vaule[3];
	int front;
	int rear;
}Queue;

int main()
{
	int N;
	Queue queue={{1,1,0},0,1};
	scanf("%d",&N);
	
	printf("%d %d ",queue.vaule[0],queue.vaule[1]);//打印前两�?
	if(N<=2)
	{
		return 0;
	}
	
	for(int i=2;i<N;i++)
	{
		//入队
		queue.vaule[(queue.rear+1)%3]=queue.vaule[queue.front]+queue.vaule[queue.rear];
		queue.rear=(queue.rear+1)%3;//尾更�?
		printf("%d ",queue.vaule[queue.rear]);//打印�?
		//出队
		queue.front=(queue.front+1)%3;//头更�?
	}
	
	return 0;
}