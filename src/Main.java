import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int[][] arr = new int[n][2];
    static ArrayList<Time> times = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;
    static int cnt = 0;

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    Time tmp1 = new Time(arr[i][j], "S");
                    times.add(tmp1);
                } else if (j == 1) {
                    Time tmp2 = new Time(arr[i][j], "E");
                    times.add(tmp2);
                }
            }
        }
        Collections.sort(times);
        for (Time t : times) {
            if (t.state == "S") {
                answer = Math.max(++cnt, answer);
            } else {
                answer = Math.max(--cnt, answer);
            }
        }
        System.out.println(answer);

    }

    static class Time implements Comparable<Time> {
        private int time;
        private String state;

        public Time(int time, String state) {
            this.time = time;
            this.state = state;
        }

        public int getTime() {
            return time;
        }

        public String getState() {
            return state;
        }

        @Override
        public int compareTo(Time other) {
            // 시간을 기준으로 오름차순 정렬
            if (this.time - other.time == 0) {
                return this.state.compareTo(other.state);
            } else {
                return this.time - other.time;
            }
        }
    }
}
