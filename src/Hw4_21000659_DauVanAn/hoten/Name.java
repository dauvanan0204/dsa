package Hw4_21000659_DauVanAn.hoten;

import java.util.Stack;

public class Name {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String hoten = "DauVanAn";
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) {
                s.push(hoten.charAt(i));
                if (!s.isEmpty()) {
                    System.out.println("Loop " + (i +1) + " push " + s.peek());
                    System.out.println(s);
                }
            }
            if (i % 3 == 0) {
                System.out.println("Loop " + (i +1) + " pop " + s.pop());
                System.out.println(s);
            }
        }
        System.out.println("Result: " + s);
    }
}
