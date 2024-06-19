package exercicio.interfaces;

import exercicio.interfaces.model.entities.Contract;
import exercicio.interfaces.model.entities.Installment;
import exercicio.interfaces.model.services.ContractService;
import exercicio.interfaces.model.services.PayPalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy");

        System.out.println("Entre os dados do contrato:");
        System.out.println("Numero: ");
        int number = sc.nextInt();
        System.out.println("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.println("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Entre com o numero de parcelas: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(new PayPalService());

        contractService.processContract(contract, n);

        System.out.println("Parcelas:");
        for(Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }
}
