package Hw4_21000659_DauVanAn.excercise8;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.add(t);
        while (requests.peek() < t - 3000) {
            requests.remove();
        }
        return requests.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));      // requests = [1], range is [-2999,1], return 1
        System.out.println(recentCounter.ping(100));    // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(recentCounter.ping(3001));   //requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(recentCounter.ping(3002));   // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }
}

