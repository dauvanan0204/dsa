package hw1_21000659_DauVanAn.goodrichpage57;
import java.util.Scanner;
import java.util.Stack;

public class ReverseLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> lines = new Stack<>();

        // Read lines from standard input and push them onto the stack
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.push(line);
            if (line.equals("end")) {
                break;
            }
        }

        // Pop lines from the stack and print them in reverse order
        while (!lines.isEmpty()) {
            String line = lines.pop();
            System.out.println(line);
        }
    }
}
