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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String textMenu = """
                Elpriser
                ========
                1. Inmatning
                2. Min, Max och Medel
                3. Sortera
                4. Bästa Laddningstid (4h)
                e. Avsluta
                """;
        while (true) {

            System.out.print(textMenu);

            String choice = sc.nextLine();
            switch (choice.toLowerCase()) {
                case "1":
                    input(sc);
                    break;
                case "2":
                    minMaxMean();
                    break;
                case "3":
                    sorting();
                    break;
                case "4":
                    break;
                case "e":
                    return;
            }

//            if (choice.equalsIgnoreCase("e")) {
//                return;
//            } else if (choice.equals("1")) {
//                input(sc);
//            } else if (choice.equalsIgnoreCase("2")) {
//                minMaxMean();
//            }
//            else if (choice.equalsIgnoreCase("5")) ;
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
            price[i] = new TimPris(String.format("%02d-%02d", i, i + 1), val);
        }
    }

    private static void minMaxMean() {

        long count = 0;
        long sum = 0;
        TimPris min = new TimPris("", Integer.MAX_VALUE);
        TimPris max = new TimPris("", Integer.MIN_VALUE);

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

    }

    private static void sorting() {

        ValueTimeHour[] values = new ValueTimeHour[price.length];
        for (int i = 0; i < price.length; i++) {
            values[i] = new ValueTimeHour(price[i].getTim(), price[i].getPris());
        }
        Arrays.sort(values, Comparator.comparingInt(ValueTimeHour::prise).reversed());

        for (ValueTimeHour v : values) {
            System.out.printf("%s %d öre\n", v.hour, v.prise);
        }
    }

    record ValueTimeHour(String hour, int prise) {

    }

}


