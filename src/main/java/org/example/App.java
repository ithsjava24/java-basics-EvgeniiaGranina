package org.example;

import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] pris = {0, 0, 0, 0, 52, 256, 403, 762, 920, 768, 1123, 972, 569, 620, 647, 691, 826, 1033, 2278, 2511, 1144, 920, 690, 570};

        System.out.print("Elpriser\n" +
                "========\n" +
                "1. Inmatning\n" +
                "2. Min, Max och Medel\n" +
                "3. Sortera\n" +
                "4. Bästa Laddningstid (4h)\n" +
                "5. Visualisering\n" +
                "e. Avsluta\n");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("e")) {
            return;
        } else if (choice.equals("1")) {
            System.out.print("Vilka timmar vill du veta om priserna?\n");
            int hour = sc.nextInt();
            System.out.println(pris[hour]);
        } else if (choice.equalsIgnoreCase("2")) {
            int min = Math.min(pris[]);
            int max = Math.max(pris[]);
            int count = 24;
            int sum = 0;
            for (int i = 0; i < pris.length; i++) {
                sum +=;
            }
            int medel = sum / count;
            System.out.print("Min pris är: " + min + "\nMax pris är: " + max + "\nMedel pris är: " + medel + "\n");
        }
    }

}

//    public static int MinMaxMedel(){
//        int min = Math.min(pris[]);
//        int max = Math.max(pris[]);
//        int count = 24;
//        int sum = 0;
//        for (int i = 0; i < pris.length; i++) {
//            sum+=;
//        }
//        int medel = sum/count;
//        return min;
//        return max;
//        return medel;
//    }

