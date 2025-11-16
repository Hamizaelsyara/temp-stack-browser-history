package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {
    public static void main(String[] args) {

        Stack<String> history = new Stack<>();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Browser History (Stack) ===");
            System.out.println("1. Browse (Tambah website)");
            System.out.println("2. View (Lihat seluruh history)");
            System.out.println("3. Back (Kembali ke halaman sebelumnya)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // buang enter

            switch (pilihan) {

                case 1: // browse
                    System.out.print("Masukkan nama website: ");
                    String website = input.nextLine();
                    history.push(website);
                    System.out.println("Website '" + website + "' ditambahkan!");
                    break;

                case 2: // view
                    System.out.println("\n--- History Browser ---");
                    if (history.isEmpty()) {
                        System.out.println("Belum ada history.");
                    } else {
                        // ditampilkan dari yang terbaru
                        Stack<String> temp = (Stack<String>) history.clone();
                        while (!temp.isEmpty()) {
                            System.out.println(temp.pop());
                        }
                    }
                    break;

                case 3: // back
                    if (history.isEmpty()) {
                        System.out.println("Tidak ada history untuk kembali.");
                    } else {
                        String removed = history.pop();
                        System.out.println("Kembali dari: " + removed);

                        if (!history.isEmpty()) {
                            System.out.println("Sekarang di: " + history.peek());
                        } else {
                            System.out.println("Tidak ada halaman yang tersisa.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);

        input.close();
    }
}
