package Hw2_21000659_DauVanAn.algorithmsevaluation;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
// Draw sort comparison chart
public class SortComparisonChart extends JPanel {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final String[] SORT_TYPES = {"Bubble Sort", "Insertion Sort", "Selection Sort", "Quick Sort", "Merge Sort"};
    private long[] AVERAGE_TIMES = averageTimes(1000);// length of array = 1000; test n = 100, 1000, 10000, 100000

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        long maxTime = getMaxTime();
        int barWidth = (WIDTH - 100) / SORT_TYPES.length;

        for (int i = 0; i < SORT_TYPES.length; i++) {
            int barHeight = (int) ((double) AVERAGE_TIMES[i] / maxTime * (HEIGHT - 100));
            int x = 50 + i * barWidth;
            int y = HEIGHT - 50 - barHeight;

            g.setColor(Color.green);
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
    public static long[] timeToRunProgame(Sorter strategy, int lengthOfArray) {
        long[] timeArray = new long[20];
        for (int i = 0; i < 20; i++) {
            DataSet dataSet = new DataSet(lengthOfArray);
            dataSet.setStrategy(strategy);
            final long startTime = System.nanoTime();
            dataSet.sort();
            final long endTime = System.nanoTime();
            timeArray[i] = endTime - startTime;
        }
        return timeArray;
    }
    public static long averageTime(long[] timeArray) {
        long sum = 0;
        for (int i = 0; i < timeArray.length; i++) {
            sum += timeArray[i];
        }
        long averageTime = sum / timeArray.length;
        return averageTime;
    }
    public static long[] averageTimes(int lengthOfArray) {
        long[] timeOfBubbleSort = timeToRunProgame(new BubbleSort(), lengthOfArray);
        long averageTimeOfBubbleSort = averageTime(timeOfBubbleSort);
        long[] timeOfInsertionSort = timeToRunProgame(new InsertionSort(), lengthOfArray);
        long averageTimeOfInsertionSort = averageTime(timeOfInsertionSort);
        long[] timeOfSelectionSort = timeToRunProgame(new SelectionSort(), lengthOfArray);
        long averageTimeOfSelectionSort = averageTime(timeOfSelectionSort);
        long[] timeOfQuickSort = timeToRunProgame(new QuickSort(), lengthOfArray);
        long averageTimeOfQuickSort = averageTime(timeOfQuickSort);
        long[] timeOfMergeSort = timeToRunProgame(new MergeSort(), lengthOfArray);
        long averageTimeOfMergeSort = averageTime(timeOfMergeSort);
        long[] arr = new long[] {averageTimeOfBubbleSort,
                                averageTimeOfInsertionSort,
                                averageTimeOfSelectionSort,
                                averageTimeOfQuickSort,
                                averageTimeOfMergeSort};
        return arr;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Comparison of Sort Algorithms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        SortComparisonChart chart = new SortComparisonChart();
        frame.getContentPane().add(chart);
        frame.pack();
        frame.setVisible(true);
    }
}

