package hw1_21000659_DauVanAn.goodrichpage57;

import java.util.ArrayList;
import java.util.Random;

public class BirthdayParadoxTest {
    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("Birthday Paradox Test");
        System.out.println("-------------------------------------------------------");

        for (int n = 5; n <= 100; n += 5) {
            int countSameBirthday = 0;
            int experiments = 10000;

            for (int i = 0; i < experiments; i++) {
                ArrayList<Integer> birthdays = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    int birthday = rand.nextInt(365) + 1;
                    if (birthdays.contains(birthday)) {
                        countSameBirthday++;
                        break;
                    } else {
                        birthdays.add(birthday);
                    }
                }
            }

            double probability = (double) countSameBirthday / experiments;
            System.out.println("For n = " + n + ", probability of having same birthday: " + probability);
        }
    }
}

