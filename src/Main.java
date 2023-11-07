
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int k = Integer.parseInt(tk.nextToken());
        int coins[] = new int[n];
        int dp[] = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            int value = coins[i];
            for (int j = value; j <= k; j++) {
                //dp[j - value] 가 MaxValue면 -2147483649 값이 나와서 엉뚱한 값이 계산됨
                if (dp[j - value] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - value] + 1, dp[j]);
                }
            }
        }
        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}
