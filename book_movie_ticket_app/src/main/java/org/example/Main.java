package org.example;

import java.util.Scanner;

public class Main {

        public static double totalCost = 0.0;
        public static double totalServiceTax = 0.0;

        public static double totalCostWithoutTax = 0.0;
        public static double totalCessTax = 0.0;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Initialize the movie theater with available seats and their categories
            int[][] seats = new int[3][10];
            String[][] categories = new String[3][10];

            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    if (i == 0) {
                        int k =j+1;
                        categories[i][j] = "A"+k;
                    } else if (i == 1) {
                        int k =j+1;
                        categories[i][j] = "B"+k;
                    } else {
                        int k =j+1;
                        categories[i][j] = "C"+k;
                    }
                    seats[i][j] = 0;
                }
            }

            // Display the available seats and their categories in the theater
            System.out.println("Current available seats:");
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    System.out.print("[" + categories[i][j] + "]");
                }
                System.out.println();
            }

            while (true) {
                // Ask the user for the seat they want to book
                System.out.println("Enter the row letter of the seat you want to book (A, B, or C):");
                String rowLetter = scanner.next().toUpperCase();
                int row = 0;
                if (rowLetter.equals("A")) {
                    row = 0;
                } else if (rowLetter.equals("B")) {
                    row = 1;
                } else if (rowLetter.equals("C")) {
                    row = 2;
                } else {
                    System.out.println("Invalid row letter. Please try again.");
                    continue;
                }

                System.out.println("Enter the column number of the seat you want to book (1-10):");
                int col = scanner.nextInt() - 1;

                // Check if the seat is available
                if (seats[row][col] == 1) {
                    System.out.println("Sorry, that seat is already booked. Please choose another seat.");
                } else {
                    // Book the seat and calculate the cost based on its category
                    seats[row][col] = 1;
                    double cost = 0;
                    double serviceTax =0;
                    double costOnly = 0;
                    double cessTax =0;
                    if (row == 0) {
                        costOnly =320;
                        serviceTax = Main.getSBTax(320);
                        cessTax = Main.cessTax(320);
                        cost = 320 + Main.getSBTax(320) + Main.cessTax(320) + Main.cessTax(320) ;
                    } else if (row == 1) {
                        costOnly =280;
                        serviceTax = Main.getSBTax(280);
                        cessTax = Main.cessTax(280);
                        cost = 280 + Main.getSBTax(280) + Main.cessTax(280) + Main.cessTax(280);
                    } else {
                        costOnly =240;
                        serviceTax = Main.getSBTax(240);
                        cessTax = Main.cessTax(240);
                        cost = 240 + Main.getSBTax(240) + Main.cessTax(240)  + Main.cessTax(240) ;
                    }

                    totalCost = totalCost +cost;
                    totalCostWithoutTax = totalCostWithoutTax +costOnly;
                    totalServiceTax = totalServiceTax + serviceTax;
                    totalCessTax =totalCessTax + cessTax;
                    System.out.println("Thank you! Your " + categories[row][col] + " seat has been booked. The cost is Rs. " + cost + ".");
                    System.out.println(" The Revenue (without tax) is Rs. " + totalCostWithoutTax + ".");
                    System.out.println(" The Service Tax @14% is Rs. " + totalServiceTax + ".");
                    System.out.println(" The Swachh Bharat Cess @0.5% is Rs. " + totalCessTax + ".");
                    System.out.println(" The krishi Kalyan Cess  @0.5% is Rs. " + totalCessTax + ".");





                }



                // Ask the user if they want to book another seat
                System.out.println("Do you want to book another seat? (y/n)");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("n")) {
                    System.out.println("The total cost is Rs. " + totalCost + ".");
                    System.out.println("The Service Tax  is Rs. " + totalCost * 0.85 + ".");



                    break;
                }

                System.out.println("Current available seats:");
                for (int i = 0; i < seats.length; i++) {
                    for (int j = 0; j < seats[i].length; j++) {
                        if(! (seats[i][j] ==1)){
                            System.out.print("[" + categories[i][j] + "]");

                        }
                    }
                    System.out.println();
                }

            }

            System.out.println("Thank you for using our movie theater seating system!");
        }

        public static double getSBTax(int x){
            return x*0.14;
        }

        public static double cessTax(int x){
            return x * 0.05;
        }
    }

