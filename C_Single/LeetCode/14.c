/*编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
示例 1：输入：strs = ["flower","flow","flight"] 输出："fl"
示例 2：输入：strs = ["dog","racecar","car"] 输出："" 解释：输入不存在公共前缀。
提示：
0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成*/
#include<string.h>
#include<stdio.h>

char * longestCommonPrefix(char ** strs, int strsSize){
    int max=strlen(strs[0]);
    if(strsSize==0)return "";
    int ret=0;
    int flag=1;
    for(;ret<=max;ret++){
        for(int i=0;i<strsSize;i++){
            if(strs[0][ret]!=strs[i][ret]){
                flag=0;
                break;
            }
        }
        if(flag==0)break;
    }
    if(ret==0)return "";
    char *prestr=(char*)malloc((ret+1)*sizeof(char));
    for(int i=0;i<ret;i++){
        prestr[i]=strs[0][i];
    }
    prestr[ret]='\0';
    return prestr;
}