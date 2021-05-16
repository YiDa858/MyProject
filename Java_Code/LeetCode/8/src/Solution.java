/*
请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
        函数myAtoi(string s) 的算法如下：
        读入字符串并丢弃无用的前导空格
        检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
        读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
        如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
        返回整数作为最终结果。
        注意：
        本题中的空白字符只包括空格字符 ' ' 。除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
*/

public class Solution {
    public int myAtoi(String s) {
        s = s.strip();                      //丢弃无用空格字符
        char[] a = s.toCharArray();         //将s转化为char型数组
        double sum = 0;                     //用于记录结果
        int flag = 1;                       //用于判断正负，默认为正
        int i = 0;
        if (a.length == 0)return 0;
        if (a[0] == '-') {                  //当数组首位表示正负时
            flag = -1;
            i++;
        } else if (a[0] == '+') {
            i++;
        }
        for (; i < a.length; i++) {         //遍历数组
            if (!Character.isDigit(a[i]))break;     //若有非法字符，停止遍历
            int ret = a[i] - '0';                   //将该位字符转化为整数
            if ((sum*10+ret) > Math.pow(2,31)-1) {     //判断是否越过边界
                if (flag > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            sum = sum*10 + ret;         //累加
        }
        return (int)sum * flag;         //返回结果
    }
}