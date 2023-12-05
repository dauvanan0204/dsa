package hw1_21000659_DauVanAn.goodrichpage100;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequencyChart {

    public static void main(String[] args) {
        String document = "Lorem ipsum dolor sit amet";
        generateFrequencyChart(document);
    }

    public static void generateFrequencyChart(String document) {
        // Remove non-alphabet characters and convert all characters to lowercase
        document = document.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Create a map to store the frequencies of each alphabet character
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Loop through each character in the document and update the frequency map
        for (char c : document.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Display the bar-chart plot of character frequencies
        for (char c : frequencyMap.keySet()) {
            System.out.print(c + ": ");
            for (int i = 0; i < frequencyMap.get(c); i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
