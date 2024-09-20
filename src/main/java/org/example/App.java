package org.example;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    private static final TimPris[] price = new TimPris[24];
//    public final static int ROW_COUNT = 10;
//    public static int[] prices;
//    public static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        prices = inputPrice();
//        printAllLines(prices);
//        printHours(prices);
        String textMenu = """
                Elpriser
                ========
                1. Inmatning
                2. Min, Max och Medel
                3. Sortera
                4. Bästa Laddningstid (4h)
                5. Visualisering
                e. Avsluta
                """;
        while (true) {

            System.out.print(textMenu);

            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("e")) {
                return;
            } else if (choice.equals("1")) {
                input(sc);

            } else if (choice.equalsIgnoreCase("2")) {
                minMaxMean();
//                int min = Arrays.stream(pris).min().getAsInt();
//                int max = Arrays.stream(pris).max().getAsInt();
//                int count = 24;
//                int sum = 0;
//                for (int i = 0; i < pris.length; i++)
//                    sum += pris[i];
//
//                int medel = sum / count;
//                System.out.print("Min pris är: " + min + "\nMax pris är: " + max + "\nMedel pris är: " + medel + "\n");
            }
            //
            else if (choice.equalsIgnoreCase("5")) ;
        }
    }

    private static class TimPris {
        private final String tim;
        private final int pris;

        TimPris(String tim, int pris) {
            this.tim = tim;
            this.pris = pris;
        }

        public String getTim() {
            return tim;
        }

        public int getPris() {
            return pris;
        }
    }

    private static void input(Scanner scanner) {
        System.out.print("Mata in priser för varie timme (i öre):\n");
        for (int i = 0; i < price.length; i++) {
            System.out.printf("%02d-%02d: ", i, i + 1);
            int val = Integer.parseInt(scanner.nextLine());
            price[i] = new TimPris(String.format("%02d-%02d ", i, i + 1), val);
        }
    }

    private static void minMaxMean() {

        long count = 0;
        long sum = 0;
        TimPris min = new TimPris("N/A", Integer.MAX_VALUE);
        TimPris max = new TimPris("N/A", Integer.MIN_VALUE);

        for (TimPris timPris : price) {
            if (timPris.getPris() < min.getPris()) {
                min = timPris;
            }
            if (timPris.getPris() > max.getPris()) {
                max = timPris;
            }
            ++count;
            sum += timPris.pris;
        }
        System.out.printf("Lägsta pris: %s, %d öre/kWh\n", min.tim, min.pris);
        System.out.printf("Högsta pris: %s, %d öre/kWh\n", max.tim, max.pris);
        System.out.printf("Medelpris: %.2f öre/kWh\n", count > 0 ? (double) sum / count : 0.0d);


//        System.out.print("Lägsta pris: " + stat.getMin() + " öre/kWh" +
//                "\nHögsta pris: " + stat.getMax() + " öre/kWh");
//        System.out.print("\nMedel pris: " + String.format("%.2f", (float) stat.getSum() / price.length) + " öre/kWh\n");

    }

}


