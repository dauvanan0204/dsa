package Hw5_21000659_DauVanAn.liststack;

public class TestLinkedListStack {
    public static void main(String[] args) {
        LinkedListStack<Integer> s = new LinkedListStack<>();
        s.push(5);      //s = [5]
        s.push(3);      //s = [5, 3]
        s.push(7);      //s = [5, 3, 7]
        System.out.println("Size of stack: " + s.size());  // size = 3
        System.out.println("Is stack empty: " + s.isEmpty());  // false
        System.out.println("Top of stack(pop): " + s.pop());        // 7
        System.out.println("Top of stack(top): " + s.top());        // 3
        System.out.println("Size of stack: " + s.size());       // size = 2
    }
}
