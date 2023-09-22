package com.example.sorting;

import java.util.Scanner;

public class PrintoutSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the document title
        System.out.print("Enter document title: ");
        String title = scanner.nextLine();

        // Validate the title (not empty)
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return; // Exit the program
        }

        // Get the document content
        System.out.print("Enter document content: ");
        String content = scanner.nextLine();

        // Validate the content (not empty)
        if (content.isEmpty()) {
            System.out.println("Content cannot be empty.");
            return; // Exit the program
        }

        // Print the document
        System.out.println("\nPrinting Document...");
        System.out.println("Title: " + title);
        System.out.println("Content:\n" + content);

        // Close the scanner
        scanner.close();
    }
}