import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int steps = in.nextInt();
        int arrLen = in.nextInt();
        int sum = Solution.numWays(steps,arrLen);
        System.out.println(sum);
    }
}
