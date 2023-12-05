package Hw6_21000659_DauVanAn.excercise3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class SortingAlgorithmsComparisonChart extends JPanel {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final String[] SORT_TYPES = {"Bubble Sort", "Insertion Sort", "Selection Sort", "Heap Sort", "Quick Sort", "Merge Sort"};
    private long[] AVERAGE_TIMES = SortingAlgorithmsComparison.test();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        long maxTime = getMaxTime();
        int barWidth = (WIDTH - 100) / SORT_TYPES.length;

        for (int i = 0; i < SORT_TYPES.length; i++) {
            int barHeight = (int) ((double) AVERAGE_TIMES[i] / maxTime * (HEIGHT - 100));
            int x = 50 + i * barWidth;
            int y = HEIGHT - 50 - barHeight;

            g.setColor(Color.blue);
            g.fillRect(x, y, barWidth - 20, barHeight);

            g.setColor(Color.BLACK);
            g.drawString(SORT_TYPES[i], x, HEIGHT - 30);
        }
    }
    private long getMaxTime() {
        long maxTime = 0;
        for (long time : AVERAGE_TIMES) {
            if (time > maxTime) {
                maxTime = time;
            }
        }
        return maxTime;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Comparison of Sort Algorithms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        SortingAlgorithmsComparisonChart chart = new SortingAlgorithmsComparisonChart();
        frame.getContentPane().add(chart);
        frame.pack();
        frame.setVisible(true);
    }
}
