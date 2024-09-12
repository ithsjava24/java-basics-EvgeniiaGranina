package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

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
        if (choice == "e") {
            return;
        }

    }
}
