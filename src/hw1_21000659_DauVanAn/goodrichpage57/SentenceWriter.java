package hw1_21000659_DauVanAn.goodrichpage57;

import java.util.Random;

public class SentenceWriter {
    public static void main(String[] args) {
        String sentence = "I will never spam my friends again.";

        // print 100 times
        for (int i = 1; i <= 100; i++) {
            String modifiedSentence = addTypos(sentence);
            System.out.println(i + ". " + modifiedSentence);
        }
    }

    // add typos
    public static String addTypos(String sentence) {
        Random rand = new Random();
        StringBuilder modifiedSentence = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);

            // Xác định xem có thêm lỗi chính tả cho ký tự hiện tại hay không
            boolean addTypo = rand.nextInt(10) < 2; // Xác suất là 20% (2/10)

            // Thêm lỗi chính tả ngẫu nhiên nếu có
            if (addTypo) {
                char typoChar = getRandomTypo(currentChar);
                modifiedSentence.append(typoChar);
            } else {
                modifiedSentence.append(currentChar);
            }
        }

        return modifiedSentence.toString();
    }

    // Phương thức để lấy một ký tự lỗi chính tả ngẫu nhiên từ một ký tự ban đầu
    public static char getRandomTypo(char originalChar) {
        Random rand = new Random();

        char typoChar = originalChar;

        // Mảng chứa các ký tự lỗi chính tả có thể được chọn ngẫu nhiên
        char[] typoChars = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        // Chọn một ký tự lỗi chính tả ngẫu nhiên khác với ký tự ban đầu
        while (typoChar == originalChar) {
            typoChar = typoChars[rand.nextInt(typoChars.length)];
        }

        return typoChar;
    }
}
