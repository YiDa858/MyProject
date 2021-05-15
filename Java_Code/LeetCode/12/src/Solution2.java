/*罗马数字包含以下七种字符：I，V，X，L，C，D和M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：

I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
给定一个整数，将其转为罗马数字。输入确保在 1到 3999 的范围内。
*/

public class Solution2 {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
}

/*
回顾前言中列出的这 1313 个符号，可以发现：

千位数字只能由 M 表示；
百位数字只能由 C，CD，D 和 CM 表示；
十位数字只能由 X，XL，L 和 XC 表示；
个位数字只能由 I，IV，V 和 IX 表示。
这恰好把这 1313 个符号分为四组，且组与组之间没有公共的符号。因此，整数 num 的十进制表示中的每一个数字都是可以单独处理的。

进一步地，我们可以计算出每个数字在每个位上的表示形式，整理成一张硬编码表。
*/