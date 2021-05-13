#include<string.h>
int lengthOfLongestSubstring(char * s)
{
    int slen=strlen(s);
    char ch[slen+1];
    int max=0;
    for(int n=0;n<slen;n++)
    {
        int ret=0;
        int cnt=0;
        for(int i=n;i<slen;i++)
        {
            if(i==n)
            {
                ch[cnt]=s[n];
                cnt++;
                ret++;
            }
            else
            {
                int flag=1;
                for(int j=0;j<cnt;j++)
                {
                    if(s[i]==ch[j])
                    {
                        flag=0;
                        break;
                    }
                }
                if(flag==1)
                {
                    ch[cnt++]=s[i];
                    ret++;
                }
                else
                {
                    break;
                }
            }
        }
        if(ret>max)max=ret;
    }
    return max;
}