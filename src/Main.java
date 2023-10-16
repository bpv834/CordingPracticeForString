import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int p1, p2;
    static String answer = "NO";
    static int parent[] = new int[n + 1];

    //서로소인지 확인하는 메서드
    static int find(int v) {
        if (v == parent[v]) return v;
        else return parent[v]=find(parent[v]);
    }

    //관계를 맺어주는 메서드
    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        //fa와 fb가 같다면 둘 사이에 부모가 존재한다. 보통 낮은 숫자가 부모
        if (fa != fb) {
            parent[fb] = fa;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }
        p1 = sc.nextInt();
        p2 = sc.nextInt();
        if (find(p1) == find(p2))
            answer = "YES";
        System.out.println(answer);

    }
}
