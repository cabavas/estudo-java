package defender.methods;

import defender.methods.services.BrazilInterestService;
import defender.methods.services.UsaInterestService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Amount: ");
        double amount = sc.nextDouble();
        System.out.println("Months: ");
        int months = sc.nextInt();

        UsaInterestService is = new UsaInterestService(1);
        double payment = is.payment(amount, months);

        System.out.println("Payment after " + months + " months: ");
        System.out.printf("%.2f%n", payment);

        sc.close();
    }
}
