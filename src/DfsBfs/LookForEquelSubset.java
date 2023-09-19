package memoBfs;

import java.util.Scanner;

public class LookForEquelSubset {
    static boolean ch=false;
    static Scanner sc = new Scanner(System.in);
    static int All=0;
    static int n = sc.nextInt();
    static int arr[] = new int[n];
    static String answer = "NO";
    static void memo(int L,int sum){
        if(ch==true)
            return;
        if (L == n) {
            if (sum == All -sum) {
                answer = "YES";
                ch=true;
            }
        }
        else{
            memo(L + 1, sum + arr[L]);
            memo(L + 1, sum);
        }

    }


    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            All += arr[i];
        }
        memo(0, 0);
        System.out.println(answer);

    }
}
