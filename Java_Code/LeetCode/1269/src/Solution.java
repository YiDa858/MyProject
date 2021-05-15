/*
有一个长度为arrLen的数组，开始有一个指针在索引0 处。

每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。

给你两个整数steps 和arrLen ，请你计算并返回：在恰好执行steps次操作以后，指针仍然指向索引0 处的方案数。

由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 */

public class Solution {
    public static int numWays(int steps, int arrLen) {
        int maxColumn = Math.min(arrLen - 1, steps);
        int[][] dp = new int[steps + 1][maxColumn + 1];     //在i步操作后，指针位于j的方案数
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % (int) (Math.pow(10,9)+7);
                }
                if (j + 1 <= maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % (int) (Math.pow(10,9)+7);
                }
            }
        }
        return dp[steps][0];
    }
}

/*对于计算方案数的题目，常用的方法是动态规划。对于这道题，需要计算在 steps 步操作之后，指针位于下标 0 的方案数。

用 dp[i][j] 表示在 i 步操作之后，指针位于下标 j 的方案数。其中，i 的取值范围是 0≤i≤steps，j 的取值范围是 0≤j≤arrLen−1。

由于一共执行 steps 步操作，因此指针所在下标一定不会超过 steps，可以将 j 的取值范围进一步缩小到 0≤j≤min(arrLen−1,steps)。

当没有进行任何操作时，指针一定位于下标 0，因此动态规划的边界条件是 dp[0][0]=1，当 1≤j≤min(arrLen−1,steps) 时有 dp[0][j]=0。

每一步操作中，指针可以向左或向右移动 1 步，或者停在原地。因此，当 1≤i≤steps 时，状态 dp[i][j] 可以从 dp[i−1][j−1]、dp[i−1][j] 和 dp[i−1][j+1] 这三个状态转移得到。

状态转移方程如下：dp[i][j]=dp[i−1][j−1]+dp[i−1][j]+dp[i−1][j+1]

由于指针不能移动到数组范围外，因此对于上述状态转移方程，需要注意下标边界情况。当 j=0 时，dp[i−1][j−1]=0；当 j=min(arrLen−1,steps) 时，dp[i−1][j+1]=0。具体实现时，需要对下标进行判断，避免下标越界。

计算过程中需要对每个状态的值计算模 10^9+7 后的结果。最终得到 dp[steps][0] 的值即为答案。
*/